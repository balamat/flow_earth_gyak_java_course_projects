import java.util.*;

public abstract class Library {
    public static List<Book> bookList = new ArrayList<>();

    public static Set<String> titleSet = new HashSet<>();

    public static Map<Integer, Book> MapByInteger = new HashMap<>();
    public static Map<String, Book> MapByString = new HashMap<>();



    public static void addToLibrary(Book inputBook) {
        bookList.add(inputBook);
    }

    public static void addToTitle(Book book) {
        titleSet.add(book.getTitle());
    }

    public static void addToMapByInteger(Book book) {
        MapByInteger.put(MapByInteger.size() + 1, book);      //növekvő számsor
    }

    public static void addToMapByString(Book book) {
        MapByString.put(book.getAuthor(), book);
    }


}
