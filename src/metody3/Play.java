package metody3;

import java.util.ArrayList;
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
		ArrayList<Heun> heun = new ArrayList<Heun>();
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
			

			// liczenie eulera
			x = 1;
			y = 1;
			euler.add(new Euler(x, y));
			for (int i = 1; i <= n; i++) {
				y = y + h * liczF(x, y);
				x = 1 + i * h;
				euler.add(new Euler(x, y));
			}

			// liczenie Heuna
			x = 1;
			y = 1;
			heun.add(new Heun(x, y));
			for (int i = 1; i <= n; i++) {
				y = y + h * 0.5
						* (liczF(x, y) + liczF(x + h, y + h * liczF(x, y)));
				x = 1 + i * h;
				heun.add(new Heun(x, y));
			}
			
			drukuj();
			if (n <= 10) {
				for (int i = 0; i <= n; i++) {
					System.out.printf("|%f||%f||   ||%f||%f|\n", euler.get(i)
							.getX(), euler.get(i).getY(), heun.get(i).getX(), heun.get(i).getY());
				}

			} else {
				int wEuler = euler.size() / 10;
				int licznik = 0;
				for (int i = 0; i < 10; i++) {

					System.out.printf("|%f||%f||   ||%f||%f|\n",
							euler.get(licznik).getX(), euler.get(licznik).getY(), heun.get(licznik).getX(), heun.get(licznik).getY());

					licznik = wEuler + licznik;
				}

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
			heun.removeAll(heun);

		} while (wybor == 1);

	}

	public static double liczF(double x, double y) {
		return (2 * Math.pow(y, 2) - 2 * x * (Math.pow(x, 3) - 1));
	}
	public static void drukuj(){
		System.out.println("--------------------");
		System.out.println("        Euler                     Heun");
		System.out.println("|    x   |" + "|    y   ||   ||    x   |" + "|    y   |");
		System.out.println("--------------------");
	}

}
