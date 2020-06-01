package lanzamiento;

public class Lanzamiento implements Comparable<Lanzamiento>{
	public double x;
	public double y;
	public double distOrigen;
	
	public Lanzamiento(double x, double y) {
		this.x = x;
		this.y = y;
		this.distOrigen = this.calcularDistOrige();
	}
	
	private double calcularDistOrige() {
		return Math.sqrt( Math.pow( this.x - 0, 2 ) + Math.pow( this.y - 0, 2 ) ); 
	}
	
	public boolean isInside(double radius) {
		return ( this.calcularDistOrige() <= radius );
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double getDistOrigen() {
		return distOrigen;
	}

	public void setDistOrigen(double distOrigen) {
		this.distOrigen = distOrigen;
	}

	@Override
	public int compareTo(Lanzamiento o) {
		if(this.distOrigen<=o.distOrigen)
		return -1;
		else return 1;
	}
	
	@Override
	public String toString() {
		return "["+x + ", "+ y+","+distOrigen+"]";
	}
}
