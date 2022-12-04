package org.campcleanup;

import java.util.List;

public class RangePairParser {

    private final RangeParser rangeParser;

    public RangePairParser(RangeParser rangeParser) {
        this.rangeParser = rangeParser;
    }

    List<RangePair> getRangePairs(List<String> input) {
        return input.stream()
                .map(s -> s.split(","))
                .map(this::parseRangePairStrings)
                .toList();
    }

    private RangePair parseRangePairStrings(String[] strings) {
        String firstRange = strings[0];
        String secondRange = strings[1];
        Range firstRangeObj = rangeParser.getRange(firstRange);
        Range secondRangeObj = rangeParser.getRange(secondRange);
        return new RangePair(firstRangeObj, secondRangeObj);
    }

}