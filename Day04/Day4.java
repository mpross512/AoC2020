import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day4 {
    
    public static void main(String[] args) {
        
        try {

            Scanner scanner = new Scanner(new File("day4.txt"));

            int count = 0;
            String line = "";
            String bigLine = "";
            boolean byr = false, iyr = false, eyr = false, hgt = false, hcl = false, ecl = false, pid = false;
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                while(!line.equals("")) {
                    if(bigLine.length() == 0)
                        bigLine += line;
                    else
                        bigLine += " " + line;
                    if(scanner.hasNextLine())
                        line = scanner.nextLine();
                    else   
                        line = "";
                }
                String split[] = bigLine.split(" ");
                for(int i = 0; i < split.length; i++) {
                    if(split[i].indexOf("byr") == 0 && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1)) <= 2002
                        && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1)) >= 1920)
                        byr = true;
                    if(split[i].indexOf("iyr") == 0 && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1)) <= 2020
                    && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1)) >= 2010)
                        iyr = true;
                    if(split[i].indexOf("eyr") == 0 && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1)) <= 2030
                    && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1)) >= 2020)
                        eyr = true;
                    if(split[i].indexOf("hgt") == 0) {
                        if(split[i].contains("cm") && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1, split[i].indexOf("cm"))) >= 150
                            && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1, split[i].indexOf("cm"))) <= 193) {
                            hgt = true;
                        }
                        else if(split[i].contains("in") && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1, split[i].indexOf("in"))) >= 59
                            && Integer.parseInt(split[i].substring(split[i].indexOf(":") + 1, split[i].indexOf("in"))) <= 76){
                                hgt = true;
                        }
                    }
                    if(split[i].indexOf("hcl") == 0) {
                        if(Pattern.compile("^#[0-9a-f]{6}$").matcher(split[i].substring(split[i].indexOf(":") + 1)).find())
                            hcl = true;
                    }
                    if(split[i].indexOf("ecl") == 0) {
                        if(Pattern.compile("^amb|blu|brn|gry|grn|hzl|oth$").matcher(split[i].substring(split[i].indexOf(":") + 1)).find())
                            ecl = true;
                    }
                    if(split[i].indexOf("pid") == 0) {
                        if(Pattern.compile("^[0-9]{9}$").matcher(split[i].substring(split[i].indexOf(":") + 1)).find())
                            pid = true;
                    }
                }
                if(byr && iyr && eyr && hgt && hcl && ecl && pid)
                    count++;
                bigLine = "";
                byr = false;
                iyr = false; 
                eyr = false;
                hgt = false;
                hcl = false; 
                ecl = false;
                pid = false;
            }

            System.out.println(count);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

}
