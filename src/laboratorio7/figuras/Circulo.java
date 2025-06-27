package laboratorio7.figuras;

import laboratorio7.visitors.FiguraVisitor;

public class Circulo implements FiguraGeometrica {
    private double raio;
    public Circulo(double raio) { this.raio = raio; }
    public double getRaio() { return raio; }
    public void setRaio(double raio) { this.raio = raio; }
    @Override
    public void accept(FiguraVisitor visitor) { 
    	visitor.visit(this); 
    	}
}