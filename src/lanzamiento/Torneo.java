package lanzamiento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Torneo {
	private List<Lanzamiento>lanzamientosOli;
	private List<Lanzamiento>lanzamientosContrincante;
	private int cantLanzamientos;
	private int radioMaximo;
	
	public Torneo() {
		lanzamientosOli = new ArrayList<Lanzamiento>();
		lanzamientosContrincante = new ArrayList<Lanzamiento>();
	}
	
	public void determinarRadio() {
		leerLanzamientos();
		int lanzO = 0, lanzC = 0, i = 0, gano=0;
		double radio, radioMaximo = 0;
		while (i < lanzamientosOli.size() && gano != 1) {
			radio = lanzamientosOli.get(i).getDistOrigen();
			for (Lanzamiento l : lanzamientosOli)
				if (l.isInside(radio))
					lanzO++;
			for (Lanzamiento l : lanzamientosContrincante)
				if (l.isInside(radio))
					lanzC++;
			if ((lanzO - lanzC) > 0) {
				radioMaximo = radio;
				gano++;
			}
			else {
				radioMaximo = 0;
				gano = 0;
			}
			lanzO = 0;
			lanzC = 0;
			i++;
		}
		System.out.println("RADIO MAXIMO: " + radioMaximo);
		System.out.println(Math.pow(radioMaximo, 2));
		this.radioMaximo = (int)Math.pow(radioMaximo, 2);
		grabarResultados();
	}

	public void leerLanzamientos() {
		try {
			Scanner sc = new Scanner(new File("input.in"));
			Lanzamiento lanzamiento;
			this.cantLanzamientos = sc.nextInt();
			for (int i = 0; i < this.cantLanzamientos; i++) {
				lanzamiento = new Lanzamiento(sc.nextInt(), sc.nextInt());
				if (lanzamiento.getX() > 0)
					lanzamientosOli.add(lanzamiento);
				else
					lanzamientosContrincante.add(lanzamiento);
			}
			Collections.sort(lanzamientosOli);
			Collections.sort(lanzamientosContrincante);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void grabarResultados() {
		try {
			PrintWriter pw = new PrintWriter(new File("ouput.out"));
			pw.println();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Torneo [lanzamientosOli=" + lanzamientosOli + ", lanzamientoContrincante=" + lanzamientosContrincante
				+ ", cantLanzamientos=" + cantLanzamientos + "]";
	}
	public static void main(String[] args) {
		Torneo t = new Torneo();
		t.determinarRadio();
		System.out.println(t);
	}
}



