package br.com.mylena.domain;

import br.com.mylena.dao.IClientDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientMapDAO implements IClientDAO {
    private Map<Long, Client> map;

    public ClientMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean register(Client client) {
        if (this.map.containsKey(client.getCpf())) {
            return false;
        }
        this.map.put(client.getCpf(), client);
        return true;
    }

    @Override
    public void delete(Long cpf) {
        Client clientRegistered = this.map.get(cpf);

        if (clientRegistered != null) {
            this.map.remove(clientRegistered.getCpf(), clientRegistered);
        }
    }

    @Override
    public void update(Client client) {
        Client clientRegistered = this.map.get(client.getCpf());
        if(clientRegistered != null) {
            clientRegistered.setName(client.getName());
            clientRegistered.setCpf(client.getCpf());
            clientRegistered.setTel(client.getTel());
            clientRegistered.setNumber(client.getNumber());
            clientRegistered.setAddress(client.getAddress());
            clientRegistered.setCity(client.getCity());
            clientRegistered.setState(client.getState());
        }
    }

    @Override
    public Client search(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Client> searchAll() {
        return this.map.values();
    }
}
