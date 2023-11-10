public enum LottoType {


    ÖTÖSLOTTÓ("5-90", 5, 91, 400, new double[]{0, 0, 0.12, 0.12, 0.33, 0.43}),
    HATOSLOTTÓ("6-45", 6, 46, 400, new double[]{0, 0, 0.1, 0.15, 0.15, 0.25, 0.35});

    private String lottoType;
    private int numberOfChoosenNumbers;

    //exclusive upper range limit
    private int upperLimitOfRange;

    private int ticketPrice;
    private double[] percentageOfPool;

    LottoType(String lottoType, int numberOfChoosenNumbers, int upperLimitOfRange, int ticketPrice, double[] percentageOfPool) {
        this.lottoType = lottoType;
        this.numberOfChoosenNumbers = numberOfChoosenNumbers;
        this.upperLimitOfRange = upperLimitOfRange;
        this.ticketPrice = ticketPrice;
        this.percentageOfPool = percentageOfPool;
    }

    public String getLottoType() {
        return lottoType;
    }

    public int getNumberOfChoosenNumbers() {
        return numberOfChoosenNumbers;
    }

    public int getUpperLimitOfRange() {
        return upperLimitOfRange;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public double[] getPercentageOfIncome() {
        return percentageOfPool;
    }
}
