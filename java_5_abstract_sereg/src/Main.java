import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Soldier kardos1 = new Kardos();
        Soldier kardos2 = new Kardos();
        Soldier kardos3 = new Kardos();
        Soldier kardos4 = new Kardos();
        Soldier kardos5 = new Kardos();
        Soldier kardos6 = new Kardos();
        Soldier kardos7 = new Kardos();
        Soldier kardos8 = new Kardos();
        Soldier kardos9 = new Kardos();
        Soldier kardos10 = new Kardos();


        Soldier archer1 = new Archer();
        Soldier archer2 = new Archer();
        Soldier archer3 = new Archer();
        Soldier archer4 = new Archer();
        Soldier archer5 = new Archer();
        Soldier archer6 = new Archer();
        Soldier archer7 = new Archer();
        Soldier archer8 = new Archer();
        Soldier archer9 = new Archer();
        Soldier archer10 = new Archer();


        List<Soldier> soldierListA = List.of(kardos1, kardos2, kardos3, kardos4, kardos5, archer1, archer2, archer3, archer4, archer5);
        List<Soldier> soldierListB = List.of(archer10, kardos6, kardos7, kardos8, kardos9, kardos10, archer6, archer7, archer8, archer9);
        System.out.println(soldierListA);
        System.out.println(soldierListB);

        System.out.println("----------------------------------------------------------\n Harc után:");

        for (int i = 0; i < soldierListA.size(); i++) {
            System.out.println(i + 1 + ". kör: ");

            System.out.println(soldierListA.get(i) + " és " + soldierListB.get(i));
            soldierListA.get(i).tamad(soldierListB.get(i));
            System.out.println(soldierListA.get(i) + " és " + soldierListB.get(i));
            soldierListB.get(i).tamad(soldierListA.get(i));
            System.out.println(soldierListA.get(i) + " és " + soldierListB.get(i));

        }

        //harc
        System.out.println("----------------------------------------------------------\n Harc után:");

        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < soldierListA.size(); i++) {
            sumA += soldierListA.get(i).lifePoint;
            sumB += soldierListB.get(i).lifePoint;
        }

        System.out.println(soldierListA);
        System.out.println(soldierListB);
        System.out.println("Az 1. sereg életpontja:" + sumA);
        System.out.println("A 2. sereg életpontja:" + sumB);

    }
}