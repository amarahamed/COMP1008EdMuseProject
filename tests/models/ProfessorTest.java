package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    Professor professor;
    @BeforeEach
    void setUp ()
    {
        professor = new Professor("John", "Doe", "2 School Lane", LocalDate.of(1976, 10, 2), 10001);
    }

    @Test
    void addTeachable() {
        professor.addTeachable("COMP 1008");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("COMP 1008");
        assertEquals(expResult, professor.getTeachable());
    }

    @Test
    void addTeachableInvalid()
    {
        assertThrows(IllegalArgumentException.class, ()-> {
           professor.addTeachable("cool course");
        });
    }

    @Test
    void addTeachableInvalid2()
    {
        assertThrows(IllegalArgumentException.class, ()-> {
            professor.addTeachable("COMP 123P");
        });
    }
}