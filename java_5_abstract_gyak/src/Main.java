import butorgyar.Butor;
import butorgyar.Butorlap;

public class Main {
    public static void main(String[] args) {
        Butor szekreny1 = new Butor();
        Butorlap butorElem1 = new Butorlap(100, 200, "hátlap");
        Butorlap butorElem2 = new Butorlap(100, 100, "tartólap");
        Butorlap butorElem3 = new Butorlap(50, 200, "tartólap");
        Butorlap butorElem4 = new Butorlap(200, 300, "tartólap");
        Butorlap butorElem5 = new Butorlap(300, 50, "tartólap");
        Butorlap butorElem6 = new Butorlap(200, 10, "hátlap");

        szekreny1.lapHozzaad(butorElem1).lapHozzaad(butorElem2).lapHozzaad(butorElem3).lapHozzaad(butorElem4).lapHozzaad(butorElem5).lapHozzaad(butorElem6);
        System.out.println(szekreny1);


    }
}