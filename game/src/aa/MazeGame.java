/**
 * Connects cat mouse cheese with maze and checks for mouse and cat movement logics. Also checks mouse's visibility
 * */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeGame {
	private Maze myMaze;
	private Mouse myMouse;
	private List<Cat> myCats;
	private List<Cheese> myCheese;
	private int cheeseToCollect;
	private int cheeseCollected;
	private boolean mapTrigger;

	public MazeGame() {
		myMaze = new Maze();
		myMouse = new Mouse(1, 1);
		myCats = new ArrayList<>();
		myCheese = new ArrayList<>();
		this.cheeseToCollect = 5;
		this.cheeseCollected = 0;
		mapTrigger = false;
	}
	public Maze getMyMaze() {
		return myMaze;
	}

	public void start() {
		myMaze.createMaze();

		for (int i = 0; i < cheeseToCollect; i++) {
			placeCheese();
		}
		placeCat();
		myMaze.setEntity(myMouse);
		exploredUnexploredLogic();
	}
	private void placeCheese() {
		while (true) {
			Random random = new Random();
			int x = (Math.abs(random.nextInt()) % getMyMaze().getROWS() - 5) + 5;
			random = new Random();
			int y = (Math.abs(random.nextInt()) % getMyMaze().getCOLS() - 5) + 5;
			Point newLocation = new Point(x,y);
			if (myMaze.getCellType(x, y).equals(CellType.path)){
				if (myCheese.size() == 0){
					entityMaker(EntityType.cheese,x,y);
					break;
				}
				else{
					boolean canPlace = true;
					for (Cheese cheese : myCheese) {
						if (cheese.getLocation().equals(newLocation)) {
							canPlace = false;
							break;
						}
					}
					if (canPlace) {
						entityMaker(EntityType.cheese, x, y);
						break;
					}
				}
			}
		}
	}

	private void placeCat() {
		entityMaker(EntityType.cat, 1, 18);
		entityMaker(EntityType.cat, 13, 1);
		entityMaker(EntityType.cat, 13, 18);

	}

	private void entityMaker(EntityType entityType, int x, int y) {
		if (entityType.equals(EntityType.cat)) {
			Cat newCat = new Cat(x, y);
			myCats.add(newCat);
			myMaze.setEntity(newCat);
		}
		else if (entityType.equals(EntityType.cheese)) {
			Cheese newCheese = new Cheese(x, y);
			myCheese.add(newCheese);
			myMaze.setEntity(newCheese);
		}
	}
	public void moveCats(){
		for (Cat myCat : myCats) {
			catMovementLogic(myCat);
		}
	}
	public void catMovementLogic(Cat cat) {
		int x = cat.getLocation().getX();
		int y = cat.getLocation().getY();
		Random newRandom;
		int move;
		boolean status = true;
		while (status) {
			newRandom = new Random();
			move = Math.abs(newRandom.nextInt()) % 4;
			switch (move) {
				case 0 -> {
					if (myMaze.getCellType(x - 1, y).equals(CellType.path) && !myMaze.getEntity(x - 1, y).getEntityType().equals(EntityType.cheese) && !myMaze.getEntity(x - 1, y).getEntityType().equals(EntityType.cat)) {
						swapEntity(x - 1, y, x, y);
						status = false;
					}
				}
				case 1 -> {
					if (myMaze.getCellType(x, y - 1).equals(CellType.path) && !myMaze.getEntity(x, y - 1).getEntityType().equals(EntityType.cheese) && !myMaze.getEntity(x, y - 1).getEntityType().equals(EntityType.cat)) {
						swapEntity(x, y - 1, x, y);
						status = false;
					}
				}
				case 2 -> {
					if (myMaze.getCellType(x + 1, y).equals(CellType.path) && !myMaze.getEntity(x + 1, y).getEntityType().equals(EntityType.cheese) && !myMaze.getEntity(x + 1, y).getEntityType().equals(EntityType.cat)) {
						swapEntity(x + 1, y, x, y);
						status = false;
					}
				}
				case 3 -> {
					if (myMaze.getCellType(x, y + 1).equals(CellType.path) && !myMaze.getEntity(x, y + 1).getEntityType().equals(EntityType.cheese) && !myMaze.getEntity(x, y + 1).getEntityType().equals(EntityType.cat)) {
						swapEntity(x, y + 1, x, y);
						status = false;
					}
				}
			}
		}
	}
	public ReturnType mouseMovementLogic(char move) {
		Mouse mouse = myMouse;
		int x = mouse.getLocation().getX();
		int y = mouse.getLocation().getY();
		if(move == 'M' || move == 'm') {
			mapTrigger = true;
			exploredLogic();
		}

		switch (move) {

			case 'W', 'w' -> {
				if (myMaze.getCellType(x - 1, y).equals(CellType.path)) {
					if (myMaze.getEntity(x - 1, y).getEntityType().equals(EntityType.cat)) {
						myMaze.getEntity(x, y).setEntityType(EntityType.eatenMouse);
						myMaze.getMaze()[x - 1][y] = new Cell(x - 1, y, CellType.path);
						exploredUnexploredLogic();
						return ReturnType.eaten;
					}
					else if (myMaze.getEntity(x - 1, y).getEntityType().equals(EntityType.cheese)) {
						myMaze.getMaze()[x - 1][y] = new Cell(x - 1, y, CellType.path);
						swapEntity(x - 1, y, x, y);
						if(mapTrigger){
							exploredLogic();
						}
						cheeseCollected++;
						exploredUnexploredLogic();
						return ReturnType.grabbedCheese;
					}
					else {
						swapEntity(x - 1, y, x, y);
						exploredUnexploredLogic();
						if(mapTrigger){
							exploredLogic();
						}
						return ReturnType.move;
					}

				} else if (myMaze.getCellType(x - 1, y).equals(CellType.wall) || myMaze.getCellType(x - 1, y).equals(CellType.barricade)) {
					exploredUnexploredLogic();
					return ReturnType.block;
				}
			}
			case 'A', 'a' -> {
				if (myMaze.getCellType(x, y - 1).equals(CellType.path)) {
					if (myMaze.getEntity(x, y - 1).getEntityType().equals(EntityType.cat)) {
						myMaze.getEntity(x, y).setEntityType(EntityType.eatenMouse);
						myMaze.getMaze()[x][y - 1] = new Cell(x, y - 1, CellType.path);
						exploredUnexploredLogic();
						return ReturnType.eaten;
					} else if (myMaze.getEntity(x, y - 1).getEntityType().equals(EntityType.cheese)) {
						myMaze.getMaze()[x][y - 1] = new Cell(x, y - 1, CellType.path);
						swapEntity(x, y - 1, x, y);
						exploredUnexploredLogic();
						if(mapTrigger){
							exploredLogic();
						}
						cheeseCollected++;
						return ReturnType.grabbedCheese;
					} else {
						swapEntity(x, y - 1, x, y);
						exploredUnexploredLogic();
						if(mapTrigger){
							exploredLogic();
						}
						return ReturnType.move;
					}

				} else if (myMaze.getCellType(x, y - 1).equals(CellType.wall) || myMaze.getCellType(x, y - 1).equals(CellType.barricade)) {
					exploredUnexploredLogic();
					return ReturnType.block;
				}
			}
			case 'S', 's' -> {
				if (myMaze.getCellType(x + 1, y).equals(CellType.path)) {
					if (myMaze.getEntity(x + 1, y).getEntityType().equals(EntityType.cat)) {
						myMaze.getEntity(x, y).setEntityType(EntityType.eatenMouse);
						myMaze.getMaze()[x + 1][y] = new Cell(x + 1, y, CellType.path);
						exploredUnexploredLogic();
						return ReturnType.eaten;
					}
					else if (myMaze.getEntity(x + 1, y).getEntityType().equals(EntityType.cheese)) {
						myMaze.getMaze()[x + 1][y] = new Cell(x + 1, y, CellType.path);
						swapEntity(x + 1, y, x, y);
						exploredUnexploredLogic();
						if(mapTrigger){
							exploredLogic();
						}
						cheeseCollected++;
						return ReturnType.grabbedCheese;
					}
					else {
						swapEntity(x + 1, y, x, y);
						exploredUnexploredLogic();
						if(mapTrigger){
							exploredLogic();
						}
						return ReturnType.move;
					}

				} else if (myMaze.getCellType(x + 1, y).equals(CellType.wall) || myMaze.getCellType(x + 1, y).equals(CellType.barricade)) {
					exploredUnexploredLogic();
					return ReturnType.block;
				}
			}
			case 'D', 'd' -> {
				if (myMaze.getCellType(x, y + 1).equals(CellType.path)) {
					if (myMaze.getEntity(x, y + 1).getEntityType().equals(EntityType.cat)) {
						myMaze.getEntity(x, y).setEntityType(EntityType.eatenMouse);
						myMaze.getMaze()[x][y + 1] = new Cell(x, y + 1, CellType.path);
						exploredUnexploredLogic();
						return ReturnType.eaten;
					} else if (myMaze.getEntity(x, y + 1).getEntityType().equals(EntityType.cheese)) {
						myMaze.getMaze()[x][y + 1] = new Cell(x, y + 1, CellType.path);
						swapEntity(x, y + 1, x, y);
						exploredUnexploredLogic();
						if(mapTrigger){
							exploredLogic();
						}
						cheeseCollected++;
						return ReturnType.grabbedCheese;
					} else {
						swapEntity(x, y + 1, x, y);
						exploredUnexploredLogic();
						if(mapTrigger){
							exploredLogic();
						}
						return ReturnType.move;
					}

				} else if (myMaze.getCellType(x, y + 1).equals(CellType.wall) || myMaze.getCellType(x, y + 1).equals(CellType.barricade)) {
					exploredUnexploredLogic();
					return ReturnType.block;
				}
			}
			case 'C', 'c' ->
				reduceCheese(mapTrigger);

		}
		return ReturnType.wrong;
	}
	private void exploredUnexploredLogic() {
		int x = myMouse.getLocation().getX();
		int y = myMouse.getLocation().getY();

		myMaze.setViewType(x - 1, y - 1, ViewType.explored);
		myMaze.setViewType(x - 1, y, ViewType.explored);
		myMaze.setViewType(x - 1, y + 1, ViewType.explored);
		myMaze.setViewType(x, y - 1, ViewType.explored);
		myMaze.setViewType(x , y + 1, ViewType.explored);
		myMaze.setViewType(x + 1, y - 1, ViewType.explored);
		myMaze.setViewType(x + 1, y, ViewType.explored);
		myMaze.setViewType(x + 1, y + 1, ViewType.explored);

	}
	public void exploredLogic(){
		for(int i = 1 ;i < myMaze.getROWS();i++){
			for(int j = 1; j < myMaze.getCOLS();j++) {
				myMaze.setViewType(i, j, ViewType.explored);
			}
		}
	}
	private void reduceCheese(boolean mapTrigger){
		int x, y;
		for(int i = 1; i < cheeseToCollect; i++){
			x = myCheese.get(i).getLocation().getX();
			y = myCheese.get(i).getLocation().getY();
			Empty path = new Empty(x,y);
			Cell newCell = new Cell(x,y,CellType.path);
			newCell.setEntity(path);
			myMaze.setCell(newCell);
			if(mapTrigger){
				exploredLogic();
			}
		}
		cheeseToCollect = 1;
	}

	public int getCheeseToCollect() {
		return cheeseToCollect;
	}

	public int getCheeseCollected() {
		return cheeseCollected;
	}
	private void swapEntity(int x1, int y1, int x2, int y2){
		Cell[][] maze = myMaze.getMaze();

		if(maze[x1][y1].getCellType().equals(CellType.wall) || maze[x1][y1].getCellType().equals(CellType.barricade) || maze[x2][y2].getCellType().equals(CellType.wall) || maze[x2][y2].getCellType().equals(CellType.barricade)) {return;}
		Entity temp = maze[x1][y1].getEntity();
		maze[x1][y1].setEntity(maze[x2][y2].getEntity());
		maze[x2][y2].setEntity(temp);

		Point tempLocation = maze[x1][y1].getEntity().getLocation();
		maze[x1][y1].getEntity().swapLocation(maze[x2][y2].getEntity().getLocation());
		maze[x2][y2].getEntity().swapLocation(tempLocation);
		if(!mapTrigger){
			if(maze[x1][y1].getCellType().equals(CellType.path)){ maze[x1][y1].setViewType(ViewType.unexplored);}
			if(maze[x2][y2].getCellType().equals(CellType.path)){ maze[x2][y2].setViewType(ViewType.unexplored);}
		}
		exploredUnexploredLogic();
	}
}
