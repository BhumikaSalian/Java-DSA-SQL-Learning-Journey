import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindCharInList{
    public static void main(String[] args) {
        String[] words = {"abc", "code", "aaa", "def"};
        char x = 'z';
        List<Integer> Collected = IntStream.range(0, words.length).
            filter(index->words[index].indexOf(x) != -1).boxed().collect(Collectors.toList());
        System.out.println(Collected);
    }
}