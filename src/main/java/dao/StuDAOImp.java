package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StuDAOImp implements StuDAO {

    String url = "jdbc:hsqldb:hsql://localhost";
    String driver = "org.hsqldb.jdbcDriver";
    String user = "sa";
    String pass = "";

    public int add(String username,String password) throws Exception {

        int flags = 0;
        Class.forName(driver);
        String sqladd = "insert into USERTABLE VALUES(?,?)";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement pres = con.prepareStatement(sqladd);
            pres.setString(1, username);
            pres.setString(2, password);
            pres.execute();
            flags = pres.executeUpdate(sqladd);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        return flags;
    }




}
