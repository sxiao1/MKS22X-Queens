public class QueenBoard{
  private int[][] board;
  private int numQueens = 0;
  public QueenBoard(int size){
    if(size >= 0){
      board = new int[size][size];
      for(int x = 0; x < board.length; x ++){
        for(int y = 0; y < board[x].length; y++){
          board[x][y] = 0;
        }
      }
    }
    else {
		throw new NumberFormatException();
	}
  }
  private boolean addQueen(int r, int c){
    if(board[r][c] == 0){
      board[r][c] = -1;
      mark(r,c, 0);
      mark(r, c, 1);
      mark(r,c, -1);
      return true;
    }
    return false;
  }
  private boolean removeQueen(int r, int c){
    if(board[r][c] == -1){
      board[r][c] = 0;
      demark(r,c,0);
      demark(r,c,1);
      demark(r,c,-1);
      return true;
    }
    return false;
  }
  private void mark(int row, int col, int shift){
    int x = row;
    int y = col;
    while(row < board.length && col < board[row].length && col >= 0){
      board[x][y] = board[x][y] + 1;
      x++;
      y = y + shift;
    }
  }
  private void demark(int row, int col, int shift){
    int x = row;
    int y = col;
    while(row < board.length && col < board[row].length && col >= 0){
      board[x][y] = board[x][y] - 1;
      x++;
      y = y + shift;
    }
  }
  public String toString(){
    String newstr = "";
    for(int x = 0; x < board.length; x++){
      for(int y = 0; y < board[x].length; y++){
        if(board[x][y] == -1){
          newstr += "Q ";
        }
        else{
          newstr += "_";
        }
      }
      newstr += "\n";
    }
    return newstr;
  }
  public boolean solve(){
    int queensNeeded = 0;
    if(board.length == 2){
      queensNeeded = 1;
    }
    if(board.length == 3){
      queensNeeded = 2;
    }
    else{
      queensNeeded = board.length;
    }
    boardAlt(0, 0, queensNeeded);
    if(queensNeeded == numQueens){
      return true;
    }
    return false;
  }
  public void boardAlt(int row, int col, int target){

  }

}
