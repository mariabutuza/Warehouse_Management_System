package businessLogic;

import Model.Order;
import dataAccess.ProductDAO;

import java.util.ArrayList;
import java.util.List;

public class OrderBLL {
    private ProductBLL productDAO;
    private ClientBLL clientDAO;
    private OrderBLL orderDAO;

    /*public OrderBLL()
    {
        //productDAO = new ProductDAO();
        clientDAO = new ClientBLL();
        orderDAO = new OrderBLL();
    }

    public ArrayList<Order> getAllOrder()
    {
        List<Order> orders = orderDAO.findAll();
        return new ArrayList<Order>(orders);
    }

    public void deleteOrder(Order order)
    {
        orderDAO.delete(order);
    }*/
}
