package homework3grupo1.repository;

import homework3grupo1.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


    //The mean employeeCount can be displayed by typing “Mean EmployeeCount”
    @Query("SELECT AVG(employeeCount) from Account")
    Double findAverage();

    // The median employeeCount can be displayed by typing “Median EmployeeCount”
    //The maximum employeeCount can be displayed by typing “Max EmployeeCount”
    @Query("SELECT MAX(employeeCount) from Account")
    Double findMax();

    //The minimum employeeCount can be displayed by typing “Min EmployeeCount”
    @Query("SELECT MIN(employeeCount) from Account")
    Double findMin();


}
