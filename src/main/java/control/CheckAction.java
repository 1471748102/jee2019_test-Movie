package control;

import com.opensymphony.xwork2.ActionSupport;
import dao.StuDAO;
import dao.StuDAOImp;

public class CheckAction extends ActionSupport {
    private String username;
    private String password;
    private String reapeat;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getReapeat() {
        return reapeat;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReapeat(String reapeat) {
        this.reapeat = reapeat;
    }
    public String execute() throws Exception {
        StuDAO stu = new StuDAOImp();
        int flags = stu.add(username,password);
        if(flags!=0) {
            addFieldError("username","Add Error" );
            return "input";
        }
        else
            return SUCCESS;
    }
}
