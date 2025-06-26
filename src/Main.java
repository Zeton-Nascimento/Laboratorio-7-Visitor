package Laboratorio7;

public class Main {
    public static void main(String[] args) {
        FiguraGeometrica[] figuras = {
            new Circulo(5), new Triangulo(3,4,3,4,5),
            new Retangulo(2,6), new Trapezio(5,3,4)
        };
        FiguraVisitor[] visitors = {
            new DesenharVisitor(), new AreaVisitor(),
            new PerimetroVisitor(), new MaximizeVisitor()
        };
        for (FiguraVisitor v : visitors) {
            System.out.println("--- Executando visitor: " + v.getClass().getSimpleName() + " ---");
            for (FiguraGeometrica f : figuras) {
                f.accept(v);
            }
            System.out.println();
        }
    }
}