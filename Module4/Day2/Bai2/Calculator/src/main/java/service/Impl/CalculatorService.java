package service.Impl;

import service.ICalculatorService;

public class CalculatorService implements ICalculatorService {

    @Override
    public double calculator(double firstNum, double secondNum, String operator) {
        switch (operator) {
            case "Addition(+)":
                return firstNum + secondNum;
            case "Subtraction(-)":
                return firstNum - secondNum;
            case "Multiplication(*)":
                return firstNum * secondNum;
            case "Division(/)":
                return firstNum / secondNum;
        }
        return 0;
    }
}
