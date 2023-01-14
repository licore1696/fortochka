package Calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesTest {

    @Test
    void CALC() {
        assertEquals("7.0", Proces.CALC("5+2"));
        assertEquals("12.0", Proces.CALC("4*3"));
        assertEquals("3.0", Proces.CALC("6/2"));
        assertEquals("6.0", Proces.CALC("10-4"));
        assertEquals("-10.0", Proces.CALC("0-10"));
    }
}