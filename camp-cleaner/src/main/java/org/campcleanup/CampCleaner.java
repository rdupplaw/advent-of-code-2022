package org.campcleanup;

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CampCleaner {

  private final Object textParser;

  public CampCleaner(Object textParser) {
    this.textParser = textParser;
  }

  public void duplicateFinder() throws IOException, URISyntaxException {
    // parse text into an array
    List<RangeObject> listOfSections = new ArrayList<RangeObject>();

    // load the data from file
    var listOfSectionsString = Files.readAllLines(Paths.get(requireNonNull(getClass().getClassLoader().getResource("input.txt")).toURI()));

    for(String string : listOfSectionsString) {
      int end = 7;
      int start = 9;
      listOfSections.add(new RangeObject(end, start));
    }

    // find the duplicates
      // if the first element is
  }

  public static void main(String[] args) throws IOException, URISyntaxException {
    CampCleaner campCleaner = new CampCleaner(null);
    campCleaner.duplicateFinder();
  }
}
