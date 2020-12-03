import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "F:\\Programmierkram\\AdventOfCode2020\\src\\inputFiles\\";

        System.out.println("\nDay 1");
        d1(path);

        System.out.println("\nDay 2");
        d2(path);

        System.out.println("\nDay 3");
        d3(path);

        System.out.println("\nDay 4");
        d4(path);

        System.out.println("\nDay 5");
        d5(path);

        System.out.println("\nDay 6");
        d6(path);

        System.out.println("\nDay 7");
        d7(path);

        System.out.println("\nDay 8");
        d8(path);

        System.out.println("\nDay 9");
        d9(path);

        System.out.println("\nDay 10");
        d10(path);

        System.out.println("\nDay 11");
        d11(path);

        System.out.println("\nDay 12");
        d12(path);

        System.out.println("\nDay 13");
        d13(path);

        System.out.println("\nDay 14");
        d14(path);

        System.out.println("\nDay 15");
        d15(path);

        System.out.println("\nDay 16");
        d16(path);

        System.out.println("\nDay 17");
        d17(path);

        System.out.println("\nDay 18");
        d18(path);

        System.out.println("\nDay 19");
        d19(path);

        System.out.println("\nDay 20");
        d20(path);

        System.out.println("\nDay 21");
        d21(path);

        System.out.println("\nDay 22");
        d22(path);

        System.out.println("\nDay 23");
        d23(path);

        System.out.println("\nDay 24");
        d24(path);

        System.out.println("\nDay 25");
        d25(path);
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

    public static void d1(String path) throws IOException {
        long timer1;
        long timer2;
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;

        List<String> input = inputreader(path + "d1.txt");
        List<Integer> inputInt = new ArrayList<>();

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            inputInt.add(Integer.parseInt(data));
        }

        for (int data : inputInt) {
            for (int data2 : inputInt) {
                if (data + data2 == 2020) {
                    correctanswerT1 = data * data2;
                    break;
                } else {
                    for (int data3 : inputInt) {
                        if (data + data2 + data3 == 2020) {
                            correctanswerT2 = data * data2 * data3;
                            break;
                        }
                    }
                }
            }
        }

        timer2 = System.currentTimeMillis();
        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d2(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;

        int low;
        int high;
        int counter;

        boolean found;

        String searchChar;
        String[] spliStr;

        List<String> input = inputreader(path + "d2.txt");
        List<String[]> inputdata = new ArrayList<>();

        timer1 = System.currentTimeMillis();

        for (String data : input) {
            /*
            data = 3-5 f: fgfff
            inputdata[0] = 3-5
            inputdata[1] = f:
            inputdata[2] = fgfff
             */
            inputdata.add(data.split(" "));
        }

        for (String[] data : inputdata) {
            found = false;
            counter = 0;

            spliStr = data[0].split("-");
            low = Integer.parseInt(spliStr[0]);
            high = Integer.parseInt(spliStr[1]);

            searchChar = data[1];

            for (int i = 0; i < data[2].length(); i++) {
                if (data[2].charAt(i) == searchChar.charAt(0)) {
                    counter++;
                    if (i == low - 1 || i == high - 1) {
                        found = !found;
                    }
                }
            }

            if (counter >= low && counter <= high) {
                correctanswerT1++;
            }

            if (found) {
                correctanswerT2++;
            }
        }

        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d3(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1;
        long correctanswerT2 = 1;
        List<String> input = inputreader(path + "d3.txt");

        int[] travelRight = new int[]{1, 3, 5, 7, 1};
        int[] travelDown = new int[]{1, 1, 1, 1, 2};

        int[] partsesult = new int[travelRight.length];

        int width = input.get(0).length();
        int actualWidth;

        timer1 = System.currentTimeMillis();

        for (int i = 0; i < travelRight.length; i++) {
            actualWidth = 0;
            for (int j = 0; j < input.size(); j++) {
                if (actualWidth > width - 1) {
                    actualWidth -= width;
                }
                if (input.get(j).charAt(actualWidth) == '#') {
                    partsesult[i]++;
                }
                if (travelDown[i] != 1) {
                    j += travelDown[i] - 1;
                }
                actualWidth += travelRight[i];
            }
        }

        correctanswerT1 = partsesult[1];

        for (int i = 0; i < partsesult.length; i++) {
            correctanswerT2 = correctanswerT2 * partsesult[i];
        }

        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d4(String path) throws IOException {
        long timer1;
        long timer2;
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d4.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d5(String path) throws IOException {
        long timer1;
        long timer2;
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d5.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d6(String path) throws IOException {
        long timer1;
        long timer2;
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d6.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d7(String path) throws IOException {
        long timer1;
        long timer2;
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d7.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d8(String path) throws IOException {
        long timer1;
        long timer2;
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d8.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d9(String path) throws IOException {
        long timer1;
        long timer2;
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d9.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d10(String path) throws IOException {
        long timer1;
        long timer2;
        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d10.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d11(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d11.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d12(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d12.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d13(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d13.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d14(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d14.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d15(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d15.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d16(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d16.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d17(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d17.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d18(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d18.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d19(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d19.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d20(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d20.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d21(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d21.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d22(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d22.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d23(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d23.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d24(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d24.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }

    public static void d25(String path) throws IOException {
        long timer1;
        long timer2;

        int correctanswerT1 = 0;
        int correctanswerT2 = 0;
        List<String> input = inputreader(path + "d25.txt");

        timer1 = System.currentTimeMillis();
        for (String data : input) {
            System.out.println(data);
        }
        timer2 = System.currentTimeMillis();

        System.out.println("Task One: " + correctanswerT1);
        System.out.println("Task Two: " + correctanswerT2);
        System.out.println("Time needed in ms " + (timer2 - timer1));
    }
}
