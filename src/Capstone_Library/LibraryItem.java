package Capstone_Library;

public class LibraryItem {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public LibraryItem(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }

    // Formats record cleanly for console display
    @Override
    public String toString() {
        String status = isIssued ? "[ISSUED]" : "[AVAILABLE]";
        return String.format("ID: %d | %-22s | Author: %-16s | %s", id, title, author, status);
    }

    // Formats record as CSV line for saving to disk
    public String toCSV() {
        return id + "," + title + "," + author + "," + isIssued;
    }
}