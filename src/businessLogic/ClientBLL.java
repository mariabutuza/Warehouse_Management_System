package businessLogic;

import Model.Client;
import dataAccess.ClientDAO;

import java.util.ArrayList;
import java.util.List;

public class ClientBLL {
    private ClientDAO clientDAO;

    public ClientBLL()
    {
        clientDAO = new ClientDAO();
    }

    public ArrayList<Client> getAllClients()
    {
        List<Client> clients = clientDAO.findAll();
        return new ArrayList<>(clients);
    }

    public void insertClient(Client client)
    {
        clientDAO.insert(client);
    }
    public void deleteClient(int id)
    {
        clientDAO.delete(id);
    }

    public void updateClient(Client client,int id)
    {
        clientDAO.update(client,id);
    }

}
