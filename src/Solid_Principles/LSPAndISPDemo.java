package Solid_Principles;

// 1. ISP: Small, cohesive interfaces instead of one giant DocumentOperations interface
interface Readable {
    String readContent();
}

interface Editable {
    void updateContent(String newContent);
}

// 2. LSP: ReadOnlyReport implements ONLY Readable—never breaks callers expecting Editable behavior
class ReadOnlyAuditReport implements Readable {
    private final String reportText;

    public ReadOnlyAuditReport(String reportText) {
        this.reportText = reportText;
    }

    @Override
    public String readContent() {
        return "[READ-ONLY REPORT] " + reportText;
    }
}

// 3. EditableNote implements both Readable and Editable
class EditableNote implements Readable, Editable {
    private String text;

    public EditableNote(String text) {
        this.text = text;
    }

    @Override
    public String readContent() {
        return "[EDITABLE NOTE] " + text;
    }

    @Override
    public void updateContent(String newContent) {
        this.text = newContent;
    }
}

public class LSPAndISPDemo {
    // Any Readable subtype can be substituted here with 100% behavioral safety (LSP)
    public static void printDocument(Readable doc) {
        System.out.println(doc.readContent());
    }

    public static void main(String[] args) {
        Readable report = new ReadOnlyAuditReport("Q4 System Audit Passed");
        EditableNote note = new EditableNote("Draft v1");
        note.updateContent("Final Approved Version");

        printDocument(report);
        printDocument(note);
    }
}