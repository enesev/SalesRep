package homework3grupo1.models;

import homework3grupo1.enums.Industry;
import homework3grupo1.enums.Product;
import homework3grupo1.funcionesPedirDatos.PideDatos;
import homework3grupo1.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

@Entity
public class Leads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;
    private String name;
    private int phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRepLead;

    public Leads(String name, int phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    public Leads(String name, int phoneNumber, String email, String companyName, SalesRep salesRepLead) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        setSalesRepLead(salesRepLead);
    }

    public Leads(){};



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

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    @Override
    public String toString() {
        return "Leads{" +
                "leadId=" + leadId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", salesRepLead=" + salesRepLead.getSalesRepId() + "" + salesRepLead.getName() +
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

    public static Leads createNewLead(List<SalesRep> listaSalesRep) {
        //we check to see if the arraylist is empty, so we can display the proper message
        if (listaSalesRep.size() == 0) {
            System.err.println("The SalesRep list is empty. Please create a SalesRep first.");
            //otherwise, we proceed to create a lead
        } else {
            System.out.println("Creating a new lead:");
            String name = PideDatos.pideString("What is the name of the new lead?");
            int phoneNumber = PideDatos.pideEntero("What is its phone number?");
            String email = PideDatos.pideString("What is its email address?");
            String companyName = PideDatos.pideString("What company does he/she work for?");
            Leads leads1 = new Leads(name, phoneNumber, email, companyName);
            return leads1;
        }
        return null;
    }


    public static Leads addSalesRepToLead(List<SalesRep> listaSalesRep, Leads leads1) {
        System.out.println("A new lead has been created with the following data: " + leads1.toString2());
        System.out.println("\nThese are the SalesRep we have available: \n");

        boolean found = false;
        do {
            SalesRep.showSalesReps((listaSalesRep));
            int idSelected = PideDatos.pideValorMinMax(1,listaSalesRep.size(),"\nPlease select the SalesRep's id you want to associate this lead with.");
            for (int i = 0; i < listaSalesRep.size(); i++) {
                if (idSelected == listaSalesRep.get(i).getSalesRepId()) {
                    leads1.setSalesRepLead(listaSalesRep.get(i));
                    found = true;
                }
            }
            if (!found) System.err.println("Selected id doesn't exist. Try again");
            found = true;
        } while (!found);
        System.out.println("\nLead " + leads1.getLeadId() + " has been added to the selected SalesRep\n");
        return leads1;
    }



    public static void lookupLeadId(List<Leads> leadsList) {
        if (leadsList.size() == 0) {
            System.err.println("The SalesRep list is empty. Please create a SalesRep first.");
            //otherwise, we proceed to show the lead
        } else {

        Long id = (long) PideDatos.pideValorMinMax(1, leadsList.size(), "Choose the Lead's ID you want to see.");
        boolean repite = true;
        while (repite) {

            for (int i = 0; i < leadsList.size(); i++) {
                Long a = leadsList.get(i).getLeadId();
                if (a == id) {
                    System.out.println("Lead's details are: " + leadsList.get(i).toString());
                    repite = false;
                }
            }
        }
        }
    }    //esta perfect

    public static void showLeads(List<Leads> lista){
        //we check to see if the arraylist is empty, so we can display the proper message
        if (lista.size() == 0) {
            System.err.println("Currently our systems don't have any Leads in the database");
        }
        //otherwise, we proceed to print out all of the leads in the system.
        else {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).getLeadId() + " " + lista.get(i).getName() + "\n");
            }
        }
    } // está ok


    public static Contact convertLead_fase1(List<Leads> listaLeads, List<Contact> listaContactos, int id) {
        Leads lead1;
        for (Leads listaLead : listaLeads) {
            if (listaLead.getLeadId().equals(id)) {
                lead1 = listaLead;
                Contact contact1 = new Contact(lead1.getName(), lead1.getPhoneNumber(), lead1.getEmail(), lead1.getCompanyName());
                listaContactos.add(contact1);
                System.out.println("The lead " + listaLead.getLeadId() + " has been transferred to the contact list.\n");

                return contact1;
            }else {
                System.err.println("This ID doesn't exist.");
                break;
            }
        }
            return null;
        }

    public static Opportunity convertLead_fase2( Contact contact, List<Opportunity> listaOpportunities) {
        Product product = PideDatos.pideProduct();
        int quantity = PideDatos.pideValorMinMaxCamiones(1, 50);
        Opportunity opportunity1 = new Opportunity(contact, product, quantity);
        listaOpportunities.add(opportunity1);
        System.out.println("The lead has been converted to opportunity and added to the list of opportunities, with the following data : " + opportunity1.toString2() + ".\n");
        return opportunity1;
    }

    public static Account convertLead_fase3(Contact contact, Opportunity opportunity, List<Account> listaAccounts) {
                    Scanner scan = new Scanner(System.in);
                    boolean exit = false;
                    do {
                        try {
                            System.out.println("Would you like to create a new account? (Y/N)");
                            String option = scan.nextLine().toLowerCase().trim();

                            switch (option) {

                                case "y":
                                    Account accountNueva = createAccount(listaAccounts);
                                    accountNueva.addContactList(contact);
                                    accountNueva.addOpportunityList(opportunity);
                                    exit = true;
                                    return accountNueva;


                                case "n":
                                    if (listaAccounts.size() == 0) {
                                        System.err.println("Currently our systems don't have any Account in the database.");
                                        exit = true;
                                    }
                                    //otherwise, we proceed to print out all of the accounts in the system.
                                    else {
                                        Account.showAccounts(listaAccounts);
                                        boolean found = false;
                                        do {
                                            int accountId = PideDatos.pideEntero("Select an account id.");
                                            for (int q = 0; q < listaAccounts.size(); q++) {
                                                Long b = listaAccounts.get(q).getAccountId();
                                                if (b == accountId){
                                                    Account accountCopia = listaAccounts.get(q);
                                                    accountCopia.addContactList(contact);
                                                    accountCopia.addOpportunityList(opportunity);
                                                    System.out.println("Contact " + contact.getContactId() +
                                                            " and " + opportunity.getOpportunityId() +
                                                            " have been added to Account " + listaAccounts.get(q).getAccountId());
                                                    found = true;
                                                    return accountCopia;
                                                }
                                            }if (!found) System.err.println("Selected id doesn't exist. Try again");
                                        }while (!found);
                                    }//
                                    exit = true;
                                    break;

                                default:
                                    System.err.println("You have to select an appropriate option. Type just Y or N.");
                            }
                        }catch (Exception e) {
                            e.printStackTrace();
                            scan.next();
                        }
                    } while (!exit);
            return null;
    }



    public static Account createAccount(List<Account> listaAccounts){
        Industry industry1 = PideDatos.pideIndustry();
        int empleados = PideDatos.pideValorMinMaxEmpleados(1, 50000);
        String city = PideDatos.pideString("What city is the company from?");
        String country = PideDatos.pideString("What country is the city from?");
        Account account1 = new Account(industry1, empleados, city, country);
        System.out.println("An account has been created with the following data :" + account1.toString() + "\n");
        return account1;
    }//


}


