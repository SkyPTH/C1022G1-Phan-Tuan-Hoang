package controller;

import model.Author;
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

@WebServlet(name = "BookServlet", value = "/book")
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
            case "update":
                break;
            case "delete":
                break;
            default:
                try {
                    displayList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    void displayList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        if (nameSearch == null) {
            nameSearch = "";
        }
        request.setAttribute("bookList", iService.displayList(nameSearch));
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setAttribute("authorList", iService.authorList());
        request.setAttribute("categoryList", iService.categoryList());
        request.getRequestDispatcher("create.jsp").forward(request, response);
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
                    create(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                break;
            case "delete":
                break;

        }
    }

    void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String authorID = request.getParameter("authorID");
        String categoryID = request.getParameter("categoryID");
        Author author = new Author(Integer.parseInt(authorID));
        Category category =new Category(Integer.parseInt(categoryID));
        Book book = new Book(name, pageSize, author, category);
        iService.create(book);
        response.sendRedirect("/book");
    }
}
