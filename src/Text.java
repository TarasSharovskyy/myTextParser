import java.text.BreakIterator;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Text {
    private StringBuffer test_text;
    private List<Sentence> sentences = new ArrayList<>();
    private Map<String, Integer> frequencyResponseCalculating = new HashMap<>();

    public Text(StringBuffer test_text) {
        this.test_text = test_text;
        textAnalyzer();
    }

    public StringBuffer getTest_text() {
        return test_text;
    }

    public Map<String, Integer> getFrequencyResponseCalculating() {
        return frequencyResponseCalculating;

    }

    public void textAnalyzer(){
       textToSentences();
            calculateFrequencyDIct();
    }

    private void textToSentences(){
        sentences.clear();
        Pattern regex = Pattern.compile("\\b(Mrs?|Dr|Rev|Mr|Ms|st)\\.$", Pattern.CASE_INSENSITIVE);
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.ENGLISH);
        iterator.setText(test_text.toString());
        int sStart = iterator.first();
        StringBuilder builder = new StringBuilder();
        int sentenceStart = sStart;
        int sentenceEnd;
        boolean newSentence = true;
        for (int end = iterator.next(); end!=BreakIterator.DONE; sStart = end, end = iterator.next()){
            if (newSentence){
                sentenceStart = sStart;
            }
            builder.append(test_text.subSequence(sStart,end).toString().trim());
            String sentence = builder.toString();
            if (!regex.matcher(sentence).find()){
                newSentence = true;
                builder.setLength(0);
            } else {
                newSentence = false;
                builder.append(" ");
            }
            if (newSentence){
                sentenceEnd = end;
                sentences.add(new Sentence(sentence, sentenceStart,sentenceEnd));
                sentenceStart = sStart;
            }
        }
    }

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
