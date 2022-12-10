public class GridPoint{
  private int x,y;

  public GridPoint(int anX, int aY){
    x = anX;
    y = aY;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  @Override
  public String toString(){
    return "(" + getX() + "," + getY() + ")";
  }

  @Override
  public boolean equals(Object obj){
    if ( !(obj instanceof GridPoint) ){
      return false;
    }
    GridPoint other = (GridPoint) obj;
    return x == other.x && y == other.y;
  }

  @Override
  public int hashCode(){
    int hash = 17;
    hash = hash * 31 + x;
    hash = hash * 31 + y;
    return hash; 
  }

}
