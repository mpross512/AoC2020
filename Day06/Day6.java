import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scanner = new Scanner(new File("Day06/input.txt"));

        scanner.useDelimiter("\n\n");

        ArrayList<String> groups = new ArrayList<>();

        while(scanner.hasNext()) {
            groups.add(scanner.next());
        }

        String var = "";
        int sum = 0; 
        for(int i = 0; i < groups.size(); i++) {
            var = "";
            String index = groups.get(i);
            for(int j = 0; j < index.length(); j++) {
                if(var.indexOf(index.charAt(j)) == -1 && index.charAt(j) != '\n') {
                    var += groups.get(i).charAt(j);
                }
            }
            sum += var.length();
        }

        System.out.println(sum);

        sum = 0;
        for(int i = 0; i < groups.size(); i++) {
            var = "";
            String index = groups.get(i);
            long count = index.chars().filter(ch -> ch == '\n').count() + 1;
            for(int j = 0; j < index.length(); j++) {
                final Integer innerJ = Integer.valueOf(j);
                if(index.charAt(j) != '\n' && var.indexOf(index.charAt(j)) == -1 && index.chars().filter(ch -> ch == index.charAt(innerJ) ).count() == count) {
                    var += index.charAt(j);
                    sum++;
                }
            }
        }

        System.out.println(sum);



    }
    
}