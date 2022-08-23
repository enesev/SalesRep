package homework3grupo1.repository;

import homework3grupo1.models.Lead;
import homework3grupo1.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    //A count of Leads by SalesRep can be displayed by typing “Report Lead by SalesRep”
    List<Lead> findBySalesRep(SalesRep salesRepLead);

    /*
    public Lead createLead(){
        return null;
    }

    Lead lead1 = new Lead;
    lead1 = leadRepository.save(lead1);
    */



}
