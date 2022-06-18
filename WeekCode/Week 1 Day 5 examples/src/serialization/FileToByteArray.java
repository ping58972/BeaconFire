package serialization;

import java.io.*;
import java.util.Arrays;

public class FileToByteArray {

    public static void main(String[] args) {

        File path = new File("file2.txt");
        File pathOut = new File("fileOut.txt");

        try {
            // convert file to byte array
            byte[] byteArray = convertToByteArray(path);

            System.out.println(Arrays.toString(byteArray));

            // TODO: Coding Assignment - convert byte array back to file
            FileOutputStream fout = new FileOutputStream(pathOut);

                fout.write(byteArray);
                fout.flush();
                fout.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    static byte[] convertToByteArray(File file) throws IOException {
        // create an instance to read from a file
        FileInputStream fin = new FileInputStream(file);

        // create byte array of same length as file
        byte[] arr = new byte[(int)file.length()];

        // read bytes of data from the file input stream into an array of bytes
        fin.read(arr);

        fin.close();
        return arr;
    }

}
