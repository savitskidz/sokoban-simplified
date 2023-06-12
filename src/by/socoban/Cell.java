package by.socoban;

public class Cell {

	private String ico;
	private boolean isBox = false;
	private boolean isWall = false;
	private boolean isTarget = false;
	private boolean isEmpty = true;

	
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	public boolean isBox() {
		return isBox;
	}
	public void setBox(boolean isBox) {
		this.isBox = isBox;
	}
	public boolean isWall() {
		return isWall;
	}
	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}
	public boolean isTarget() {
		return isTarget;
	}
	public void setTarget(boolean isTarget) {
		this.isTarget = isTarget;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

}
