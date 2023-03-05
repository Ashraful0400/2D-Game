/**
 *Creates Entities for Cells
 * */
package Model;

public class Entity {

	protected Point location;
	protected EntityType entityType;

	public Entity(int x, int y, EntityType entityType) {
		this.location = new Point(x,y);
		this.entityType = entityType;
	}

	public Point getLocation() {
		return location;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public void swapLocation(Point location){
		this.location = location;
	}

}
