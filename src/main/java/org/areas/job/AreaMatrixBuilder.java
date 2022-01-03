package org.areas.job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AreaMatrixBuilder {

    private final List<Area> areaList;

    public AreaMatrixBuilder() {
        this.areaList = new ArrayList<>();
    }

    public Area addPOI(PointOfInterest pointOfInterest) {
        var area = new Area(pointOfInterest);
        var result = areaList.stream().filter(a -> a.equals(area)).findFirst();
        if (result.isPresent()) {
            result.get().insertPointOfInterest(pointOfInterest);
            return area;
        }
        areaList.add(area);
        return area;
    }

    public List<Area> build() {
        return Collections.unmodifiableList(areaList);
    }


    public int getPoisNumber(PointOfInterest pointOfInterest) {
        var area = new Area(pointOfInterest);
        return areaList.stream().filter(a -> a.equals(area)).findFirst().map(a->a.getPointOfInterestNumber()).get();
    }
}
