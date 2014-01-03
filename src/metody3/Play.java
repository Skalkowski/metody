package metody3;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	private static Scanner wczytaj;

	public static void main(String[] args) {
		int n; // przedzial na ile kawalkow podzielic, wieksze niz 0!!
		int wybor = 0;
		double h;
		double y = 1;
		double x;
		ArrayList<Euler> euler = new ArrayList<Euler>();
		ArrayList<Heun> heun = new ArrayList<Heun>();
		ArrayList<Porownywalna> por = new ArrayList<Porownywalna>();
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
				y = Euler.liczY(x, y, h);
				x = liczX(h, i);
				euler.add(new Euler(x, y));
			}

			// liczenie Heuna
			x = 1;
			y = 1;
			heun.add(new Heun(x, y));
			for (int i = 1; i <= n; i++) {
				y = Heun.liczY(x, y, h);
				x = liczX(h, i);
				heun.add(new Heun(x, y));
			}

			// liczenie porownywalnego punktu

			x = 1;
			y = 1;
			por.add(new Porownywalna(x, y));
			for (int i = 1; i <= n; i++) {
				x = liczX(h, i);
				y = Math.pow(x, 2);

				por.add(new Porownywalna(x, y));
			}

			drukuj();
			if (n <= 10) {
				for (int i = 0; i <= n; i++) {
					System.out
							.printf("| %6d|| %10f||   || %10f|| %10f||     || %10f||     || %10f||\n",
									i,
									euler.get(i).getX(),
									euler.get(i).getY(),
									heun.get(i).getY(),
									Math.abs(euler.get(i).getY()
											- por.get(i).getY()),
									Math.abs(heun.get(i).getY()
											- por.get(i).getY()));
				}

			} else {
				int wEuler = euler.size() / 10;
				int licznik = 0;
				for (int i = 0; i < 10; i++) {

					System.out
							.printf("| %6d|| %10f||   || %10f|| %10f||     || %10f||     || %10f||\n",
									licznik, euler.get(licznik).getX(), euler
											.get(licznik).getY(),
									heun.get(licznik).getY(), Math.abs(euler
											.get(licznik).getY()
											- por.get(licznik).getY()), Math
											.abs(heun.get(licznik).getY()
													- por.get(licznik).getY()));

					licznik = wEuler + licznik;
				}

			}

			// Menu
			System.out
					.println("\n\n\nMenu:\n1)Ja chce jeszcze raz!!\n2)Koniec programu\nTwoj wybor: ");
			wybor = wczytaj.nextInt();
			while (wybor < 1 || wybor > 2) {
				System.out.println("nie ma takiej opcji, sprobuj jeszcze raz");
				wybor = wczytaj.nextInt();
			}
			euler.removeAll(euler);
			heun.removeAll(heun);
			por.removeAll(por);

		} while (wybor == 1);

	}

	public static double liczF(double x, double y) {
		return (2 * Math.pow(y, 2) - 2 * x * (Math.pow(x, 3) - 1));
	}

	public static double liczX(double h, int i) {
		return 1 + i * h;
	}

	public static void drukuj() {
		System.out
				.println("-----------------------------------------------------------------------------------------------");
		System.out
				.println("                               Euler         Heun               Euler                Heun  ");
		System.out
				.println("|   k   ||     x     ||   ||     y     ||     y     ||     ||blad metody||     ||blad metody||");
		System.out
				.println("-----------------------------------------------------------------------------------------------");
	}

}
