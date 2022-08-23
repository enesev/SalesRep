package homework3grupo1.repository;

import homework3grupo1.enums.Product;
import homework3grupo1.enums.Status;
import homework3grupo1.models.Lead;
import homework3grupo1.models.Opportunity;
import homework3grupo1.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

    //BY SALESREP
    //A count of all Opportunities by SalesRep can be displayed by typing “Report Opportunity by SalesRep”

    List<Opportunity> findBySalesRep(SalesRep salesRepOpportunity);

    //A count of all CLOSED_WON Opportunities by SalesRep can be displayed by typing “Report CLOSED-WON by SalesRep”
    //A count of all CLOSED_LOST Opportunities by SalesRep can be displayed by typing “Report CLOSED-LOST by SalesRep”
    //A count of all OPEN Opportunities by SalesRep can be displayed by typing “Report OPEN by SalesRep”
    List<Opportunity> findBySalesRepAndStatusEquals(SalesRep salesRepOpportunity, Status status);

    //BY PRODUCT
    //A count of all Opportunities by the product can be displayed by typing “Report Opportunity by the product”
    List<Opportunity> findAllByProduct(Product product);


    //A count of all CLOSED_WON Opportunities by the product can be displayed by typing “Report CLOSED-WON by the product”
    //A count of all CLOSED_LOST Opportunities by the product can be displayed by typing “Report CLOSED-LOST by the product”
    //A count of all OPEN Opportunities by the product can be displayed by typing “Report OPEN by the product”

    List<Opportunity> findByProductAndStatusEquals(Product product, Status status);


    //BY COUNTRY
    //A count of all Opportunities by country can be displayed by typing “Report Opportunity by Country”
    List<Opportunity> findByCountry();


    //A count of all CLOSED_WON Opportunities by country can be displayed by typing “Report CLOSED-WON by Country”
    //A count of all CLOSED_LOST Opportunities by country can be displayed by typing “Report CLOSED-LOST by Country”
    //A count of all OPEN Opportunities by country can be displayed by typing “Report OPEN by Country”




    //The mean quantity of products order can be displayed by typing “Mean Quantity”
    @Query("SELECT AVG(quantity) from Opportunity")
    Double findAverage();
    //The median quantity of products order can be displayed by typing “Median Quantity”



    //The maximum quantity of products order can be displayed by typing “Max Quantity”
    @Query("SELECT MAX(quantity) from Opportunity")
    Double findMax();
    //The minimum quantity of products order can be displayed by typing “Min Quantity”
    @Query("SELECT MIN(quantity) from Opportunity")
    Double findMin();


}
