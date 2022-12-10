import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Part1{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int register = 1;
      int cycle = 0;
      int signalStrengthSum = 0;

      while (input.hasNextLine()){
        String line = input.nextLine();

        cycle++;
        if ( (cycle - 20) % 40 == 0 && (cycle - 20) % 40 <= 5){
          signalStrengthSum += cycle * register;
        }

        if (line.substring(0,4).equals("addx")){
          cycle++;
          if ( (cycle - 20) % 40 == 0 && (cycle - 20) % 40 <= 5){
            signalStrengthSum += cycle * register;
          }
          register += Integer.parseInt( line.substring(5) );
        }
      }
      System.out.println(signalStrengthSum);

      input.close();
    } catch (FileNotFoundException e){
      System.out.println(e);
    }
  }
}
