import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Part1{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int max = 0;
      int curr = 0;
      while (input.hasNextLine()){

        String line = input.nextLine();
        if (line.equals("")){
          if (curr > max){
            max = curr;
          }
          curr = 0;
        }else{
          curr += Integer.parseInt(line);
        }

      }
      System.out.println(max);
      input.close();
    } catch (FileNotFoundException e){
      System.out.println(e);
    }

  }
}
