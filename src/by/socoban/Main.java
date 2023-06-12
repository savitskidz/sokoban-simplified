package by.socoban;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
//		Map.intCells();
		Map.place();
		Map.printMap();
		
		
		
		while (!Map.checkWin()) {
			Map.move(Map.pressedKey());
			Map.printMap();

		}
		
		

	}
	


}
