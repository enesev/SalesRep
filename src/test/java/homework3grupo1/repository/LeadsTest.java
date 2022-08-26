package homework3grupo1.repository;

import homework3grupo1.models.Leads;
import homework3grupo1.models.SalesRep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LeadsTest {
    // can't test anything here, everything depends on console
    @Test
    @DisplayName("Check if values are properly assigned")
    void LeadValuesTest() {
        Leads l1 = new Leads();
        l1.setName("Pedro Jr");
        l1.setPhoneNumber(644820734);
        l1.setEmail("pjr@novact.org");
        l1.setCompanyName("International Institute for Nonviolent Action");

        Leads l2 = new Leads("Pedro Jr",644820734,"pjr@novact.org","International Institute for Nonviolent Action");
        // Just in case we eventually implement logic in our g&s
        assertEquals(l2.getName(),l1.getName());
        assertEquals(l2.getPhoneNumber(),l1.getPhoneNumber());
        assertEquals(l2.getEmail(),l1.getEmail());
        assertEquals(l2.getCompanyName(),l1.getCompanyName());
    }
}