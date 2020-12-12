import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {


        List<Integer> nums = new ArrayList<>();

        try {
        Scanner file = new Scanner(new File("day1.txt"));

        while(file.hasNextInt()) {
            nums.add(file.nextInt());
        }

        } catch(FileNotFoundException e) {
            System.out.println(e);
        }

        for(int i = 0; i < nums.size(); i++) {
            for(int j = i + 1; j < nums.size(); j++) {
                if(nums.get(i) + nums.get(j) == 2020)
                    System.out.println(nums.get(i) + " * " + nums.get(j) + " = " + nums.get(i) * nums.get(j));
            }
        }

        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.size(); j++) {
                for(int k = 0; k < nums.size(); k++) {
                    if(nums.get(i) + nums.get(j) + nums.get(k) == 2020) {
                        System.out.println(nums.get(i) * nums.get(j) * nums.get(k));
                    }
                }
            }
        }
    }

}