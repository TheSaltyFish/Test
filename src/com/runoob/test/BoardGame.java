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
		//��ʼ������
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
		System.out.print("��������Ϸ���򣺺������֣�ÿ�������壬,ÿ�غ��ƶ�һ�����ӣ�\n"
				+ "���̿ɿ������ڡ��ֿ�����һ�����ס��֡�\n"
				+ "һ��9��λ�ӣ������Ͻǿ�ʼ����ֱ�Ϊ1,2,3,4,5,6,7,8,9\n"
				+ "�ƶ���ʱֻ���ƶ�����֮���ڵ�λ�á�\n"
				+ "ֻ�����м���ĸ������λ��ֱ���ܹ���б�ߡ�\n"
				+ "�磺1��5Ϊ�Ϸ���5��3Ϊ�Ϸ�����2��4Ϊ�Ƿ���8��6Ϊ�Ƿ���\n"
				+ "��ĳһ������ʱ��������Ӷ���ͬһ��б����ʱ����Ϸ�������÷�ʤ����\n"
				+ "�ƶ����ӵķ���������һ���������ƶ�����(�м��ÿո����)�������룺1 4����1λ�õ����ƶ���4λ�á�\n"
				+ "���ڸ���������������̣�\n");
		System.out.println("1  2  3\n4  5  6\n7  8  9\n");
		System.out.println();
		printboard(board);
		System.out.println("������ģʽ����1����ҶԿ���2���˻��Կ�����");
		mod=(in.nextInt()==1)?true:false;
		if(mod) {
			System.out.println("��ѡ�������ҶԿ�ģʽ��");
		}else {
			System.out.println("���ԣ���ѡ������˻��Կ�ģʽ�����ɱ�������Ķ��֡�");
		}
		while(mod) {
			move(board,in.nextInt(),in.nextInt(),in,turn++);
			if((board[0][0]==board[1][1]&&
					board[1][1]==board[2][2])||
					(board[0][2]==board[1][1]&&
					board[1][1]==board[2][0])) {
				System.out.println("��Ϸ������");
				if(board[1][1]==1) {
					System.out.println("����ʤ����");
				}else if(board[1][1]==-1) {
					System.out.println("����ʤ����");
				}
				break;
			}
		}
		while(!mod) {
			if(turn % 2 == 0) {
				System.out.println("�ֵ���Ļغ��ˣ����������ӵ��ƶ�����(�磺1 4)��");
				move(board,in.nextInt(),in.nextInt(),in,turn++);
			}
			else {
				System.out.println("�ֵ����ԵĻغ��ˡ�");
				System.out.print("���ԣ��ݱ���˼��һ��");
				try
				{
				    Thread.sleep(500);
				}catch (InterruptedException e)
				{
				    e.printStackTrace();
				}System.out.print("��");
				try
				{
				    Thread.sleep(500);
				}catch (InterruptedException e)
				{
				    e.printStackTrace();
				}System.out.print("��");
				try
				{
				    Thread.sleep(500);
				}catch (InterruptedException e)
				{
				    e.printStackTrace();
				}System.out.println("��");
				computer.scanBoard(board, turn);
				System.out.println("���ԣ�û��������һ����");
				computer.think();
				turn++;
			}
			if((board[0][0]==board[1][1]&&
					board[1][1]==board[2][2])||
					(board[0][2]==board[1][1]&&
					board[1][1]==board[2][0])) {
				System.out.println("��Ϸ������");
				if(board[1][1]==1) {
					System.out.println("����ʤ����");
					try
					{
					    Thread.sleep(1500);
					}catch (InterruptedException e)
					{
					    e.printStackTrace();
					}
					System.out.println("���ԣ��������ţ�������Ȼ������㣡");
				}else if(board[1][1]==-1) {
					System.out.println("����ʤ����");
					try
					{
					    Thread.sleep(1500);
					}catch (InterruptedException e)
					{
					    e.printStackTrace();
					}
					System.out.println("���ԣ��������㻹�����������Ķ��֣�");
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
				System.out.println("�㲻�����Լ��Ļغ��ƶ����ֵ��壡");
			}
			System.out.println("�Ƿ�����������������λ�������Ŀ�����꣺");
			from = in.nextInt();
			to = in.nextInt();
			coordinate(from, co[0]);
			coordinate(to, co[1]);
			x=co[0][0];y=co[0][1];a=co[1][0];b=co[1][1];
		}
		board[a][b]=board[x][y];
		board[x][y]=0;
		printboard(board);
		System.out.println("��"+from+"�ƶ�����"+to+"��");
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
					System.out.print("�� ");
					break;
				case 0:
					System.out.print("_ ");
					break;
				case -1:
					System.out.print("�� ");
					break;
				default:
					System.out.println("��������ֹ��Ϸ�����ص��ԣ�");
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