public enum Month {
    JANUARY("Január", 1, 31, false, Season.WINTER),
    FEBRUARY("Február", 2, 28, false, Season.WINTER),
    MARCH("Március", 3, 31, true, Season.SPRING),
    APRIL("Április", 4, 30, true, Season.SPRING),
    MAY("Május", 5, 31, true, Season.SPRING),
    JUNE("Június", 6, 30, true, Season.SUMMER),
    JULY("Július", 7, 31, false, Season.SUMMER),
    AUGUST("Augusztus", 8, 31, false, Season.SUMMER),
    SEPTEMBER("Szeptember", 9, 30, false, Season.AUTUMN),
    OCTOBER("Október", 10, 31, true, Season.AUTUMN),
    NOVEMBER("November", 11, 30, false, Season.AUTUMN),
    DECEMBER("December", 12, 31, true, Season.WINTER);

    private String nameOfMonth;
    private int whichMonthOfTheYear;
    private int numberOfDays;
    private boolean hasHoliday;
    private Season season;

    Month(String nameOfMonth, int whichMonthOfTheYear, int numberOfDays, boolean hasHoliday, Season season) {
        this.nameOfMonth = nameOfMonth;
        this.whichMonthOfTheYear = whichMonthOfTheYear;
        this.numberOfDays = numberOfDays;
        this.hasHoliday = hasHoliday;
        this.season = season;
    }

    public String getNameOfMonth() {
        return nameOfMonth;
    }

    public int getWhichMonthOfTheYear() {
        return whichMonthOfTheYear;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public boolean isHasHoliday() {
        return hasHoliday;
    }

    public Season getSeason() {
        return season;
    }

    public static void getByNumber(int number) {
        for (Month month : Month.values()) {
            if (month.getWhichMonthOfTheYear() == number) {
                System.out.println(month);
                break;
            } else if (number > Month.values().length) {
                System.out.println("Nincs ilyen hónap!");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return nameOfMonth + "{ évszak=" + season.getName() + ", az év " + whichMonthOfTheYear + ". hónapja, napok száma=" +
                numberOfDays + ", " + (hasHoliday ? "van" : "nincs") + " ünnepe }";
    }
}

