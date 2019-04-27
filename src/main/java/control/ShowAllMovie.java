package control;

import bean.movie;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.StuDAO;
import dao.StuDAOImp;

import java.util.List;

public class ShowAllMovie extends ActionSupport {


    private List<movie> StudentList;

    public List<movie> getStudentList() {
        return StudentList;
    }

    public void setStudentList(List<movie> studentList) {
        StudentList = studentList;
    }


    public String execute() throws Exception {
        StuDAO stu = new StuDAOImp();
        StudentList=stu.show( );

        for (movie ux:StudentList) {
            System.out.println(ux);
        }
        ActionContext.getContext().put("StudentList",StudentList);
        return SUCCESS;
    }
}
