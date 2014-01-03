package metody3;

public class Heun {
	private double x;
	private double y;

	public Heun(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Heun(){
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public static double liczY(double x, double y, double h){
		return y + h * 0.5
				* (liczF(x, y) + liczF(x + h, y + h * liczF(x, y)));
	}
	
	public static double liczF(double x, double y) {
		return (2 * Math.pow(y, 2) - 2 * x * (Math.pow(x, 3) - 1));
	}
}
