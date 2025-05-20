package org.ambiguity;

public class Sum {
    private int num1;
    private int num2;

    public Sum() {
        super();
    }

    public Sum(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        System.out.println("Sum Constructor: Integer");
    }

    public Sum(String num1, String num2) {
        this.num1 = Integer.parseInt(num1);
        this.num2 = Integer.parseInt(num2);
        System.out.println("Sum Constructor: String");
    }

    public int getSum() {
        return num1 + num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Sum{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                " }";
    }
}
