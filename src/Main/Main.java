package Main;

import Model.Client;
import Presentation.*;
import dataAccess.ClientDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        MainView mv = new MainView();
        new Controller(mv);
        ClientDAO clientDAO = new ClientDAO();
        /*System.out.println(clientDAO.createSelectAllQuery());
        System.out.println(clientDAO.createSelectQuery("id"));
        System.out.println(clientDAO.createDeleteQuery("id"));
        System.out.println(clientDAO.createInsertQuery("id"));
        System.out.println(clientDAO.createUpdateQuery("id"));*/

        List<Client> clients = clientDAO.findAll();
        for (Client c: clients) {
            System.out.println(c);
        }

    }
}