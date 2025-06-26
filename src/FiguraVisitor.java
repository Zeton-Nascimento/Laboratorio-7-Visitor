package Laboratorio7;

public interface FiguraVisitor {
	void visit(Circulo c);
    void visit(Triangulo t);
    void visit(Retangulo r);
    void visit(Trapezio t);
}
