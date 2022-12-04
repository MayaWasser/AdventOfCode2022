import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Part1{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int count = 0;
      while (input.hasNextLine()){
        String line = input.nextLine();
        int dash1 = line.indexOf("-");
        int comma = line.indexOf(",");
        int dash2 = line.lastIndexOf("-");
        int start1 = Integer.parseInt( line.substring(0, dash1) );
        int end1 = Integer.parseInt( line.substring(dash1+1, comma));
        int start2 = Integer.parseInt( line.substring(comma+1, dash2));
        int end2 = Integer.parseInt( line.substring(dash2+1) );

        boolean overlap = (start1 <= start2 && end1 >= end2) || (start1 >= start2 && end1 <= end2);
        if ( overlap ){
          count++;
        }
      }
      System.out.println(count);
      input.close();
    } catch (FileNotFoundException e){
      System.out.println(e);
    }

  }
}
