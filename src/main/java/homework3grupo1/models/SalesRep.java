package homework3grupo1.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salesRepId;

    private String name;

    @OneToMany (mappedBy = "salesRepOpportunity" )
    private List<Opportunity> opportunitySalesRepList = new ArrayList<>();

    @OneToMany (mappedBy = "salesRepLead" )
    private List<Lead> leadSalesRepList = new ArrayList<>();


    public SalesRep() {
    }

    public SalesRep(String name, List<Opportunity> opportunitySalesRepList, List<Lead> leadSalesRepList) {
        this.name = name;
        setOpportunitySalesRepList(opportunitySalesRepList);
        this.leadSalesRepList = leadSalesRepList;
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

    public Long getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(Long salesRepId) {
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
