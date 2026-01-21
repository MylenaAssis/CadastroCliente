package br.com.mylena.dao;

import br.com.mylena.dao.generic.GenericDAO;
import br.com.mylena.domain.Client;

public class ClientMapDAO extends GenericDAO<Client> implements IClientDAO {

    public ClientMapDAO() {
        super();
    }

    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }

    @Override
    public Long getCode(Client client) {
        return client.getCpf();
    }

    @Override
    public void updateData(Client client, Client newClient) {
        if (newClient != null) {
            client.setCpf(newClient.getCpf());
            client.setTel(newClient.getTel());
            client.setNumber(newClient.getNumber());
            client.setAddress(newClient.getAddress());
            client.setCity(newClient.getCity());
            client.setState(newClient.getState());
        }
    }
}