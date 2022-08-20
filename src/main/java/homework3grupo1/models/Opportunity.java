package homework3grupo1.models;

import homework3grupo1.enums.Product;
import homework3grupo1.enums.Status;

import javax.persistence.*;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer opportunityId = (int) (Math.random() * 100 + 300);
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
        this.salesRepOpportunity = salesRepOpportunity;
    }

    public Opportunity() {
    }


    public void compareId(Integer id1, Integer id2) throws RuntimeException{
        if (id1 == id2) throw new RuntimeException("Ids must be different.");
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

    public Integer getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(Integer opportunityId) {
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
                ", SalesRep=" + salesRepOpportunity.getSalesRepId() + " " + salesRepOpportunity.getName() +
                '}';
    }

    public String toString2() {
        return "Opportunity{" +
                "opportunityId=" + opportunityId +
                ", status=" + status +
                ", decisionMaker=" + decisionMaker +
                ", product=" + product +
                ", quantity=" + quantity +
                ", account=" + account +
                '}';
    }
}
