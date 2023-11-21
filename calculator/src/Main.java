import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj współczynniki a, b i c funkcji kwadratowej ax^2 + bx + c:");
        System.out.print("a: ");
        double a = scanner.nextDouble()
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        double p = -b / (2 * a);
        double delta = (b * b) - (4 * a *c)
        double q = delta / (4 * a);
        System.out.println("Postać kanoniczna funkcji kwadratowej: f(x) = " + a + "(x - " + p + ")^2 + " + q);
    }
}
