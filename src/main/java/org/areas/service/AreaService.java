package org.areas.service;

import org.areas.job.Area;
import org.areas.job.AreaMatrixBuilder;
import org.areas.job.PointOfInterest;
import org.areas.parse.BuildPoisData;
import org.areas.parse.ParsePOIsData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class AreaService {

    private final String fileName;
    private AreaMatrixBuilder areaMatrixBuilder= new AreaMatrixBuilder();

    public AreaService(String fileName) throws IOException, URISyntaxException {
        this.fileName = fileName;
        List<PointOfInterest> pointOfInterestList=getListOfPoisParsed();
        pointOfInterestList.stream().forEach(areaMatrixBuilder::addPOI);
    }


    public List<Area> getDensestAreas(int number)  {
        return areaMatrixBuilder.build().stream().sorted((o1, o2) ->o2.getPointOfInterestNumber()-o1.getPointOfInterestNumber() )
                .limit(number)
                .collect(Collectors.toList());
    }

    private List<PointOfInterest> getListOfPoisParsed() throws IOException, URISyntaxException {
        return  new BuildPoisData(new ParsePOIsData(fileName).init()).start();
    }

    public int getPointOfInterestInArea(PointOfInterest pointOfInterest) {
        return areaMatrixBuilder.getPoisNumber(pointOfInterest);
    }
}
