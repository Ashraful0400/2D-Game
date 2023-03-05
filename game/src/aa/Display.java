/**
 * Displays everything
 * */
package Ui;

import Model.*;

public class Display {
	public void display(){
		String L1 = "Welcome to Cat and Mouse Maze Adventure";
		String L0 = "";
		for(int i =0; i < L1.length();i++){
			L0 += "-";
		}
		System.out.println(L0);
		System.out.println(L1);
		System.out.println("By Tawheed Sarker Aakash and Mohammad Ashraful Islam Bhuiyan");
		System.out.println(L0);
		System.out.println();
		System.out.println("DIRECTIONS:");
		System.out.println("\tFind 5 cheese before a cat eats you!");
		System.out.println("Legend");
		System.out.println("\t#: Wall");
		System.out.println("\t@: You (a mouse)");
		System.out.println("\t!: Cat");
		System.out.println("\t$: Cheese");
		System.out.println("\t.: Unexplored space");
		System.out.println("MOVES:");
		System.out.println("\tUse W (up), A (left), S (down) and D (right) to move.");
		System.out.println("\t(You must press enter after each move).");
	}
	public static void print(Maze myMaze) {
		System.out.println();
		System.out.println("Maze: ");
		for (int i = 0; i < myMaze.getROWS(); i++) {
			for (int j = 0; j < myMaze.getCOLS(); j++) {
				Cell cell = myMaze.getMaze()[i][j];

				if (cell.getCellType().equals(CellType.wall)) {
					System.out.print("#");
				} else if (cell.getCellType().equals(CellType.barricade)) {
					if (cell.getViewType().equals(ViewType.explored)) {
						System.out.print("#");
					} else if (cell.getViewType().equals(ViewType.unexplored)) {
						System.out.print(".");
					}
				} else if (cell.getCellType().equals(CellType.path)) {
					if (cell.getEntity().getEntityType().equals(EntityType.cat)) {
						System.out.print("!");
					} else if (cell.getEntity().getEntityType().equals(EntityType.mouse)) {
						System.out.print("@");
					} else if (cell.getEntity().getEntityType().equals(EntityType.cheese)) {
						System.out.print("$");
					} else if (cell.getEntity().getEntityType().equals(EntityType.eatenMouse)) {
						System.out.print("X");
					} else if (cell.getViewType().equals(ViewType.explored)) {
						System.out.print(" ");
					} else if (cell.getViewType().equals(ViewType.unexplored)) {
						System.out.print(".");
					}
				}
			}
			System.out.println();
		}
	}
}
