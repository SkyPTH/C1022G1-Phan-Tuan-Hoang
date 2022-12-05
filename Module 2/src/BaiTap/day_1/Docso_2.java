package BaiTap.day_1;

import java.util.Scanner;

public class Docso_2 {
    public static void main(String[] args) {
        System.out.println("Nhập số: ");
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        if (num < 20) {
            switch (num) {
                case 1:
                    System.out.println("one");

                    break;
                case 2:
                    System.out.println("two");

                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
                case 10:
                    System.out.println("ten");
                    break;
                case 11:
                    System.out.println("eleven");
                    break;
                case 12:
                    System.out.println("twelve");
                    break;
                case 13:
                    System.out.println("thirteen");
                    break;
                case 14:
                    System.out.println("fourteen");
                    break;
                case 15:
                    System.out.println("fifteen");
                    break;
                case 16:
                    System.out.println("sixteen");
                    break;
                case 17:
                    System.out.println("seventeen");
                    break;
                case 18:
                    System.out.println("eighteen");
                    break;
                case 19:
                    System.out.println("nineteen");
                    break;
            }
        } else {
            if (num < 100) {
                int tens = num / 10;
                int ones = num % 10;
                switch (tens) {
                    case 2:
                        System.out.println("Twenty");
                        break;
                    case 3:
                        System.out.println("Thirty");
                        break;
                    case 4:
                        System.out.println("Forty");
                        break;
                    case 5:
                        System.out.println("Fifty");
                        break;
                    case 6:
                        System.out.println("Sixty");
                        break;
                    case 7:
                        System.out.println("Seventy");
                        break;
                    case 8:
                        System.out.println("Eighty");
                        break;
                    case 9:
                        System.out.println("Ninety");
                        break;
                }
                switch (ones) {
                    case 1:
                        System.out.println("One");
                        break;
                    case 2:
                        System.out.println("Two");
                        break;
                    case 3:
                        System.out.println("Three");
                        break;
                    case 4:
                        System.out.println("Four");
                        break;
                    case 5:
                        System.out.println("Five");
                        break;
                    case 6:
                        System.out.println("Six");
                        break;
                    case 7:
                        System.out.println("Seven");
                        break;
                    case 8:
                        System.out.println("Eight");
                        break;
                    case 9:
                        System.out.println("Nine");
                        break;
                }
            } else
            if (num < 1000) {
                switch (num / 100) {
                    case 1:
                        System.out.print("One hundred ");
                        break;
                    case 2:
                        System.out.print("Two hundred ");
                        break;
                    case 3:
                        System.out.print("Three hundred ");
                        break;
                    case 4:
                        System.out.print("Four hundred ");
                        break;
                    case 5:
                        System.out.print("Five hundred ");
                        break;
                    case 6:
                        System.out.print("Six hundred ");
                        break;
                    case 7:
                        System.out.print("Seven hundred ");
                        break;
                    case 8:
                        System.out.print("Eight hundred ");
                        break;
                    case 9:
                        System.out.print("Nine hundred ");
                        break;
                }
                switch (num / 10 % 10) {
                    case 0:
                        switch (num % 10) {
                            case 0:
                                System.out.print("");
                                break;
                            case 1:
                                System.out.print("One");
                                break;
                            case 2:
                                System.out.println("Two");
                                break;
                            case 3:
                                System.out.println("Three");
                                break;
                            case 4:
                                System.out.println("Four");
                                break;
                            case 5:
                                System.out.println("Five");
                                break;
                            case 6:
                                System.out.println("Six");
                                break;
                            case 7:
                                System.out.print("Seven");
                                break;
                            case 8:
                                System.out.print("Eight");
                                break;
                            case 9:
                                System.out.print("Nine");
                                break;
                        }
                        break;
                    case 1:
                        switch (num % 10) {
                            case 0:
                                System.out.print("Ten");
                                break;
                            case 1:
                                System.out.print("Eleven");
                                break;
                            case 2:
                                System.out.print("Twelve");
                                break;
                            case 3:
                                System.out.print("Thirteen");
                                break;
                            case 4:
                                System.out.print("Fourteen");
                                break;
                            case 5:
                                System.out.print("Fifteen");
                                break;
                            case 6:
                                System.out.print("Sixteen");
                                break;
                            case 7:
                                System.out.print("Seventeen");
                                break;
                            case 8:
                                System.out.print("Eighteen");
                                break;
                            case 9:
                                System.out.print("Nineteen");
                                break;
                        }
                        break;
                    case 2:
                        System.out.print("Twenty ");
                        break;
                    case 3:
                        System.out.print("Thirty ");
                        break;
                    case 4:
                        System.out.print("Fourty ");
                        break;
                    case 5:
                        System.out.print("Fifty ");
                        break;
                    case 6:
                        System.out.print("Sixty ");
                        break;
                    case 7:
                        System.out.print("Seventy ");
                        break;
                    case 8:
                        System.out.print("Eighty ");
                        break;
                    case 9:
                        System.out.print("Ninety ");
                        break;
                }
                if (num / 10 % 10 > 1) {
                    switch (num % 10) {
                        case 0:
                            System.out.print("");
                            break;
                        case 1:
                            System.out.print("One");
                            break;
                        case 2:
                            System.out.print("Two");
                            break;
                        case 3:
                            System.out.print("Three");
                            break;
                        case 4:
                            System.out.print("Four");
                            break;
                        case 5:
                            System.out.print("Five");
                            break;
                        case 6:
                            System.out.print("Six");
                            break;
                        case 7:
                            System.out.print("Seven");
                            break;
                        case 8:
                            System.out.print("Eight");
                            break;
                        case 9:
                            System.out.print("Nine");
                            break;
                    }
                }
            }
        }
    }
}
