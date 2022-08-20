package homework3grupo1;

import homework3grupo1.enums.Industry;
import homework3grupo1.enums.Product;
import homework3grupo1.enums.Status;
import homework3grupo1.funcionesPedirDatos.PideDatos;
import homework3grupo1.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Lead> lalista = new ArrayList<>();

        List<Contact> listaContactos = new ArrayList<>();

        List<Opportunity> listaOpportunities = new ArrayList<>();

        List<Account> listaAccounts = new ArrayList<>();

        List<SalesRep> listaSalesRep = new ArrayList<>();

        ////////////////////////////////////////////////////PRUEBAS

        Lead lead1 = new Lead("kakakak",666666, "email", "kakakakak");
        Lead lead2 = new Lead("kekekek",666666, "email", "kakakakak");
        Lead lead3 = new Lead("kokoko",666666, "email", "kakakakak");
        Lead lead4 = new Lead("kukuku",666666, "email", "kukuku");

        lalista.add(lead1);
        lalista.add(lead2);
        lalista.add(lead3);
        lalista.add(lead4);


        SalesRep salesRep1 = new SalesRep("jajajaj");
        SalesRep salesRep2 = new SalesRep("jejejej");
        SalesRep salesRep3 = new SalesRep("jojojo");
        SalesRep salesRep4 = new SalesRep("jujuju");

        listaSalesRep.add(salesRep1);
        listaSalesRep.add(salesRep2);
        listaSalesRep.add(salesRep3);
        listaSalesRep.add(salesRep4);



        //////////////////////////////////////////////////// FIN DE PRUEBAS

        Scanner scan = new Scanner(System.in);
        boolean exit = false;

        System.out.println("****************************************************");
        System.out.println("*\tWelcome to your CRM\t *");
        System.out.println("****************************************************\n");

        do{
            try{

                System.out.println("Please choose one of the options below: \n" +
                        "New Lead \n" +
                        "New SalesRep \n" +
                        "Show Leads \n" +
                        "Lookup Lead id \n" +
                        "Convert id \n" +
                        "Show contacts \n" +
                        "Show opportunities \n" +
                        "Show accounts \n" +
                        "Show SalesReps \n" +
                        "Close-lost id \n" +
                        "Close-won id \n" +
                        "Exit \n");
                String option = scan.nextLine().toLowerCase().trim();

                switch (option){

                    case "new lead":
                        createNewLead(lalista, listaSalesRep);

                        break;

                    case "new salesrep":
                        createNewSalesRep(listaSalesRep);

                        break;

                    case "show leads":
                        showLeads(lalista);

                        break;

                    case "lookup lead id":
                        lookupLeadId(lalista);
                        break;

                    case "convert id":
                        int id = PideDatos.pideEntero("Select a lead's id to convert it to contact.");
                        convertLead(lalista, listaContactos, listaOpportunities, id, listaAccounts, listaSalesRep);

                        break;

                    case "show contacts":
                        showContacts(listaContactos);

                        break;

                    case "show opportunities":
                        showOpportunities(listaOpportunities);
                        break;

                    case "show accounts":
                        showAccounts(listaAccounts);
                        break;

                    case "show salesreps":
                        showSalesReps(listaSalesRep);;
                        break;

                    case "close-lost id":
                        int oppId = PideDatos.pideEntero("Write opportunity's id you want to mark as closed-lost.");

                        closeLostId(listaOpportunities, oppId);
                        break;

                    case "close-won id":
                        int oppId2 = PideDatos.pideEntero("Write opportunity's id you want to mark as closed-won.");
                        closeWonId(listaOpportunities, oppId2);
                        break;

                    case "exit":
                        System.out.println("Thank you for using CRM!");
                        exit = true;
                        break;


                    default:
                        System.err.println("You have to select an appropriate option. Try again.");
                }
            }catch (Exception e){
                e.printStackTrace();
                scan.next();
            }
        }while (!exit);



    }

    public static void createNewLead(List<Lead> lalista, List<SalesRep> listaSalesRep){
        //we check to see if the arraylist is empty, so we can display the proper message
        if(listaSalesRep.size() == 0){
            System.err.println("The SalesRep list is empty. Please create a SalesRep first.");
            //otherwise, we proceed to create a lead
        }else {
            System.out.println("Creating a new lead:");
            String name = PideDatos.pideString("What is the name of the new lead?");
            int phoneNumber = PideDatos.pideEntero("What is its phone number?");
            String email = PideDatos.pideString("What is its email address?");
            String companyName = PideDatos.pideString("What company does he/she work for?");
            Lead lead1 = new Lead(name, phoneNumber, email, companyName);
            System.out.println("A new lead has been created with the following data: " + lead1.toString2());
            lalista.add(lead1);
            System.out.println("\nThese are the SalesRep we have available: \n");
            showSalesReps(listaSalesRep);
            boolean found = false;
            do {
                int idSelected = PideDatos.pideEntero("\nPlease select the SalesRep's id you want to associate this lead with.");
                for (int i = 0; i < listaSalesRep.size(); i++) {
                    if (idSelected == listaSalesRep.get(i).getSalesRepId()) {
                        listaSalesRep.get(i).addLeadListToSalesRep(lead1);
                        lead1.setSalesRepLead(listaSalesRep.get(i));
                        found = true;
                    }
                }if (!found) System.err.println("Selected id doesn't exist. Try again");
            }while (!found);
            System.out.println("\nLead " + lead1.getLeadId() + " has been added to the selected SalesRep\n");

        }
    }

    public static void createNewSalesRep(List<SalesRep> listaSalesRep){
        System.out.println("Creating a new SalesRep:");
        String name = PideDatos.pideString("What is the name of the new SalesRep?");
        SalesRep salesRep1 = new SalesRep(name);
        System.out.println("A new SalesRep has been created with the following data: " + salesRep1.toString());
        System.out.println();
        listaSalesRep.add(salesRep1);
    }


    public static void lookupLeadId(List<Lead> lista) {

        boolean repite = true;
        while (repite) {
            int id = PideDatos.pideEntero("Choose the id you want to see detailed");
            for (int i = 0; i < lista.size(); i++) {
                int a = lista.get(i).getLeadId();
                if (a == id) {
                    System.out.println("Lead's details are: " + lista.get(i).toString());
                    repite = false;
                }
            }
        }
    }    //esta perfect  357


    public static void convertLead(List<Lead> listaLeads, List<Contact> listaContactos, List<Opportunity> listaOpportunities, int id, List<Account> listaAccounts, List<SalesRep> listaSalesRep){
        //we check to see if the arraylist is empty, so we can display the proper message
        if (listaLeads.size() == 0) {
            System.err.println("Currently our systems don't have any Leads in the database.");
        }
        //otherwise, we proceed to print out all of the leads in the system.
        else {
            for (int i = 0; i < listaLeads.size(); i++) {
                int a = listaLeads.get(i).getLeadId();
                if (a == id) {
                    Contact contact1 = new Contact(listaLeads.get(i).getName(), listaLeads.get(i).getPhoneNumber(), listaLeads.get(i).getEmail(), listaLeads.get(i).getCompanyName());
                    listaContactos.add(contact1);
                    System.out.println("The lead " + listaLeads.get(i).getLeadId() + " has been transferred to the contact list.\n");
                    Product product = PideDatos.pideProduct();
                    int quantity = PideDatos.pideValorMinMaxCamiones(1, 50);
                    Opportunity opportunity1 = new Opportunity(contact1, product, quantity, listaLeads.get(i).getSalesRepLead());
                    listaOpportunities.add(opportunity1);
                    System.out.println("The lead " + listaLeads.get(i).getLeadId() + " has been converted to opportunity and added to the list of opportunities, with the following data : " + opportunity1.toString2() + ".\n");
                    listaLeads.get(i).getSalesRepLead().addOpportunityListToSalesRep(opportunity1);
                    listaLeads.remove(i); //TODO -- remove aqui? en caso de que en el switch eligan N, saldra fuera al menu principal y el lead ya no existira.

                    Scanner scan = new Scanner(System.in);
                    boolean exit = false;
                    do {
                        try {
                            System.out.println("Would you like to create a new account? (Y/N)");
                            String option = scan.nextLine().toLowerCase().trim();

                            switch (option) {

                                case "y":
                                    createAccount(listaAccounts);
                                    listaAccounts.get(i).addContactList(contact1);
                                    listaAccounts.get(i).addOpportunityList(opportunity1);
                                    exit = true;
                                    break;

                                case "n":
                                    if (listaAccounts.size() == 0) {
                                        System.err.println("Currently our systems don't have any Account in the database.");
                                        exit = true;
                                    }
                                    //otherwise, we proceed to print out all of the accounts in the system.
                                    else {
                                        showAccounts(listaAccounts);
                                        boolean found = false;
                                        do {
                                            int accountId = PideDatos.pideEntero("Select an account id.");
                                            for (int q = 0; q < listaAccounts.size(); q++) {
                                                int b = listaAccounts.get(q).getAccountId();
                                                if (b == accountId){
                                                    listaAccounts.get(q).addContactList(contact1);
                                                    listaAccounts.get(q).addOpportunityList(opportunity1);
                                                    System.out.println("Contact " + contact1.getContactId() +
                                                            " and " + opportunity1.getOpportunityId() +
                                                            " have been added to Account " + listaAccounts.get(q).getAccountId());
                                                    found = true;
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

                }
            }
        }
    }


    public static void createAccount(List<Account> listaAccounts){
        Industry industry1 = PideDatos.pideIndustry();
        int empleados = PideDatos.pideValorMinMaxEmpleados(1, 50000);
        String city = PideDatos.pideString("What city is the company from?");
        String country = PideDatos.pideString("What country is the city from?");
        Account account1 = new Account(industry1, empleados, city, country);
        System.out.println("An account has been created with the following data :" + account1.toString() + "\n");
        listaAccounts.add(account1);
    }//


    public static void showLeads(List<Lead> lista){
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

    public static void showAccounts(List<Account> listaAccounts){
        //we check to see if the arraylist is empty, so we can display the proper message
        if (listaAccounts.size() == 0) {
            System.err.println("Currently our systems don't have any Account in the database");
        }
        //otherwise, we proceed to print out all of the accounts in the system.
        else {
            for (int i = 0; i < listaAccounts.size(); i++) {
                System.out.println(listaAccounts.get(i).toString() + "\n");
            }
        }
    } // está ok

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

    public static void closeLostId(List<Opportunity> listaOpportunities, int oppId){
        for (int i = 0; i < listaOpportunities.size(); i++) {
            Opportunity opportunity1 = listaOpportunities.get(i);
            if (opportunity1.getOpportunityId() == oppId){

                if (opportunity1.getStatus() == Status.OPEN) {
                    opportunity1.setStatus(Status.CLOSED_LOST);
                    System.out.println("Status changed to Closed_Lost status.");
                }else if (opportunity1.getStatus() != Status.OPEN){
                    System.err.println("This opportunity's status is not open. Please select an oppen oportunity");
                }
            }else {
                System.err.println("Selected id doesn't exist. Please choose a valid id.");
            }
        }
    }//añadir al principio que compruebe que haya opportunities en la lista?? o que haya y esten en open??

    public static void closeWonId(List<Opportunity> listaOpportunities, int oppId2){
        for (int i = 0; i < listaOpportunities.size(); i++) {
            Opportunity opportunity1 = listaOpportunities.get(i);
            if (opportunity1.getOpportunityId() == oppId2){

                if (opportunity1.getStatus() == Status.OPEN) {
                    opportunity1.setStatus(Status.CLOSED_WON);
                    System.out.println("Status changed to Closed_Won status.");
                }else if (opportunity1.getStatus() != Status.OPEN){
                    System.err.println("This opportunity's status is not open. Please select an open oportunity");
                }
            }else {
                System.err.println("Selected id doesn't exist. Please choose a valid id.");
            }
        }
    } ////añadir al principio que compruebe que haya opportunities en la lista?? o que haya y esten en open??




}