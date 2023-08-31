package butorgyar;

public class Butorlap {

    private static final int BUTOR_TARTOLAP_PRICE = 5000;
    private static final int BUTOR_HATLAP_PRICE = 500;

    private double length;
    private double width;
    private String type;

    public Butorlap(double length, double width, String type) {
        this.length = length / 100;       //cm-input, m output
        this.width = width / 100;
        this.type = type;
    }

    public double arSzamol() {
        int pricePerArea = this.type.equals("hátlap") ? BUTOR_HATLAP_PRICE : BUTOR_TARTOLAP_PRICE;
        return this.length * this.width * pricePerArea;
    }

    @Override
    public String toString() {
        return type + ": " + length + "x" + width;
    }
}
