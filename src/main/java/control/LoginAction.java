package control;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.StuDAO;
import dao.StuDAOImp;

import java.util.Map;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception {
        StuDAO stu = new StuDAOImp();
        boolean flag = stu.inter(username,password);
        if(flag){
            Map session= ActionContext.getContext().getSession();
            session.put("username",username);
        }
        return flag? SUCCESS : ERROR;
    }
}

