import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Book firstBook = new Book("Móra Ferenc", "Kincskereső Kisködmön");
        Book secondBook = new Book("Jókai Mór", "A kőszívű ember fiai");
        Book thirdBook = new Book("Móricz Zsigmond", "Légy jó mindhalálig");
        Book fourthBook = new Book("Molnár Ferenc", "A Pál utcai fiúk");
        Book fifthBook = new Book("Gárdonyi Géza", "Egri csillagok");
        Library.addToLibrary(firstBook);
        Library.addToLibrary(secondBook);
        Library.addToLibrary(thirdBook);
        Library.addToLibrary(fourthBook);
        Library.addToLibrary(fifthBook);

        Library.addToTitle(fifthBook);
        Library.addToTitle(secondBook);
        Library.addToTitle(thirdBook);
        Library.addToTitle(fourthBook);
        Library.addToTitle(fifthBook);

        Library.addToMapByInteger(firstBook);
        Library.addToMapByInteger(secondBook);
        Library.addToMapByInteger(thirdBook);
        Library.addToMapByInteger(fourthBook);
        Library.addToMapByInteger(fifthBook);

        Library.addToMapByString(firstBook);
        Library.addToMapByString(secondBook);
        Library.addToMapByString(thirdBook);
        Library.addToMapByString(fourthBook);
        Library.addToMapByString(fifthBook);









        handleList(Library.bookList);
        handleTitleSet();
        handleMap();


    }

    public static void handleList(List<Book> list) {
        //a-feature
        System.out.println(list);
        System.out.println("----------------------------------------");
        //b-feature
        for (Book element : list) {
            System.out.println(element);
        }
        System.out.println("----------------------------------------");
        //c-feature
        System.out.println(list.get(0));
        System.out.println("----------------------------------------");
        //d-feature
        System.out.println(list.get(1).getAuthor());
        System.out.println("----------------------------------------");
        //e-feature
        System.out.println(list.get(2).title);
        System.out.println("----------------------------------------");
        //f-feature
        list.remove(3);
        //g-feature
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals("Kincskereső Kisködmön")) {
                list.remove(i);
            }
        }

//        list.removeIf(book -> book.getAuthor().equals("Kincskereső Kisködmön"));        //itt helyesen nem csinál semmit
//        list.removeIf(book -> book.getAuthor().equals("Móra Ferenc"));

        //h-feature
        list.get(list.size() - 1).setAuthor("Ismeretlen szerző");
        //i-feature
        System.out.println(list);
        System.out.println("----------------------------------------");
    }

    public static void handleTitleSet() {
        //a - feature
        System.out.println(Library.titleSet);
        System.out.println("----------------------------------------");
        //b - feature
        System.out.println("Benne van a Kincskereső Kisködmön? " + Library.titleSet.contains("Kincskereső Kisködmön"));
        System.out.println("----------------------------------------");
        //c-d- feature
        System.out.println("Benne van a Pál utcai..." + Library.titleSet.contains("A Pál utcai fiúk"));
        Library.titleSet.remove("A Pál utcai fiúk");
        System.out.println("Benne van a Pál utcai törlés után?" + Library.titleSet.contains("A Pál utcai fiúk"));
        System.out.println("----------------------------------------");
    }

    public static void handleMap() {
        System.out.println(Library.MapByInteger);
        System.out.println(Library.MapByString);
        System.out.println("----------------------------------------");
        //MapInteger 2. elemének kiírása
        System.out.println(Library.MapByInteger.get(2));
        System.out.println(Library.MapByString.get("Molnár Ferenc"));
        System.out.println("----------------------------------------");
        Library.MapByInteger.remove(2);
        System.out.println(Library.MapByInteger);
        System.out.println("----------------------------------------");
        System.out.println(Library.MapByInteger.values());      //values
        System.out.println(Library.MapByInteger.keySet());      //keySet
        System.out.println(Library.MapByInteger.entrySet());    //entrySet


    }

}