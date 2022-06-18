package serialization.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {

    public static void main(String[] args) {

        // create a writer instance
        BufferedWriter writer = null;

        try { //attempt to write to a file

            writer = new BufferedWriter(new FileWriter("buffered-writer.txt"));
            writer.write("qwertyuiop");

        } catch (IOException e) {
            e.printStackTrace();

        } finally { // attempt to close writer
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
