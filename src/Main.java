import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String [] args) throws IOException{
        Text myText = new Text(new StringBuffer(
                new String(
                        Files.readAllBytes(Paths.get("src/test_text_1.txt")))));

        System.out.println(myText.firstUniqueWord());

    }
}
