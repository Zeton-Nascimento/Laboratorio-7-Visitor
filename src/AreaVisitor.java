package Laboratorio7;

public class AreaVisitor implements FiguraVisitor {
    @Override public void visit(Circulo c) { double area = Math.PI * c.getRaio()*c.getRaio(); System.out.println("Área círculo: " + area); }
    @Override public void visit(Triangulo t) { double area = t.getBase()*t.getAltura()/2; System.out.println("Área triângulo: " + area); }
    @Override public void visit(Retangulo r) { double area = r.getLargura()*r.getAltura(); System.out.println("Área retângulo: " + area); }
    @Override public void visit(Trapezio t) { double area = (t.getBaseMaior()+t.getBaseMenor())*t.getAltura()/2; System.out.println("Área trapézio: " + area); }
}