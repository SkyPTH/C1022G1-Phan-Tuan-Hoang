import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customerServlet", value = "")
public class customerServlet extends HttpServlet {
    private  List<Customer> customerList = new ArrayList<>();
    public void init() {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-2-22", "Hà Nội", "https://img.meta.com.vn/Data/image/2022/01/13/anh-dep-thien-nhien-3.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-2-22", "Đà Nẵng", "https://img.meta.com.vn/Data/image/2022/01/13/anh-dep-thien-nhien-3.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-2-22", "Bắc Giang", "https://img.meta.com.vn/Data/image/2022/01/13/anh-dep-thien-nhien-3.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-2-22", "Hà Tây", "https://img.meta.com.vn/Data/image/2022/01/13/anh-dep-thien-nhien-3.jpg"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
