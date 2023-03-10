package controller;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "")
public class StudentServlet extends HttpServlet {
    private List<Student> studentList = new ArrayList<>();

    public void init() {
studentList.add(new Student(1,"Hoàng","Nam",100));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(studentList.isEmpty()){
            request.setAttribute("emptyList","Danh sách rỗng");
        }
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
