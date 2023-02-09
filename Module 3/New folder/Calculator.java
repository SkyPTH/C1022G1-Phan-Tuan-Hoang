import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Calculator", value = "/Calculator")
public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String productDescription=request.getParameter("product-description");
 double listPrice=Double.parseDouble(request.getParameter("list-price"));
 double discountPercent=Double.parseDouble(request.getParameter("discount-percent"));
 double discountAmount= listPrice*discountPercent*0.01;
 double discountPrice= listPrice-discountAmount;
 request.setAttribute("productDescription",productDescription);
 request.setAttribute("listPrice",listPrice);
 request.setAttribute("discountAmount",discountAmount);
 request.setAttribute("discountPrice",discountPrice);
request.getRequestDispatcher("/Ketqua.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
