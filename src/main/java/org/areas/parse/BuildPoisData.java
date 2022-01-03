package org.areas.parse;

import org.areas.job.PointOfInterest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record BuildPoisData(Stream<String> dataFileLines) {


    public List<PointOfInterest> start() {
        return this.dataFileLines.skip(1).map(line -> buildPoi(line)).collect(Collectors.toList());
    }

    private PointOfInterest buildPoi(String line) {
        String[] PoiLines = line.split(" ");
        return new PointOfInterest(PoiLines[0], Double.parseDouble(PoiLines[1]), Double.parseDouble(PoiLines[2]));
    }
}
