package Laboratorio7;

public class Triangulo implements FiguraGeometrica {
    private double base, altura, ladoA, ladoB, ladoC;
    public Triangulo(double base, double altura, double a, double b, double c) {
        this.base = base; this.altura = altura;
        this.ladoA = a; this.ladoB = b; this.ladoC = c;
    }
    public double getBase() { return base; }
    public double getAltura() { return altura; }
    public double getLadoA() { return ladoA; }
    public double getLadoB() { return ladoB; }
    public double getLadoC() { return ladoC; }
    public void setBase(double b) { this.base = b; }
    public void setAltura(double h) { this.altura = h; }
    @Override
    public void accept(FiguraVisitor visitor) { visitor.visit(this); }
}