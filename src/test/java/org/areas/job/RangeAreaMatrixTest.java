package org.areas.job;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangeAreaMatrixTest {
    private List<PointOfInterest> pointOfInterests = Arrays.asList(
            new PointOfInterest("id1",-48.6,-37.7),
            new PointOfInterest("id2",-27.1,8.4),
            new PointOfInterest("id3",6.6,-6.9),
            new PointOfInterest("id4",-2.3,38.3),
            new PointOfInterest("id5",6.8,-6.9),
            new PointOfInterest("id6",-2.5,38.3),
            new PointOfInterest("id7",0.1,-0.1),
            new PointOfInterest("id8",-2.1,38.1));


    @Test
    void checkWrongLonRange(){
        LonRange lonRange= new LonRange(-27.5,-27.0);
        assertEquals(lonRange.isIncludeOn(-27.6),false);
    }

    @Test
    void checkWrongLatRange(){
        LatRange latRange= new LatRange(48.0,48.5);
        assertEquals(latRange.isIncludeOn(48.8),false);
    }
    @Test
    void checkLonRange(){
        LonRange lonRange= new LonRange(-27.5,-27.0);
        assertEquals(lonRange.isIncludeOn(-27.3),true);
    }

    @Test
    void checkLatRange(){
        LatRange latRange= new LatRange(48.0,48.5);
        assertEquals(latRange.isIncludeOn(48.1),true);
    }

    @Test
    void checkAreaInsertOfPointInterest(){
        PointOfInterest firstPointOfInterest= new PointOfInterest("d1", -48.6, -37.7);
        Area area= new Area(firstPointOfInterest);
        PointOfInterest pointOfInterestnew=new  PointOfInterest("id2",-27.1,8.4);

        assertEquals(area.insertPointOfInterest(pointOfInterestnew),false);
    }

    @Test
     void shouldCorrectlyCalculateArea(){
        PointOfInterest pointOfInterest= new PointOfInterest("d1", -48.6, -37.7);
        AreaMatrixBuilder areaMatrixBuilder= new AreaMatrixBuilder();
        Area area = areaMatrixBuilder.addPOI(pointOfInterest);
        assertEquals(new Area(new LatRange(-49.0,-48.5),new LonRange(-38.0,-37.5)),area);
    }
    @Test
    void checkAreaListSize(){
        AreaMatrixBuilder areaMatrixBuilder= new AreaMatrixBuilder();
        pointOfInterests.stream().forEach(areaMatrixBuilder::addPOI);
        assertEquals(areaMatrixBuilder.build().size(),5);
    }

    @Test
    void checkFirstArea(){
        AreaMatrixBuilder areaMatrixBuilder= new AreaMatrixBuilder();
        pointOfInterests.stream().forEach(areaMatrixBuilder::addPOI);
        List<Area> areas = areaMatrixBuilder.build();
        assertEquals(1,areas.get(0).getPointOfInterestNumber());
    }

    @Test
    void shouldCorrectlyCalculateListArea(){
        AreaMatrixBuilder areaMatrixBuilder= new AreaMatrixBuilder();
        pointOfInterests.stream().forEach(areaMatrixBuilder::addPOI);
        List<Area> areas = areaMatrixBuilder.build();
        assertEquals(1,areas.get(1).getPointOfInterestNumber());
        assertEquals(2,areas.get(2).getPointOfInterestNumber());
        assertEquals(3,areas.get(3).getPointOfInterestNumber());
        assertEquals(1,areas.get(4).getPointOfInterestNumber());

    }




}