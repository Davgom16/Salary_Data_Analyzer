package com.salarydataanalyzer;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    /**
     * Reads all lines from the specified file
     * and stores them in a list.
     *
     * @param fileName name of the input file
     * @return list containing all file lines
     * @throws Exception if the file cannot be read
     */
    public List<String> readFile(String fileName) throws Exception {

        // Store file content line by line
        List<String> data = new ArrayList<>();

        // Read file using Scanner
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {

            // Add each line to the list
            while (scanner.hasNext()) {
                data.add(scanner.nextLine());
            }
        }

        return data;
    }
}
