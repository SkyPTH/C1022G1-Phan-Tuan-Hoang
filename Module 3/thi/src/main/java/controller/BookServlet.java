package controller;

import model.Book;
import model.Category;
import service.IService;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "bookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    IService iService = new Service();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
//            case "update":
//                break;
//            case "delete":
//                break;
            default:
                try {
                    showList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Category> categoryList = iService.categoryList();
        List<Book> bookList = iService.bookList();
        request.setAttribute("bookList", bookList);
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Book> bookList = iService.bookList();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    create(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case "update":
        }
    }
    void create(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String name = request.getParameter("bookName");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        Category category = new Category(categoryID);
        Book book = new Book( name, pageSize, category);
        iService.create(book);
        response.sendRedirect("/book");
    }
}
