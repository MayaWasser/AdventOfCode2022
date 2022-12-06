import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part2{
  public static void main(String[] args){
    try{
      File file = new File("input.txt");
      Scanner input = new Scanner(file);

      int stackNum = 9;
      ArrayList<ArrayList<Character>> stacks = new ArrayList<ArrayList<Character>>();
      for (int i=0; i < stackNum; i++){
        stacks.add( new ArrayList<Character>() );
      }

      for (String line = input.nextLine(); line.charAt(0) != '1'; line = input.nextLine()){
        for (int i = 1; i < line.length(); i += 4){
            char current = line.charAt(i);
            if (Character.isLetter(current)){
              stacks.get(i/4).add(current);
            }
        }
      }

      input.nextLine();
      while (input.hasNextLine()){
        String line = input.nextLine();
        String[] parts = line.split(" ");
        int numToMove = Integer.parseInt(parts[1]);
        int moveFrom = Integer.parseInt(parts[3]);
        int moveTo =Integer.parseInt(parts[5]);
        moveCrates(stacks, moveFrom, moveTo, numToMove);
      }

      for (int i=0; i < stacks.size(); i++){
        System.out.println( stacks.get(i).get(0) );
      }

      input.close();
    }catch(FileNotFoundException e){
      System.out.println(e);
    }
  }

  public static void moveCrates(ArrayList<ArrayList<Character>> stacks, int moveFrom, int moveTo, int numToMove){
    for (int i=0; i < numToMove; i++){
      stacks.get(moveTo - 1).add(i, stacks.get(moveFrom - 1).get(0));
      stacks.get(moveFrom - 1).remove(0);
    }

  }
}
