import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Day2 {
    
    public static void main(String[] args) {
        
        try {

            Scanner scanner = new Scanner(new File("list.txt"));

            int count = 0;
            int count2 = 0;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(passwordIsValid(line))
                    count++;
                if(newPassIsValid(line))
                    count2++;
            }

            System.out.println(count);
            System.out.println(count2);

        } catch(FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static boolean passwordIsValid(String phrase) {

        int min = Integer.parseInt(phrase.substring(0, phrase.indexOf("-")));
        int max = Integer.parseInt(phrase.substring(phrase.indexOf("-") + 1, phrase.indexOf(" ")));
        char letter = phrase.charAt(phrase.indexOf(" ") + 1);


        int count = 0;
        for(int i = phrase.indexOf(':') + 1; i < phrase.length(); i++) {
            if(phrase.charAt(i) == letter)
                count++;
        }

        return count <= max && count >= min;

    }

    public static boolean newPassIsValid(String phrase) {
        
        int first = Integer.parseInt(phrase.substring(0, phrase.indexOf("-")));
        int second = Integer.parseInt(phrase.substring(phrase.indexOf("-") + 1, phrase.indexOf(" ")));
        char letter = phrase.charAt(phrase.indexOf(" ") + 1);

        String newPhrase = phrase.substring(phrase.indexOf(':') + 1);

        

        return newPhrase.charAt(first) == letter ^ newPhrase.charAt(second) == letter;
    }

}
