package sn.isi.dao;
import sn.isi.entities.Client;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ClientImpl implements IClient {
    DB db = new DB();
    @Override
    public int add(Client client) throws Exception {
        db.open();
        Scanner scan = new Scanner(System.in);
        String sql = "INSERT INTO client VALUES(NULL,?,?,?,?,?)";
        db.init(sql);
        db.getPstm().setString(1, client.getNom());
        db.getPstm().setString(2, client.getPrenom());
        db.getPstm().setString(3, client.getEmail());
        db.getPstm().setString(4, client.getPassword());
        db.getPstm().setString(5,client.getTel());
        return db.executeUpdate();
    }
    @Override
    public int delete(int id) throws Exception {
        db.open();
        String sql = "Delete from client where id = ?";
        db.init(sql);
        db.getPstm().setInt(1,id);
        return 0;
    }
    @Override
    public int update(Client client) throws Exception {
        db.open();
        /*Modifier le client dont id = 2
        Client c1 = cs.findById(2);
        cc.setNom("nouveau nom");
        cc.setPrenom("nouveau Prénom"); 
        cs.update(c);*/
        String sql = "UPDATE client set nom = ?,prenom = ?,email = ?,password = ?,tel = ? where id = ?";
        db.init(sql);
        db.getPstm().setString(1,client.getNom());
        db.getPstm().setString(2, client.getPrenom());
        db.getPstm().setString(3, client.getEmail());
        db.getPstm().setString(4, client.getPassword());
        db.getPstm().setString(5, client.getTel());
        db.getPstm().setInt(6, client.getId());
        int ok  = db.executeUpdate();
        return ok;
    }
    @Override
    public List<Client> getAll() throws Exception {
            List<Client> clients= new ArrayList<Client>();
            db.open();
            String sql = "SELECT * from client";
            db.init(sql);
            ResultSet res = db.executeSelect();
            while (res.next())
            {
                Client client = new Client();
                client.setId(res.getInt(1));
                client.setNom(res.getString(2));
                client.setPrenom(res.getString(3));
                client.setEmail(res.getString(4));
                client.setPassword(res.getString(5));
                client.setTel(res.getString(6));
                clients.add(client);
            }
            return clients;
        }
    }

