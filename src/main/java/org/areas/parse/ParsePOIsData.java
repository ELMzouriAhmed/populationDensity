package org.areas.parse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public record ParsePOIsData(String fileName) {

    public Stream<String> init() throws IOException, URISyntaxException {
        URL url = getClass().getClassLoader().getResource(this.fileName);
        return Files.lines(Paths.get(url.toURI()));
    }
}
