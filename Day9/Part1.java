import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
public class Part1{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      GridPoint heads = new GridPoint(0,0);
      GridPoint tails = new GridPoint(0,0);
      HashSet<GridPoint> positions = new HashSet<GridPoint>();
      positions.add( new GridPoint(0,0) );

      while (input.hasNextLine()){
        String line = input.nextLine();
        char heading = line.charAt(0);
        int number = Integer.parseInt(line.substring(2));

        for (int i = 0; i < number; i++){
          if (heading == 'R'){
            heads = right(heads);
          }
          if (heading == 'L'){
            heads = left(heads);
          }
          if (heading == 'U'){
            heads = up(heads);
          }
          if (heading == 'D'){
            heads = down(heads);
          }
          tails = moveTails(heads, tails);
          positions.add(tails);
        }
      }
      System.out.println( positions.size() );

      input.close();
    } catch (FileNotFoundException e){
      System.out.println(e);
    }
  }

  public static GridPoint up(GridPoint point){
    return new GridPoint(point.getX(), point.getY() + 1);
  }

  public static GridPoint down(GridPoint point){
    return new GridPoint(point.getX(), point.getY() - 1);
  }

  public static GridPoint right(GridPoint point){
    return new GridPoint(point.getX() + 1, point.getY());
  }

  public static GridPoint left(GridPoint point){
    return new GridPoint(point.getX() - 1, point.getY());
  }

  public static GridPoint moveTails(GridPoint heads, GridPoint tails){
    int xDistance = heads.getX() - tails.getX();
    int yDistance = heads.getY() - tails.getY();
    if ( xDistance > 1 || (xDistance == 1 && Math.abs(yDistance) > 1) ){
      tails = right(tails);
    }
    if ( xDistance < -1 || (xDistance == -1 && Math.abs(yDistance) > 1) ){
      tails = left(tails);
    }
    if ( yDistance > 1 || (yDistance == 1 && Math.abs(xDistance) > 1) ){
      tails = up(tails);
    }
    if (yDistance < -1 || (yDistance == -1 && Math.abs(xDistance) > 1) ){
      tails = down(tails);
    }
    return tails;
  }
}
