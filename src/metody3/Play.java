package metody3;

import java.util.Scanner;

public class Play {
	private static Scanner wczytaj;

	public static void main(String[] args) {
		int n = 0; // przedzial na ile kawalkow podzielic, wieksze niz 0!!
		int wybor = 0;
		double h = 0;
		double y = 1; // y0 w Eulerze
		double x = 0;

		wczytaj = new Scanner(System.in);
		do {
			// Poczatek programu
			System.out.println("Podaj n: ");
			n = wczytaj.nextInt();
			while (n <= 0) {
				System.out.println("zle podane n, sprobuj jeszcze raz: ");
				n = wczytaj.nextInt();
			}
			
			euler(h, n, y, x);

			// Menu
			System.out
					.println("\n\n\nMenu:\n1)Ja chce jeszcze raz!!\n2)Koniec programu");
			wybor = wczytaj.nextInt();
			while (wybor < 1 || wybor > 2) {
				System.out.println("nie ma takiej opcji, sprobuj jeszcze raz");
				wybor = wczytaj.nextInt();
			}
		} while (wybor == 1);

	}
	public static void euler(double h, double n, double y, double x){
		h = (2 - 1) / (double) n;

		y = 1;
		System.out.println("--------------------");
		System.out.println("|    x   |" + "|    y   |");
		System.out.println("--------------------");
		for (int i = 0; i <= n; i++) {
			x = 1 + i * h;
			y = y + h * (2 * Math.pow(y, 2) - 2 * x * (Math.pow(x, 3) - 1));
			System.out.printf("|%f||%f|\n", x, y);

		}
	}
}
