package com.salarydataanalyzer;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SalaryAnalyzerTest {

    SalaryAnalyzer analyzer = new SalaryAnalyzer();

    @Test
    void testIsNumeric() {
        assertTrue(analyzer.isNumeric("100"));
        assertTrue(analyzer.isNumeric("-50.5"));
        assertFalse(analyzer.isNumeric("abc"));
        assertFalse(analyzer.isNumeric(null));
    }

    @Test
    void testGetValidNumbers() {
        List<String> input = List.of("100", "abc", "200", "50x");
        List<Double> result = analyzer.getValidNumbers(input);

        assertEquals(2, result.size());
        assertTrue(result.contains(100.0));
        assertTrue(result.contains(200.0));
    }

    @Test
    void testCountEntries() {
        List<String> input = List.of("100", "abc", "200");

        int[] result = analyzer.countEntries(input);

        assertEquals(2, result[0]); // valid
        assertEquals(1, result[1]); // invalid
    }

    @Test
    void testFindHighestSalary() {
        List<Double> data = List.of(100.0, 500.0, 300.0);

        assertEquals(500.0, analyzer.findHighestSalary(data));
    }

    @Test
    void testFindHighestSalaryEmpty() {
        assertEquals(-1, analyzer.findHighestSalary(List.of()));
    }

    @Test
    void testCalculateAverageSalary() {
        List<Double> data = List.of(100.0, 200.0, 300.0);

        assertEquals(200.0, analyzer.calculateAverageSalary(data));
    }
}