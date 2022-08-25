package homework3grupo1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import homework3grupo1.funcionesPedirDatos.PideDatos;

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
    private List<Leads> leadsSalesRepList = new ArrayList<>();


    public SalesRep() {

    }

    public SalesRep(String name, List<Opportunity> opportunitySalesRepList, List<Leads> leadsSalesRepList) {
        this.name = name;
        setOpportunitySalesRepList(opportunitySalesRepList);
        this.leadsSalesRepList = leadsSalesRepList;
    }

    public void addOpportunityListToSalesRep(Opportunity opportunity){
        this.opportunitySalesRepList.add(opportunity);
    }

    public void addLeadListToSalesRep(Leads leads){
        this.leadsSalesRepList.add(leads);
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
        return opportunitySalesRepList == null? new ArrayList<>() : opportunitySalesRepList;
    }

    public void setOpportunitySalesRepList(List<Opportunity> opportunitySalesRepList) {
        this.opportunitySalesRepList = opportunitySalesRepList;
    }

    public List<Leads> getLeadSalesRepList() {

        return leadsSalesRepList == null? new ArrayList<>() : leadsSalesRepList;
    }

    public void setLeadSalesRepList(List<Leads> leadsSalesRepList) {
        this.leadsSalesRepList = leadsSalesRepList;
    }

    @Override
    public String toString() {
        return "SalesRep{" +
                "salesRepId=" + salesRepId +
                ", name='" + name + '\'' +
                '}';
    }

    public static SalesRep createNewSalesRep(){
        System.out.println("Creating a new SalesRep:");
        String name = PideDatos.pideString("What is the name of the new SalesRep?");
        SalesRep salesRep1 = new SalesRep(name);
        System.out.println("A new SalesRep has been created with the following data: " + salesRep1.toString());
        System.out.println();
        return salesRep1;
    }

    public static void showSalesReps(List<SalesRep> listaSalesRep){
        //we check to see if the arraylist is empty, so we can display the proper message

        if (listaSalesRep.size() == 0) {

            System.err.println("Currently our systems don't have any SalesRep in the database");
        }
        //otherwise, we proceed to print out all of the salesreps in the system.
        else {
            for (int i = 0; i < listaSalesRep.size(); i++) {
                System.out.println(listaSalesRep.get(i).toString() + "\n");
            }
        }
    } // está ok
}
