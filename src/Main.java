import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Get the input file and output file from the user
        File fin = Console.GetFileToRead();
        File fout = Console.GetFileToWrite();

        // Count the number of different symbols in the file
        Counter cnt = new Counter();
        cnt.CountingInTheFile(fin);

        // Write the results to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fout))) {
            writer.write("Number of different symbols of the English alphabet:\n");
            writer.write(cnt.toString());
        } catch (IOException e) {
            System.out.println("An error occurred during recording: " + e.getMessage());
        }
    }
}
