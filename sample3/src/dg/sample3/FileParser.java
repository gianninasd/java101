package dg.sample3;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Application to read each line a given file and process it.
 */
public class FileParser {

  private static Logger logger = Logger.getLogger(FileParser.class.getName());

  private static final String URL_FILE_PREFIX = "file:///";

  /**
   * Where application starts
   */
  public static void main(String [] args) {
    logger.info("////////// SAMPLE 2 //////////");

    FileParser parser = new FileParser();

    if( args.length == 0 ) {
      logger.info("Filename missing as argument");
    }
    else {
      parser.processFile( args[0] );
    }

    logger.info("//////////////////////////////");
  }

  /**
   * Reads the file provided and parses each record
   */
  private void processFile( String fileName ) {
    logger.info("Parsing file: " + fileName);

    List<String> lines;
    String line;
    PaymentRecord rec;

    try {
      lines = Files.readAllLines(Paths.get(new URL(URL_FILE_PREFIX + fileName).toURI()));
      Iterator<String> it = lines.iterator();
      logger.info("Number of records: " + lines.size());

      while( it.hasNext() ) {
        line = it.next();

        if( line != null && line != "" && line.length() != 0 ) {
          rec = PaymentRecord.parse( line );
          logger.info("rec: " + rec);
        }
      }

      logger.info("Total records parsed: " + PaymentRecord.totalCount);
    }
    catch (Exception e) {
      logger.info("Unable to read file: " + e);
      e.printStackTrace();
    }
  }
}
