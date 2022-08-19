package homework3grupo1.repository;

import homework3grupo1.models.Lead;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LeadTest {

    @Test
    @DisplayName("Compare ids, throw RTex if equal.")
    void LeadValuesTest() throws RuntimeException{
        Lead l1 = new Lead();
        l1.setName("Pedro Jr");
        l1.setPhoneNumber(644820734);
        l1.setEmail("pjr@novact.org");
        l1.setCompanyName("International Institute for Nonviolent Action");

        Lead l2 = new Lead("Pedro Jr",644820734,"pjr@novact.org","International Institute for Nonviolent Action");
        // Just in case we eventually implement logic in our g&s
        assertEquals(l2.getName(),l1.getName());
        assertEquals(l2.getPhoneNumber(),l1.getPhoneNumber());
        assertEquals(l2.getEmail(),l1.getEmail());
        assertEquals(l2.getCompanyName(),l1.getCompanyName());
        // compareId should throw RTex if ids are equal
        l1.setLeadId(l2.getLeadId());
        assertThrows(RuntimeException.class,
                () -> l1.compareId(l1.getLeadId(), l2.getLeadId()));
    }
}
