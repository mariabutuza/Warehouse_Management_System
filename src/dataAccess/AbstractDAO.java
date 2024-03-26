package dataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    public final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public String createSelectQuery(String field)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("bazadate.").append(type.getSimpleName().toLowerCase());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    public String createSelectAllQuery()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("bazadate.").append(type.getSimpleName().toLowerCase());
        return sb.toString();
    }

    public String createInsertQuery(String field)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append("bazadate.").append(type.getSimpleName().toLowerCase());

        sb.append(" (");
        for(Field f: type.getDeclaredFields())
        {
            f.setAccessible(true);
            sb.append(f.getName());
            if(f.getName().equals(type.getDeclaredFields()[type.getDeclaredFields().length - 1].getName()))
                continue;
            sb.append(",");
        }
        sb.append(") ");

        sb.append("VALUES");

        sb.append(" (");
        for(Field f: type.getDeclaredFields())
        {
            f.setAccessible(true);
            if(f.getName().equals(type.getDeclaredFields()[type.getDeclaredFields().length - 1].getName())){
                sb.append("?");
                continue;
            }

            sb.append("?,");
        }
        sb.append(") ");

        //insert into client (id,name,address,email,age) values (?,?,?,?,?)
        //si astea gen is generalizat,client il iei cu type.getSimpleName()
        //folosesti acest for ca sa iei generalizat campurile din baze de date
        //for(Field f: type.getDeclaredFields())
        //{ f.setAccesible(true);
        //  sb.append(f.getName());
        //  etc }
        return sb.toString();
    }

    public String createUpdateQuery(String field)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("bazadate.").append(type.getSimpleName().toLowerCase());
        Field last = null;
        boolean first = true;
        sb.append(" SET ");
        for(Field f: type.getDeclaredFields())
        {
            f.setAccessible(true);
            sb.append(f.getName() + "=?");
            if(f.getName().equals(type.getDeclaredFields()[type.getDeclaredFields().length - 1].getName())){
                continue;
            }
            sb.append(", ");

            /*if(first && last == null)
            {
                first = false;
                continue;
            }
            if(last != null && last.equals(f))
            {
                sb.append(f.getName()); // + ") " );
                sb.append("=?");
                break;
            }
            last = f;
            sb.append(f.getName()); //+ ",");
            sb.append("=?, ");*/
        }

        //update client set name=?,address=?,email=?,age=? where id=?
        return sb.toString();
    }

    public String createDeleteQuery(String field)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append("bazadate.").append(type.getSimpleName().toLowerCase());
        sb.append(" WHERE " + field + " =?");

        /*StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM " + type.getSimpleName());
        Field last = null;
        boolean first = true;
        sb.append(" WHERE ");
        for(Field f: type.getDeclaredFields())
        {
            f.setAccessible(true);
            if(first)
            {
                first = false;
                sb.append(f.getName()); // + ") " );
                sb.append("=?");
            }
        }*/
        //delete from client where id=?
        return sb.toString();
    }

    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery(); //("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            //statement.setInt(1,id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            //System.out.println(statement.toString());       ?>?>???
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        //ArrayList<Object> values = new ArrayList<>();
        //ArrayList<String> fields = new ArrayList<String>();
        //.....................getValuesFromT?
        String query = createInsertQuery("id");
        try {
            int i=1;
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            for(Field f: type.getDeclaredFields())
            {
                if(f.getName() != "id"){
                    //Object o = getter.invoke(t);
                    //statement.setString(i, o.toString());
                    //i++;
                }
            }
            /*for(int i=1;i<fields.size();i++){
                if(values.get(i) instanceof Integer){
                    statement.setInt(i,((Integer) values.get(i)).intValue());
                }
                if(values.get(i) instanceof String){
                    statement.setString(i,values.get(i).toString());
                }
                if(values.get(i) instanceof Double){
                    statement.setDouble(i,((Double) values.get(i)).doubleValue());
                }
            }*/

            statement.execute();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    public T update(T t, int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        //ArrayList<Object> values = new ArrayList<>();
        //ArrayList<String> fields = new ArrayList<String>();
        //.....................getValuesFromT?
        String query = createUpdateQuery("id");
        try {
            int i=0;
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            /*for(i=0;i<fields.size();i++){
                if(values.get(i) instanceof Integer){
                    statement.setInt(i+1,((Integer) values.get(i)).intValue());
                }
                if(values.get(i) instanceof String){
                    statement.setString(i+1,values.get(i).toString());
                }
                if(values.get(i) instanceof Double){
                    statement.setDouble(i+1,((Double) values.get(i)).doubleValue());
                }
            }*/
            statement.setInt(i+1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    public void delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery("id");
        T t = findById(id);
        try {
            int i;
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(resultSet);
        }
    }
}
