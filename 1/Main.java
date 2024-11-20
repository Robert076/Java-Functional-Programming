import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "robert");
        
        // P1. Loop down the words and print each on a separate line, with two spaces in front of each word.
        // Don’t use map.

        words.stream().forEach(word -> System.out.println("  " + word));

        // P2. Repeat the previous problem, but without the two spaces in front. This is trivial if you use the
        // same approach as in P1, so the point is to use a method reference here, as opposed to an explicit
        // lambda as in P1.

        words.stream().forEach(System.out::println);
    }
}