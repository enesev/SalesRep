package homework3grupo1.repository;

import homework3grupo1.models.Account;
import homework3grupo1.models.Leads;
import homework3grupo1.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {

    List<SalesRep> findAll();
}
