package control;

import bean.movie;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.StuDAO;
import dao.StuDAOImp;

import java.util.List;

public class SelectByName extends ActionSupport {
    private List<movie> StudentList;
    private  String moviename;

    public List<movie> getStudentList() {
        return StudentList;
    }

    public void setStudentList(List<movie> studentList) {
        StudentList = studentList;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String execute() throws Exception {
        StuDAO stu = new StuDAOImp();
        System.out.println(moviename);
        StudentList=stu.selectbyname(moviename);
        ActionContext.getContext().put("StudentList",StudentList);
        return SUCCESS;
    }
}
