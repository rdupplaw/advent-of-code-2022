package org.campcleanup;

public record RangePair(Range firstRange, Range secondRange) {
    public boolean hasFullOverlap() {
        return firstRange.fullyOverlaps(secondRange) || secondRange.fullyOverlaps(firstRange);
    }
}
