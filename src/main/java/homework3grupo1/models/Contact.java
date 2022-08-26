package homework3grupo1.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String name;

    private int phoneNumber;
    private String email;
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne (mappedBy = "decisionMaker")
    private Opportunity opportunity;

    public Contact(String name, int phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }



    public Contact(String name, int phoneNumber, String email, String companyName, Account account, Opportunity opportunity) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        setAccount(account);
        setOpportunity(opportunity);
    }

    public Contact(){};


    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Contact id=" + contactId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}'+"\n" ;
    }

    public static void showContacts(List<Contact> listaContacts){
        //we check to see if the arraylist is empty, so we can display the proper message
        if (listaContacts.size() == 0) {
            System.err.println("Currently our systems don't have any Contact in the database");
        }
        //otherwise, we proceed to print out all of the contacts in the system.
        else {
            for (int i = 0; i < listaContacts.size(); i++) {
                System.out.println(listaContacts.get(i).toString() +"\n");
            }
        }
    } // está ok
}


