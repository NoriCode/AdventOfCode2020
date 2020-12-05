import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Helpers {
    public static List<String> inputreaderEachLineValue(String filename) throws IOException {
        List<String> input = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            input.add(line);
        }
        br.close();
        return input;
    }

    public static List<String> inputreaderEmptyLineSeperated(String filename) throws IOException {
        List<String> input = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));

        StringBuilder passPortPart = new StringBuilder();

        String line = br.readLine();

        while (line != null) {
            if (!line.isEmpty()) {
                passPortPart.append(line).append(" ");
            } else {
                input.add(passPortPart.toString());
                passPortPart = new StringBuilder();
            }
            line = br.readLine();
        }
        input.add(passPortPart.toString());
        br.close();
        return input;
    }
}
