package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Fred","William","3 Bedrock Lane", LocalDate.of(1989,02,02));
    }

    @Test
    void setFirstName() {
        person.setFirstName("Amar");
        assertEquals("Amar", person.getFirstName());
    }

    @Test
    void setFirstNameInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                person.setFirstName(""));
    }

    @Test
    void setFirstNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                person.setFirstName("54Yeah"));
    }

    @Test
    void setLastName() {
        person.setLastName("Ahamed");
        assertEquals("Ahamed", person.getLastName());
    }

    @Test
    void setLastNameInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                person.setLastName(""));
    }

    @Test
    void setLastNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                person.setLastName("54Yeah"));
    }

    @Test
    void setAddress() {
        person.setAddress("123 Happy St, Barrie, ON");
        assertEquals("123 Happy St, Barrie, ON", person.getAddress());
    }

    @Test
    void setInvalidAddressEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                person.setAddress("    "));
    }

    @Test
    void setBirthday() {
        person.setBirthday(LocalDate.of(1975,01,29));
        assertEquals(LocalDate.of(1975,01,29), person.getBirthday());
    }

    @Test
    void setInvalidBirthdayFuture() {
        assertThrows(IllegalArgumentException.class, ()->
                person.setBirthday(LocalDate.of(2025,01,01)));
    }

    @Test
    void getAge() {
        assertEquals(32, person.getAge());
    }

}