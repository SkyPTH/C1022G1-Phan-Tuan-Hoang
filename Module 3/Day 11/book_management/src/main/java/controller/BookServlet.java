package controller;

import model.Book;
import service.BookService;
import service.IBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String tittleSearch=request.getParameter("tittleSearch");
        if (tittleSearch==null){
            tittleSearch="";
        }
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addForm(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;

            default:
                request.setAttribute("bookList", bookService.displayAll(tittleSearch));
                request.getRequestDispatcher("/displayAll.jsp").forward(request, response);
        }
    }

    public void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add.jsp").forward(request, response);


    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tittle = request.getParameter("tittle");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        Book book = new Book(tittle, pageSize, author, category);
        bookService.add(book);
        response.sendRedirect("/book");
    }

    public void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String tittle = request.getParameter("tittle");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        Book book = new Book(id,tittle, pageSize, author, category);
        bookService.update(id,book);
        response.sendRedirect("/book");
    }



    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        bookService.delete(id);
        response.sendRedirect("/book");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String tittleSearch=request.getParameter("tittleSearch");
        if (action == null) {
            action = "";
        }
        if (tittleSearch==null){
            tittleSearch="";}
        switch (action) {
            case "add":
                add(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                request.setAttribute("bookList", bookService.displayAll(tittleSearch));
                request.getRequestDispatcher("/displayAll.jsp").forward(request, response);
        }
    }
}
