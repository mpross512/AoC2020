import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day5 {

    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(new File("day5.txt"));

        List<Integer> seatIDs = new ArrayList<>();

        int maxID = 0;

        while(scanner.hasNextLine()) {
            int maxRow = 127, minRow = 0, maxCol = 7, minCol = 0;
            String line = scanner.nextLine();
            for(int i = 0; i < 7; i++) {
                if(line.charAt(i) == 'F')
                    maxRow = ((maxRow - minRow) / 2) + minRow;
                else if(line.charAt(i) == 'B')
                    minRow = maxRow - ((maxRow - minRow) / 2);
            }
            for(int i = 7; i < 10; i++) {
                if(line.charAt(i) == 'L')
                    maxCol = ((maxCol - minCol) / 2) + minCol;
                else if(line.charAt(i) == 'R')
                    minCol = maxCol - ((maxCol - minCol) / 2);
            }
            if(maxRow * 8 + maxCol > maxID)
                maxID = maxRow * 8 + maxCol;
            seatIDs.add(maxRow * 8 + maxCol);
        }

        System.out.println(maxID);

        Collections.sort(seatIDs);

        for(int i = 0; i < seatIDs.size() - 1; i++) {
            if(seatIDs.get(i) + 2 == seatIDs.get(i + 1)) {
                System.out.println(seatIDs.get(i) + 1);
                break;
            }
        }
    }

}
