import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day09 {
    
    final static int preamble = 25;
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scanner = new Scanner(new File("Day09/cypher.txt"));

        ArrayList<Long> nums = new ArrayList<>();

        ArrayList<Long> sums = new ArrayList<>();

        while(scanner.hasNextLine()) {
            nums.add(Long.parseLong(scanner.nextLine()));
        }

        for(int i = preamble; i < nums.size(); i++) {
            sums.clear();

            for(int k = i - preamble; k < i; k++) 
                for(int l = k + 1; l < i; l++)
                    if(!sums.contains(nums.get(k) + nums.get(l)))
                        sums.add(nums.get(k) + nums.get(l));

            if(!sums.contains(nums.get(i))) {
                System.out.println(nums.get(i));
                break;
            }
        }

        long sum = 0;
        for(int i = 0; i < nums.size(); i++) {
            sums.clear();
            sum = 0;
            int index = i;
            while(sum < 138879426) {
                sum+=nums.get(index);
                sums.add(nums.get(index));
                index++;
            }
            if(sum == 138879426) {
                Collections.sort(sums);
                System.out.println(sums.get(0) + sums.get(sums.size() - 1));
            }
        }



    }

}
