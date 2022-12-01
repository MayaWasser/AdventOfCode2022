import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part2{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int curr = 0;
      ArrayList<Integer> elves = new ArrayList<Integer>();

      while (input.hasNextLine()){
        String line = input.nextLine();
        if (line.equals("")){
          elves.add(curr);
          curr = 0;
        }else{
          curr += Integer.parseInt(line);
        }
      }
      elves.add(curr);

      int ans = 0;
      for (int i = 0; i < 3; i++){
        int max = getMax(elves);
        ans += max;
      }

      System.out.println(ans);
      input.close();
    } catch (FileNotFoundException e){
      System.out.println(e);
    }

  }

  public static int getMax(ArrayList<Integer> ary){
    int max = 0;
    int maxi = 0;
    for (int i = 0; i < ary.size(); i++){
      int curr = ary.get(i).intValue();
      if (curr > max){
        max = curr;
        maxi = i;
      }
    }
    ary.set(maxi, -1);
    return max;
  }
}
