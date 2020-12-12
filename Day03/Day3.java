import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        
        try {

            Scanner scanner = new Scanner(new File("day3.txt"));

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String input = "";
                for(int i = 0; i <= 73; i++) {
                    input += line;
                }
                list.add(input);
            }

            System.out.println(a(list));
            System.out.println(b(list));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static int a(List<String> list) {
        int count = 0;
        int c = 0;
        for(int r = 0; r < list.size(); r++) {
            c = r * 3;
            if(list.get(r).charAt(c) == '#')
                count++;
        }

        return count;
    }

    public static int b(List<String> list) {
        int one = 0, two = 0, three = 0, four = 0, five = 0;

        int c = 0;
        for(int r = 0; r < list.size(); r++) {
            c = r * 1;
            if(list.get(r).charAt(c) == '#')
                one++;
        }

        c = 0;
        for(int r = 0; r < list.size(); r++) {
            c = r * 3;
            if(list.get(r).charAt(c) == '#')
                two++;
        }

        c = 0;
        for(int r = 0; r < list.size(); r++) {
            c = r * 5;
            if(list.get(r).charAt(c) == '#')
                three++;
        }

        c = 0;
        for(int r = 0; r < list.size(); r++) {
            c = r * 7;
            if(list.get(r).charAt(c) == '#')
                four++;
        }

        c = 0;
        for(int r = 0; r < list.size(); r+=2) {
            c = r/2;
            if(list.get(r).charAt(c) == '#')
                five++;
        }

        return one * two * three * four * five;
    }

}