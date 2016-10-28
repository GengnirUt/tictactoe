package com.is.ru.tictac;

public class startGame {
	
    Board board;
    Player p1;
    Player p2;
    GamePlay cpugame;
    
    startGame(){
	board = new Board();
	Printer.getPlayers(1);
	p1 = new Player(1, Input.getPlayerMode());
	Printer.getPlayers(2);
	p2 = new Player(2, Input.getPlayerMode());
	
	if(!(p1.isHuman() && p2.isHuman()))
	    cpugame = new GamePlay();
	else
	    cpugame = null;		
    }
    
    
    startGame(boolean player1, boolean player2){
	board = new Board();
	p1 = new Player(1, player1);
	p2 = new Player(2, player2);
	
	if(!(p1.isHuman() && p2.isHuman()))
	    cpugame = new GamePlay();
	else
	    cpugame = null;
    }
    
    private boolean checkMove(int[] move){
	boolean a = (board.isCellEmpty(move[0], move[1]));
	return a;
    }
    
    private boolean checkIfOnBoard( int[] move){
	boolean a = (move[0] < board.getBoardSize() && move[1] < board.getBoardSize());
	return a;
    }
    
    public void humanMove(int player){
	// 	get human input
	int[] move = Input.getPlayerMove();	
	while(!(checkIfOnBoard(move) && checkMove(move)) ){
	    Printer.spotTakenOrIllegal();
	    Printer.playerMove(player);
	    move = Input.getPlayerMove();
	}
	board.markCellPlayed(player, move[0], move[1]);
    }
    
    public boolean checkForWin(int player){
    	if(checkForWinnerHorizontal(player)){
	    return true;
    	}
    	else if(checkForWinnerVertical(player)){
	    return true;
    	}
    	else if(checkForWinnerDiagonal(player)){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    private boolean checkForWinnerHorizontal(int player){
    	if(player == board.getPlayerAtRowCol(0, 0) 
	   && player == board.getPlayerAtRowCol(0, 1) 
	   && player == board.getPlayerAtRowCol(0, 2)){
	    return true; // first row
    	}
    	else if(player == board.getPlayerAtRowCol(1, 0) 
		&& player == board.getPlayerAtRowCol(1, 1) 
		&& player == board.getPlayerAtRowCol(1, 2)){
	    return true; // second row
    	}
    	else if(player == board.getPlayerAtRowCol(2, 0) 
		&& player == board.getPlayerAtRowCol(2, 1) 
		&& player == board.getPlayerAtRowCol(2, 2)){
	    return true; // third row
        }
    	else{
	    return false;
    	}
    }
    
    private boolean checkForWinnerVertical(int player){
    	if(player == board.getPlayerAtRowCol(0, 0) 
	   && player == board.getPlayerAtRowCol(1, 0) 
	   && player == board.getPlayerAtRowCol(2, 0)){
	    return true; // first row
    	}
    	else if(player == board.getPlayerAtRowCol(0, 1) 
		&& player == board.getPlayerAtRowCol(1, 1) 
		&& player == board.getPlayerAtRowCol(2, 1)){
            return true; // second row
        }
        else if(player == board.getPlayerAtRowCol(0, 2) 
		&& player == board.getPlayerAtRowCol(1, 2) 
		&& player == board.getPlayerAtRowCol(2, 2)){
	    return true; // third row
        }
        else{
	    return false;
        }
    }
    
    private boolean checkForWinnerDiagonal(int player){
    	if(player == board.getPlayerAtRowCol(0, 0)
	   && player == board.getPlayerAtRowCol(1, 1)
	   && player == board.getPlayerAtRowCol(2, 2)){
	    return true;
    	}
    	else if (player == board.getPlayerAtRowCol(0, 2)
		 && player == board.getPlayerAtRowCol(1, 1)
		 && player == board.getPlayerAtRowCol(2, 0)){
	    return true;
    	}
    	else{
	    return false;
    	}
    }
    
    public static void main(String[] args) {
    	startGame game = new startGame();
    	
    	//Board board = new Board();
	int maxTurns = 9; // only 9 moves possible
	
	Player next = game.p1;
	Printer.printBoard(game.board);
	for(int round = 0; round < maxTurns; round++)
	    {
		
		Printer.playerMove(next.getPlayerNr());
		if(next.isHuman()){
		    
		    game.humanMove(next.getPlayerNr()); 
		}
		else{
		    int[] move = game.cpugame.computerMove(next.getPlayerNr(), game.board);
		    game.board.markCellPlayed(next.getPlayerNr(), move[0], move[1]);
		}
		
		Printer.printBoard(game.board);
		//	Check for a winner
		if(round > 3 && game.checkForWin(next.getPlayerNr())){   
		    Printer.winner(next.getPlayerNr());
		    break;
		}
		    
		    
		    // Change who's to play
		    if(next == game.p1)
		    	next = game.p2;
		    else
		    	next = game.p1;
	    }
    }
}
