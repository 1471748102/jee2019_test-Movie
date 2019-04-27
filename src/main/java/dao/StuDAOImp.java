package dao;

import conn.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StuDAOImp implements StuDAO {



    public int add(String username,String password) throws Exception {

        int flags = 0;

        connect db = new connect();
        Connection con=db.getConnection();
        String sqladd = "insert into USERTABLE VALUES(?,?)";
        try {

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
