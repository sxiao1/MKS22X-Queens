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
    return true;
  }
  private boolean removeQueen(int r, int c){
    return true;
  }
}
