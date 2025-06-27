package laboratorio7.visitors;

import laboratorio7.figuras.*;

public class DesenharVisitor implements FiguraVisitor {
    @Override public void visit(Circulo c) { System.out.println("Desenhando círculo com raio " + c.getRaio()); }
    @Override public void visit(Triangulo t) { System.out.println("Desenhando triângulo com base " + t.getBase() + " e altura " + t.getAltura()); }
    @Override public void visit(Retangulo r) { System.out.println("Desenhando retângulo " + r.getLargura() + " x " + r.getAltura()); }
    @Override public void visit(Trapezio t) { System.out.println("Desenhando trapézio: bases " + t.getBaseMaior() + "/" + t.getBaseMenor() + " altura " + t.getAltura()); }
}
