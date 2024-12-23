import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16);

        int result = numbers.stream()
                .filter(n -> (n % 5 == 0 || n % 2 == 0))  // Eliminate numbers not multiple of 4
                .map(n -> n + 1)               // Transform each remaining number into its successor
                .reduce(0, Integer::sum)    // Compute the sum
                %2;

        System.out.println("Result: " + result);
    }


}
