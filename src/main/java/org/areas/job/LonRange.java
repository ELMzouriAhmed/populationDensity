package org.areas.job;

public record LonRange(Double minLon, Double maxLon) {

    boolean isIncludeOn(double lon){
        return (lon>=minLon && lon<=maxLon);
    }

    @Override
    public String toString() {
        return "minLon=" + minLon + ", maxLon=" + maxLon;
    }
}
