package homework3grupo1.repository;

import homework3grupo1.enums.Product;
import homework3grupo1.enums.Status;
import homework3grupo1.models.Account;
import homework3grupo1.models.Opportunity;
import homework3grupo1.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

    List<Opportunity> findAll();

    List<Opportunity> findByStatus(Status status);




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
