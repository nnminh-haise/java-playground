package ICPC.PTIT;

import java.util.ArrayList;
import java.util.Scanner;

class Bignum implements Comparable<Bignum> {
    private ArrayList<Integer> reversedDigits;
    private String value = "";
    private boolean positive = true;

    public Bignum() {
        this.value = "";
        this.positive = true;
        this.reversedDigits = new ArrayList<>();
    }

    public Bignum(String value) {
        this.value = value;
        this.reversedDigits = new ArrayList<>();
        if (value.charAt(0) == '-') {
            this.positive = false;
            for (int i = value.length() - 1; i >= 1; --i) {
                this.reversedDigits.add(value.charAt(i) - '0');
            }
        }
        else {
            this.positive = true;
            for (int i = value.length() - 1; i >= 0; --i) {
                this.reversedDigits.add(value.charAt(i) - '0');
            }
        }
    }

    public void negate() {
        this.positive = !this.positive;
    }

    @Override
    public int compareTo(Bignum other) {
        if (this.reversedDigits.size() > other.reversedDigits.size()) {
            return 1;
        }
        else if (this.reversedDigits.size() < other.reversedDigits.size()) {
            return -1;
        }

        for (int i = this.reversedDigits.size() - 1; i >= 0; --i) {
            if (this.reversedDigits.get(i) > other.reversedDigits.get(i)) {
                return 1;
            }
            else if (this.reversedDigits.get(i) < other.reversedDigits.get(i)) {
                return -1;
            }
        }

        return 0;
    }

    public Bignum add(Bignum second) {
        if (!this.positive && !second.positive) {
            this.negate();
            second.negate();
            Bignum result = this.add(second);
            result.negate();
            this.negate();
            second.negate();
            return result;
        }
        else if (!this.positive) {
            this.negate();
            Bignum result = second.subtract(this);
            this.negate();
            return result;
        }
        else if (!second.positive) {
            second.negate();
            Bignum result = this.subtract(second);
            second.negate();
            return result;
        }

        Bignum result = new Bignum();
        int minDigitLength = Math.min(this.reversedDigits.size(), second.reversedDigits.size());
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < minDigitLength; ++i) {
            sum = this.reversedDigits.get(i) + second.reversedDigits.get(i) + carry;
            result.reversedDigits.add(sum % 10);
            carry = sum / 10;
        }

        if (this.reversedDigits.size() > minDigitLength) {
            for (int i = minDigitLength; i < this.reversedDigits.size(); ++i) {
                sum = this.reversedDigits.get(i) + carry;
                result.reversedDigits.add(sum % 10);
                carry = sum / 10;
            }
        }

        if (second.reversedDigits.size() > minDigitLength) {
            for (int i = minDigitLength; i < second.reversedDigits.size(); ++i) {
                sum = second.reversedDigits.get(i) + carry;
                result.reversedDigits.add(sum % 10);
                carry = sum / 10;
            }
        }

        if (carry > 0) {
            result.reversedDigits.add(carry);
        }

        return result;
    }

    public Bignum subtract(Bignum second) {
        if (!this.positive && second.positive) {
            this.negate();
            Bignum result = this.add(second);
            result.negate();
            this.negate();
            return result;
        }
        else if (!this.positive) {
            second.negate();
            this.negate();
            Bignum result = second.subtract(this);
            this.negate();
            second.negate();
            return result;
        }
        else if (this.positive && !second.positive) {
            second.negate();
            Bignum result = this.add(second);
            second.negate();
            return result;
        }


        if (this.compareTo(second) == 0) {
            return new Bignum("0");
        }

        if (this.compareTo(second) == -1) {
            Bignum result = second.subtract(this);
            result.negate();
            return result;
        }

        Bignum result = new Bignum();
        int carry = 0;
        int minDigitLength = Math.min(this.reversedDigits.size(), second.reversedDigits.size());
        int sub;
        int a, b;
        for (int i = 0; i < minDigitLength; ++i) {
            a = this.reversedDigits.get(i);
            b = second.reversedDigits.get(i);
            if (a + carry >= b) {
                sub = a + carry - b;
                carry = 0;
            }
            else {
                sub = 10 + a + carry - b;
                carry = 1;
            }
            result.reversedDigits.add(sub);
        }

        if (this.reversedDigits.size() > minDigitLength) {
            for (int i = minDigitLength; i < this.reversedDigits.size(); ++i) {
                a = this.reversedDigits.get(i);
                if (a >= carry) {
                    sub = a - carry;
                    carry = 0;
                }
                else {
                    sub = 10 + a - carry;
                    carry = 1;
                }
                result.reversedDigits.add(sub);
            }
        }

        if (second.reversedDigits.size() > minDigitLength) {
            for (int i = minDigitLength; i < second.reversedDigits.size(); ++i) {
                b = second.reversedDigits.get(i);
                if (b >= carry) {
                    sub = b - carry;
                    carry = 0;
                }
                else {
                    sub = 10 + b - carry;
                    carry = 1;
                }
                result.reversedDigits.add(sub);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (!this.positive) {
            result.append('-');
        }
        for (int i = this.reversedDigits.size() - 1; i >= 0 && this.reversedDigits.size() > 1; --i) {
            if (this.reversedDigits.get(i) == 0) {
                this.reversedDigits.remove(i);
            }
            else {
                break;
            }
        }
        for (int i = this.reversedDigits.size() - 1; i >= 0; --i) {
            result.append(this.reversedDigits.get(i).toString());
        }
        this.value = result.toString();
        return this.value;
    }
}

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bignum a = new Bignum(scanner.next());
        Bignum b = new Bignum(scanner.next());
        Bignum c = a.add(b);
        System.out.println(c);
        scanner.close();
    }
}
