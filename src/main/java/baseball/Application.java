package baseball;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        NumberGenerator generator = new NumberGenerator();
//        List<Integer> numbers = generator.createRandomNumbers();
//        System.out.println(numbers);

        Judgement judgement = new Judgement();
        int count = judgement.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        System.out.println(count);
    }
}
