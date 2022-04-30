/*
 * Author: Ping Nalongsone Danddank.
 * email: ndanddank@gmail.com
 * Question 4:  Write a method to convert the given byte array back into a file:
[104, 116, 116, 112, 115, 58, 47, 47, 119, 119, 119, 46, 121, 111, 117, 116, 117, 98,
101, 46, 99, 111, 109, 47, 119, 97, 116, 99, 104, 63, 118, 61, 100, 81, 119, 52, 119, 57, 87,
103, 88, 99, 81]
 * */
import java.io.*;
public class ByteArrayToFile {
    public static void main(String[] args) {
        byte[] bytes =   {104, 116, 116, 112, 115, 58, 47, 47, 119, 119, 119, 46, 121, 111, 117, 116, 117, 98,
                101, 46, 99, 111, 109, 47, 119, 97, 116, 99, 104, 63, 118, 61, 100, 81, 119, 52, 119, 57, 87,
                103, 88, 99, 81};
        if(convertByteArrayToFile(bytes, "byteToFile.txt")){
            System.out.println("convert Byte Array To File success!");
        } else {
            System.out.println("Convert fails.");
        }
    }
    // to convert the given byte array back into a file
    // @params: bytes -> byte[] array of byte of string for file.
    //          fileName -> String , file name to create a new file.
    // @ return boolean when convert success else false to fail.
    public static boolean convertByteArrayToFile(byte[] bytes, String fileName){
        File path = new File(fileName);
        try(FileOutputStream fout = new FileOutputStream(path)){
            fout.write(bytes);
            fout.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
            return false;
        }
        return true;
    }
}
