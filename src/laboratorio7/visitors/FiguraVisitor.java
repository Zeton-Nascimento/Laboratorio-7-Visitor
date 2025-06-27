package laboratorio7.visitors;

import laboratorio7.figuras.*;

public interface FiguraVisitor {
	void visit(Circulo c);
    void visit(Triangulo t);
    void visit(Retangulo r);
    void visit(Trapezio t);
}
