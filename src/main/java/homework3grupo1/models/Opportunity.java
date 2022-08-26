package homework3grupo1.models;

import homework3grupo1.enums.Product;
import homework3grupo1.enums.Status;
import homework3grupo1.funcionesPedirDatos.PideDatos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opportunityId;
    @Enumerated
    private Status status = Status.OPEN;
    @OneToOne
    @JoinColumn(name = "decision_maker_id")
    private Contact decisionMaker;
    @Enumerated
    private Product product;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRepOpportunity;




    public Opportunity(Contact decisionMaker, Product product, int quantity) {
        setDecisionMaker(decisionMaker);
        setProduct(product);
        setQuantity(quantity);
    }

    public Opportunity( Contact decisionMaker, Product product, int quantity, SalesRep salesRepOpportunity) {
        setDecisionMaker(decisionMaker);
        setProduct(product);
        setQuantity(quantity);
        setSalesRepOpportunity(salesRepOpportunity);
    }

    public Opportunity() {
    }




    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SalesRep getSalesRepOpportunity() {
        return salesRepOpportunity;
    }

    public void setSalesRepOpportunity(SalesRep salesRepOpportunity) {
        this.salesRepOpportunity = salesRepOpportunity;
    }

    public Long getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    @Override
    public String toString() {
        return "Opportunity{" +
                "opportunityId=" + opportunityId +
                ", status=" + status +
                ", decisionMaker=" + decisionMaker +
                ", product=" + product +
                ", quantity=" + quantity +
                ", account=" + account +
                '}' +"\n"+"\n" ;
    }

    public String toString2() {
        return "Opportunity{" +
                "opportunityId=" + opportunityId +
                ", status=" + status +
                ", decisionMaker=" + decisionMaker +
                ", product=" + product +
                ", quantity=" + quantity +
                ", account=" + account +
                '}' +"\n"+"\n";
    }

    public static void showOpportunities(List<Opportunity> listaOpportunities){
        //we check to see if the arraylist is empty, so we can display the proper message
        if (listaOpportunities.size() == 0) {
            System.err.println("Currently our systems don't have any Opportunity in the database");
        }
        //otherwise, we proceed to print out all of the opportunities in the system.
        else {
            for (int i = 0; i < listaOpportunities.size(); i++) {
                System.out.println(listaOpportunities.get(i).toString2() +"\n");
            }
        }
    } // está ok

    public static Opportunity closeLostId(List<Opportunity> listaOpportunities) {
        //we check to see if the arraylist is empty, so we can display the proper message
        if (listaOpportunities.size() == 0) {
            System.err.println("Currently our systems don't have any Opportunity in the database");
        }
        //otherwise, we proceed to print out all of the opportunities in the system.
        else {
            System.out.println(listaOpportunities);
            Long id = (long) PideDatos.pideEntero("Choose the Opportunity's ID you want to close-Lost.");
            Opportunity opportunity1 = null;
            for (int i = 0; i < listaOpportunities.size(); i++) {
                opportunity1 = listaOpportunities.get(i);
                if (opportunity1.getOpportunityId().equals(id)) {
                    opportunity1.setStatus(Status.CLOSED_LOST);
                    System.out.println("Status changed to Closed_Lost status.");
                    return opportunity1;
                }
                
            }if (opportunity1.getOpportunityId() != id) {
                System.err.println("This id doesn't exist. Try again.");
            }
        }
        return closeLostId(listaOpportunities);
    }


    public static Opportunity closeWonId(List<Opportunity> listaOpportunities) {
        //we check to see if the arraylist is empty, so we can display the proper message
        if (listaOpportunities.size() == 0) {
            System.err.println("Currently our systems don't have any Opportunity in the database");
        }
        //otherwise, we proceed to print out all of the opportunities in the system.
        else {
            System.out.println(listaOpportunities);
            Long id = (long) PideDatos.pideEntero("Choose the Opportunity's ID you want to close-Lost.");
            Opportunity opportunity1 = null;
            for (int i = 0; i < listaOpportunities.size(); i++) {
                opportunity1 = listaOpportunities.get(i);
                if (opportunity1.getOpportunityId().equals(id)) {
                    opportunity1.setStatus(Status.CLOSED_WON);
                    System.out.println("Status changed to Closed_Won status.");
                    return opportunity1;
                }

            }if (opportunity1.getOpportunityId() != id) {
                System.err.println("This id doesn't exist. Try again.");
            }
        }
        return closeWonId(listaOpportunities);
    }





}
