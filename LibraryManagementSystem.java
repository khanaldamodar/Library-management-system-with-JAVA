import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int id;
    private boolean isIssued;
    
    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isIssued = false;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getId() {
        return id;
    }
    
    public boolean isIssued() {
        return isIssued;
    }
    
    public void issueBook() {
        this.isIssued = true;
    }
    
    public void returnBook() {
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    public Book searchBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; // If book is not found
    }
    
    public void issueBook(int id) {
        Book book = searchBookById(id);
        if (book != null && !book.isIssued()) {
            book.issueBook();
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued or not found.");
        }
    }
    
    public void returnBook(int id) {
        Book book = searchBookById(id);
        if (book != null && book.isIssued()) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued or not found.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        
        // Add sample books
        library.addBook(new Book("Java Basics", "Author A", 1));
        library.addBook(new Book("Data Structures", "Author B", 2));
        
        // List all books
        library.listBooks();
        
        // Issue a book
        library.issueBook(1);
        
        // Return a book
        library.returnBook(1);
        
        // List books after issuing and returning
        library.listBooks();
    }
}
