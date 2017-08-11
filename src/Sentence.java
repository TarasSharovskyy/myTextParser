import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private String sentence;
    private int sentenceStart = 0;
    private int sentenceEnd;
    private String shortWord = "";
    private String longWord = "";
    private List<String> sentenceToWords = new ArrayList<>();

    public Sentence(String sentence, int start, int end) {
        this.sentence = sentence;
        this.sentenceStart = start;
        this.sentenceEnd = end;
        this.shortWord = shortWord;
        this.longWord = longWord;
        this.sentenceToWords = sentenceToWords;
    }




    public String getSentence() {
        return sentence;
    }

    public int getSentenceStart() {
        return sentenceStart;
    }

    public int getSentenceEnd() {
        return sentenceEnd;
    }

    public String getShortWord() {
        return shortWord;
    }

    public String getLongWord() {
        return longWord;
    }

    public List<String> getSentenceToWord() {
        return sentenceToWords;
    }

    private void sentenceToWordParser(){
        sentenceToWords.clear();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(sentence);
        int lastIndexOf = breakIterator.next();
        while (BreakIterator.DONE!=lastIndexOf){
            int firstIndexOf = lastIndexOf;
            lastIndexOf = breakIterator.next();
        if (lastIndexOf!=BreakIterator.DONE&&Character.isLetterOrDigit(sentence.charAt(firstIndexOf)));
        String sentenceToWord = sentence.substring(firstIndexOf, lastIndexOf);
        sentenceToWords.add(sentenceToWord);
        if (sentenceToWord.length()>longWord.length()){
            longWord = sentenceToWord;
        } else if (shortWord.length()==0||sentenceToWord.length()<shortWord.length()){
            shortWord = sentenceToWord;
        }
        }
    }
}

