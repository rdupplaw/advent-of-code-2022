package org.campcleanup;

public class RangeParser {
    Range getRange(String range) {
        String[] rangeSplit = range.split("-");
        return new Range(Integer.parseInt(rangeSplit[0]), Integer.parseInt(rangeSplit[1]));
    }
}