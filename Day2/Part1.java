import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Part1{
  public static void main(String[] args){
    try{

      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int score = 0;
      while(input.hasNextLine()){
        String line = input.nextLine();
        char opponent = line.charAt(0);
        char you = line.charAt(2);

        if (you == 'X'){
          score++;
          you = 'A';
        }
        if (you == 'Y'){
          score += 2;
          you = 'B';
        }
        if (you == 'Z'){
          score += 3;
          you = 'C';
        }

        if (you == opponent){
          score += 3;
        }
        if ((you == 'A' && opponent == 'C') || (you == 'B' && opponent == 'A') || (you == 'C' && opponent == 'B')) {
          score += 6;
        }
      }

      System.out.println(score);
      input.close();
    } catch (FileNotFoundException e){
      System.out.println(e);
    }

  }
}
