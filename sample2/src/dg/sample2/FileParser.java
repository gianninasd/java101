package dg.sample2;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/**
 * Application to read each line a given file and process it.
 */
public class FileParser {

  private static final String URL_FILE_PREFIX = "file:///";

  public static void main(String [] args) {
    System.out.println("\n////////// SAMPLE 2 //////////");

    FileParser parser = new FileParser();

    if( args.length == 0 ) {
      System.out.println("Filename missing as argument");
    }
    else {
      parser.processFile( args[0] );
    }

    System.out.println("//////////////////////////////");
  }

  private void processFile( String fileName ) {
    System.out.println("Parsing file: " + fileName);

    List<String> lines;
    try {
      lines = Files.readAllLines(Paths.get(new URL(URL_FILE_PREFIX + fileName).toURI()));
      Iterator<String> it = lines.iterator();
      System.out.println("Number of records: " + lines.size());

      while( it.hasNext() ) {
        System.out.println("Line: " + it.next());
      }
    }
    catch (Exception e) {
      System.out.println("Unable to read file: " + e);
      e.printStackTrace();
    }
  }
}
