package homework3grupo1.models;

import homework3grupo1.enums.Industry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    @OneToMany (mappedBy = "account" )
    private List<Contact> contactList = new ArrayList<>();
    @OneToMany (mappedBy = "account")
    private List<Opportunity> opportunityList = new ArrayList<>();

    public Account(Industry industry, int employeeCount, String city, String country) {
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
    }
    public Account(){};

    public void compareId(int id1, int id2) throws RuntimeException{
        if (id1 == id2) throw new RuntimeException("Ids must be different.");
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Enum getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void addContactList(Contact contact){
        this.contactList.add(contact);
    }
    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void addOpportunityList(Opportunity opportunity){
        this.opportunityList.add(opportunity);
    }
    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", industry=" + industry +
                ", employeeCount=" + employeeCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                '}';
    }
}
