package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculoIMCTest {

    @Test
    public void testLimitesInferioresDasFaixas() {
        assertEquals("Magreza grave", CalculoIMC.classificarIMC(15.99));
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.0));
        assertEquals("Magreza leve", CalculoIMC.classificarIMC(17.0));
        assertEquals("Saudável", CalculoIMC.classificarIMC(18.5));
        assertEquals("Sobrepeso", CalculoIMC.classificarIMC(25.0));
        assertEquals("Obesidade Grau I", CalculoIMC.classificarIMC(30.0));
        assertEquals("Obesidade Grau II", CalculoIMC.classificarIMC(35.0));
        assertEquals("Obesidade Grau III", CalculoIMC.classificarIMC(40.0));
    }

    @Test
    public void testLimitesSuperioresDasFaixas() {
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.99));
        assertEquals("Magreza leve", CalculoIMC.classificarIMC(18.49));
        assertEquals("Saudável", CalculoIMC.classificarIMC(24.99));
        assertEquals("Sobrepeso", CalculoIMC.classificarIMC(29.99));
        assertEquals("Obesidade Grau I", CalculoIMC.classificarIMC(34.99));
        assertEquals("Obesidade Grau II", CalculoIMC.classificarIMC(39.99));
    }

    @Test
    public void testParticoesValidas() {
        assertEquals("Magreza grave", CalculoIMC.classificarIMC(15.0));
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.5));
        assertEquals("Magreza leve", CalculoIMC.classificarIMC(18.0));
        assertEquals("Saudável", CalculoIMC.classificarIMC(22.0));
        assertEquals("Sobrepeso", CalculoIMC.classificarIMC(27.0));
        assertEquals("Obesidade Grau I", CalculoIMC.classificarIMC(32.0));
        assertEquals("Obesidade Grau II", CalculoIMC.classificarIMC(37.0));
        assertEquals("Obesidade Grau III", CalculoIMC.classificarIMC(45.0));
    }

    @Test
    public void testCalculoIMC() {
        double imc = CalculoIMC.calcularPeso(70.0, 1.75);
        assertEquals(22.86, imc, 0.01);
    }

    @Test
    public void testCalculoIMCComZero() {
        double imc = CalculoIMC.calcularPeso(70.0, 0.0);
        assertEquals(Double.POSITIVE_INFINITY, imc, 0.01);
    }

    @Test
    public void testCalculoIMCComNegativo() {
        double imc = CalculoIMC.calcularPeso(-70.0, 1.75);
        assertEquals(-22.86, imc, 0.01);
    }

    @Test
    public void testCalculoIMCComPesoEAlturaNegativos() {
        double imc = CalculoIMC.calcularPeso(-70.0, -1.75);
        assertEquals(22.86, imc, 0.01); // preciso que retorne resultado negativo (a*a=positivo)
    }

    @Test
    public void testCalculoIMCComZeroEZero() {
        double imc = CalculoIMC.calcularPeso(0.0, 0.0);
        assertEquals(Double.NaN, imc, 0.01);
    }
}
