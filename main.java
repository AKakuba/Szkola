package punkty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner odczyt = new Scanner(new File("plik.txt"));
		odczyt.useDelimiter(",|\n");

		Punkt_1D[] lista_1D = new Punkt_1D[0];
		Punkt_2D[] lista_2D = new Punkt_2D[0];
		Punkt_3D[] lista_3D = new Punkt_3D[0];

		while (odczyt.hasNext()) {
		
			if (Integer.parseInt(odczyt.next()) == 1) {
			
				int x = odczyt.nextInt();
				Punkt_1D nowyPunkt_1D = new Punkt_1D(x);
				lista_1D = dodajPunkt_1D(lista_1D, nowyPunkt_1D);
			}
			if (Integer.parseInt(odczyt.next()) == 2) {
				
				int x = odczyt.nextInt();
				int y = odczyt.nextInt();
				Punkt_2D nowyPunkt_2D = new Punkt_2D(x,y);
				lista_2D = dodajPunkt_2D(lista_2D, nowyPunkt_2D);
			}
			if (Integer.parseInt(odczyt.next()) == 3) {
				
				int x = odczyt.nextInt();
				int y = odczyt.nextInt();
				int z = odczyt.nextInt();
				Punkt_3D nowyPunkt_3D = new Punkt_3D(x,y,z);
				lista_3D = dodajPunkt_3D(lista_3D, nowyPunkt_3D);
			}
		}
		
		System.out.format("Wartosc x punktu 1D: %d\n", lista_1D[0].x);
		System.out.format("Wartosc x,y punktu 2D: %d, %d\n", lista_2D[0].x, lista_2D[0].y);
		System.out.format("Wartosc x,y,z punktu 3D: %d, %d, %d\n", lista_3D[0].x, lista_3D[0].y, lista_3D[0].z);
		
		sortPoints(lista_1D[0], lista_2D[0], lista_3D[0]);
	}

	private static Punkt_1D[] dodajPunkt_1D(Punkt_1D[] lista_1D, Punkt_1D PunktdoDodania) {
		Punkt_1D[] nowyPkt = new Punkt_1D[lista_1D.length + 1];
		System.arraycopy(lista_1D, 0, nowyPkt, 0, lista_1D.length);
		nowyPkt[nowyPkt.length - 1] = PunktdoDodania;

		return nowyPkt;
	}
	
	private static Punkt_2D[] dodajPunkt_2D(Punkt_2D[] lista_2D, Punkt_2D PunktdoDodania) {
		Punkt_2D[] nowyPkt = new Punkt_2D[lista_2D.length + 1];
		System.arraycopy(lista_2D, 0, nowyPkt, 0, lista_2D.length);
		nowyPkt[nowyPkt.length - 1] =PunktdoDodania;

		return nowyPkt;
	}
	
	private static Punkt_3D[] dodajPunkt_3D(Punkt_3D[] lista_3D, Punkt_3D PunktdoDodania) {
		Punkt_3D[] nowyPkt = new Punkt_3D[lista_3D.length + 1];
		System.arraycopy(lista_3D, 0, nowyPkt, 0, lista_3D.length);
		nowyPkt[nowyPkt.length - 1] = PunktdoDodania;

		return nowyPkt;
	}

	private static void sortPoints(Punkt_1D jeden, Punkt_2D dwa, Punkt_3D trzy) {

		double odleglosc1D = jeden.x;
		double odleglosc2D = Math.sqrt(dwa.x*dwa.x+dwa.y*dwa.y);
		double xz = Math.sqrt(trzy.x*trzy.x+trzy.z*trzy.z);
		double odleglosc3D = Math.sqrt(xz*xz+trzy.y*trzy.y);		
		
		double [] arr = {odleglosc1D, odleglosc2D, odleglosc3D};
		Arrays.sort(arr);
		
		if (arr[0] == odleglosc1D && arr[1] == odleglosc2D && arr[2] == odleglosc3D) {
			System.out.println("Kolejnosc: Punkt1D, Punkt2D, Punkt3D");
		} else if (arr[0] == odleglosc1D && arr[1] == odleglosc3D && arr[2] == odleglosc2D) {
			System.out.println("Kolejnosc: Punkt1D, Punkt3D, Punkt2D");
		}else if (arr[0] == odleglosc2D && arr[1] == odleglosc1D && arr[2] == odleglosc3D) {
			System.out.println("Kolejnosc: Punkt2D, Punkt1D, Punkt3D");
		}else if (arr[0] == odleglosc2D && arr[1] == odleglosc3D && arr[2] == odleglosc1D) {
			System.out.println("Kolejnosc: Punkt2D, Punkt3D, Punkt1D");
		}else if (arr[0] == odleglosc3D && arr[1] == odleglosc1D && arr[2] == odleglosc2D) {
			System.out.println("Kolejnosc: Punkt3D, Punkt1D, Punkt2D");
		}else if (arr[0] == odleglosc3D && arr[1] == odleglosc2D && arr[2] == odleglosc1D) {
			System.out.println("Kolejnosc: Punkt3D, Punkt2D, Punkt1D");
		}

	}
}
