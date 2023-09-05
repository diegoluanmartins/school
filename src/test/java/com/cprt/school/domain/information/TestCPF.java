package com.cprt.school.domain.information;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestCPF {

    @Test
    void  cannotCreateInvalidAddressEmail(){
        assertThrows(IllegalArgumentException.class, () -> new CPF("1234567890"));
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
    }

    @Test
    void  canCreateValidAddressEmail(){
        assertDoesNotThrow(() -> new CPF("12345678909"));
        assertDoesNotThrow(() -> new CPF("123456789-09"));
        assertDoesNotThrow(() -> new CPF("123.456.789-09"));
    }
    
}
