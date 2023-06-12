package by.socoban;

public class Box extends Cell {
	
	private String ico = "B";
	private boolean isBox = true;
	private boolean isEmpty = false;
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
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	

}
