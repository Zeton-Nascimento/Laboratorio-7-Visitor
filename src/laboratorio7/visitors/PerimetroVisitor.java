package laboratorio7.visitors;

import laboratorio7.figuras.*;

public class PerimetroVisitor implements FiguraVisitor {
    @Override public void visit(Circulo c) { double p = 2*Math.PI*c.getRaio(); System.out.println("Perímetro círculo: " + p); }
    @Override public void visit(Triangulo t) { double p = t.getLadoA()+t.getLadoB()+t.getLadoC(); System.out.println("Perímetro triângulo: " + p); }
    @Override public void visit(Retangulo r) { double p = 2*(r.getLargura()+r.getAltura()); System.out.println("Perímetro retângulo: " + p); }
    @Override public void visit(Trapezio t) {
        // assumir lados iguais às bases e altura para simplificação
        double ladoObliquo = Math.hypot((t.getBaseMaior()-t.getBaseMenor())/2, t.getAltura());
        double p = t.getBaseMaior()+t.getBaseMenor()+2*ladoObliquo;
        System.out.println("Perímetro trapézio: " + p);
    }
}