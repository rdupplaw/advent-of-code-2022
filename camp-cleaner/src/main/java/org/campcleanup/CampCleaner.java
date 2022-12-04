package org.campcleanup;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class CampCleaner {

    private final RangePairParser rangePairParser;

    public CampCleaner(RangePairParser rangePairParser) {
        this.rangePairParser = rangePairParser;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        RangeParser rangeParser = new RangeParser();
        RangePairParser rangePairParser = new RangePairParser(rangeParser);
        CampCleaner campCleaner = new CampCleaner(rangePairParser);
        System.out.println(campCleaner.duplicateFinder());
    }

    public long duplicateFinder() throws IOException, URISyntaxException {
        List<String> input = Files.readAllLines(Paths.get(requireNonNull(getClass().getClassLoader().getResource("input.txt")).toURI()));
        List<RangePair> rangePairs = rangePairParser.getRangePairs(input);
        return getNumberOfOverlappingRanges(rangePairs);
    }

    private long getNumberOfOverlappingRanges(List<RangePair> rangePairs) {
        return rangePairs.stream()
                .filter(RangePair::hasFullOverlap)
                .count();
    }

}
