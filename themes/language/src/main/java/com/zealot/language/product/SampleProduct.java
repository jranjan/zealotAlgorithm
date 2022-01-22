package main.java.com.zealot.language.product;

public class SampleProduct {
    private final String name;

    public SampleProduct(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        SampleProduct p = new SampleProduct(("Car"));
        System.out.println(p.getName());
    }
}
