package randomquote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomQuote {
    private static final String FILE_PATH = "quotes.txt";
    private static List<String> quotes = new ArrayList<>();

    static {
        loadQuotes();
    }

    private static void loadQuotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                quotes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }

    public static void main(String[] args) {
        System.out.println("Press Enter for a random quote or Ctrl+C to exit.");
        while (true) {
            try {
                System.in.read();
                String quote = generateRandomQuote();
                System.out.println("Random Quote: " + quote);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
