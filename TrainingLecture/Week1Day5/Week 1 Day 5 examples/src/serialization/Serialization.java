package serialization;

import java.io.*;

public class Serialization {

    public static void serialization(User user) {
        try {
            FileOutputStream file = new FileOutputStream("file.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(user);

            out.close();
            file.close();
            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static User deserialization() {
        User user = null;
        try {
            FileInputStream file = new FileInputStream("file.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            
            user = (User) in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized ");

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        // serialize user
        User user = new User("April", "123");
        serialization(user);

        // deserialize user
        User deserializedUser = deserialization();
        System.out.println(deserializedUser);
        System.out.println(user == deserializedUser);
    }
}
