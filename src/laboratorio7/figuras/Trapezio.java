package laboratorio7.figuras;

import laboratorio7.visitors.FiguraVisitor;

public class Trapezio implements FiguraGeometrica {
    private double baseMaior, baseMenor, altura;
    public Trapezio(double maior, double menor, double altura) {
        this.baseMaior = maior; this.baseMenor = menor; this.altura = altura;
    }
    public double getBaseMaior() { return baseMaior; }
    public double getBaseMenor() { return baseMenor; }
    public double getAltura() { return altura; }
    public void setBaseMaior(double b) { this.baseMaior = b; }
    public void setBaseMenor(double b) { this.baseMenor = b; }
    public void setAltura(double h) { this.altura = h; }
    @Override
    public void accept(FiguraVisitor visitor) { visitor.visit(this); }
}