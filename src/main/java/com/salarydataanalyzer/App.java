package com.salarydataanalyzer;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Input file containing salary data
        String fileName = "data.txt";

        FileManager fileManager = new FileManager();
        SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer();

        String userInput;
        int choice;

        // Handle file or input related exceptions
        try (Scanner scanner = new Scanner(System.in)) {

            // Main menu loop
            do {

                System.out.println("""
                        Choose 1 to display valid and invalid entries
                        Choose 2 to display the highest salary
                        Choose 3 to calculate the average weekly salary
                        Choose 4 to exit
                        """);

                // Validate numeric menu input
                do {
                    System.out.println("Enter your choice:");
                    userInput = scanner.nextLine();

                } while (!userInput.matches("\\d+"));

                // Read file content
                List<String> fileLines = fileManager.readFile(fileName);

                // Extract valid numeric salary values
                List<Double> validNumbers = salaryAnalyzer.getValidNumbers(fileLines);

                choice = Integer.parseInt(userInput);

                switch (choice) {

                    // Count valid and invalid file entries
                    case 1 -> {

                        int[] results = salaryAnalyzer.countEntries(fileLines);

                        int validEntries = results[0];
                        int invalidEntries = results[1];

                        System.out.println("\nValid entries: " + validEntries);
                        System.out.println("Invalid entries: " + invalidEntries);
                    }

                    // Display highest salary
                    case 2 -> {

                        double maxSalary = salaryAnalyzer.findHighestSalary(validNumbers);

                        if (maxSalary == -1) {
                            System.out.println("No valid salaries found.");
                        } else {
                            System.out.println("Highest salary: " + maxSalary);
                        }
                    }

                    // Calculate and display average salary
                    case 3 -> {

                        double averageSalary = salaryAnalyzer.calculateAverageSalary(validNumbers);

                        if (averageSalary == -1) {
                            System.out.println("No valid data to calculate average.");
                        } else {
                            System.out.println("Average weekly salary: " + averageSalary);
                        }
                    }

                    // Exit application
                    case 4 -> {
                        choice = 4;
                        System.out.println("Exiting program...");
                    }

                    // Handle invalid menu options
                    default -> System.out.println("Invalid input, please try again.");
                }

            } while (choice != 4);

        } catch (Exception e) {

            // Display error if file cannot be accessed
            System.out.println("Error: unable to find file " + fileName);
        }
    }
}
