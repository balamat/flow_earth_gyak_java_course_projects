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

    public Butor lapHozzaad(Butorlap butorlap) {
        //add the butorlap object as a parameter to the chosen butor object
        this.ButorElements[this.numberOfElements] = butorlap;
        this.numberOfElements++;
        return this;
    }

    public double arSzamol() {
        double sum = 0;
        for (int i = 0; i < this.numberOfElements; i++) {
            sum += this.ButorElements[i].arSzamol();
        }
        return sum;     //a bútor ára
    }

    @Override
    public String toString() {
        String elements = "";
        int i = 0;
        while (ButorElements[i] != null) {
            elements += "\n" + (i + 1) + ". " + ButorElements[i] + " " + ButorElements[i].arSzamol() + " Ft";
            i++;
        }
        return "Butor - lapok: " + (numberOfElements) + ", ár " + arSzamol() + " Ft" + elements;
    }
}
