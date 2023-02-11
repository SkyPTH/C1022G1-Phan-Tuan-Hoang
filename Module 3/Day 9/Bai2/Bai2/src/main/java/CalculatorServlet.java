import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstNum = Double.parseDouble(request.getParameter("first-num"));
        String operator = request.getParameter("operator");
        double secondNum = Double.parseDouble(request.getParameter("second-num"));
        double result = 0.0;
        try {
            result= Calculator.calculator(firstNum, secondNum, operator);
            request.setAttribute("result", result);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        switch (operator) {
            case "Addition":
                operator = "+";
            case "Subtraction":
                operator = "-";
            case "Multiplication":
                operator = "*";
            case "Division":
                operator = "%";
        }
        request.setAttribute("first-operand", firstNum);
        request.setAttribute("operator", operator);
        request.setAttribute("second-operand", secondNum);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
