package words;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
        // Split the string on delimiter of 1 or more instances of non-words.
        String[] splitSentence = sentence.split("\\W+");
        ArrayList<String> lowerCaseArray = new ArrayList<>(List.of(splitSentence));
        lowerCaseArray.replaceAll(String::toLowerCase);
        // Convert list to a data structure that does not allow duplicates,
        // then convert and return the final list.
        return new ArrayList<>(new LinkedHashSet<>(lowerCaseArray));
    }
}
