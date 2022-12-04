package org.snackanalyzer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.readString;
import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;

public class CalorieImporter {

    private final String resourceFilename;
    private final String elfSeparator;
    private final String calorieSeparator;

    public CalorieImporter(String resourceFilename, String elfSeparator, String calorieSeparator) {
        this.resourceFilename = resourceFilename;
        this.elfSeparator = elfSeparator;
        this.calorieSeparator = calorieSeparator;
    }

    List<Integer> parseCalorieTotals() throws URISyntaxException, IOException {
        return stream(getInput().split(elfSeparator))
                .map(s -> s.split(calorieSeparator))
                .map(strings -> stream(strings)
                        .mapToInt(Integer::parseInt)
                        .sum())
                .collect(Collectors.toList());
    }

    String getInput() throws URISyntaxException, IOException {
        return readString(new File(requireNonNull(getClass().getClassLoader().getResource(resourceFilename)).toURI()).toPath());
    }
}