package org.areas.job;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Area {
    private final LatRange latRange;
    private final LonRange lonRange;
    private final List<PointOfInterest> pointOfInterestList = new ArrayList<>();

    private final static Double VALUE_OF_INCREMENT_AREA = 0.5;

    public Area(LatRange latRange, LonRange lonRange) {
        this.latRange = latRange;
        this.lonRange = lonRange;
    }

    public Area(PointOfInterest indexPoint) {
        this(buildLat(indexPoint), buildLon(indexPoint));
        pointOfInterestList.add(indexPoint);
    }

    public boolean insertPointOfInterest(PointOfInterest pointOfInterest) {
        if (this.latRange.isIncludeOn(pointOfInterest.lat()) && this.lonRange.isIncludeOn(pointOfInterest.lon())) {
            pointOfInterestList.add(pointOfInterest);
            return true;
        }
        return false;
    }

    public int getPointOfInterestNumber() {
        return pointOfInterestList.size();
    }

    private static LonRange buildLon(PointOfInterest indexPoint) {
        if (Math.abs(indexPoint.lon() - indexPoint.lon().intValue()) <= VALUE_OF_INCREMENT_AREA) {
            return buildMinLon(indexPoint);
        }
        return buildMaxLon(indexPoint);
    }

    private static LatRange buildLat(PointOfInterest indexPoint) {
        if (Math.abs(indexPoint.lat() - indexPoint.lat().intValue()) <= VALUE_OF_INCREMENT_AREA) {
            return buildMinLat(indexPoint);
        }
        return buildMaxLat(indexPoint);
    }

    private static LonRange buildMaxLon(PointOfInterest indexPoint) {
        return new LonRange((indexPoint.lon().intValue() > 0) ? indexPoint.lon().intValue() + VALUE_OF_INCREMENT_AREA : indexPoint.lon().intValue() - 1,
                (indexPoint.lon().intValue() > 0) ? indexPoint.lon().intValue() + 1 : indexPoint.lon().intValue() - VALUE_OF_INCREMENT_AREA);
    }

    private static LonRange buildMinLon(PointOfInterest indexPoint) {
        return new LonRange((indexPoint.lon().intValue() > 0) ? indexPoint.lon().intValue() : indexPoint.lon().intValue() - VALUE_OF_INCREMENT_AREA,
                (indexPoint.lon().intValue() > 0) ? indexPoint.lon().intValue() + VALUE_OF_INCREMENT_AREA : indexPoint.lon().intValue());
    }

    private static LatRange buildMaxLat(PointOfInterest indexPoint) {
        return new LatRange((indexPoint.lat().intValue() > 0) ? indexPoint.lat().intValue() + VALUE_OF_INCREMENT_AREA : indexPoint.lat().intValue() - 1,
                (indexPoint.lat().intValue() > 0) ? indexPoint.lat().intValue() + 1 : indexPoint.lat().intValue() - VALUE_OF_INCREMENT_AREA);
    }

    private static LatRange buildMinLat(PointOfInterest indexPoint) {
        return new LatRange((indexPoint.lat().intValue() > 0) ? indexPoint.lat().intValue() : indexPoint.lat().intValue() - VALUE_OF_INCREMENT_AREA,
                (indexPoint.lat().intValue() > 0) ? indexPoint.lat().intValue() + VALUE_OF_INCREMENT_AREA : indexPoint.lat().intValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return latRange.equals(area.latRange) && lonRange.equals(area.lonRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latRange, lonRange);
    }

    @Override
    public String toString() {
        return "{"
                + latRange +
                ", " + lonRange +
                '}';
    }

}
