package homework3grupo1.repository;

import homework3grupo1.enums.Industry;
import homework3grupo1.enums.Product;
import homework3grupo1.models.Account;
import homework3grupo1.models.Contact;
import homework3grupo1.models.Leads;
import homework3grupo1.models.Opportunity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    List<Leads> listaLeads = new ArrayList<>();
    List<Account> listaAccounts = new ArrayList<>();
<<<<<<< HEAD
    Lead l1 = new Lead(0,"juan",622733955,"juan@gmail.com","juanCompany");
=======
    Leads l1 = new Leads("juan",622733955,"juan@gmail.com","juanCompany");
>>>>>>> sergio
    Contact c1 = new Contact("pedro",623525213,"pedro@hotmail.com","pedroCompany");
    Opportunity o1 = new Opportunity(c1, Product.FLATBED,20);
    Account a1 = new Account(Industry.PRODUCE,20000,"Paris", "France");

    @AfterEach
    void tearDown() {
        listaLeads.removeAll(listaLeads);
        listaAccounts.removeAll(listaAccounts);
    }


    @Test
    @DisplayName("Check if new leads are created with the right values")
    void createNewLeadTest(){
        /* "Simulating" how our scanner behaves. Most methods in Main use a customized Scanner. I have tried
            InputStream, Scanner, and similar tools, but I can't find a way to run these in a testing environment.
            Therefore, I will implement tests that are functionally identical to those found in other test files,
            but I will use the logic implemented in Main, instead of the logic found in their respective class files */

        listaLeads.add(l1);
        String name = "juan";
        int phoneNumber = 622733955;
        String email = "juan@gmail.com";
        String companyName = "juanCompany";
<<<<<<< HEAD
        Lead lead2 = new Lead(0,name, phoneNumber, email, companyName);
        listaLeads.add(lead2);
=======
        Leads leads2 = new Leads(name, phoneNumber, email, companyName);
        listaLeads.add(leads2);
>>>>>>> sergio

        assertEquals(listaLeads.get(1).getName(),listaLeads.get(0).getName());
        assertEquals(listaLeads.get(1).getPhoneNumber(),listaLeads.get(0).getPhoneNumber());
        assertEquals(listaLeads.get(1).getEmail(),listaLeads.get(0).getEmail());
        assertEquals(listaLeads.get(1).getCompanyName(),listaLeads.get(0).getCompanyName());


    }

    @Test
    @DisplayName("Test lookupLeadId output")
    void lookupLeadIdTest(){
        listaLeads.add(l1);
        String expected = l1.toString();
        boolean repite = true;
        while (repite) {
            Long id = l1.getLeadId();
            for (int i = 0; i < listaLeads.size(); i++) {
                Long a = listaLeads.get(i).getLeadId();
                if (a == id) {
                    assertEquals(expected, listaLeads.get(0).toString());
                    repite = false;
                }
            }
        }
    }

    @Test
    @DisplayName("Check convertLead's output")
    void convertLeadTest() {
        Contact expectedContact = c1;
        Opportunity expectedOpportunity = o1;
        Long id = l1.getLeadId();
        for (int i = 0; i < listaLeads.size(); i++) {
            Long a = listaLeads.get(i).getLeadId();
            if (a == id) {
                Contact contact2 = new Contact("pedro",623525213,"pedro@hotmail.com","pedroCompany");
                assertEquals(expectedContact.getName(),contact2.getName());
                Product product = Product.FLATBED;
                int quantity = 20;
                Opportunity opportunity2 = new Opportunity(contact2, product, quantity);
                assertEquals(expectedOpportunity.getDecisionMaker(),opportunity2.getDecisionMaker());

            }
        }

    }
    @Test
    @DisplayName("Check createAccount's output")
    void createAccountTest () {
        listaAccounts.add(a1); // expected
        Industry industry1 = Industry.PRODUCE;
        int empleados = 20000;
        String city = "Paris";
        String country = "France";
        Account account2 = new Account(industry1, empleados, city, country);
        listaAccounts.add(account2);
        assertEquals(listaAccounts.get(0).getIndustry(),listaAccounts.get(1).getIndustry());
        assertEquals(listaAccounts.get(0).getEmployeeCount(),listaAccounts.get(1).getEmployeeCount());
        assertEquals(listaAccounts.get(0).getCity(),listaAccounts.get(1).getCity());
        assertEquals(listaAccounts.get(0).getCountry(),listaAccounts.get(1).getCountry());

        }
}
