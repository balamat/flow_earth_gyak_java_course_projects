package butorgyar;

public class Butorlap {

    private static final int BUTOR_TARTOLAP_PRICE = 5000;
    private static final int BUTOR_HATLAP_PRICE = 500;

//    private static final String TYPE_HATLAP = "hátlap";
//    private static final String TYPE_TARTOLAP = "tartólap";

    private double length;
    private double width;
    private String type;

    public Butorlap(double length, double width, String type) {
        this.length = length / 100;       //cm-input, m output
        this.width = width / 100;
        this.type = type;
    }

//    public double getLength() {
//        return length;
//    }
//
//    public void setLength(double length) {
//        this.length = length;
//    }
//
//    public double getWidth() {
//        return width;
//    }
//
//    public void setWidth(double width) {
//        this.width = width;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public double arSzamol(Butorlap butorlap) {
        int pricePerArea = this.type.equals("hátlap") ? BUTOR_HATLAP_PRICE : BUTOR_TARTOLAP_PRICE;
        return this.length * this.width * pricePerArea;
    }

    @Override
    public String toString() {
        return type + ": " + length + "x" + width;
    }
}
