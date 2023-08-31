public class Book {
    String author;
    String title;

    Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }


    @Override
    public String toString() {
        return author + ": " + title;
    }
}

