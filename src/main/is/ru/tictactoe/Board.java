public class Board{
    
    private int[][] board;
    private final int size = 3;

    public Board(){
	board = new int[size][size];

	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++)
		board[i][j] = 0;
	}
    }    


}
