import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "F:\\Programmierkram\\AdventOfCode2020\\src\\";

        System.out.println("\nDay 1");
        d1(path);

        System.out.println("\nDay 2");
        d2(path);

        System.out.println("\nDay 3");
        d3(path);
    }

    public static List<String> inputreader(String filename) throws IOException {
        List<String> input = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            input.add(line);
        }
        br.close();
        return input;
    }


    public static void kopiervorlage(String path) throws IOException {
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d.txt");




        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
    }


    public static void d1(String path) throws IOException {
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;

        List<String> input = inputreader(path + "d1.txt");
        List<Integer> inputInt = new ArrayList<>();

        for (String data : input) {
            inputInt.add(Integer.parseInt(data));
        }
        for (int data : inputInt) {
            for (int data2 : inputInt) {
                if (data + data2 != 2020) {
                    for (int data3 : inputInt) {
                        if (data + data2 + data3 == 2020) {
                            correctanswerT2 = data * data2 * data3;
                        }
                    }
                } else {
                    correctanswerT1 = data * data2;
                }
            }
        }

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
    }

    public static void d2(String path) throws IOException {
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;

        List<String> input = inputreader(path + "d2.txt");
        List<String[]> inputdata = new ArrayList<>();

        for (String data : input) {
            inputdata.add(data.split(" "));
        }

        for (String[] data : inputdata) {
            boolean found = false;
            int counter = 0;

            String[] spliStr = data[0].split("-");
            int low = Integer.parseInt(spliStr[0]);
            int high = Integer.parseInt(spliStr[1]);

            spliStr = data[1].split(":");
            String searchChar = spliStr[0];

            char[] password = data[2].toCharArray();

            for (char c : password) {
                if (Character.toString(c).equals(searchChar)) {
                    counter++;
                }
            }
            if (counter >= low && counter <= high) {
                correctanswerT1++;
            }

            if (Character.toString(password[low - 1]).equals(searchChar)) {
                found = true;
            }
            if (Character.toString(password[high - 1]).equals(searchChar)) {
                found = !found;
            }

            if (found) {
                correctanswerT2++;
            }
        }
        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
    }

    public static void d3(String path) throws IOException {
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d3.txt");




        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
    }
}
