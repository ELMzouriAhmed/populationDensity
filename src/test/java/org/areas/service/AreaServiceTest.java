package org.areas.service;

import org.areas.job.Area;
import org.areas.job.LatRange;
import org.areas.job.LonRange;
import org.areas.job.PointOfInterest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AreaServiceTest {
    private  AreaService areaService = new AreaService("POIs.tsv");

    AreaServiceTest() throws IOException, URISyntaxException {
    }


    @Test
    void checkMostDenseAreaService() throws IOException, URISyntaxException {
        List<Area> areas= Arrays.asList(new Area(new LatRange(-2.5, -2.0),new LonRange(38.0,38.5)));
        assertEquals(areaService.getDensestAreas(1),areas);
    }

    @Test
    void checkDenseAreaServiceWithNumber() throws IOException, URISyntaxException {
        List<Area> areas= Arrays.asList(new Area(new LatRange(-2.5, -2.0),new LonRange(38.0,38.5)),
                new Area(new LatRange(6.5, 7.0),new LonRange(-7.0, -6.5)));
        assertEquals(areaService.getDensestAreas(2),areas);
    }

    @Test
    void calculatePOIsNumberInArea() throws IOException, URISyntaxException {
        PointOfInterest pointOfInterest=new PointOfInterest("id4",-2.3,38.3);
        PointOfInterest pointOfInterest2=new PointOfInterest("id3",6.6,-6.9);
        assertEquals(areaService.getPointOfInterestInArea(pointOfInterest),3);
        assertEquals(areaService.getPointOfInterestInArea(pointOfInterest2),2);
    }


}