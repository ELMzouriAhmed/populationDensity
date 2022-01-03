import org.areas.job.PointOfInterest;
import org.areas.service.AreaService;

import java.io.IOException;
import java.net.URISyntaxException;
public class StartPOIs {

    private static final double MIN_LAT=-48.6;
    private static final double MIN_LON=-37.7;
    private static final  String ID="id1";

    private static final  String FILE_NAME="POIs.tsv";

    public static void main(String[] args) throws IOException, URISyntaxException {
        AreaService areaService= new AreaService(FILE_NAME);
        PointOfInterest pointOfInterest= new PointOfInterest(ID,MIN_LAT,MIN_LON);

        //Calculat number of  POIs from one point of interest in this Area
        System.out.println(areaService.getPointOfInterestInArea(pointOfInterest));

        //Find the N densest Area with N = 2
        System.out.println(areaService.getDensestAreas(2));

    }
}
