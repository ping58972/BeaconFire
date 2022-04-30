package serialization.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

    public static void main(String[] args) {

        // create a reader instance
        BufferedReader reader = null;

        try { // attempt to read contents of file line by line
            reader = new BufferedReader(new FileReader("buffered-reader.txt"));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) { // handle any exceptions
            e.printStackTrace();

        } finally { // attempt to close reader
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
