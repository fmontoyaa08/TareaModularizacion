import java.util.Scanner;

public class Modularizacion {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {
            System.out.print("\n1.Calc 2.Pass 3.Primo 4.SumaPares 5.Temp 6.Vocal 7.Fact 8.Game 9.Ref 10.Tabla 0.Salir\nOpción: ");
            op = leerInt("");

            switch (op) {
                case 1: calculadora(); break;
                case 2: String p; do{System.out.print("Pass (1234): "); p=sc.nextLine();}while(!p.equals("1234")); break;
                case 3: System.out.println("Es primo: "+esPrimo(leerInt("Número: "))); break;
                case 4: sumaPares(); break;
                case 5: double t=leerDouble("Celsius: "); System.out.println("Fahrenheit: "+(t*9/5+32)); break;
                case 6: contadorVocales(); break;
                case 7: factorial(); break;
                case 8: adivinanza(); break;
                case 9: pasoReferencia(); break;
                case 10: tabla(); break;
            }
        } while (op != 0);
    }

    static int leerInt(String m){
        try{System.out.print(m); return Integer.parseInt(sc.nextLine());}
        catch(Exception e){System.out.println("Error! Solo números."); return leerInt(m);}
    }

    static double leerDouble(String m){
        try{System.out.print(m); return Double.parseDouble(sc.nextLine());}
        catch(Exception e){System.out.println("Error! Solo números."); return leerDouble(m);}
    }

    static void calculadora(){
        double a=leerDouble("n1: "), b=leerDouble("n2: ");
        int op=leerInt("1.Suma 2.Resta 3.Mult 4.Div: ");
        if(op==4&&b==0){System.out.println("Error división 0"); return;}
        if(op==1)System.out.println("Resultado: "+(a+b));
        else if(op==2)System.out.println("Resultado: "+(a-b));
        else if(op==3)System.out.println("Resultado: "+(a*b));
        else if(op==4)System.out.println("Resultado: "+(a/b));
        else System.out.println("Opción inválida");
    }

    static boolean esPrimo(int n){
        if(n<2)return false;
        for(int i=2;i<=Math.sqrt(n);i++) if(n%i==0)return false;
        return true;
    }

    static void sumaPares(){
        int n,s=0;
        while((n=leerInt("Número (0 salir): "))!=0) if(n%2==0)s+=n;
        System.out.println("Suma pares: "+s);
    }

    static void contadorVocales(){
        System.out.print("Texto: ");
        String t=sc.nextLine().toLowerCase();
        int c=0;
        for(int i=0;i<t.length();i++) if("aeiou".indexOf(t.charAt(i))!=-1)c++;
        System.out.println("Vocales: "+c);
    }

    static void factorial(){
        int n=leerInt("Número: "),f=1;
        for(int i=1;i<=n;i++)f*=i;
        System.out.println("Factorial: "+f);
    }

    static void adivinanza(){
        int r=(int)(Math.random()*100)+1,i;
        do{
            i=leerInt("Adivina (1-100): ");
            if(i<r)System.out.println("Mayor >");
            else if(i>r)System.out.println("Menor <");
        }while(i!=r);
        System.out.println("¡Ganaste!");
    }

    static void pasoReferencia(){
        int a=leerInt("A: "), b=leerInt("B: ");
        int t=a; a=b; b=t;
        System.out.println("Intercambio: A="+a+" B="+b);
    }

    static void tabla(){
        int n=leerInt("Tabla: ");
        for(int i=1;i<=10;i++) System.out.println(n+" x "+i+" = "+(n*i));
    }
}