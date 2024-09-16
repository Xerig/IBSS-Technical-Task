package words;

import java.util.ArrayList;
import java.util.List;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
        //Split the string on delimiter of 1 or more instances of non-words.
        String[] splitSentence = sentence.split("\\W+");
        ArrayList<String> lowerCaseArray = new ArrayList<>(List.of(splitSentence));
        lowerCaseArray.replaceAll(String::toLowerCase);
        for (String word : lowerCaseArray) {
            System.out.println(word);
        }
        throw new UnsupportedOperationException();
    }
}
