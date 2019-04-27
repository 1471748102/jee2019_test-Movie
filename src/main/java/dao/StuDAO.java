package dao;

import bean.movie;

import java.util.List;

public interface StuDAO {
    int add(String username,String password) throws Exception;
    List show( ) throws Exception;
    List selectbyname(String moviename) throws Exception;
    movie mlz(movie uk) throws Exception;
    boolean inter(String username,String password) throws Exception;
}
