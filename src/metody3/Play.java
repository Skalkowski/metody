package metody3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Play {
	private static Scanner wczytaj;

	public static void main(String[] args) {
		int n; // przedzial na ile kawalkow podzielic, wieksze niz 0!!
		int wybor = 0;
		double h;
		double y = 1; // y0 w Eulerze
		double x;
		ArrayList<Euler> euler = new ArrayList<Euler>();
		wczytaj = new Scanner(System.in);
		do {
			// Poczatek programu
			System.out.println("Podaj n: ");
			n = wczytaj.nextInt();
			while (n <= 0) {
				System.out.println("zle podane n, sprobuj jeszcze raz: ");
				n = wczytaj.nextInt();
			}

			h = (2 - 1) / (double) n;

			y = 1;
			System.out.println("--------------------");
			System.out.println("|    x   |" + "|    y   |");
			System.out.println("--------------------");
			for (int i = 0; i <= n; i++) {
				x = 1 + i * h;
				y = y + h * (2 * Math.pow(y, 2) - 2 * x * (Math.pow(x, 3) - 1));
				euler.add(new Euler(x,y));
				 

			}
			for (Euler e : euler){
				System.out.printf("|%f||%f|\n", e.getX(), e.getY());
			}

			// Menu
			System.out
					.println("Menu:\n1)Ja chce jeszcze raz!!\n2)Koniec programu");
			wybor = wczytaj.nextInt();
			while (wybor < 1 || wybor > 2) {
				System.out.println("nie ma takiej opcji, sprobuj jeszcze raz");
				wybor = wczytaj.nextInt();
			}
			euler.removeAll(euler);
			
		} while (wybor == 1);

	}

}
