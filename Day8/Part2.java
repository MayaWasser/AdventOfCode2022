import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Part2{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      // uses the fact that the grid is a square
      int size = input.nextLine().length();
      input = new Scanner(file);
      int[][] trees = new int[size][size];
      int lineIndex = 0;

      while (input.hasNextLine()){
        String line = input.nextLine();
        for (int i = 0; i < size; i++){
          trees[lineIndex][i] = Integer.parseInt( line.substring(i, i+1) );
        }
        lineIndex++;
      }

      int maxScore = 0;
      for (int i = 0; i < size; i++){
        for (int j = 0; j < size; j++){
          int score = scenicScore(trees, i, j);
          if (score > maxScore){
            maxScore = score;
          }
        }
      }
      System.out.println(maxScore);

      input.close();

    } catch (FileNotFoundException e){
      System.out.println(e);
    }
  }

  public static int rightTrees(int[][] ary, int row, int column){
    int countTrees = 0;
    for (int i = column+1; i < ary[0].length; i++){
      countTrees++;
      if (ary[row][i] >= ary[row][column]){
        break;
      }
    }
    return countTrees;
  }

  public static int leftTrees(int[][] ary, int row, int column){
    int countTrees = 0;
    for (int i = column-1; i >= 0; i--){
      countTrees++;
      if (ary[row][i] >= ary[row][column]){
        break;
      }
    }
    return countTrees;
  }

  public static int upTrees(int[][] ary, int row, int column){
    int countTrees = 0;
    for (int i = row-1; i >= 0; i--){
      countTrees++;
      if (ary[i][column] >= ary[row][column]){
        break;
      }
    }
    return countTrees;
  }

  public static int downTrees(int[][] ary, int row, int column){
    int countTrees = 0;
    for (int i = row+1; i < ary.length; i++){
      countTrees++;
      if (ary[i][column] >= ary[row][column]){
        break;
      }
    }
    return countTrees;
  }

  public static int scenicScore(int[][] ary, int row, int column){
    return rightTrees(ary, row, column) * leftTrees(ary, row, column)
         * downTrees(ary, row, column) * upTrees(ary, row, column);
  }
}
