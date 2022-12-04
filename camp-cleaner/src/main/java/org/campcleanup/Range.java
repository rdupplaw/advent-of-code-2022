package org.campcleanup;

public record Range(int start, int end) {

    public boolean fullyOverlaps(Range secondRange) {
        return start <= secondRange.start() && end >= secondRange.end();
    }
}
