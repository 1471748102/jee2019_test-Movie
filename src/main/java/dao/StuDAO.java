package dao;

import java.util.List;

public interface StuDAO {
    int add(String username,String password) throws Exception;
    List show( ) throws Exception;
}
