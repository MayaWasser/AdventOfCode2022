import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Part1{
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

      int visibleTrees = 0;
      for (int i = 0; i < size; i++){
        for (int j = 0; j < size; j++){
          if ( isUpVisible(trees, i, j) || isDownVisible(trees, i, j)
          || isLeftVisible(trees, i, j) || isRightVisible(trees, i, j)){
            visibleTrees++;
          }
        }
      }
      System.out.println(visibleTrees);
      input.close();

    } catch (FileNotFoundException e){
      System.out.println(e);
    }
  }

  public static boolean isRightVisible(int[][] ary, int row, int column){
    for (int i = column+1; i < ary[0].length; i++){
      if (ary[row][i] >= ary[row][column]){
        return false;
      }
    }
    return true;
  }

  public static boolean isLeftVisible(int[][] ary, int row, int column){
    for (int i = column-1; i >= 0; i--){
      if (ary[row][i] >= ary[row][column]){
        return false;
      }
    }
    return true;
  }

  public static boolean isUpVisible(int[][] ary, int row, int column){
    for (int i = row-1; i >= 0; i--){
      if (ary[i][column] >= ary[row][column]){
        return false;
      }
    }
    return true;
  }

  public static boolean isDownVisible(int[][] ary, int row, int column){
    for (int i = row+1; i < ary.length; i++){
      if (ary[i][column] >= ary[row][column]){
        return false;
      }
    }
    return true;
  }

}
