import java.text.BreakIterator;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Text {
    private StringBuffer test_text;
    private List<Sentence> sentences = new ArrayList<>();
    private HashMap<String, Integer> frequencyResponseCalculating = new HashMap<>();

    public Text(StringBuffer test_text) {
        this.test_text = test_text;
    }

    public StringBuffer getTest_text() {
        return test_text;
    }

    public HashMap<String, Integer> getFrequencyResponseCalculating() {
        return frequencyResponseCalculating;

    }

    public void textAnalyzer(){
//        textToSentences();
            calculateFrequencyDIct();
    }

//    private void textToSentences(){
//        sentences = null;
//        Pattern regex = Pattern.compile("\\b(Mr|Ms|Mrs|Dr|st)\\.$", Pattern.CASE_INSENSITIVE);
//        BreakIterator iterator = BreakIterator.getLineInstance(Locale.ENGLISH);
//        iterator.setText(test_text.toString());
//        int st = iterator.first();
//        StringBuilder builder = new StringBuilder();
//        int start = st;
//        int end;
//        boolean nextSentence = true;
//        for (end = iterator.next(); end != iterator.DONE; st=end, end=iterator.next()){
//            if (nextSentence){
//                start = st;
//            }
//            builder.append(test_text.substring(st,end).trim());
//        String builderSentence = builder.toString();
//        }
//        if (!regex.matcher((CharSequence) sentences).find()){
//            nextSentence = true;
//            builder.setLength(0);
//        } else {
//            nextSentence = false;
//            builder.append(" ");
//        }
//        if (nextSentence){
//            end = end;
//            sentences.add(new Sentence(nextSentence,start,end));
//            start = st;
//        }
//    }

    private void calculateFrequencyDIct(){
        for(Sentence sentence :sentences){
            for (String word : sentence.getSentenceToWord()){
                frequencyResponseCalculating.put(word, frequencyResponseCalculating.getOrDefault(word,0)+1);
            }
        }
        frequencyResponseCalculating = frequencyResponseCalculating.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue)->oldValue, LinkedHashMap::new));
    }




}
