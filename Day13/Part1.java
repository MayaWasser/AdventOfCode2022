import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Part1{

  public static ArrayList<ArrayList<Integer>> createList(String line){
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    line = line.substring(1, line.length()-1);
    String[] values = line.split(",");
    
    return result;
  }

  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      for (int i=0; i<22;i++){
        input.nextLine();
      }
      String line = input.nextLine();
      createList(line);
      // index = 1;
      // while (input.hasNextLine()){
      //   String line1 = input.nextLine();
      //   String line2 = input.nextLine();
      //
      // }

      input.close();
    } catch (FileNotFoundException e){
      System.out.println(e);
    }
  }
}
