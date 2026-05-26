import java.util.Scanner;
import java.util.List;

public class App {

    public static boolean isNumeric(String data) {

        return data.matches("\\d+(\\.\\d+)?");
    }


    public static void main(String[] args) {
        
        //Declaring variables
        
        // Declare a variable to store the document (file) name
        String doc_name;
        // Assign the file name "data.txt" to the variable
        doc_name="data.txt";

        FileManager fileManager = new FileManager();
        
        // variables used
        
        // Declare a variable to store a numeric value
        double num;
        // Declare a string variable to store user's choice or input
        String choose;
        // Declare an integer variable to represent a numerical choice or selection
        int choice;
        // Initialize a counter to track total number of inputs or iterations
        int count=0;
        // Initialize a counter to track the number of valid entries
        int count_real=0;
        // Initialize a counter to track the number of errors or invalid entries
        int count_error=0;
        // Initialize a variable to hold the sum of values
        double sum=0;
        // Declare a variable to store the average of the numbers
        double avg;
        // Declare a variable to store the maximum value among the numbers
        double max;
        
   
        // try was  used in case the program can not find the document
        
        try {
            // Create a Scanner object to read input from the keyboard
           Scanner myKB = new Scanner (System.in);
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
                    choose = myKB.nextLine();


                // Repeat if input is not a single digit (0-9)
                }while (!choose.matches("[0-9]"));

                List<String> fileData = fileManager.readFile(doc_name);
                count_real=0;
                count_error=0;

                for(String data : fileData){

                    if (isNumeric(data)){

                        count_real++;

                    } else {

                        count_error++;

                    }
                }

                // Convert the valid input string into an integer
                choice = Integer.parseInt(choose);
                
                // Switch statement to handle different menu options based on user's choice
                switch (choice) {
                    // Case 1: Count valid and invalid entries in the file
                    case 1 -> {
                            //reset values
                            count_real=0;
                            count_error=0;

                            for(String data : fileData){

                                if (isNumeric(data)) {

                                    count_real++;

                                } else {

                                    count_error++;

                                }
                            }

                        // Output the results
                        System.out.println("\nValid entries\n" + count_real + "\nInvalid entries \n" + count_error);

                    }
                    // Case 2: find the highest salary in the file
                    case 2 -> {
                        //reset count value
                        count=0;
                        max = Double.MIN_VALUE;

                        for(String data : fileData){

                            if (isNumeric(data)) {

                               num = Double.parseDouble(data);

                                if(num > max) max = num;

                                count++;

                            } else {

                                count_error++;

                            }
                        }

                        if(count == 0){
                            System.out.println("No valid salaries found.");
                            break;
                        }

                        // Print out the highest salary found
                        System.out.println("Highest salary is \n" + max);

                    }
                    // Case 3: find the average weekly salary in the file
                    case 3 -> {
                        //reset values
                        sum=0;
                        avg=0;
                        count=0;

                        for(String data : fileData){

                            if (isNumeric(data)) {

                                num = Double.parseDouble(data);

                                sum += num;

                                count++;

                            }
                        }

                        if (count > 0) {
                             // Calculate the average by dividing the sum by the number of valid entries
                            avg = sum / count;
                            // Print the average salary
                            System.out.println("Average weekly salary is \n" + avg);
                        } else {
                            // Handle case where there are no valid entries to avoid division by zero
                            System.out.println("No valid data to calculate average.");
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
          System.out.println(e.getMessage() + "Error - unable to find file " + doc_name);

    }
    



    }
}
