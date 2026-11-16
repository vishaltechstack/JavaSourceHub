package Capstone_Library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryManager {

    private List<LibraryItem> catalog = new ArrayList<>();
    private final Path storagePath = Paths.get("library_catalog.csv");

    public void addBook(LibraryItem item) {
        catalog.add(item);
    }

    // Searches catalog using Streams & returns Optional
    public Optional<LibraryItem> findById(int id) {
        return catalog.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    // Issues a book or throws custom exception if missing/already issued
    public void issueBook(int id) throws BookUnavailableException {
        LibraryItem book = findById(id)
                .orElseThrow(() -> new BookUnavailableException("Book ID " + id + " does not exist."));

        if (book.isIssued()) {
            throw new BookUnavailableException("Book '" + book.getTitle() + "' is already issued.");
        }

        book.setIssued(true);
        System.out.println("Successfully issued: " + book.getTitle());
    }

    // Filters and displays only available books using Streams
    public void showAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        catalog.stream()
                .filter(book -> !book.isIssued())
                .forEach(System.out::println);
    }

    // Exports current catalog state to a CSV file
    public void saveCatalogToFile() {
        List<String> lines = catalog.stream()
                .map(LibraryItem::toCSV)
                .collect(Collectors.toList());
        try {
            Files.write(storagePath, lines);
            System.out.println("\nCatalog saved to: " + storagePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save catalog: " + e.getMessage());
        }
    }
}