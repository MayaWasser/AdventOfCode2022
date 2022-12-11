import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Part2{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int register = 1;
      int cycle = 0;
      int[] xAtCycle = new int[240];

      while (input.hasNextLine()){
        String line = input.nextLine();

        cycle++;
        xAtCycle[cycle-1] = register;
        if (line.substring(0,4).equals("addx")){
          cycle++;
          xAtCycle[cycle-1] = register;
          register += Integer.parseInt(line.substring(5));
        }
      }


      char[][] screen = new char[6][40];
      for (int i = 0; i < 240; i++){
        int modifyX = (i / 40) * 40;
        determinePixel(i, xAtCycle[i] + modifyX, screen);
      }

      for (int i = 0; i < 6; i++){
        for (int j = 0; j < 40; j++){
          System.out.print(screen[i][j]);
        }
        System.out.println();
      }

      input.close();
    } catch (FileNotFoundException e){
      System.out.println(e);
    }
  }

  public static void determinePixel(int cycle, int register, char[][] screen){
    int row = cycle / 40;
    int column = cycle % 40;
    if ( cycle == register || cycle == register-1 || cycle == register + 1){
      screen[row][column] = '#';
    }else{
      screen[row][column] = '.';
    }
  }


}
