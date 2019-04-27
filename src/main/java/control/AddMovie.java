package control;

import bean.movie;
import com.opensymphony.xwork2.ActionSupport;
import dao.StuDAO;
import dao.StuDAOImp;

public class AddMovie extends ActionSupport {
    private movie uk;
    private movie us;

    public movie getUk() {
        return uk;
    }

    public void setUk(movie uk) {
        this.uk = uk;
    }

    public String execute() throws Exception {
        StuDAO stu = new StuDAOImp();
        us =stu.mlz(uk);
        return SUCCESS;
    }
}


