import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "robert", "bec");
        
        // P1. Loop down the words and print each on a separate line, with two spaces in front of each word.
        // Don’t use map.

        words.stream().forEach(word -> System.out.println("  " + word));

        // P2. Repeat the previous problem, but without the two spaces in front. This is trivial if you use the
        // same approach as in P1, so the point is to use a method reference here, as opposed to an explicit
        // lambda as in P1.

        words.stream().forEach(System.out::println);

        // P3. We assume that we have a method StringUtils.transformedList(List<String>,
        // Function1<String>)
        // where interface Function1<T> { T app(T);}
        // and we produced transformed lists like this:
        // • List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
        // • List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
        // • List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
        // Produce the same lists as above, but this time use streams and the builtin “map” method.

        List<String> excitingWords = words.stream().map(s -> s + "!").collect(Collectors.toList());
        excitingWords.stream().forEach(System.out::println);

        List<String> eyeWords = words.stream().map(s -> s.replace("i", "eye")).collect(Collectors.toList());
        eyeWords.stream().forEach(System.out::println);

        List<String> upperCaseWords = words.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        upperCaseWords.stream().forEach(System.out::println);

        // P4. We assume that we have the method StringUtils.allMatches(List<String>, Predicate1<String>)
        // where interface Predicate1<T> { boolean check(T);}
        // and we produced filtered lists like this:
        // • List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
        // • List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
        // • List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
        // Produce the same lists as above, but this time use “filter”.

        List<String> shortWords = words.stream().filter(s -> s.length() < 4).collect(Collectors.toList());
        shortWords.stream().forEach(System.out::println);

        List<String> wordsWithB = words.stream().filter(s -> s.contains("b")).collect(Collectors.toList());
        wordsWithB.stream().forEach(System.out::println);

        List<String> evenLengthWords = words.stream().filter(s -> (s.length() % 2 == 0)).collect(Collectors.toList());
        evenLengthWords.stream().forEach(System.out::println);

        // P5. Turn the strings into uppercase, keep only the ones that are shorter than 4 characters, of what is
        // remaining, keep only the ones that contain “E”, and print the first result. Repeat the process, except
        // checking for a “Q” instead of an “E”. When checking for the “Q”, try to avoid repeating all the code
        // from when you checked for an “E”.
        
        String p5E = words.stream().map(s -> s.toUpperCase()).filter(s -> s.length() < 4).filter(s -> s.contains("E")).findFirst().orElse("");
        System.out.println(p5E);
        
        // P6. Produce a single String that is the result of concatenating the uppercase versions of all of the
        // Strings. Use a single reduce operation, without using map.

        String p6 = words.stream().reduce("", (partialResult, current) -> partialResult + current.toUpperCase());
        System.out.println(p6);

//         P7. Produce the same String as above, but this time via a map operation that turns the words into
// uppercase, followed by a reduce operation that concatenates them.
    }
}