import java.util.Scanner;

public class Main {

    // ===========================
    // Section 0: Federal Tax Data
    // ===========================
    private static final double[] BRACKET_LIMITS = {11925, 48475, 103350, 197300, 250525, 626350};
    private static final double[] BRACKET_RATES  = {0.10, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};

    public static void main(String[] args) {

        // ========================
        // Section 1: Title Display 
        // ========================
        final int CONSOLE_WIDTH = 50;
        ConsoleUtils.displayTitle("NET SALARY ESTIMATOR", CONSOLE_WIDTH);

        System.out.println("\nWelcome! Let's estimate your salary step by step.");
        System.out.println("Instructions: Enter numbers for amounts/rates, 'y' for yes, 'n' for no, and 'e' to exit anytime.");

        // ============================
        // Section 2: Main Program Loop
        // ============================
        Scanner userInput = new Scanner(System.in);

        boolean continueProgram = true;
        final int DOT_COUNT = 3;
        final int DOT_DELAY_MS = 500;

        while (continueProgram) {

            ConsoleUtils.displayProcessingText("Starting a new salary estimation", DOT_COUNT, DOT_DELAY_MS);

            // ==================================
            // Section 3: User Input & Validation
            // ==================================

            // --- Sub-section 3.1: Base Salary ---
            double baseSalary = 0;

            while (true) {

                String baseSalaryPrompt = ConsoleUtils.buildPrompt(
                "BASE SALARY",    
                "Enter your base salary ($)",
                "Must be > 0, or 'e' to exit"
                );

                System.out.print(baseSalaryPrompt);
                String input = userInput.nextLine().trim();

                if (input.equalsIgnoreCase("e")) {

                    ConsoleUtils.displayProcessingText("Exiting", DOT_COUNT, DOT_DELAY_MS);

                    continueProgram = false;
                    break;

                } else if (input.isEmpty()) {

                    ConsoleUtils.displayEmptyInputError();
                    continue;

                }

                try {

                    baseSalary = Double.parseDouble(input);

                    if (baseSalary > 0) 
                        break;
                    else 
                        ConsoleUtils.displayConstraintError("Base Salary", "must be greater than 0");
    
                } catch (NumberFormatException e) {

                    ConsoleUtils.displayInvalidNumberError();
                
                }

            }

            if (!continueProgram) break;

            // --- Sub-section 3.2: Sales ---
            double sales = 0;

            while (true) {

                String salesPrompt = ConsoleUtils.buildPrompt(
                "SALES",    
                "Enter your total sales ($)",
                "Must be >= 0, or 'e' to exit"
                );

                System.out.print(salesPrompt);
                String input = userInput.nextLine().trim();

                if (input.equalsIgnoreCase("e")) {

                    ConsoleUtils.displayProcessingText("Exiting", DOT_COUNT, DOT_DELAY_MS);

                    continueProgram = false;
                    break;

                } else if (input.isEmpty()) {

                    ConsoleUtils.displayEmptyInputError();
                    continue;

                }

                try {

                    sales = Double.parseDouble(input);

                    if (sales >= 0) 
                        break;
                    else 
                        ConsoleUtils.displayConstraintError("Sales", "cannot be negative");
        
                } catch (NumberFormatException e) {

                    ConsoleUtils.displayInvalidNumberError();
    
                }

            }

            if (!continueProgram) break;

            // --- Sub-section 3.3: Commission Rate ---
            double commissionRate = 0;

            if (sales > 0) {

                while (true) {

                    String commissionPrompt = ConsoleUtils.buildPrompt(
                    "COMMISSION RATE",    
                    "Enter your commission rate (%)",
                    "Must be 1-100, or 'e' to exit"
                    );

                    System.out.print(commissionPrompt);
                    String input = userInput.nextLine().trim();

                    if (input.equalsIgnoreCase("e")) {

                        ConsoleUtils.displayProcessingText("Exiting", DOT_COUNT, DOT_DELAY_MS);

                        continueProgram = false;
                        break;

                    } else if (input.isEmpty()) {

                        ConsoleUtils.displayEmptyInputError();
                        continue;

                    }

                    try {

                        commissionRate = Double.parseDouble(input);

                        if (commissionRate >= 1 && commissionRate <= 100) {

                            commissionRate /= 100; 
                            break;

                        } else {

                            ConsoleUtils.displayConstraintError("Commission Rate", "must be between 1 and 100");

                        }

                    } catch (NumberFormatException e) {

                        ConsoleUtils.displayInvalidNumberError();

                    }

                }

            }

            if (!continueProgram) break;

            // --- Sub-section 3.4: Bonus --- 
            double bonus = 0;

            if (sales > 0) {

                String target;

                while (true) {

                    String targetPrompt = ConsoleUtils.buildPrompt(
                    "SALES TARGET",    
                    "Did you achieve your sales target?",
                    "Enter 'y' for yes, 'n' for no,",
                    "or 'e' to exit"
                    );

                    System.out.print(targetPrompt);
                    target = userInput.nextLine().trim();

                    if (target.equalsIgnoreCase("e")) {

                        ConsoleUtils.displayProcessingText("Exiting", DOT_COUNT, DOT_DELAY_MS);

                        continueProgram = false;
                        break;

                    } else if (target.isEmpty()) {

                        ConsoleUtils.displayEmptyInputError();
                        continue;

                    } else if (target.equalsIgnoreCase("y") || target.equalsIgnoreCase("n")) {

                        break;

                    } else {

                        ConsoleUtils.displayYesNoError();

                    }

                }

                if (target.equalsIgnoreCase("y")) {

                    while (true) {

                        String bonusPrompt = ConsoleUtils.buildPrompt(
                        "BONUS",    
                        "Enter your bonus amount ($)",
                        "Must be > 0, or 'e' to exit"
                        );

                        System.out.print(bonusPrompt);
                        String input = userInput.nextLine().trim();

                        if (input.equalsIgnoreCase("e")) {

                            ConsoleUtils.displayProcessingText("Exiting", DOT_COUNT, DOT_DELAY_MS);

                            continueProgram = false;
                            break;

                        } else if (input.isEmpty()) {

                            ConsoleUtils.displayEmptyInputError();
                            continue;

                        }

                        try {

                            bonus = Double.parseDouble(input);

                            if (bonus > 0) 
                                break;
                            else 
                                ConsoleUtils.displayConstraintError("Bonus", "must be greater than 0");

                        } catch (NumberFormatException e) {

                            ConsoleUtils.displayInvalidNumberError();

                        }

                    }

                }

            }

            if (!continueProgram) break;

            // =======================
            // Section 4: Calculations
            // =======================

            // --- Sub-section 4.1: Commission ---
            double commission = sales * commissionRate;

            // --- Sub-section 4.2: Gross Income ---
            double grossIncome = baseSalary + commission + bonus;

            // --- Sub-section 4.3: Deductions ---
            double federalTax = calculateFederalTax(grossIncome);
            double socialSecurity = calculateSocialSecurity(grossIncome);
            double medicare = calculateMedicare(grossIncome);
            double totalDeductions = federalTax + socialSecurity + medicare;

            // --- Sub-section 4.4: Net Salary ---
            double netSalary = grossIncome - totalDeductions;
            
            // ==================
            // Section 5: Results
            // ==================
            ConsoleUtils.displayProcessingText("Generating Results", DOT_COUNT, DOT_DELAY_MS);

            System.out.println();

            // --- Sub-section 5.1: Earnings ---
            ConsoleUtils.displayBoxTitle("EARNINGS", CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Base Salary", baseSalary, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Bonus", bonus, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Commission", commission, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxDivider(CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Total Earnings", baseSalary + bonus + commission, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxBottom(CONSOLE_WIDTH);

            // --- Sub-section 5.2: Deductions ---
            ConsoleUtils.displayBoxTitle("DEDUCTIONS", CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Federal Tax", federalTax, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Social Security", socialSecurity, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Medicare", medicare, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxDivider(CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Total Deductions", totalDeductions, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxBottom(CONSOLE_WIDTH);

            // --- Sub-section 5.3: Net Salary ---
            ConsoleUtils.displayBoxTitle("NET SALARY", CONSOLE_WIDTH);
            ConsoleUtils.displayBoxRow("Net Salary", netSalary, CONSOLE_WIDTH);
            ConsoleUtils.displayBoxBottom(CONSOLE_WIDTH);

            // =========================
            // Section 6: Repeat or Exit
            // =========================
            String userChoice;

            while (true) {

                String repeatPrompt = ConsoleUtils.buildPrompt(
                "REPEAT OR EXIT",
                "Would you like to calculate another salary?",
                "Enter 'y' for yes, 'n' for no"
                );

                System.out.print(repeatPrompt);
                userChoice = userInput.nextLine();

                if (userChoice.isEmpty()) {

                    ConsoleUtils.displayEmptyInputError();
                    continue;

                } else if (userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("n")) {

                    break;

                } else {

                    ConsoleUtils.displayYesNoError();

                }
                    
            }

            if (!userChoice.equalsIgnoreCase("y")) {

                ConsoleUtils.displayProcessingText("Exiting", DOT_COUNT, DOT_DELAY_MS);
                
                continueProgram = false;

            }
            
        }

        // ======================
        // Section 7: End Message
        // ======================
        System.out.println("\nThank you for using Net Salary Estimator!");
        System.out.println("Created by Asim");

        userInput.close();

    }

    // =======================================
    // Section 8: Tax & Deduction Calculations
    // =======================================

    // --- Sub-section 8.1: Federal Tax ---
    private static double calculateFederalTax(double income) {

        double tax = 0;
        double previousLimit = 0;

        for (int i = 0; i < BRACKET_LIMITS.length; i++) {

            double limit = BRACKET_LIMITS[i];

            if (income > limit) {

                tax += (limit - previousLimit) * BRACKET_RATES[i];
                previousLimit = limit;

            } else {

                tax += (income - previousLimit) * BRACKET_RATES[i];

                return tax;

            }

        }

        tax += (income - previousLimit) * BRACKET_RATES[BRACKET_RATES.length - 1];

        return tax;

    }


    // --- Sub-section 8.2: Social Security ---
    private static double calculateSocialSecurity(double income) {
    
        return Math.min(income, 176100) * 0.062;

    }

    // --- Sub-section 8.3: Medicare ---
    private static double calculateMedicare(double income) {

        double medicare = income * 0.0145;
        final double MEDICARE_THRESHOLD = 200000;

        if (income > MEDICARE_THRESHOLD)
            medicare += (income - MEDICARE_THRESHOLD) * 0.009;
    
        return medicare;

    }

}