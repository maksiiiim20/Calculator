import java.util.Scanner;
public class KanonicznaPostacKwadratowej {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = collect_Input("a", scanner);
        double b = collect_Input("b", scanner);
        double c = collect_Input("c", scanner);
        double p = calculate_P(a, b);
        double q = calculate_Q(a, b, c);
        System.out.println("Postać kanoniczna funkcji kwadratowej: f(x) = " + a + "(x - " + p + ")^2 + " + q);
    }
    private static double collect_Input(String nazwa, Scanner scanner) {
        System.out.print(nazwa + ": ");
        return scanner.nextDouble();
    }
    private static double calculate_P(double a, double b) {
        return -b / (2 * a);
    }
    private static double calculate_Q(double a, double b, double c) {
        return (4 * a * c - b * b) / (4 * a);
    }
}
