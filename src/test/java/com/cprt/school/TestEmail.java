package com.cprt.school;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestEmail {

    @Test
    void  cannotCreateInvalidAddressEmail(){
        assertThrows(IllegalArgumentException.class, () -> new Email("invalid-email"));
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }

    @Test
    void  canCreateValidAddressEmail(){
        assertDoesNotThrow(() -> new Email("valid.email@email.com"));
        assertDoesNotThrow(() -> new Email("valid_email@email.com"));
        assertDoesNotThrow(() -> new Email("valid_email@email.com"));
    }
    
}
