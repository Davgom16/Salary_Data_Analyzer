package com.salarydataanalyzer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalaryAnalyzerTest {

    SalaryAnalyzer analyzer = new SalaryAnalyzer();

    /**
     * Tests numeric validation logic.
     */
    @Test
    void testIsNumeric() {

        assertTrue(analyzer.isNumeric("100"));
        assertTrue(analyzer.isNumeric("-50.5"));

        assertFalse(analyzer.isNumeric("abc"));
        assertFalse(analyzer.isNumeric(null));
    }

    /**
     * Tests extraction of valid numeric values.
     */
    @Test
    void testGetValidNumbers() {

        List<String> input = List.of("100", "abc", "200", "50x");

        List<Double> result = analyzer.getValidNumbers(input);

        assertEquals(2, result.size());

        assertTrue(result.contains(100.0));
        assertTrue(result.contains(200.0));
    }

    /**
     * Tests counting of valid and invalid entries.
     */
    @Test
    void testCountEntries() {

        List<String> input = List.of("100", "abc", "200");

        int[] result = analyzer.countEntries(input);

        assertEquals(2, result[0]);
        assertEquals(1, result[1]);
    }

    /**
     * Tests highest salary calculation.
     */
    @Test
    void testFindHighestSalary() {

        List<Double> data = List.of(100.0, 500.0, 300.0);

        assertEquals(500.0, analyzer.findHighestSalary(data));
    }

    /**
     * Tests behavior when salary list is empty.
     */
    @Test
    void testFindHighestSalaryEmpty() {

        assertEquals(-1, analyzer.findHighestSalary(List.of()));
    }

    /**
     * Tests average salary calculation.
     */
    @Test
    void testCalculateAverageSalary() {

        List<Double> data = List.of(100.0, 200.0, 300.0);

        assertEquals(200.0, analyzer.calculateAverageSalary(data));
    }
}

