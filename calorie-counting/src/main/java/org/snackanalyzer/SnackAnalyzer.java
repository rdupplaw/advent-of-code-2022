package org.snackanalyzer;

import java.io.IOException;
import java.net.URISyntaxException;

import static java.util.Comparator.reverseOrder;

public class SnackAnalyzer {

    private final CalorieImporter calorieImporter;

    public SnackAnalyzer(CalorieImporter calorieImporter) {
        this.calorieImporter = calorieImporter;
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        CalorieImporter calorieImporter = new CalorieImporter("input.txt", "\\n{2,}", "\\n");
        System.out.println(new SnackAnalyzer(calorieImporter).threeHighestCaloriesTotal());
    }

    private int threeHighestCaloriesTotal() throws URISyntaxException, IOException {
        return calorieImporter.parseCalorieTotals().stream()
                .sorted(reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }
}