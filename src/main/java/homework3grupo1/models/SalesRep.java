package homework3grupo1.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesRepId = (int) (Math.random() * 100 + 300);

    private String name;

    @OneToMany (mappedBy = "salesRepOpportunity" )
    private List<Opportunity> opportunitySalesRepList = new ArrayList<>();

    @OneToMany (mappedBy = "salesRepLead" )
    private List<Lead> leadSalesRepList = new ArrayList<>();


    public SalesRep() {
    }

    public void addOpportunityListToSalesRep(Opportunity opportunity){
        this.opportunitySalesRepList.add(opportunity);
    }

    public void addLeadListToSalesRep(Lead lead){
        this.leadSalesRepList.add(lead);
    }

    public SalesRep(String name) {
        this.name = name;
    }

    public Integer getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Integer salesRepId) {
        this.salesRepId = salesRepId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Opportunity> getOpportunitySalesRepList() {
        return opportunitySalesRepList;
    }

    public void setOpportunitySalesRepList(List<Opportunity> opportunitySalesRepList) {
        this.opportunitySalesRepList = opportunitySalesRepList;
    }

    public List<Lead> getLeadSalesRepList() {
        return leadSalesRepList;
    }

    public void setLeadSalesRepList(List<Lead> leadSalesRepList) {
        this.leadSalesRepList = leadSalesRepList;
    }

    @Override
    public String toString() {
        return "SalesRep{" +
                "salesRepId=" + salesRepId +
                ", name='" + name + '\'' +
                ", opportunitySalesRepList=" + opportunitySalesRepList +
                ", leadSalesRepList=" + leadSalesRepList +
                '}';
    }
}