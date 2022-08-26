package homework3grupo1.repository;

import homework3grupo1.models.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactTest {

    @Test
    @DisplayName("Should throw RTex if ids from diff contacts are equal.")
    void ContactValuesTest() throws RuntimeException{
        Contact c1 = new Contact();
        c1.setName("Pedro");
        c1.setPhoneNumber(654765324);
        c1.setEmail("pedro@arenabsrpg.org");
        c1.setCompanyName("GladiaWizards");

        Contact c2 = new Contact("Pedro",654765324,"pedro@arenabsrpg.org","GladiaWizards");
        // As of now, there's no logic implemented in our g&s; but we might want to test them in the future
        assertEquals(c2.getName(),c1.getName());
        assertEquals(c2.getPhoneNumber(),c1.getPhoneNumber());
        assertEquals(c2.getEmail(),c1.getEmail());
        assertEquals(c2.getCompanyName(),c1.getCompanyName());
    }
}