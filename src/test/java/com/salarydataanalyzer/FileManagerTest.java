package com.salarydataanalyzer;

import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    void testReadFile() throws Exception {

        // Crear archivo temporal
        String fileName = "test.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("100\nabc\n200");
        }

        FileManager fm = new FileManager();
        List<String> result = fm.readFile(fileName);

        assertEquals(3, result.size());
        assertEquals("100", result.get(0));
        assertEquals("abc", result.get(1));
    }
}