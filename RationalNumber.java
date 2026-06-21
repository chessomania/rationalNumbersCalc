public class RationalNumber {

    private int numerator;
    private int denominator;

    public RationalNumber (int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }

        this.numerator = numerator;
        this.denominator = denominator;

        normalize();
    }

    private void normalize() {
        if (this.numerator == 0) {
            this.denominator = 1;
            return;
        }
        if (this.numerator == this.denominator) {
            this.numerator = 1;
            this.denominator = 1;
            return;
        }
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
        int max;
        if (this.numerator >= this.denominator)
            max = this.numerator;
        else
            max = this.denominator;
        for (int i = max / 2; i >=2; i--) {
            if (this.numerator % i == 0 && this.denominator % i == 0) {
                this.numerator = this.numerator / i;
                this.denominator = this.denominator / i;
                return;
            }
        }
    }
    public RationalNumber add (RationalNumber other) {
        int num = this.numerator * other.denominator
                + other.numerator * this.denominator;

        int den = this.denominator * other.denominator;

        return new RationalNumber(num, den);
    }

    public RationalNumber subtract (RationalNumber other) {
        int num = this.numerator * other.denominator
                - other.numerator * this.denominator;

        int den = this.denominator * other.denominator;

        return new RationalNumber(num, den);
    }

    public RationalNumber multiply (RationalNumber other) {
        int num = this.numerator * other.numerator;

        int den = this.denominator * other.denominator;

        return new RationalNumber(num, den);
    }

    public RationalNumber divide (RationalNumber other) {
        int num = this.numerator * other.denominator;

        int den = this.denominator * other.numerator;

        return new RationalNumber(num, den);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        RationalNumber other = (RationalNumber) obj;

        return this.numerator == other.numerator
                && this.denominator == other.denominator;
    }
}
