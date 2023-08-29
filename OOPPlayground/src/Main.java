class Fraction {
    private double numerator;
    private double denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(double numerator, double denominator) {
        if (denominator == 0.0) {
            throw new ArithmeticException("Denominator cannot be 0!");
        }
        else {
            double gcd = this.GCD(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

    }

    public double getNumerator() {
        return numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    public Fraction add(Fraction b) {
        return new Fraction(
                this.numerator * b.getDenominator() + b.getNumerator() * this.denominator, this.denominator * b.getDenominator()
        ).reduce();
    }

    public Fraction subtract(Fraction b) {
        return new Fraction(
                this.numerator * b.getDenominator() - b.getNumerator() * this.denominator, this.denominator * b.getDenominator()
        ).reduce();
    }

    public Fraction multiply(Fraction b) {
        return new Fraction(
                this.numerator * b.getNumerator(), this.denominator * b.getDenominator()
        ).reduce();
    }

    public Fraction divide(Fraction b) {
        return new Fraction(
                this.numerator * b.getDenominator(), this.denominator * b.getNumerator()
        ).reduce();
    }

    private double GCD(double a, double b) {
        if (b > 0) {
            return GCD(b, a % b);
        }
        else {
            return a;
        }
    }

    private Fraction reduce() {
        double gcd = this.GCD(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return new Fraction(this.numerator, this.denominator);
    }

    @Override
    public String toString() {
        if (this.numerator == 0.0) {
            return "0.0";
        }
        else {
            return this.numerator + "/" + this.denominator;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            Fraction a = new Fraction(3, 4);
            Fraction b = new Fraction(6, 8);

            Fraction summation = a.add(b);
            Fraction subtraction = a.subtract(b);
            Fraction multiplication = a.multiply(b);
            Fraction division = a.divide(b);

            System.out.println("Fraction a: " + a);
            System.out.println("Fraction b: " + b);
            System.out.println("a + b = " + summation);
            System.out.println("a - b = " + subtraction);
            System.out.println("a * b = " + multiplication);
            System.out.println("a / b = " + division);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}