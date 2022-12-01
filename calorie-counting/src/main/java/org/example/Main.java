package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println(new Main().getHighestCalories());
    }

    private int getHighestCalories() throws URISyntaxException, IOException {
        List<String> input = getInput();
        List<Integer> calorieTotals = getCalorieTotals(input);
        return calorieTotals
                .stream()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .limit(3)
                .sum();
    }

    private List<Integer> getCalorieTotals(List<String> calorieEntries) {
        List<Integer> calorieTotals = new ArrayList<>();
        int currentCalorieTotal = 0;
        for (String calorieEntry : calorieEntries) {
            if (calorieEntry.isBlank()) {
                calorieTotals.add(currentCalorieTotal);
                currentCalorieTotal = 0;
                continue;
            }
            currentCalorieTotal += Integer.parseInt(calorieEntry);
        }
        return calorieTotals;
    }

    private List<String> getInput() throws URISyntaxException, IOException {
        return Files.readAllLines(new File(getClass().getClassLoader().getResource("input.txt").toURI()).toPath());
    }
}