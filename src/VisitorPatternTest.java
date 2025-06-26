package Laboratorio7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class VisitorPatternTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testAreaVisitor() {
        FiguraVisitor visitor = new AreaVisitor();
        Circulo circulo = new Circulo(1.0);
        Retangulo retangulo = new Retangulo(2.0, 3.0);
        Trapezio trapezio = new Trapezio(4.0, 2.0, 5.0);
        // Novo construtor do Triangulo com lados
        Triangulo triangulo = new Triangulo(3.0, 4.0, 3.0, 4.0, 5.0);

        circulo.accept(visitor);
        retangulo.accept(visitor);
        trapezio.accept(visitor);
        triangulo.accept(visitor);

        String output = outContent.toString().trim();
        String[] lines = output.split("\\r?\\n");
        assertEquals(4, lines.length, "Deve haver quatro linhas de saída para cada figura");

        assertTrue(lines[0].startsWith("Área círculo:"), "Saída deve começar com 'Área círculo:'");
        double circleArea = Double.parseDouble(lines[0].split(":")[1].trim());
        assertEquals(Math.PI * 1.0, circleArea, 1e-6);

        assertTrue(lines[1].startsWith("Área retângulo:"));
        double rectArea = Double.parseDouble(lines[1].split(":")[1].trim());
        assertEquals(2.0 * 3.0, rectArea, 1e-6);

        assertTrue(lines[2].startsWith("Área trapézio:"));
        double trapArea = Double.parseDouble(lines[2].split(":")[1].trim());
        assertEquals((4.0 + 2.0) * 5.0 / 2.0, trapArea, 1e-6);

        assertTrue(lines[3].startsWith("Área triângulo:"));
        double triArea = Double.parseDouble(lines[3].split(":")[1].trim());
        assertEquals(3.0 * 4.0 / 2.0, triArea, 1e-6);
    }

    @Test
    public void testDesenharVisitor() {
        FiguraVisitor visitor = new DesenharVisitor();
        Circulo circulo = new Circulo(2.5);
        Retangulo retangulo = new Retangulo(3.0, 4.0);
        Trapezio trapezio = new Trapezio(5.0, 2.0, 3.0);
        Triangulo triangulo = new Triangulo(6.0, 7.0, 6.0, 7.0, 8.0);

        circulo.accept(visitor);
        retangulo.accept(visitor);
        trapezio.accept(visitor);
        triangulo.accept(visitor);

        String output = outContent.toString().trim();
        String[] lines = output.split("\\r?\\n");
        assertEquals(4, lines.length);

        assertEquals("Desenhando círculo com raio 2.5", lines[0]);
        assertEquals("Desenhando retângulo 3.0 x 4.0", lines[1]);
        assertEquals("Desenhando trapézio: bases 5.0/2.0 altura 3.0", lines[2]);
        assertEquals("Desenhando triângulo com base 6.0 e altura 7.0", lines[3]);
    }

    @Test
    public void testMaximizeVisitor() {
        FiguraVisitor visitor = new MaximizeVisitor();
        Circulo circulo = new Circulo(1.5);
        Retangulo retangulo = new Retangulo(2.0, 3.0);
        Trapezio trapezio = new Trapezio(4.0, 2.0, 5.0);
        Triangulo triangulo = new Triangulo(3.0, 4.0, 3.0, 4.0, 5.0);

        circulo.accept(visitor);
        assertEquals(1.5 * 2, circulo.getRaio(), 1e-6);
        String out1 = outContent.toString().split("\\r?\\n")[0];
        assertEquals("Maximizou círculo para raio " + circulo.getRaio(), out1);

        outContent.reset();
        retangulo.accept(visitor);
        assertEquals(4.0, retangulo.getLargura(), 1e-6);
        assertEquals(6.0, retangulo.getAltura(), 1e-6);
        String out2 = outContent.toString().trim();
        assertEquals("Maximizou retângulo para 4.0 x 6.0", out2);

        outContent.reset();
        trapezio.accept(visitor);
        assertEquals(8.0, trapezio.getBaseMaior(), 1e-6);
        assertEquals(4.0, trapezio.getBaseMenor(), 1e-6);
        assertEquals(10.0, trapezio.getAltura(), 1e-6);
        String out3 = outContent.toString().trim();
        assertEquals("Maximizou trapézio para bases 8.0/4.0 altura 10.0", out3);

        outContent.reset();
        triangulo.accept(visitor);
        assertEquals(6.0, triangulo.getBase(), 1e-6);
        assertEquals(8.0, triangulo.getAltura(), 1e-6);
        String out4 = outContent.toString().trim();
        assertEquals("Maximizou triângulo para base 6.0 e altura 8.0", out4);
    }
}
