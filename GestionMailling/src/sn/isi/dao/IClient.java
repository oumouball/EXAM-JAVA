package sn.isi.dao;

import sn.isi.entities.Client;

import java.util.List;

public interface IClient {
    public int add(Client client) throws Exception;
    public int delete(int id) throws Exception;
    public int update(Client client) throws Exception;
    public List<Client> getAll() throws Exception;
}

