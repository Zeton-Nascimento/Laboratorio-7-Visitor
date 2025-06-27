package laboratorio7.figuras;

import laboratorio7.visitors.FiguraVisitor;

public class Retangulo implements FiguraGeometrica {
    private double largura, altura;
    public Retangulo(double largura, double altura) {
        this.largura = largura; this.altura = altura;
    }
    public double getLargura() { return largura; }
    public double getAltura() { return altura; }
    public void setLargura(double w) { this.largura = w; }
    public void setAltura(double h) { this.altura = h; }
    @Override
    public void accept(FiguraVisitor visitor) { visitor.visit(this); }
}