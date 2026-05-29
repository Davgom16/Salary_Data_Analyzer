package com.salarydataanalyzer;

import java.util.ArrayList;
import java.util.List;

public class SalaryAnalyzer {

    /**
     * Checks whether a string contains a valid numeric value.
     *
     * @param line input string
     * @return true if the value is numeric, otherwise false
     */
    public boolean isNumeric(String line) {

        return line != null && line.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Extracts valid numeric values from the file data.
     *
     * @param fileLines list containing file lines
     * @return list of valid salary values
     */
    public List<Double> getValidNumbers(List<String> fileLines) {

        List<Double> validNumbers = new ArrayList<>();

        // Convert valid numeric strings into double values
        for (String line : fileLines) {

            if (isNumeric(line)) {

                validNumbers.add(Double.parseDouble(line));
            }
        }

        return validNumbers;
    }

    /**
     * Counts valid and invalid entries from the input data.
     *
     * @param fileLines list containing file lines
     * @return array with valid and invalid entry counts
     */
    public int[] countEntries(List<String> fileLines) {

        int validEntries = 0;
        int invalidEntries = 0;

        for (String line : fileLines) {

            if (isNumeric(line)) {
                validEntries++;
            } else {
                invalidEntries++;
            }
        }

        return new int[]{validEntries, invalidEntries};
    }

    /**
     * Finds the highest salary value.
     *
     * @param validNumbers list of valid salary values
     * @return highest salary or -1 if the list is empty
     */
    public double findHighestSalary(List<Double> validNumbers) {

        if (validNumbers.isEmpty()) {
            return -1;
        }

        double max = validNumbers.get(0);

        // Compare each salary to find the maximum value
        for (double number : validNumbers) {

            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    /**
     * Calculates the average salary value.
     *
     * @param validNumbers list of valid salary values
     * @return average salary or -1 if the list is empty
     */
    public double calculateAverageSalary(List<Double> validNumbers) {

        if (validNumbers.isEmpty()) {
            return -1;
        }

        double sum = 0;

        // Sum all salary values
        for (double number : validNumbers) {

            sum += number;
        }

        return sum / validNumbers.size();
    }
}
