package com.cprt.school.domain.information;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestPhoneNumber {

    @Test
    void cannotCreateInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("666", "1234567"));
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("666", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("6", "1234567"));
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("6", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber(null, "12345678"));
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("66", null));
    }

    @Test
    void canCreateValidPhoneNumber() {
        assertDoesNotThrow(() -> new PhoneNumber("66", "12345678"));
        assertDoesNotThrow(() -> new PhoneNumber("66", "123456789"));
    }

}
