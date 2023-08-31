package butorgyar;

import java.util.Arrays;
import java.util.Iterator;

public class Butor {
    private int numberOfElements;
    private Butorlap[] ButorElements;

    public Butor() {
        this.numberOfElements = 0;
        this.ButorElements = new Butorlap[100];
    }


    public Butor lapHozzaad(Butor butor, Butorlap butorlap) {       //mihez mit
        butor.ButorElements[butor.numberOfElements] = butorlap;
        butor.numberOfElements++;
        return butor;
    }

    public double arSzamol(Butor butor) {
        double sum = 0;
        for (int i = 0; i < numberOfElements; i++) {
//            sum+=butorlap.arSzamol(butorlap);
            sum += butor.ButorElements[i].arSzamol(butor.ButorElements[i]);
        }
        return sum;     //a bútor ára
    }

    @Override
    public String toString() {
        String elements = "";
        int i = 0;
        while (ButorElements[i] != null) {
            elements += "\n" + (i+1) + ". " +ButorElements[i] + " " + ButorElements[i].arSzamol(ButorElements[i]) + " Ft";
            i++;
        }
        return "Butor - lapok: " + (numberOfElements) + ", ár " + arSzamol(this) + " Ft" + elements;
    }
}
