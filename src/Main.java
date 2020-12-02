import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "F:\\Programmierkram\\AdventOfCode2020\\src\\";

        System.out.println("\nDay 1");
        System.out.println(d1T1(path));
        System.out.println(d1T2(path));

        System.out.println("\nDay 2");
        System.out.println(d2T1(path));
        System.out.println(d2T2(path));
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

    public static int d1T1(String path) throws IOException {
        List<String> input = inputreader(path + "d1.txt");
        List<Integer> inputInt = new ArrayList<Integer>();
        for (String data : input) {
            inputInt.add(Integer.parseInt(data));
        }
        for (int data : inputInt) {
            for (int data2 : inputInt) {
                if (data + data2 == 2020) {
                    return data * data2;
                }
            }
        }
        return 0;
    }

    public static int d1T2(String path) throws IOException {
        List<String> input = inputreader(path + "d1.txt");
        List<Integer> inputInt = new ArrayList<Integer>();
        for (String data : input) {
            inputInt.add(Integer.parseInt(data));
        }
        for (int data : inputInt) {
            for (int data2 : inputInt) {
                for (int data3 : inputInt) {
                    if (data + data2 + data3 == 2020) {
                        return data * data2 * data3;
                    }
                }
            }
        }
        return 0;
    }

    public static int d2T1(String path) throws IOException {
        List<String> input = inputreader(path +"d2.txt");
        List<String[]> inputdata = new ArrayList<String[]>();

        int correctanswer = 0;

        for (String data : input) {
            inputdata.add(data.split("\\s+"));
        }

        for (String[] data : inputdata) {
            String[] spliStr = data[0].split("-");
            int countLow = Integer.parseInt(spliStr[0]);
            int countHigh = Integer.parseInt(spliStr[1]);
            int counter = 0;
            spliStr = data[1].split(":");
            String searchChar = spliStr[0];

            char[] password = data[2].toCharArray();
            for (int j = 0; j < password.length; j++) {
                if (Character.toString(password[j]).equals(searchChar)) {
                    counter++;
                }
            }
            if (counter >= countLow && counter <= countHigh) {
                correctanswer++;
            }
        }
        return correctanswer;
    }

    public static int d2T2(String path) throws IOException {
        List<String> input = inputreader(path +"d2.txt");
        List<String[]> inputdata = new ArrayList<String[]>();

        int correctanswer = 0;

        for (String data : input) {
            inputdata.add(data.split("\\s+"));
        }

        for (String[] data : inputdata) {
            boolean found = false;
            String[] spliStr = data[0].split("-");
            int lowIndex = Integer.parseInt(spliStr[0]);
            int highIndex = Integer.parseInt(spliStr[1]);
            spliStr = data[1].split(":");
            String searchChar = spliStr[0];

            char[] password = data[2].toCharArray();

            if (Character.toString(password[lowIndex - 1]).equals(searchChar)) {
                found = true;
            }
            if (Character.toString(password[highIndex - 1]).equals(searchChar)) {
                if (!found) {
                    found = true;
                } else {
                    found = false;
                }
            }

            if (found) {
                correctanswer++;
            }
        }
        return correctanswer;
    }
}
