package org.areas.parse;

import org.areas.job.Area;
import org.areas.job.AreaMatrixBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ParseTest {

    ParsePOIsData parsePOIsData=new ParsePOIsData("POIs.tsv");

    @Test
    void checkSizeOfDataParsed() throws IOException, URISyntaxException {
        assertEquals(parsePOIsData.init().collect(Collectors.toList()).size(),9.0 );
    }

    @Test
    void checkFirstDataParsed() throws IOException, URISyntaxException {
        assertEquals(parsePOIsData.init().collect(Collectors.toList()).get(0),"@id @lat @lon" );
    }

    @Test
    void checkSecondDataParsed() throws IOException, URISyntaxException {
        assertEquals(parsePOIsData.init().collect(Collectors.toList()).get(2),"id2 -27.1 8.4" );
    }


}