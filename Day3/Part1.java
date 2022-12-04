import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Part1{
  public static void main(String[] args){
    try{

      File file = new File("input.txt");
      Scanner input = new Scanner(file);
      String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

      int sum = 0;

      while (input.hasNextLine()){
        String line = input.nextLine();
        String part1 = line.substring(0, line.length() / 2);
        String part2 = line.substring(line.length() / 2);

        String item = "";
        String misplaced = "";
        for (int i=0; i < part1.length(); i++){
          item = part1.substring(i, i+1);
          if (part2.indexOf(item) != -1){
            misplaced = item;
          }
        }

        sum += letters.indexOf(misplaced) + 1;
      }
      System.out.println(sum);
      input.close();

    } catch (FileNotFoundException e){
      System.out.println(e);
    }

  }
}
