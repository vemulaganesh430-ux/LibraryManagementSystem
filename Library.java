import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n--- Library Books ---");

        for (Book book : books) {
            book.displayBook();
        }
    }

    public void issueBook(int bookId, User user) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);

                    System.out.println(
                        "Book issued successfully to " + user.getName()
                    );
                    return;
                } else {
                    System.out.println("Book is already issued.");
                    return;
                }
            }
        }

        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not issued.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }
}