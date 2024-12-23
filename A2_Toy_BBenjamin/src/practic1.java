import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class practic1 {
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,14,15);
        int result = numbers.stream()
                .filter(n ->  (n%3 != 0 || n%7==0))
                .map(n -> n - 1)
                .reduce(0, Integer::sum)%5;
        System.out.println(": " + result);
    }
}
