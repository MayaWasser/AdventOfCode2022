import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Part2{
  public static void main(String[] args){
    try{

      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int score = 0;
      while(input.hasNextLine()){
        String line = input.nextLine();
        char opponent = line.charAt(0);
        char end = line.charAt(2);
        char you = 'F';

        if (end == 'X'){
          if (opponent == 'A'){
            you = 'C';
            score += 3;
          }
          if (opponent == 'B'){
            you = 'A';
            score += 1;
          }
          if (opponent == 'C'){
            you = 'B';
            score += 2;
          }
        }

        if (end == 'Y'){
          if (opponent == 'A'){
            you = 'A';
            score += 1;
          }
          if (opponent == 'B'){
            you = 'B';
            score += 2;
          }
          if (opponent == 'C'){
            you = 'C';
            score += 3;
          }
          score += 3;
        }

        if (end == 'Z'){
          if (opponent == 'A'){
            you ='B';
            score += 2;
          }
          if (opponent == 'B'){
            you = 'C';
            score += 3;
          }
          if (opponent == 'C'){
            you = 'A';
            score += 1;
          }
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
