package CaseStudy.Controller.CustomController;

import CaseStudy.Controller.FuramaManager;
import CaseStudy.Model.model.Facility.Room;
import CaseStudy.Model.model.Facility.Villa;
import CaseStudy.Service.Facility.FacilityServiceImpl;
import CaseStudy.Service.Facility.IFacilityService;
import CaseStudy.utils.MyRegex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FacilityController {
    public static void main() throws IOException {

        IFacilityService facilityService = new FacilityServiceImpl();
        do {
            System.out.println("------Facility Management-------");
            System.out.println("1\tDisplay list facility");
            System.out.println("2\tAdd new facility");
            System.out.println("3\tDisplay list facility maintenance");
            System.out.println("4\tReturn main menu");
            Scanner scanner = new Scanner(System.in);
            try {
                int choice3 = Integer.parseInt(scanner.nextLine());
                switch (choice3) {
                    case 1:
                        facilityService.displayList();
                        break;
                    case 2:
                        do {
                            System.out.println("1.\tAdd New Villa");
                            System.out.println("2.\tAdd New Room");
                            System.out.println("3.\tBack to menu");
                            int choice4 = Integer.parseInt(scanner.nextLine());
                            switch (choice4) {
                                case 1:
                                    String name = null;
                                    do {
                                        System.out.println("Enter villa name(form: SVVL-YYYY, with Y is number between 0-9)");
                                        name = scanner.nextLine();
                                    } while (!name.matches(MyRegex.REGEX_IDSVILLA));
                                    String area = null;
                                    do {
                                        System.out.println("Enter area (real number and bigger than 30m2)");
                                        area = scanner.nextLine();

                                    } while (!area.matches(MyRegex.REGEX_AREA));
                                    String price = null;
                                    do {
                                        System.out.println("Enter price (positive number)");
                                        price = scanner.nextLine();
                                    } while (!price.matches(MyRegex.REGEX_PRICE));
                                    String maxPeople = null;
                                    do {
                                        System.out.println("Enter max number of people (from 1 to 19)");
                                        maxPeople = scanner.nextLine();
                                    } while (!maxPeople.matches(MyRegex.REGEX_NUMBERPEOPLE));
                                    String typeRent = null;
                                    do {
                                        System.out.println("Enter type rent (Day/Month/Year)");
                                        typeRent = scanner.nextLine();

                                    } while (!typeRent.matches(MyRegex.REGEX_TYPERENT));
                                    String quality = null;
                                    do {
                                        System.out.println("Enter quality (Standard|Superior|Deluxe|Suite)");
                                        quality = scanner.nextLine();
                                    } while (!quality.matches(MyRegex.REGEX_QUALITY));
                                    String poolArea = null;
                                    do {
                                        System.out.println("Enter pool area (real number and bigger than 30m2)");
                                        poolArea = scanner.nextLine();
                                    } while (!poolArea.matches(MyRegex.REGEX_POOLAREA));
                                    String floorNumber = null;
                                    do {
                                        System.out.println("Enter floor number (integer)");
                                        floorNumber = scanner.nextLine();
                                    } while (!floorNumber.matches(MyRegex.REGEX_NUMBERFLOOR));
                                    Villa villa = new Villa(name, area, maxPeople, typeRent, quality, poolArea, floorNumber, price);
                                    facilityService.addVilla(villa);
                                    break;
                                case 2:

                                    String name1 = null;
                                    do {
                                        System.out.println("Enter room name (form: SVRO-YYYY, with Y is number between 0-9)");
                                        name = scanner.nextLine();
                                    } while (!name1.matches(MyRegex.REGEX_IDROOM));
                                    String area1 = null;
                                    do {
                                        System.out.println("Enterd area (real number and bigger than 30m2)");
                                        area1 = scanner.nextLine();

                                    } while (!area1.matches(MyRegex.REGEX_AREA));
                                    String price1 = null;
                                    do {
                                        System.out.println("Enter price (positive number)");
                                        price1 = scanner.nextLine();
                                    } while (!price1.matches(MyRegex.REGEX_PRICE));
                                    String maxPeople1 = null;
                                    do {
                                        System.out.println("Enter max number of people (from 1 to 19)");
                                        maxPeople1 = scanner.nextLine();
                                    } while (!maxPeople1.matches(MyRegex.REGEX_NUMBERPEOPLE));
                                    String typeRent1 = null;
                                    do {
                                        System.out.println("Enter type rent (Day/Month/Year)");
                                        typeRent1 = scanner.nextLine();

                                    } while (!typeRent1.matches(MyRegex.REGEX_TYPERENT));
                                    String freeService = null;
                                    do {
                                        System.out.println("Enter free service (The first letter must be capitalized, the following characters are normal characters)");
                                        freeService = scanner.nextLine();
                                    } while (!typeRent1.matches(MyRegex.REGEX_NAMESERVICE));
                                    Room room = new Room(name1, area1, maxPeople1, typeRent1, freeService, price1);
                                    facilityService.addRoom(room);
                                    break;
                                case 3:
                                    FuramaManager.displayMainMenu();
                            }
                        } while (true);

                    case 3:
                        facilityService.displayMaintenanceList();
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println("Enter valid number again");
                }
            } catch (NumberFormatException e) {
                System.err.println("Not a number, try again");
            } catch (FileNotFoundException e) {
                System.out.println("Problem with data path or file");
            }
        } while (true);
    }
}
