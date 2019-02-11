public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    if(size >= 0){
      board = new int[size][size];
      for(int x = 0; x < board.length; x ++){
        for(int y = 0; y < board[x].length; y++){
          board[x][y] = 0; //setting initial values to 0
        }
      }
    }
    else {
		throw new NumberFormatException();
	}
  }
  private boolean addQueen(int r, int c){
    if(board[r][c] == 0){
      mark(r ,c, 0); //marking across
      mark(r,c,1); //marking diagonally up
      mark(r,c, -1); //marking diagonally down
      board[r][c] = -1; //setting to queen
      return true;
    }
    return false;
  }
  private boolean removeQueen(int r, int c){
    if(board[r][c] == -1){
      demark(r,c,0);
      demark(r,c,1);
      demark(r,c, -1);
      board[r][c] = 0;
      return true;
    }
    return false;
  }
  private void mark(int row, int col, int shift){
    int x = row;
    int y = col;
    while(x < board.length && x >= 0 && y < board[row].length && y >= 0){
        board[x][y] ++;
        //System.out.println( x + "," + y + " " + board[x][y]);
        x++;
        y = y + shift; //move either by up or down
    }
  }
  private void demark(int row, int col, int shift){
    int x = row;
    int y = col;
    while(x < board.length && x >= 0 && y < board[row].length && y >= 0){
      board[x][y] --;
      x++;
      y = y + shift;
    }
  }
  public String toString(){
    String newstr = "";
    for(int x = 0; x < board.length; x++){
      for(int y = 0; y < board[x].length; y++){
        if(board[x][y] >= 0){
          newstr += "_ ";
        }
        else{
          newstr += "Q ";
        }
      }
      newstr += "\n";
    }
    return newstr;
  }
  public boolean solve(){
    int queensNeeded = 0;
    if(board.length == 2){
      queensNeeded = 1; //special cases
    }
    if(board.length == 3){
      queensNeeded = 2;
    }
    else{
      queensNeeded = board.length;
    }
    return boardAlt(0, 0, 0, queensNeeded); //calling helper
  }
  public boolean boardAlt(int row, int col, int numQueens, int target){
    if(numQueens == target){
      return true; //reached goal
    }
    for(int i = 0; i < board[row].length; i++){
      if(addQueen(row, i)){ //if add successful
        if(boardAlt(row + 1, i, numQueens  + 1, target)){ //going to the next row
          return true;
        }
        else{
          removeQueen(row, i); //going back
        }
      }
    }
    return false;
  }
  public int countSolutions(){
    for(int x = 0; x < board.length; x++){
      for(int y = 0; y < board[x].length; y++){
        if(board[x][y] != 0){
          throw new IllegalStateException();
        }
      }
    }
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
    return hcs(0, 0, 0, queensNeeded, 0); //calling helper function

  }
  public int hcs(int row, int col, int numQueens, int target, int count){
    if(numQueens == target && numQueens != 0){
      return count + 1;
    }
    for(int i = 0; i < board[row].length; i++){
      if(addQueen(row, i)){
        int x = hcs(row + 1, i, numQueens  + 1, target, count);
        if(x != count){
          count += x - count;
        }
        removeQueen(row, i);
      }
    }
    return count;
  }
}
