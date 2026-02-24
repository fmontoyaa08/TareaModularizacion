
import java.util.Scanner;

public class Modularizacion {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {
            System.out.print("\n--- SISTEMA MODULAR ---\n1.Calc 2.Pass 3.Primo 4.SumaPares 5.Temp 6.Vocal 7.Fact 8.Game 9.Ref 10.Tabla 0.Salir\nOpción: ");
            op = leerint(""); 
            switch (op) {
                case 1 -> calculadora();
                case 2 -> { String p; do { System.out.print("Pass (1234): "); p = sc.nextLine(); } while(!p.equals("1234")); }
                case 3 -> System.out.println("Es primo: " + esPrimo(leerint("Número: ")));
                case 4 -> sumaPares();
                case 5 -> { double t = leerint("Celsius: "); System.out.println("Farenheit: " + (t * 9 / 5 + 32)); }
                case 6 -> contadorVocales();
                case 7 -> factorial();
                case 8 -> adivinanza();
                case 9 -> pasoReferencia();
                case 10 -> tabla();
            }
        } while (op != 0);
    }

  
    static int leerint(String m) {
        try { 
            System.out.print(m); 
            return Integer.parseInt(sc.nextLine()); 
        } catch (Exception e) { 
            System.out.println("¡Error! Solo números."); 
            return leerint(m); 
        }
    }

    static void calculadora() {
        double a = leerint("n1: "), b = leerint("n2: ");
        System.out.println("Suma: " + (a + b) + " Resta: " + (a - b));
    }

    static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    static void sumaPares() {
        int n, s = 0;
        while ((n = leerint("Num (0 salir): ")) != 0) {
            if (n % 2 == 0) s += n;
        }
        System.out.println("Suma pares: " + s);
    }

    static void contadorVocales() {
        System.out.print("Texto: "); 
        String t = sc.nextLine().toLowerCase();
        long c = t.chars().filter(ch -> "aeiou".indexOf(ch) != -1).count();
        System.out.println("Vocales: " + c);
    }

    static void factorial() {
        int n = leerint("Número: ");
        long f = 1; for (int i = 1; i <= n; i++) f *= i;
        System.out.println("Factorial: " + f);
    }

    static void adivinanza() {
        int r = (int)(Math.random() * 100) + 1, i;
        do { 
            i = leerint("Adivina (1-100): "); 
            if (i < r) System.out.println("Es mayor >"); 
            else if (i > r) System.out.println("Es menor <"); 
        } while (i != r);
        System.out.println("¡Ganaste!");
    }

    static void pasoReferencia() {
        int[] n = {leerint("A: "), leerint("B: ")};
        int temp = n[0]; n[0] = n[1]; n[1] = temp;
        System.out.println("Intercambio: A=" + n[0] + " B=" + n[1]);
    }

    static void tabla() {
        int n = leerint("Tabla del: ");
        for (int i = 1; i <= 10; i++) System.out.println(n + " x " + i + " = " + (n * i));
    }
}