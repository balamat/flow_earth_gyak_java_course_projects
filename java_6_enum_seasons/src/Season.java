public enum Season {

    WINTER ("Tél"),
    SPRING ("Tavasz"),
    SUMMER ("Nyár"),
    AUTUMN ("Ősz");
    private String name;
    private Season(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
