package lanzamiento;

import java.util.Comparator;

public class Lanzamiento implements Comparable<Lanzamiento>{
	public double x;
	public double y;
	public double distOrigen;
	
	public Lanzamiento(double x, double y) {
		this.x = x;
		this.y = y;
		this.distOrigen = this.calcularDistOrige();
	}
	
	public boolean isInside(double radius) {
		return ( Math.sqrt( Math.pow( this.x - 0, 2 ) + Math.pow( this.y - 0, 2 ) ) <= radius );
	}
	
	private double calcularDistOrige() {
		return Math.sqrt( Math.pow( this.x - 0, 2 ) + Math.pow( this.y - 0, 2 ) ); 
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
