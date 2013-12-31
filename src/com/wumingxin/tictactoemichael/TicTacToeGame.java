package com.wumingxin.tictactoemichael;

import java.util.Random;

public class TicTacToeGame {
	
	private char mBoard[];
	private final static int BOARD_SIZE=9;
	
	public static final char PLAYER_ONE = 'X';
	public static final char PLAYER_TWO = 'O';
	public static final char EMPTY_SPACE = ' ';
	
	private Random mRand;
	
	public static int getBOARD_SIZE(){
		return BOARD_SIZE;
	}
	
	public TicTacToeGame(){
		mBoard = new char[BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++){
			mBoard[i] = EMPTY_SPACE;
		}
		
		mRand = new Random();
	}
	
	public void clearBoard(){
		for (int i = 0; i<BOARD_SIZE; i++){
			mBoard[i] = EMPTY_SPACE;
		}
	}
	
	public void setMove(char player, int location){
		mBoard[location] = player;
	}
	
	public int getComputerMove(){
		int move;
		
		for (int i = 0; i< getBOARD_SIZE(); i++){
			if (mBoard[i]!=PLAYER_ONE && mBoard[i]!= PLAYER_TWO){
				char curr = mBoard[i];
				mBoard[i] = PLAYER_TWO;
				if (checkForWinner() == 3){
					setMove(PLAYER_TWO, i);
					return i;
				}
				else{
					mBoard[i]=curr;
				}
			}
		}
		
		for (int i = 0; i< getBOARD_SIZE(); i++){
			if (mBoard[i]!=PLAYER_ONE && mBoard[i]!= PLAYER_TWO){
				char curr = mBoard[i];
				mBoard[i] = PLAYER_ONE;
				if (checkForWinner() == 2){
					setMove(PLAYER_TWO, i);
					return i;
				}
				else{
					mBoard[i]=curr;
				}
			}
		}
		
		do{
			move = mRand.nextInt(getBOARD_SIZE());
		} while (mBoard[move]==PLAYER_ONE || mBoard[move]==PLAYER_TWO);
			
		setMove(PLAYER_TWO, move);
		return move;	
	}
	
	
	public int checkForWinner(){
		for (int i = 0; i<=6; i+=3){   //horizontal checks
			if (mBoard[i]==PLAYER_ONE &&
				mBoard[i+1]== PLAYER_ONE &&
				mBoard[i+2]==PLAYER_ONE)
				return 2;
			if (mBoard[i]==PLAYER_TWO &&
				mBoard[i+1]== PLAYER_TWO &&
				mBoard[i+2]==PLAYER_TWO)
				return 3;
				
		}
		
		for (int i = 0; i<= 2; i++){  //vertical checks
			if (mBoard[i]==PLAYER_ONE &&
				mBoard[i+3]== PLAYER_ONE &&
				mBoard[i+6]==PLAYER_ONE)
				return 2;
			if (mBoard[i]==PLAYER_TWO &&
				mBoard[i+3]== PLAYER_TWO &&
				mBoard[i+6]==PLAYER_TWO)
				return 3;
		}
		
		if ((mBoard[0]==PLAYER_ONE &&   //check diagonals
			 mBoard[4]==PLAYER_ONE &&
			 mBoard[8]==PLAYER_ONE) ||
			(mBoard[2]==PLAYER_ONE &&
			 mBoard[4]==PLAYER_ONE &&
			 mBoard[6]==PLAYER_ONE))
			return 2;
		if ((mBoard[0]==PLAYER_TWO &&
			 mBoard[4]==PLAYER_TWO &&
			 mBoard[8]==PLAYER_TWO) ||
			(mBoard[2]==PLAYER_TWO &&
			 mBoard[4]==PLAYER_TWO &&
			 mBoard[6]==PLAYER_TWO))
			return 3;
		
		for (int i = 0 ; i<getBOARD_SIZE(); i++){  //check for tie
			if (mBoard[i]!=PLAYER_ONE && mBoard[i]!=PLAYER_TWO){
				return 0;  //still moves left
			}
		}
		
		return 1; //tie!
		
			 
		
	}
	
	
}
