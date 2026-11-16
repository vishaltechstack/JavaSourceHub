package Internationalization;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleI18nRunner {

    public static void renderCheckoutScreen(Locale userLocale, String customerName, int itemCount, double cartTotal) {
        System.out.println("==================================================");
        System.out.println("Active Locale: " + userLocale.getDisplayName(Locale.ENGLISH) +
                " [" + userLocale.toLanguageTag() + "]");

        // 1. Load the matching 'messages_<lang>_<COUNTRY>.properties' file from classpath
        // Falls back automatically to 'messages.properties' if no exact match exists
        ResourceBundle bundle = ResourceBundle.getBundle("resources.messages", userLocale);

        // 2. Format the monetary total according to the user's region
        String localizedTotal = NumberFormat.getCurrencyInstance(userLocale).format(cartTotal);

        // 3. Retrieve localized templates and inject placeholders {0}, {1} using MessageFormat
        String welcomeMsg = MessageFormat.format(bundle.getString("greeting"), customerName);
        String summaryMsg = MessageFormat.format(bundle.getString("cart.summary"), itemCount, localizedTotal);
        String closingMsg = bundle.getString("farewell");

        System.out.println(welcomeMsg);
        System.out.println(summaryMsg);
        System.out.println(closingMsg);
    }

    public static void main(String[] args) {
        String user = "Vishal";
        int items = 3;
        double total = 4599.50;

        // Render the exact same screen for three different global users!
        renderCheckoutScreen(Locale.forLanguageTag("en-IN"), user, items, total);
        renderCheckoutScreen(Locale.forLanguageTag("hi-IN"), user, items, total);
        renderCheckoutScreen(Locale.FRANCE, user, items, total);
    }
}