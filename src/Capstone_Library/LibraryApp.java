package Capstone_Library;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryManager library = new LibraryManager();

        // 1. Populate initial catalog
        library.addBook(new LibraryItem(101, "Effective Java", "Joshua Bloch"));
        library.addBook(new LibraryItem(102, "Clean Code", "Robert Martin"));
        library.addBook(new LibraryItem(103, "Head First Java", "Kathy Sierra"));

        // 2. Display initial state
        library.showAvailableBooks();

        // 3. Issue books & test custom exception handling
        System.out.println("\n--- Processing Book Issues ---");
        try {
            library.issueBook(101); // Succeeds
            library.issueBook(101); // Throws BookUnavailableException (already issued)
        } catch (BookUnavailableException e) {
            System.out.println("Alert: " + e.getMessage());
        }

        // 4. Display updated available books
        library.showAvailableBooks();

        // 5. Persist catalog to disk
        library.saveCatalogToFile();
    }
}