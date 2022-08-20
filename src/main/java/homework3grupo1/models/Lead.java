package homework3grupo1.models;

import javax.persistence.*;

@Entity
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leadId = (int) (Math.random() * 2000 + 2000);
    private String name;
    private int phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRepLead;

    public Lead(String name, int phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    public Lead(String name, int phoneNumber, String email, String companyName, SalesRep salesRepLead) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        setSalesRepLead(salesRepLead);
    }

    public Lead(){};

    public void compareId(Integer id1, Integer id2) throws RuntimeException{
        if (id1 == id2) throw new RuntimeException("Ids must be different.");
    }

    public SalesRep getSalesRepLead() {
        return salesRepLead;
    }

    public void setSalesRepLead(SalesRep salesRepLead) {
        this.salesRepLead = salesRepLead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "leadId=" + leadId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", SalesRep==" + salesRepLead.getSalesRepId() + " " + salesRepLead.getName() +
                '}';
    }


    public String toString2() {
        return "Lead{" +
                "leadId=" + leadId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName +
                '}';
    }
}


