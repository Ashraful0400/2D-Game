/**
 *Creates Cells for maze
 * */
package Model;

public class Cell {
	private Point location;
	private CellType cellType;
	private Entity entity;
	private ViewType viewType;


	public Cell(int x, int y, CellType cellType) {
		this.location = new Point(x,y);
		this.cellType = cellType;
		this.entity = new Empty(x,y);
		viewType = ViewType.unexplored;
	}

	public Point getLocation() {
		return location;
	}


	public CellType getCellType() {
		return cellType;
	}

	public void setCellType(CellType cellType) {this.cellType = cellType;}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
		if(entity.getEntityType().equals(EntityType.cheese) || entity.getEntityType().equals(EntityType.cat) || entity.getEntityType().equals(EntityType.mouse)){
			viewType = ViewType.explored;
		}
	}

	public ViewType getViewType() {
		return viewType;
	}

	public void setViewType(ViewType viewType) {
		this.viewType = viewType;
	}
}
