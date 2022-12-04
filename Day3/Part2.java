import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Part2{
  public static void main(String[] args){
    try{

      File file = new File("input.txt");
      Scanner input = new Scanner(file);
      String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

      int sum = 0;

      while (input.hasNextLine()){
        String line1 = input.nextLine();
        String line2 = input.nextLine();
        String line3 = input.nextLine();

        String item = "";
        String misplaced = "";
        for (int i=0; i < line1.length(); i++){
          item = line1.substring(i, i+1);
          if (line2.indexOf(item) != -1 && line3.indexOf(item) != -1){
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
