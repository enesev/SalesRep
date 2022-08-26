package homework3grupo1.repository;

import homework3grupo1.enums.Industry;
import homework3grupo1.enums.Product;
import homework3grupo1.models.Account;
import homework3grupo1.models.Contact;
import homework3grupo1.models.Opportunity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    @DisplayName("Checks that acc properties are equal in case any logic is implemented in g&s. " +
            "Also makes sure RTex is thrown if ids from diff accs are equal.")
    void AccountValuesTest(){
        Account a1 = new Account();
        a1.setIndustry(Industry.PRODUCE);
        a1.setEmployeeCount(25000);
        a1.setCity("Minas Tirith");
        a1.setCountry("Gondor");

        Account a2 = new Account(Industry.PRODUCE,25000,"Minas Tirith","Gondor");
        /* As of now, there's no logic implemented in our g&s; but we might want to test them in the future.
           For example, since we can't provide any more than 50 trucks, we might want to limit employeeCount
           to avoid selling our services to companies, if their logistical chain's size is way above ours */
        assertEquals(a2.getIndustry(),a1.getIndustry());
        assertEquals(a2.getEmployeeCount(),a1.getEmployeeCount());
        assertEquals(a2.getCity(),a1.getCity());
        assertEquals(a2.getCountry(),a1.getCountry());
    }

    @Test
    @DisplayName("Check if contacts are added to list")
    void addContactListTest(){
        List<Contact> contactList = new ArrayList<>();
        List<Opportunity> opportunityList= new ArrayList<>();
        Contact c1 = new Contact("Pedro",666555777,"pedro@pedro.com","Pedrería");

        Account account1 = new Account(Industry.ECOMMERCE, 478, "Arkansas", "EEUU", contactList, opportunityList);
        account1.addContactList(c1);

        List<Contact> expectedContactList = new ArrayList<>();
        expectedContactList.add(c1);

        Account expected = new Account(Industry.ECOMMERCE, 478, "Arkansas", "EEUU", expectedContactList, opportunityList);

        assertEquals(expected.getContactList(),account1.getContactList());
    }

    @Test
    @DisplayName("Check if opps are added to list")
    void addOpportunityListTest(){
        List<Contact> contactList = new ArrayList<>();
        List<Opportunity> opportunityList= new ArrayList<>();
        Contact decisionMaker = new Contact("Pedro",666555777,"pedro@pedro.com","Pedrería");
        Opportunity opp1 = new Opportunity(decisionMaker, Product.FLATBED, 10);

        Account account1 = new Account(Industry.ECOMMERCE, 478, "Arkansas", "EEUU", contactList, opportunityList);
        account1.addOpportunityList(opp1);

        List<Opportunity> expectedOpportunityList = new ArrayList<>();
        expectedOpportunityList.add(opp1);
        Account expected = new Account(Industry.ECOMMERCE, 478, "Arkansas", "EEUU", contactList, expectedOpportunityList);

        assertEquals(expected.getOpportunityList(),account1.getOpportunityList());
    }
}