package com.DivineInspiration;

import com.DivineInspiration.experimenter.IdGen;

import org.junit.Test;
import static org.junit.Assert.*;
public class TestIdGen {
    @Test
    public void baseConversion(){
        long l = 1679616L;
        assertEquals("10000", IdGen.base10To36(l));
        assertEquals(1679616L, IdGen.base36To10(IdGen.base10To36(l)));
    }
    @Test
    public void testId(){
        //TODO not sure how to test this.
    }
}
