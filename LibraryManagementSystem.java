import java.util.*;

class Book {
    String title;
    String author;
    boolean isIssued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

class User {
    String name;
    List<Book> issuedBooks = new ArrayList<>();

    User(String name) {
        this.name = name;
    }

    void issueBook(Book book) {
        issuedBooks.add(book);
        book.isIssued = true;
        System.out.println(name + " issued " + book.title);
    }

    void returnBook(Book book) {
        issuedBooks.remove(book);
        book.isIssued = false;
        System.out.println(name + " returned " + book.title);
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    Book findAvailableBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isIssued) {
                return book;
            }
        }
        return null;
    }

    void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.isIssued) {
                System.out.println(book);
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book("Gunahon ka Devta", "Dharamvir Bharti"));
        library.addBook(new Book("Raag Darbari", "Shrilal Shukla"));

        // Registering user
        User user1 = new User("Shivansh");

        library.showAvailableBooks();

        // Issue a book
        Book bookToIssue = library.findAvailableBook("Gunahon ka Devta");
        if (bookToIssue != null) {
            user1.issueBook(bookToIssue);
        }

        library.showAvailableBooks();

        // Return a book
        user1.returnBook(bookToIssue);

        library.showAvailableBooks();
    }
}
