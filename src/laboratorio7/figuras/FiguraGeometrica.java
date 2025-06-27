package laboratorio7.figuras;

import laboratorio7.visitors.FiguraVisitor;

public interface FiguraGeometrica {
    void accept(FiguraVisitor visitor);
}
