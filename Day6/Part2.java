import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
public class Part2{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);
      String data = input.next();

      HashSet<Character> letters = new HashSet<Character>();
      for (int i = 0; i < data.length() - 14; i += 1){
        for (int j = 0; j < 14; j++){
          letters.add( data.charAt(i+j) );
        }
        if (letters.size() == 14){
          System.out.println(i+14);
          break;
        }
        letters.clear();
      }

      input.close();
    }catch (FileNotFoundException e){
      System.out.println(e);
    }

  }
}
