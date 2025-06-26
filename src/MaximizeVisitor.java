package Laboratorio7;

public class MaximizeVisitor implements FiguraVisitor {
    @Override public void visit(Circulo c) { c.setRaio(c.getRaio()*2); System.out.println("Maximizou círculo para raio " + c.getRaio()); }
    @Override public void visit(Triangulo t) {
        t.setBase(t.getBase()*2); t.setAltura(t.getAltura()*2);
        System.out.println("Maximizou triângulo para base " + t.getBase() + " e altura " + t.getAltura()); }
    @Override public void visit(Retangulo r) {
        r.setLargura(r.getLargura()*2); r.setAltura(r.getAltura()*2);
        System.out.println("Maximizou retângulo para " + r.getLargura() + " x " + r.getAltura()); }
    @Override public void visit(Trapezio t) {
        t.setBaseMaior(t.getBaseMaior()*2); t.setBaseMenor(t.getBaseMenor()*2); t.setAltura(t.getAltura()*2);
        System.out.println("Maximizou trapézio para bases " + t.getBaseMaior() + "/" + t.getBaseMenor() + " altura " + t.getAltura()); }
}
