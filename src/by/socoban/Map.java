package by.socoban;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Map {
	
	public static final int SIZE = 7;
	public static final int BOXES = 5;
	public static final int UP = 119;
	public static final int LEFT = 97;
	public static final int RIGHT = 100;
	public static final int DOWN = 115;
	
	private static Cell[][] map = new Cell[SIZE][SIZE];
	
	public static int Xs = 0;
	public static int Ys = 0;


	public static void place() {
		
//		Place Target on Map
		for (int i = 1; i <= BOXES; i++) {

			int X1 = randomNum(0, SIZE);
			int Y1 = randomNum(0, SIZE);

			if (checkEmptyTarget(Y1, X1) == true) {
//				System.out.println("checkEmpty = true");
				if (map[Y1][X1] == null) {
					map[Y1][X1] = new Cell();
				}
				map[Y1][X1].setIco("t");
				map[Y1][X1].setTarget(true);
//				System.out.println("TARGET - " + map[Y1][X1].isTarget());
			}
			else 
				i--;
		}
		
//		Place Box on Map cheking Target under Box		
		for (int i = 1; i <= BOXES; i++) {

			int X = randomNum(1, SIZE-1);
			int Y = randomNum(1, SIZE-1);

			if (checkEmptyBoxWall(Y, X) == true) {
//				System.out.println("checkEmpty = true");
				if (map[Y][X] == null) { 
					map[Y][X] = new Cell();
				}
				map[Y][X].setIco(checkOnTarget(Y, X,"b"));
				map[Y][X].setBox(true);
				map[Y][X].setEmpty(false);
			}
			else 
				i--;
		}
		
		int i = 1;
		while (i != 0) {
			int X = randomNum(0, SIZE);
			int Y = randomNum(0, SIZE);
			
			if (checkEmptyBoxWall(Y, X) == true) {
//				System.out.println("checkEmpty = true");
				if (map[Y][X] == null) { 
					map[Y][X] = new Cell();
				}
				map[Y][X].setIco(checkOnTarget(Y, X,"s"));
				Ys = Y;
				Xs = X;
				i = 0;
			}
		}
	}
	
	
	public static void move(int vektor) {
		switch (vektor) {
		case (UP):
			System.out.println("UP");
			if (Ys-1 >= 0) {
				if (checkEmptyBoxWall(Ys-1, Xs)) {								//проверка если клетка не скоробкой и не со стеной
					if (map[Ys-1][Xs] == null) {
						map[Ys-1][Xs] = new Cell();
					}
					map[Ys-1][Xs].setIco(checkOnTarget(Ys-1, Xs, "s"));
					if (map[Ys][Xs].isTarget() == true) {
						map[Ys][Xs].setIco("t");
					}else {
						map[Ys][Xs] = null;
					}
					Ys = Ys-1;
					System.out.println("Ys-1 = " + Ys);
					break;
				}

				if (map[Ys-1][Xs].isBox()) {
					if (Ys-2 >=0) {
						if (checkEmptyBoxWall(Ys-2, Xs)) {
							if (map[Ys-2][Xs] == null) {
								map[Ys-2][Xs] = new Cell();
							}
							map[Ys-2][Xs].setIco(checkOnTarget(Ys-2, Xs, "b"));
							map[Ys-2][Xs].setBox(true);
							map[Ys-1][Xs].setBox(false);
							map[Ys-1][Xs].setIco(checkOnTarget(Ys-1, Xs, "s"));
							if (map[Ys][Xs].isTarget() == true) {
								map[Ys][Xs].setIco("t");
							}else {
								map[Ys][Xs] = null;
							}
							Ys = Ys-1;
							System.out.println("Ys-1 = " + Ys);
							break;
						}
					}
				}

			}
			
			break;
		case (DOWN):
			System.out.println("DOWN");
			if (Ys+1 < SIZE) {
				if (checkEmptyBoxWall(Ys+1, Xs)) {								//проверка если клетка не скоробкой и не со стеной
					if (map[Ys+1][Xs] == null) {
						map[Ys+1][Xs] = new Cell();
					}
					map[Ys+1][Xs].setIco(checkOnTarget(Ys+1, Xs, "s"));
					if (map[Ys][Xs].isTarget() == true) {
						map[Ys][Xs].setIco("t");
					}else {
						map[Ys][Xs] = null;
					}
					Ys = Ys+1;
					System.out.println("Ys+1 = " + Ys);
					break;
				}
	
				if (map[Ys+1][Xs].isBox()) {
					if (Ys+2 < SIZE) {
						if (checkEmptyBoxWall(Ys+2, Xs)) {
							if (map[Ys+2][Xs] == null) {
								map[Ys+2][Xs] = new Cell();
							}
							map[Ys+2][Xs].setIco(checkOnTarget(Ys+2, Xs, "b"));
							map[Ys+2][Xs].setBox(true);
							map[Ys+1][Xs].setBox(false);
							map[Ys+1][Xs].setIco(checkOnTarget(Ys+1, Xs, "s"));
							if (map[Ys][Xs].isTarget() == true) {
								map[Ys][Xs].setIco("t");
							}else {
								map[Ys][Xs] = null;
							}
							Ys = Ys+1;
							System.out.println("Ys+1 = " + Ys);
							break;
						}
					}
				}
	
			}
			break;
		case (LEFT):
			System.out.println("LEFT");
			if (Xs-1 >= 0) {
				if (checkEmptyBoxWall(Ys, Xs-1)) {								//проверка если клетка не скоробкой и не со стеной
					if (map[Ys][Xs-1] == null) {
						map[Ys][Xs-1] = new Cell();
					}
					map[Ys][Xs-1].setIco(checkOnTarget(Ys, Xs-1, "s"));
					if (map[Ys][Xs].isTarget() == true) {
						map[Ys][Xs].setIco("t");
					}else {
						map[Ys][Xs] = null;
					}
					Xs = Xs-1;
					System.out.println("Xs-1 = " + Xs);
					break;
				}
	
				if (map[Ys][Xs-1].isBox()) {
					if (Xs-2 >=0) {
						if (checkEmptyBoxWall(Ys, Xs-2)) {
							if (map[Ys][Xs-2] == null) {
								map[Ys][Xs-2] = new Cell();
							}
							map[Ys][Xs-2].setIco(checkOnTarget(Ys, Xs-2, "b"));
							map[Ys][Xs-2].setBox(true);
							map[Ys][Xs-1].setBox(false);
							map[Ys][Xs-1].setIco(checkOnTarget(Ys, Xs-1, "s"));
							if (map[Ys][Xs].isTarget() == true) {
								map[Ys][Xs].setIco("t");
							}else {
								map[Ys][Xs] = null;
							}
							Xs = Xs-1;
							System.out.println("Xs-1 = " + Xs);
							break;
						}
					}
				}
	
			}
			break;
		case (RIGHT):
			System.out.println("RIGHT");
			if (Xs+1 < SIZE) {
				if (checkEmptyBoxWall(Ys, Xs+1)) {								//проверка если клетка не скоробкой и не со стеной
					if (map[Ys][Xs+1] == null) {
						map[Ys][Xs+1] = new Cell();
					}
					map[Ys][Xs+1].setIco(checkOnTarget(Ys, Xs+1, "s"));
					if (map[Ys][Xs].isTarget() == true) {
						map[Ys][Xs].setIco("t");
					}else {
						map[Ys][Xs] = null;
					}
					Xs = Xs+1;
					System.out.println("Xs+1 = " + Xs);
					break;
				}
	
				if (map[Ys][Xs+1].isBox()) {
					if (Xs+2 < SIZE) {
						if (checkEmptyBoxWall(Ys, Xs+2)) {
							if (map[Ys][Xs+2] == null) {
								map[Ys][Xs+2] = new Cell();
							}
							map[Ys][Xs+2].setIco(checkOnTarget(Ys, Xs+2, "b"));
							map[Ys][Xs+2].setBox(true);
							map[Ys][Xs+1].setBox(false);
							map[Ys][Xs+1].setIco(checkOnTarget(Ys, Xs+1, "s"));
							if (map[Ys][Xs].isTarget() == true) {
								map[Ys][Xs].setIco("t");
							}else {
								map[Ys][Xs] = null;
							}
							Xs = Xs+1;
							System.out.println("Xs+1 = " + Xs);
							break;
						}
					}
				}
	
			}
			break;
		default:
			System.out.println("!!!MISS!!!");
			break;
		}
		
	}

	
	public static void printMap () {
//		System.out.println("print");
		for (int y = 0 ; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				System.out.print((map[y][x] == null ? "_" : map[y][x].getIco())+"|");
			}
			System.out.println();
		}
		System.out.println("\r\n");
	}
	

	public static boolean checkEmptyBoxWall(int Y, int X) {
		if (map[Y][X] != null) {
			if ((map[Y][X].isWall() == false) && (map[Y][X].isBox() == false)) {
				return true;
			}
			else 
				return false;
		} 
		else 
			return true;
	}
	
	
	public static boolean checkEmptyTarget(int Y, int X) {
		if (map[Y][X] != null) {
			if ((map[Y][X].isWall() == false) && (map[Y][X].isTarget() == false)) {
				return true;
			}
			else 
				return false;
		} 
		else 
			return true;
	}

	
	public static String checkOnTarget(int Y, int X, String str) {
		if (map[Y][X] != null) {
			if (map[Y][X].isTarget() == true) {
				return str.toUpperCase();
			}
			else 
				return str.toLowerCase();
		}
		else 
			return str.toLowerCase();
	}

	
	public static int pressedKey() {
		int key =0;
		System.out.println("Press key!");
		Scanner s = new Scanner(System.in);
		key = s.next().charAt(0);
		System.out.println("Pressed key - " + key);
		return key;
	}
	
	
	public static int randomNum (int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}
	
	public static boolean checkWin() {
		for (int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if ((map[i][j] != null) && (map[i][j].getIco() == "b"))
					return false;
			}
		}
		return true;
	}

}
