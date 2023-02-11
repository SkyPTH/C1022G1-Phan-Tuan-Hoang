public class Calculator {
    public static double calculator(double firstNum, double secondNum, String operator) {
        switch (operator) {
            case "Addition":
                return firstNum + secondNum;
            case "Subtraction":
                return firstNum - secondNum;
            case "Multiplication":
                return firstNum * secondNum;
            case "Division":
                if (secondNum == 0) {
                    throw new ArithmeticException();
                } else {
                    return firstNum / secondNum;
                }
            default:
                return 0;
        }
    }
}
