package com.salarydataanalyzer;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    /**
     * Tests whether the file is correctly read
     * and stored into a list.
     */
    @Test
    void testReadFile() throws Exception {

        // Create temporary test file
        String fileName = "test.txt";

        try (FileWriter writer = new FileWriter(fileName)) {

            writer.write("100\nabc\n200");
        }

        FileManager fileManager = new FileManager();

        // Read file content
        List<String> result = fileManager.readFile(fileName);

        // Validate file content
        assertEquals(3, result.size());
        assertEquals("100", result.get(0));
        assertEquals("abc", result.get(1));
        assertEquals("200", result.get(2));
    }
}
