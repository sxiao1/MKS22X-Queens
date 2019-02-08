public class QueenBoard{
  private int[][] board;
  private int numQueens = 0;
  private int boardSize;
  private int row = 0;
  private int col = 0;
  public QueenBoard(int size){
    board = new int[size][size];
    boardSize = size;
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
    if(numQueens >= boardSize){
      return true;
    }
    else{
      return false;
    }
  }
  public void boardAlt(int row, int col){
    if(row < board.length && col > board[row].length){
      boardAlt(row - 1, 0);
    }
    if(board[row][col] == 0){
      board[row][col] = 1;
      for(int x = 0; x < board.length; x ++){ //marking the across row off limits
        if(board[x][col] != 1){
          board[x][col] = board[x][col] - 1;
        }
      }
      for(int x = row; x < board.length; x++){ //marking diagonally to the right
        for(int y = col; y < board[x].length; y++){
          board[row + 1][col + 1] = board[row + 1][col + 1] -1;
        }
      }

      boardAlt(row + 1, 0);
    }

  }

}
