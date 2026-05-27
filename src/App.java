import java.util.Scanner;
import java.util.List;

public class App {

    public static void main(String[] args) {
        
        //Declaring variables
        
        // Declare a variable to store the document (file) name
        String fileName="data.txt";

        FileManager fileManager = new FileManager();
        SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer();
        
        // variables used
        
        // Declare a variable to store a numeric value
        String userInput;
        // Declare an integer variable to represent a numerical choice or selection
        int choice;

        
   
        // try was  used in case the program can not find the document
        
        try (Scanner scanner = new Scanner (System.in)) {
            // Outer loop that likely continues until the user chooses to exit
            do {
                // Display the menu of options to the user
                System.out.println("""
                                   Choose 1 if you need the quantity of valid and invalid entries
                                   Choose 2 if you wnat to know the highest salary
                                   Choose 3 if you want to calculate the average weekly salary
                                   Choose 4 if you want to exit""");
                // Inner loop to validate that the user enters a single-digit number (0-9)

                do{

                    System.out.println("Enter your choice:");
                    // Read the user's input as a string
                    userInput = scanner.nextLine();


                // Repeat if input is not a single digit (0-9)
                }while (!userInput.matches("\\d+"));

                List<String> fileLines = fileManager.readFile(fileName);

                List<Double> validNumbers = salaryAnalyzer.getValidNumbers(fileLines);


                // Convert the valid input string into an integer
                choice = Integer.parseInt(userInput);
                
                // Switch statement to handle different menu options based on user's choice
                switch (choice) {
                    // Case 1: Count valid and invalid entries in the file
                    case 1 -> {
                            //reset values
                            int[] results = salaryAnalyzer.countEntries(fileLines);

                            int validEntries = results[0];
                            int invalidEntries = results[1];

                        // Output the results
                        System.out.println("\nValid entries\n" + validEntries + "\nInvalid entries \n" + invalidEntries);

                    }
                    // Case 2: find the highest salary in the file
                    case 2 -> {

                            double maxSalary = salaryAnalyzer.findHighestSalary(validNumbers);

                            if(maxSalary == -1){

                                System.out.println("No valid salaries found.");

                            } else {

                                System.out.println("Highest salary is \n" + maxSalary);
                            }


                    }
                    // Case 3: find the average weekly salary in the file
                    case 3 -> {
                       
                            double averageSalary = salaryAnalyzer.calculateAverageSalary(validNumbers);

                            if(averageSalary == -1){

                                System.out.println("No valid data to calculate average.");

                            } else {

                                System.out.println("Average weekly salary is \n" + averageSalary);
                            }
                            
                    }
                    case 4 -> {
                        // Set choice to 4 to ensure the loop exits
                        choice=4;
                        // Notify the user that the program is exiting
                        System.out.println("exit program");
                    }
                    default -> {
                        // Handle any input that doesn't match cases 1–4
                        System.out.println("invalid input, pleas try again");
                    }
                }
            // Continue looping until the user selects option 4 to exit    
            }while (!(choice==4));
            
          
 
        }catch (Exception e){
          // Catch any exceptions, such as file not found or input/output errors

           // Print the error message and specify the file that couldn't be accessed
          System.out.println(e.getMessage() + "Error - unable to find file " + fileName);

    }
    



    }
}
