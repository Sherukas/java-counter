import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;

public class Console {
    // Get the file to read from the user
    public static File GetFileToRead() {
        File fin = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the name of the file you want to read: ");
            fin = new File(reader.readLine());
            while (true) {
                if (!fin.exists()) {
                    System.out.print("There is no such file. Enter the correct name: ");
                    fin = new File(reader.readLine());
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error when trying to read the input data: " + e.getMessage());
        }
        return fin;
    }

    // Get the file to write to from the user
    public static File GetFileToWrite() {
        File fout = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the name of the file you want to write to: ");
            fout = new File(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error when trying to read the input data: " + e.getMessage());
        }
        return fout;
    }
}
