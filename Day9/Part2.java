import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
public class Part2{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      GridPoint[] positions = new GridPoint[10];
      for (int i = 0; i < positions.length; i++){
        positions[i] = new GridPoint(0,0);
      }
      HashSet<GridPoint> lastKnot = new HashSet<GridPoint>();
      lastKnot.add( new GridPoint(0,0) );

      while (input.hasNextLine()){
        String line = input.nextLine();
        char heading = line.charAt(0);
        int number = Integer.parseInt(line.substring(2));

        for (int i = 0; i < number; i++){
          GridPoint heads = positions[0];
          if (heading == 'R'){
            positions[0] = right(heads);
          }
          if (heading == 'L'){
            positions[0] = left(heads);
          }
          if (heading == 'U'){
            positions[0] = up(heads);
          }
          if (heading == 'D'){
            positions[0] = down(heads);
          }

          for (int j = 1; j < positions.length; j++){
            positions[j] = moveKnot(positions[j-1], positions[j]);
          }
          lastKnot.add( positions[positions.length-1] );
        }
      }
      System.out.println( lastKnot.size() );
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

  public static GridPoint moveKnot(GridPoint heads, GridPoint tails){
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
