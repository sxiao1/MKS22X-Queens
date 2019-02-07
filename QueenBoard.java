public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
    for(int x = 0; x < board.length; x ++){
      for(int y = 0; y < board[x].length; y++){
        board[x][y] = 0;
      }
    }
  }
  private boolean addQueen(int r, int c){
    board[r][c] = 1;
    return true;
  }
  private boolean removeQueen(int r, int c){
    board[r][c] = 0;
    return true;
  }
  public String toString(){
    String newstr = "";
    for(int x = 0; x < board.length; x++){
      for(int y = 0; y < board[x].length; y++){
        if(board[x][y] == 0){
          newstr += "_";
        }
        else{
          newstr += "Q";
        }
      }
    }
    return newstr;
  }

}
