public class ConsoleUtils {

    // ================
    // Section 1: Title
    // ================

    public static void displayTitle(String title, int width) {

        int padding = (width - title.length()) / 2;

        System.out.println("=".repeat(width));
        System.out.println(" ".repeat(padding) + title);
        System.out.println("=".repeat(width));

    }

    // ==========================
    // Section 2: Processing Text
    // ==========================

    public static void displayProcessingText(String text, int dots, int delayMillis) {

        System.out.print("\n" + text);

        for (int i = 0; i < dots; i++) {

            System.out.print(".");
            try { Thread.sleep(delayMillis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        }

        System.out.println(); 

    }

    // ==========================
    // Section 3: Prompt Building
    // ==========================

    public static String buildPrompt(String title, String... lines) {

        int width = title.length();

        for (String line : lines) {

            if (line.length() > width) width = line.length();

        }

        width += 2; 

        StringBuilder box = new StringBuilder();

        box.append("\n┌").append("─".repeat(width)).append("┐\n");

        int padding = (width - title.length()) / 2;
        box.append("│").append(" ".repeat(padding)).append(title).append(" ".repeat(width - title.length() - padding)).append("│\n");

        box.append("│").append("─".repeat(width)).append("│\n");

        for (String line : lines) {

            box.append("│ ").append(line);
            box.append(" ".repeat(width - line.length() - 1)).append("│\n");

        }

        box.append("└").append("─".repeat(width)).append("┘\n");
        box.append("> ");

        return box.toString();

    }

    // =========================
    // Section 4: Error Messages
    // =========================

    public static void displayEmptyInputError() {

        System.out.println("\n[ERROR] Empty Input: Please type something before pressing Enter.");

    }

    public static void displayInvalidNumberError() {

        System.out.println("\n[ERROR] Invalid Input: Please enter numbers only.");

    }

    public static void displayConstraintError(String field, String rule) {

        System.out.println("\n[ERROR] Invalid Input: " + field + " " + rule + ".");

    }

    public static void displayYesNoError() {

        System.out.println("\n[ERROR] Invalid Input: Please enter 'y' or 'n'.");

    }

    // ========================
    // Section 5: Boxed Results
    // ========================

    public static void displayBoxTitle(String title, int width) {

        int padding = (width - 2 - title.length()) / 2;

        System.out.println("┌" + "─".repeat(width - 2) + "┐");
        System.out.println("│" + " ".repeat(padding) + title + " ".repeat(width - 2 - padding - title.length()) + "│");
        System.out.println("│" + "─".repeat(width - 2) + "│");

    }   

    public static void displayBoxRow(String label, double value, int width) {

        String formattedValue = String.format("$%.2f", value);
        int spaces = width - 2 - label.length() - formattedValue.length();

        System.out.println("│" + label + " ".repeat(spaces) + formattedValue + "│");

    }

    public static void displayBoxDivider(int width) {

        System.out.println("│" + "─".repeat(width - 2) + "│");
    
    }

    public static void displayBoxBottom(int width) {

        System.out.println("└" + "─".repeat(width - 2) + "┘");

    }

}
