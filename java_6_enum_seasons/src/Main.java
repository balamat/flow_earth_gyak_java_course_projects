import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hanyadik hónap adataira vagy kíváncsi?");
        Scanner sc = new Scanner(System.in);
        boolean validInput = true;
        while (validInput) {
            try {
                int numberOfMonth = sc.nextInt();
                Month.getByNumber(numberOfMonth);
            } catch (InputMismatchException e) {
                System.out.println("Számot adj meg, írd be újra!");
                sc.next();
                continue;
            }
            validInput = false;
        }


        //It shows the enum-object as defined in the toString method:
//        String str = "JANUARY";
//        System.out.println(Month.valueOf(str));


    }
}