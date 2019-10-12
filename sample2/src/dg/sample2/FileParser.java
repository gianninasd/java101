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

  /**
   * Where application starts
   */
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

  /**
   * Reads the file provided and parses each record
   */
  private void processFile( String fileName ) {
    System.out.println("Parsing file: " + fileName);

    List<String> lines;
    String line;
    PaymentRecord rec;

    try {
      lines = Files.readAllLines(Paths.get(new URL(URL_FILE_PREFIX + fileName).toURI()));
      Iterator<String> it = lines.iterator();
      System.out.println("Number of records: " + lines.size() + "\n");

      while( it.hasNext() ) {
        line = it.next();
        //System.out.println("Line: " + line);

        if( line != null && line != "" && line.length() != 0 ) {
          rec = PaymentRecord.parse( line );
          System.out.println("rec: " + rec);
        }
      }

      System.out.println("\nTotal records parsed: " + PaymentRecord.totalCount);
    }
    catch (Exception e) {
      System.out.println("Unable to read file: " + e);
      e.printStackTrace();
    }
  }
}
