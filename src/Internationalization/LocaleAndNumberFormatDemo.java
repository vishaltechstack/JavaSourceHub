package Internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleAndNumberFormatDemo {

    public static void printRegionalFormatting(Locale locale, double amount, double taxRate) {
        // 1. Display Locale metadata in English
        System.out.println("--- Region: " + locale.getDisplayCountry(Locale.ENGLISH) +
                " (" + locale.toLanguageTag() + ") ---");

        // 2. Currency Formatter tailored to the specific Locale
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Formatted Currency:   " + currencyFormatter.format(amount));

        // 3. Standard Decimal Number Formatter (handles grouping separators: commas vs dots)
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(locale);
        System.out.println("Formatted Number:     " + numberFormatter.format(amount));

        // 4. Percentage Formatter
        NumberFormat percentFormatter = NumberFormat.getPercentInstance(locale);
        percentFormatter.setMinimumFractionDigits(1);
        System.out.println("Formatted Tax Rate:   " + percentFormatter.format(taxRate));
    }

    public static void main(String[] args) {
        double samplePrice = 125450.75;
        double gstOrTax = 0.185; // 18.5%

        // Creating Locale objects using standard IETF BCP 47 language tags (Java 19+ best practice)
        Locale indiaLocale   = Locale.forLanguageTag("en-IN");
        Locale usLocale      = Locale.US;
        Locale germanyLocale = Locale.GERMANY;
        Locale japanLocale   = Locale.JAPAN;

        printRegionalFormatting(indiaLocale, samplePrice, gstOrTax);
        printRegionalFormatting(usLocale, samplePrice, gstOrTax);
        printRegionalFormatting(germanyLocale, samplePrice, gstOrTax);
        printRegionalFormatting(japanLocale, samplePrice, gstOrTax);
    }
}