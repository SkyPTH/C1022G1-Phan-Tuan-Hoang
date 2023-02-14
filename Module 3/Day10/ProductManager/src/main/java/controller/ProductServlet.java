package controller;

import service.IService;
import service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
        IService iService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        String name;
        int price;
        String description;
        String producer;
        switch (action) {
            case "create":
                name = request.getParameter("name");
                price=Integer.parseInt(request.getParameter("price"));
                description=request.getParameter("description");
                producer=request.getParameter("producer");
                request.getRequestDispatcher("/view/product/create").forward(request, response);
                break;
            case "update":
                name = request.getParameter("name");
                price=Integer.parseInt(request.getParameter("price"));
                description=request.getParameter("description");
                producer=request.getParameter("producer");
                request.getRequestDispatcher("/view/product/update").forward(request, response);
                break;
            case "delete":
                name = request.getParameter("name");
                price=Integer.parseInt(request.getParameter("price"));
                description=request.getParameter("description");
                producer=request.getParameter("producer");
                request.getRequestDispatcher("/view/product/delete").forward(request, response);
                break;
            default:
                request.setAttribute("productList", iService.displayList());
                request.getRequestDispatcher("view/product/displayList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
