package sn.isi.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DB {
    private Connection cnx;
    private PreparedStatement pstm;
    private ResultSet rs;
    //permet d'ouvrir la connexion à la base
    public void open() throws Exception {
        String url = "jdbc:mysql://localhost:3306/gestionMailling";
        String mysqluser = "root";
        String mysqlpassword = "";
        Class.forName("com.mysql.jdbc.Driver");
        cnx = DriverManager.getConnection(url, mysqluser, mysqlpassword);

    }
    public void init(String sql) throws Exception
    {
        pstm = cnx.prepareStatement(sql);
    }
    public int executeUpdate() throws Exception
    {
        int ok = 0;
        ok = pstm.executeUpdate();
        return ok;
    }
    public ResultSet executeSelect() throws Exception
    {
        rs = pstm.executeQuery();
        return rs;
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    //permet de fermer la connexion
    public void close() throws Exception {
        if (cnx != null) {
            cnx.close();
        }
    }
}
