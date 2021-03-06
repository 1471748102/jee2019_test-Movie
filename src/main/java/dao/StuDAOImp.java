package dao;

import bean.movie;
import conn.connect;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class StuDAOImp implements StuDAO {

    connect db = new connect();
    Connection con=db.getConnection();

    public int add(String username,String password) throws Exception {

        int flags = 0;


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

    public List show() throws Exception {
        List StudentList = new ArrayList();

        String sqlshow = "select * from MOVIEINFO";
        try {

            PreparedStatement pref = con.prepareStatement(sqlshow);
            ResultSet rs = pref.executeQuery();
            while (rs.next()) {
                movie uk = new movie();
                uk.setMoviename(rs.getString("moviename"));
                uk.setShowtime(rs.getString("showtime"));
                uk.setShortinfo(rs.getString("shortinfo"));
                uk.setPicturepath(rs.getString("picturepath"));
                StudentList.add(uk);
            }
            return StudentList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        return StudentList;

    }

    public List selectbyname(String moviename) throws Exception {

        List st = new ArrayList();
        String sqlselect = "select * from MOVIEINFO where MOVIENAME='" + moviename + "'";
        PreparedStatement pref = con.prepareStatement(sqlselect);
        ResultSet rst = pref.executeQuery();

        while (rst.next())
        {
            movie use= new movie();
            use.setMoviename(rst.getString("moviename"));
            use.setShowtime(rst.getString("showtime"));
            use.setShortinfo(rst.getString("shortinfo"));
            use.setPicturepath(rst.getString("picturepath"));
            st.add(use);
        }
        return st;

    }

    public movie mlz(movie uk) throws Exception {

        String sqlmlz = "insert into MOVIEINFO VALUES(?,?,?,?)";
        try {
            PreparedStatement pret = con.prepareStatement(sqlmlz);

            pret.setString(1, uk.getMoviename());
            pret.setString(2, uk.getShowtime());
            pret.setString(3, uk.getShortinfo());
            pret.setString(4, uk.getPicturepath());
            pret.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        return uk;

    }

    public boolean inter(String username, String password) throws Exception {

        boolean flag = false;

        String sqlinter = "select * from USERTABLE where USERZHANGHAO=? and PASSMIMA =?";
        try (
             PreparedStatement pstmt = con.prepareStatement(sqlinter)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                flag = rs.next();
            }
        }
        return flag;
    }

}
