package org.areas.job;

public record LatRange(Double minLat, Double maxLat) {

    boolean isIncludeOn(double lat){
        return (lat>=minLat && lat<=maxLat);
    }

    @Override
    public String toString() {
        return "minLat=" + minLat + ", maxLat=" + maxLat;
    }
}
