import java.io.*;
import java.util.HashMap;

public class Counter {
    private HashMap<Character, Integer> counter;

    public void setCounter(HashMap<Character, Integer> counter) {
        this.counter = counter;
    }

    public HashMap<Character, Integer> getCounter() {
        return counter;
    }

    public Counter() {
        this.counter = new HashMap<>();
    }

    // Count the number of different symbols in the file
    public void CountingInTheFile(File file) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            int c = 0;
            while ((c = fileReader.read()) != -1) {
                char sym = (char) c;
                if (counter.containsKey(sym)) {
                    counter.compute(sym, (key, value) -> value != null ? value + 1 : 1);
                } else {
                    counter.put(sym, 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + file);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the " + file + " file: " + e.getMessage());
        }
    }

    // Convert the counting results to a string
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (char c = 'a'; c <= 'z'; ++c) {
            str.append(c + " = " + (counter.containsKey(c) ? counter.get(c) : "0") + '\n');
        }
        for (char c = 'A'; c <= 'Z'; ++c) {
            str.append(c + " = " + (counter.containsKey(c) ? counter.get(c) : "0") + '\n');
        }
        return str.toString();
    }
}
