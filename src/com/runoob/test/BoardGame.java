package com.runoob.test;

import java.util.Scanner;

public class BoardGame {
	public static void main(String[] args) {
		int turn=0;
		boolean mod;
		Scanner in = new Scanner(System.in);
		BoardGame.cpu computer = new BoardGame().new cpu(turn,in);
		int[][] board = new int[3][3];
		int i,j;
		//初始化棋盘
		for(i=0; i<3; i++) {
			for(j=0; j<3; j++) {
				if(i==0) {
					board[i][j]=1;
				}else if(i==1) {
					board[i][j]=0;
				}else {
					board[i][j]=-1;
				}
			}
		}
		System.out.print("米字棋游戏规则：黑子先手，每人三个棋，,每回合移动一个棋子，\n"
				+ "棋盘可看做‘口’字框里面一个‘米’字。\n"
				+ "一共9个位子，从左上角开始坐标分别为1,2,3,4,5,6,7,8,9\n"
				+ "移动子时只能移动到与之相邻的位置。\n"
				+ "只有正中间和四个角落的位置直接能够走斜线。\n"
				+ "如：1→5为合法，5→3为合法，而2→4为非法，8→6为非法。\n"
				+ "当某一方落子时完成三个子都在同一条斜线上时，游戏结束，该方胜利。\n"
				+ "移动棋子的方法：输入一组坐标来移动棋子(中间用空格隔开)，如输入：1 4，将1位置的棋移动到4位置。\n"
				+ "现在给出棋盘坐标和棋盘：\n");
		System.out.println("1  2  3\n4  5  6\n7  8  9\n");
		System.out.println();
		printboard(board);
		System.out.println("请输入模式：（1：玩家对抗，2：人机对抗。）");
		mod=(in.nextInt()==1)?true:false;
		if(mod) {
			System.out.println("您选择的是玩家对抗模式。");
		}else {
			System.out.println("电脑：您选择的是人机对抗模式，将由本机做你的对手。");
		}
		while(mod) {
			move(board,in.nextInt(),in.nextInt(),in,turn++);
			if((board[0][0]==board[1][1]&&
					board[1][1]==board[2][2])||
					(board[0][2]==board[1][1]&&
					board[1][1]==board[2][0])) {
				System.out.println("游戏结束！");
				if(board[1][1]==1) {
					System.out.println("黑子胜利！");
				}else if(board[1][1]==-1) {
					System.out.println("白子胜利！");
				}
				break;
			}
		}
		while(!mod) {
			if(turn % 2 == 0) {
				System.out.println("轮到你的回合了，请输入棋子的移动坐标(如：1 4)：");
				move(board,in.nextInt(),in.nextInt(),in,turn++);
			}
			else {
				System.out.println("轮到电脑的回合了。");
				System.out.print("电脑：容本机思考一秒");
				try
				{
				    Thread.sleep(500);
				}catch (InterruptedException e)
				{
				    e.printStackTrace();
				}System.out.print("。");
				try
				{
				    Thread.sleep(500);
				}catch (InterruptedException e)
				{
				    e.printStackTrace();
				}System.out.print("。");
				try
				{
				    Thread.sleep(500);
				}catch (InterruptedException e)
				{
				    e.printStackTrace();
				}System.out.println("。");
				computer.scanBoard(board, turn);
				System.out.println("电脑：没错，就是这一步！");
				computer.think();
				turn++;
			}
			if((board[0][0]==board[1][1]&&
					board[1][1]==board[2][2])||
					(board[0][2]==board[1][1]&&
					board[1][1]==board[2][0])) {
				System.out.println("游戏结束！");
				if(board[1][1]==1) {
					System.out.println("黑子胜利！");
					try
					{
					    Thread.sleep(1500);
					}catch (InterruptedException e)
					{
					    e.printStackTrace();
					}
					System.out.println("电脑：不敢相信，本机居然输给了你！");
				}else if(board[1][1]==-1) {
					System.out.println("白子胜利！");
					try
					{
					    Thread.sleep(1500);
					}catch (InterruptedException e)
					{
					    e.printStackTrace();
					}
					System.out.println("电脑：哈哈，你还不配做本机的对手！");
				}
				break;
			}
		}
		in.close();
	}
	public static void move(int[][] board, int from, 
			int to,Scanner in,int turn) {
		int x,y,a,b;
		int[][] co = new int[2][2];
		coordinate(from, co[0]);
		coordinate(to, co[1]);
		x=co[0][0];y=co[0][1];a=co[1][0];b=co[1][1];
		while(!check(board,x,y,a,b,turn)) {
			if((turn % 2 == 1 && board[x][y] == 1)||
					(turn % 2 == 0 && board[x][y] == -1)) {
				System.out.println("你不能在自己的回合移动对手的棋！");
			}
			System.out.println("非法操作！请重新输入位移坐标和目的坐标：");
			from = in.nextInt();
			to = in.nextInt();
			coordinate(from, co[0]);
			coordinate(to, co[1]);
			x=co[0][0];y=co[0][1];a=co[1][0];b=co[1][1];
		}
		board[a][b]=board[x][y];
		board[x][y]=0;
		printboard(board);
		System.out.println("从"+from+"移动到了"+to+"。");
	}
	public static boolean check(int[][] board ,
			int x,int y, int a, int b,int turn) {
		if(x<0||x>2||y<0||y>2) {
			return false;
		}else if((turn % 2 == 1 && board[x][y] == 1)||
				(turn % 2 == 0 && board[x][y] == -1)){
			return false;
		}else if(board[x][y]!=0&&board[a][b]==0) {
			if((x-a)*(x-a)+(y-b)*(y-b)>2) {
				return false;
			}else if((x-a)*(x-a)+(y-b)*(y-b)==2) {
				if((x==0&&y==1)||(x==1&&(y==0||y==2))||
						(x==2&&y==1))
					return false;
			}
			return true;
		}
		return false;
	}
	public static void coordinate(int a,int[] co) {
		if(a>=1&&a<=3) {
			co[0] = 0;
			co[1] = a-1;
		}else if(a>=4&&a<=6) {
			co[0] = 1;
			co[1] = a-4;
		}else if(a>=7&&a<=9) {
			co[0] = 2;
			co[1] = a-7;
		}else {
			co[0] = -1;
			co[1] = -1;
		}
	}
	public static void printboard(int[][] board) {
		int i,j;
		for(i=0; i<3; i++) {
			for(j=0; j<3; j++) {
				switch(board[i][j]) {
				case 1:
					System.out.print("● ");
					break;
				case 0:
					System.out.print("_ ");
					break;
				case -1:
					System.out.print("○ ");
					break;
				default:
					System.out.println("错误，请终止游戏，返回调试！");
				}
				if(j==2) {
					System.out.println();
				}
			}
		}
	}
	class cpu{
		int turn;
		int[][] board;
		int[][] co = new int[2][2];
		int from,to,x,y,a,b;
		Scanner in;
		public cpu(int turn,Scanner in){
			this.turn = turn;
			this.in=in;
		}
		public void scanBoard(int[][] board, int turn) {
			this.board=board;
			this.turn = turn;
		}
		public void think() {
			if(board[1][1]==0) {
				if(board[0][0]==board[0][2]&&board[0][0]==board[2][0]&&trying(1,5)) {
					move(board, 1, 5, in, turn);
				}else if(board[0][0]==board[0][2]&&board[0][0]==board[2][2]&&trying(3,5)) {
					move(board, 3, 5, in, turn);
				}else if(board[0][0]==board[2][2]&&board[0][0]==board[2][0]&&trying(7,5)) {
					move(board, 7, 5, in, turn);
				}else if(board[2][2]==board[0][2]&&board[2][2]==board[2][0]&&trying(9,5)) {
					move(board, 1, 5, in, turn);
				}else {
					for(from=2,to=5;(!trying(from,to))&&from<=9;from+=2);
					if(trying(from,to)) {
						move(board, from, to, in, turn);
					}
					for(from=1,to=5;(!trying(from,to))&&from<=9;from+=2);
					if(trying(from,to)) {
						move(board, from, to, in, turn);
					}
				}
			}else if(board[1][1]==-1){ 
				if(board[1][1]==board[0][0]) {
					if(trying(8,9)) {
						move(board, 8, 9, in, turn);
					}else if(trying(6,9)) {
						move(board, 6, 9, in,turn);
					}else if(trying(3,6)) {
						move(board, 3, 6, in, turn);
					}else if(trying(7,8)) {
						move(board, 7, 8, in, turn);
					}else if(trying(2,3)) {
						move(board, 2, 3, in,turn);
					}else if(trying(4,7)) {
						move(board, 4, 7, in, turn);
					}else if(trying(6,3)) {
						move(board, 6, 3, in, turn);
					}else if(trying(8,7)) {
						move(board, 8, 7, in, turn);
					}else if(trying(3,2)) {
						move(board, 3, 2, in,turn);
					}else if(trying(7,4)) {
						move(board, 7, 4, in, turn);
					}else if(trying(1,2)){
						move(board, 1, 2, in, turn);
					}else if(trying(1,4)) {
						move(board, 1, 4, in, turn);
					}else if(trying(5,1)) {
						move(board, 5, 1, in, turn);
					}else if(trying(5,3)) {
						move(board, 5, 3, in, turn);
					}else if(trying(5,7)) {
						move(board, 5, 7, in, turn);
					}else if(trying(5,9)) {
						move(board, 5, 9, in, turn);
					}else {
						for(from=5,to=2;(!trying(from,to))&&to<=9;to+=2);
						if(trying(from,to)) {
							move(board, from, to, in, turn);
						}
					}
				}else if(board[1][1]==board[0][2]) {
					if(trying(4,7)) {
						move(board, 4, 7, in, turn);
					}else if(trying(6,9)) {
						move(board, 8, 7, in,turn);
					}else if(trying(1,4)) {
						move(board, 1, 4, in, turn);
					}else if(trying(9,8)) {
						move(board, 9, 8, in, turn);
					}else if(trying(2,1)) {
						move(board, 2, 1, in, turn);
					}else if(trying(6,9)) {
						move(board, 6, 9, in, turn);
					}else if(trying(4,1)) {
						move(board, 4, 1, in, turn);
					}else if(trying(8,9)) {
						move(board, 8, 9, in, turn);
					}else if(trying(1,2)) {
						move(board, 1, 2, in, turn);
					}else if(trying(9,6)) {
						move(board, 9, 6, in, turn);
					}else if(trying(3,2)) {
						move(board, 3, 2, in, turn);
					}else if(trying(3,6)) {
						move(board, 3, 6, in, turn);
					}else if(trying(5,1)) {
						move(board, 5, 1, in, turn);
					}else if(trying(5,3)) {
						move(board, 5, 3, in, turn);
					}else if(trying(5,7)) {
						move(board, 5, 7, in, turn);
					}else if(trying(5,9)) {
						move(board, 5, 9, in, turn);
					}else {
						for(from=5,to=2;(!trying(from,to))&&to<=9;to+=2);
						if(trying(from,to)) {
							move(board, from, to, in, turn);
						}
					}
				}else if(board[1][1]==board[2][0]) {
					if(trying(2,3)) {
						move(board, 2, 3, in, turn);
					}else if(trying(6,3)) {
						move(board, 6, 3, in,turn);
					}else if(trying(9,6)) {
						move(board, 9, 6, in, turn);
					}else if(trying(1,2)) {
						move(board, 1, 2, in, turn);
					}else if(trying(8,9)) {
						move(board, 8, 9, in, turn);
					}else if(trying(4,1)) {
						move(board, 4, 1, in, turn);
					}else if(trying(6,9)) {
						move(board, 6, 9, in, turn);
					}else if(trying(2,1)) {
						move(board, 2, 1, in, turn);
					}else if(trying(9,8)) {
						move(board, 9, 8, in, turn);
					}else if(trying(1,4)) {
						move(board, 1, 4, in, turn);
					}else if(trying(7,4)) {
						move(board, 7, 4, in, turn);
					}else if(trying(7,8)) {
						move(board, 7, 8, in, turn);
					}else if(trying(5,1)) {
						move(board, 5, 1, in, turn);
					}else if(trying(5,3)) {
						move(board, 5, 3, in, turn);
					}else if(trying(5,7)) {
						move(board, 5, 7, in, turn);
					}else if(trying(5,9)) {
						move(board, 5, 9, in, turn);
					}else {
						for(from=5,to=2;(!trying(from,to))&&to<=9;to+=2);
						if(trying(from,to)) {
							move(board, from, to, in, turn);
						}
					}
				}else if(board[1][1]==board[2][2]) {
					if(trying(2,1)) {
						move(board, 2, 1, in, turn);
					}else if(trying(4,1)) {
						move(board, 4, 1, in,turn);
					}else if(trying(3,2)) {
						move(board, 3, 2, in,turn);
					}else if(trying(7,4)) {
						move(board, 7, 4, in,turn);
					}else if(trying(8,7)) {
						move(board, 8, 7, in,turn);
					}else if(trying(6,3)) {
						move(board, 6, 3, in,turn);
					}else if(trying(2,3)) {
						move(board, 2, 3, in,turn);
					}else if(trying(4,7)) {
						move(board, 4, 7, in,turn);
					}else if(trying(7,8)) {
						move(board, 7, 8, in,turn);
					}else if(trying(3,6)) {
						move(board, 3, 6, in,turn);
					}else if(trying(9,8)) {
						move(board, 9, 8, in, turn);
					}else if(trying(9,6)) {
						move(board, 9, 6, in, turn);
					}else if(trying(5,1)) {
						move(board, 5, 1, in, turn);
					}else if(trying(5,3)) {
						move(board, 5, 3, in, turn);
					}else if(trying(5,7)) {
						move(board, 5, 7, in, turn);
					}else if(trying(5,9)) {
						move(board, 5, 9, in, turn);
					}else {
						for(from=5,to=2;(!trying(from,to))&&to<=9;to+=2);
						if(trying(from,to)) {
							move(board, from, to, in, turn);
						}
					}
				}
				else if(trying(2,1)) {move(board, 2, 1, in, turn);}
				else if(trying(2,3)) {move(board, 2, 3, in, turn);}
				else if(trying(4,1)) {move(board, 4, 1, in, turn);}
				else if(trying(4,7)) {move(board, 4, 7, in, turn);}
				else if(trying(6,3)) {move(board, 6, 3, in, turn);}
				else if(trying(6,9)) {move(board, 6, 9, in, turn);}
				else if(trying(8,7)) {move(board, 8, 7, in, turn);}
				else if(trying(8,9)) {move(board, 8, 9, in, turn);}
				else if(trying(1,2)) {move(board, 1, 2, in, turn);}
				else if(trying(3,2)) {move(board, 3, 2, in, turn);}
				else if(trying(1,4)) {move(board, 1, 4, in, turn);}
				else if(trying(7,4)) {move(board, 7, 4, in, turn);}
				else if(trying(3,6)) {move(board, 3, 6, in, turn);}
				else if(trying(9,6)) {move(board, 9, 6, in, turn);}
				else if(trying(7,8)) {move(board, 7, 8, in, turn);}
				else if(trying(9,8)) {move(board, 9, 8, in, turn);}
				else if(trying(5,1)) {
					move(board, 5, 1, in, turn);
				}else if(trying(5,3)) {
					move(board, 5, 3, in, turn);
				}else if(trying(5,7)) {
					move(board, 5, 7, in, turn);
				}else if(trying(5,9)) {
					move(board, 5, 9, in, turn);
				}else {
					for(from=5,to=2;(!trying(from,to))&&to<=9;to+=2);
					if(trying(from,to)) {
						move(board, from, to, in, turn);
					}
				}
			}else {
				if(turn == 1 && trying(7,4)) {move(board, 7, 4, in, turn);}
				else if(turn == 3 && trying(8,7)) {move(board, 8, 7, in, turn);}
				else if(board[1][1]==board[0][0]) {
					if(trying(8,9)) {
						move(board, 8, 9, in, turn);
					}else if(trying(6,9)) {
						move(board, 6, 9, in,turn);
					}else if(trying(6,3)) {
						move(board, 6, 3, in, turn);
					}else if(trying(8,7)) {
						move(board, 8, 7, in, turn);
					}else if(trying(2,3)) {
						move(board, 2, 3, in,turn);
					}else if(trying(4,7)) {
						move(board, 4, 7, in, turn);
					}else if(trying(7,4)) {
						move(board, 7, 4, in, turn);
					}else if(trying(3,2)) {
						move(board, 3, 2, in, turn);
					}else if(trying(2,1)) {move(board, 2, 1, in, turn);}
					else if(trying(2,3)) {move(board, 2, 3, in, turn);}
					else if(trying(4,1)) {move(board, 4, 1, in, turn);}
					else if(trying(8,7)) {move(board, 8, 7, in, turn);}
					else if(trying(6,3)) {move(board, 6, 3, in, turn);}
					else if(trying(6,9)) {move(board, 6, 9, in, turn);}
					else if(trying(4,7)) {move(board, 4, 7, in, turn);}
					else if(trying(8,9)) {move(board, 8, 9, in, turn);}
					else if(trying(1,2)) {move(board, 1, 2, in, turn);}
					else if(trying(3,2)) {move(board, 3, 2, in, turn);}
					else if(trying(1,4)) {move(board, 1, 4, in, turn);}
					else if(trying(7,4)) {move(board, 7, 4, in, turn);}
					else if(trying(3,6)) {move(board, 3, 6, in, turn);}
					else if(trying(9,6)) {move(board, 9, 6, in, turn);}
					else if(trying(7,8)) {move(board, 7, 8, in, turn);}
					else if(trying(9,8)) {move(board, 9, 8, in, turn);}
				}else if(board[1][1]==board[0][2]) {
					if(trying(4,7)) {
						move(board, 4, 7, in, turn);
					}else if(trying(6,9)) {
						move(board, 8, 7, in,turn);
					}else if(trying(4,1)) {
						move(board, 4, 1, in, turn);
					}else if(trying(8,9)) {
						move(board, 8, 9, in, turn);
					}else if(trying(2,1)) {
						move(board, 2, 1, in, turn);
					}else if(trying(6,9)) {
						move(board, 6, 9, in, turn);
					}else if(trying(9,6)) {
						move(board, 9, 6, in, turn);
					}else if(trying(1,2)) {
						move(board, 1, 2, in, turn);
					}else if(trying(2,1)) {move(board, 2, 1, in, turn);}
					else if(trying(2,3)) {move(board, 2, 3, in, turn);}
					else if(trying(4,1)) {move(board, 4, 1, in, turn);}
					else if(trying(8,7)) {move(board, 8, 7, in, turn);}
					else if(trying(6,3)) {move(board, 6, 3, in, turn);}
					else if(trying(6,9)) {move(board, 6, 9, in, turn);}
					else if(trying(4,7)) {move(board, 4, 7, in, turn);}
					else if(trying(8,9)) {move(board, 8, 9, in, turn);}
					else if(trying(1,2)) {move(board, 1, 2, in, turn);}
					else if(trying(3,2)) {move(board, 3, 2, in, turn);}
					else if(trying(1,4)) {move(board, 1, 4, in, turn);}
					else if(trying(7,4)) {move(board, 7, 4, in, turn);}
					else if(trying(3,6)) {move(board, 3, 6, in, turn);}
					else if(trying(9,6)) {move(board, 9, 6, in, turn);}
					else if(trying(7,8)) {move(board, 7, 8, in, turn);}
					else if(trying(9,8)) {move(board, 9, 8, in, turn);}
				}else if(board[1][1]==board[2][0]) {
					if(trying(2,3)) {
						move(board, 2, 3, in, turn);
					}else if(trying(6,3)) {
						move(board, 6, 3, in,turn);
					}else if(trying(6,9)) {
						move(board, 6, 9, in, turn);
					}else if(trying(2,1)) {
						move(board, 2, 1, in, turn);
					}else if(trying(8,9)) {
						move(board, 8, 9, in, turn);
					}else if(trying(4,1)) {
						move(board, 4, 1, in, turn);
					}else if(trying(1,4)) {
						move(board, 1, 4, in, turn);
					}else if(trying(9,8)) {
						move(board, 9, 8, in, turn);
					}else if(trying(2,1)) {move(board, 2, 1, in, turn);}
					else if(trying(2,3)) {move(board, 2, 3, in, turn);}
					else if(trying(4,1)) {move(board, 4, 1, in, turn);}
					else if(trying(8,7)) {move(board, 8, 7, in, turn);}
					else if(trying(6,3)) {move(board, 6, 3, in, turn);}
					else if(trying(6,9)) {move(board, 6, 9, in, turn);}
					else if(trying(4,7)) {move(board, 4, 7, in, turn);}
					else if(trying(8,9)) {move(board, 8, 9, in, turn);}
					else if(trying(1,2)) {move(board, 1, 2, in, turn);}
					else if(trying(3,2)) {move(board, 3, 2, in, turn);}
					else if(trying(1,4)) {move(board, 1, 4, in, turn);}
					else if(trying(7,4)) {move(board, 7, 4, in, turn);}
					else if(trying(3,6)) {move(board, 3, 6, in, turn);}
					else if(trying(9,6)) {move(board, 9, 6, in, turn);}
					else if(trying(7,8)) {move(board, 7, 8, in, turn);}
					else if(trying(9,8)) {move(board, 9, 8, in, turn);}
				}else if(board[1][1]==board[2][2]) {
					if(trying(2,1)) {
						move(board, 2, 1, in, turn);
					}else if(trying(4,1)) {
						move(board, 4, 1, in,turn);
					}else if(trying(2,3)) {
						move(board, 2, 3, in,turn);
					}else if(trying(4,7)) {
						move(board, 4, 7, in,turn);
					}else if(trying(8,7)) {
						move(board, 8, 7, in,turn);
					}else if(trying(6,3)) {
						move(board, 6, 3, in,turn);
					}else if(trying(6,3)) {
						move(board, 6, 3, in, turn);
					}else if(trying(7,8)) {
						move(board, 7, 8, in, turn);
					}else if(trying(2,1)) {move(board, 2, 1, in, turn);}
					else if(trying(2,3)) {move(board, 2, 3, in, turn);}
					else if(trying(4,1)) {move(board, 4, 1, in, turn);}
					else if(trying(8,7)) {move(board, 8, 7, in, turn);}
					else if(trying(6,3)) {move(board, 6, 3, in, turn);}
					else if(trying(6,9)) {move(board, 6, 9, in, turn);}
					else if(trying(4,7)) {move(board, 4, 7, in, turn);}
					else if(trying(8,9)) {move(board, 8, 9, in, turn);}
					else if(trying(1,2)) {move(board, 1, 2, in, turn);}
					else if(trying(3,2)) {move(board, 3, 2, in, turn);}
					else if(trying(1,4)) {move(board, 1, 4, in, turn);}
					else if(trying(7,4)) {move(board, 7, 4, in, turn);}
					else if(trying(3,6)) {move(board, 3, 6, in, turn);}
					else if(trying(9,6)) {move(board, 9, 6, in, turn);}
					else if(trying(7,8)) {move(board, 7, 8, in, turn);}
					else if(trying(9,8)) {move(board, 9, 8, in, turn);}
				}else {
					if(trying(2,1)) {move(board, 2, 1, in, turn);}
					else if(trying(2,3)) {move(board, 2, 3, in, turn);}
					else if(trying(4,1)) {move(board, 4, 1, in, turn);}
					else if(trying(8,7)) {move(board, 8, 7, in, turn);}
					else if(trying(6,3)) {move(board, 6, 3, in, turn);}
					else if(trying(6,9)) {move(board, 6, 9, in, turn);}
					else if(trying(4,7)) {move(board, 4, 7, in, turn);}
					else if(trying(8,9)) {move(board, 8, 9, in, turn);}
					else if(trying(1,2)) {move(board, 1, 2, in, turn);}
					else if(trying(3,2)) {move(board, 3, 2, in, turn);}
					else if(trying(1,4)) {move(board, 1, 4, in, turn);}
					else if(trying(7,4)) {move(board, 7, 4, in, turn);}
					else if(trying(3,6)) {move(board, 3, 6, in, turn);}
					else if(trying(9,6)) {move(board, 9, 6, in, turn);}
					else if(trying(7,8)) {move(board, 7, 8, in, turn);}
					else if(trying(9,8)) {move(board, 9, 8, in, turn);}
				}
			}
		}
		private boolean trying(int from, int to) {
			coordinate(from, co[0]);
			coordinate(to, co[1]);
			x = co[0][0];y = co[0][1];
			a = co[1][0];b = co[1][1];
			return check(board, x, y, a, b,turn);
		}
	}
}