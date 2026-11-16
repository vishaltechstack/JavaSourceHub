package Solid_Principles;

// 1. SRP: Invoice holds ONLY invoice data (its sole responsibility)
class Invoice {
    private final String customerName;
    private final double baseAmount;

    public Invoice(String customerName, double baseAmount) {
        this.customerName = customerName;
        this.baseAmount = baseAmount;
    }

    public String getCustomerName() { return customerName; }
    public double getBaseAmount() { return baseAmount; }
}

// 2. OCP: TaxRule interface allows adding new regional taxes WITHOUT modifying InvoiceCalculator
interface TaxRule {
    double calculateTax(double amount);
}

class IndiaGSTTax implements TaxRule {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.18; // 18% GST
    }
}

class ZeroExportTax implements TaxRule {
    @Override
    public double calculateTax(double amount) {
        return 0.0; // 0% Export Tax
    }
}

// 3. SRP + OCP: Calculator depends only on the TaxRule abstraction
class InvoiceCalculator {
    public double computeGrandTotal(Invoice invoice, TaxRule taxRule) {
        return invoice.getBaseAmount() + taxRule.calculateTax(invoice.getBaseAmount());
    }
}

// 4. SRP: Persistence is isolated in its own dedicated repository class
class InvoiceRepository {
    public void saveToDatabase(Invoice invoice, double finalTotal) {
        System.out.println("Saved Invoice for " + invoice.getCustomerName() + " | Total: Rs. " + finalTotal);
    }
}

public class SRPAndOCPOrderSystem {
    public static void main(String[] args) {
        Invoice inv = new Invoice("Vishal Sharma", 10000.0);
        InvoiceCalculator calculator = new InvoiceCalculator();
        InvoiceRepository repo = new InvoiceRepository();

        double totalWithGST = calculator.computeGrandTotal(inv, new IndiaGSTTax());
        repo.saveToDatabase(inv, totalWithGST);
    }
}