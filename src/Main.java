import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Main {
    public static void main(String [] args) throws IOException{
        Text myText = new Text(new StringBuffer(
                new String(
                        Files.readAllBytes(Paths.get("src/")))));
        myText.getFrequencyResponseCalculating().forEach((k,v)-> System.out.println("word: "+k+", freq: " +v));
    }
}
