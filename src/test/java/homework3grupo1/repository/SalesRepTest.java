package homework3grupo1.repository;

import homework3grupo1.enums.Product;
import homework3grupo1.models.Contact;
import homework3grupo1.models.Leads;
import homework3grupo1.models.Opportunity;
import homework3grupo1.models.SalesRep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesRepTest {

    @Test
    @DisplayName("Check if opps are added to SRList")
    void addOpportunityListToSalesRepTest() {
        Contact decisionMaker = new Contact("Pedro",666555777,"pedro@pedro.com","Pedrería");
        Opportunity opp1 = new Opportunity(decisionMaker, Product.FLATBED,10);
        List<Opportunity> opportunityList = new ArrayList<>();
        List<Leads> leadsList = new ArrayList<>();

        SalesRep s1 = new SalesRep("Juan",opportunityList, leadsList);
        s1.addOpportunityListToSalesRep(opp1);

        Contact expectedDecisionMaker = new Contact("Pedro",666555777,"pedro@pedro.com","Pedrería");
        Opportunity expectedOpp = new Opportunity(expectedDecisionMaker, Product.FLATBED,10);
        List<Opportunity> expectedOpportunityList = new ArrayList<>();
        List<Leads> expectedLeadsList = new ArrayList<>();
        expectedOpportunityList.add(expectedOpp);

        SalesRep expectedSalesRep = new SalesRep("Juan",expectedOpportunityList, expectedLeadsList);

        assertEquals(expectedSalesRep.toString(),s1.toString());
    }
}
