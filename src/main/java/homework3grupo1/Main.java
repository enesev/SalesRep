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
        Lead lead1 = new Lead(0,"pedro", 123, "aaa", "tomic");
        Lead lead2 = new Lead(0,"pedrito", 123, "aaa", "tomic");
        Lead lead3 = new Lead(0,"pedraso", 123, "aaa", "tomic");
        Lead lead4 = new Lead(0,"pedrillo", 123, "aaa", "tomic");
        Lead lead5 = new Lead(0,"pedraco", 123, "aaa", "tomic");
        Lead lead6 = new Lead(0,"pedroooo", 123, "aaa", "tomic");
        System.out.println(lead1.getLeadId() + ", " +lead2.getLeadId() + ", " +lead3.getLeadId() + ", "
                +lead4.getLeadId() + ", " +lead5.getLeadId() + ", " +lead6.getLeadId());
        List<Lead> lalista = new ArrayList<>();

        List<Contact> listaContactos = new ArrayList<>();

        List<Opportunity> listaOpportunities = new ArrayList<>();

        List<Account> listaAccounts = new ArrayList<>();

        List<SalesRep> listaSalesRep = new ArrayList<>();


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
                        createNewLead(lalista);

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
                        convertLead(lalista, listaContactos, listaOpportunities, id, listaAccounts);

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

    public static void createNewLead(List<Lead> lalista){
        //meter algo aqui que diga que si no hay salesrep creados no se puede crear un lead
        System.out.println("Creating a new lead:");
        String name = PideDatos.pideString("What is the name of the new lead?");
        int phoneNumber = PideDatos.pideEntero("What is its phone number?");
        String email = PideDatos.pideString("What is its email address?");
        String companyName = PideDatos.pideString("What company does he/she work for?");
        Lead lead1 = new Lead(0,name, phoneNumber, email, companyName);
        System.out.println("A new lead has been created with the following data: " + lead1.toString());
        lalista.add(lead1);
        //aqui mostrar lista de leads y pedir el id del salesrep, y meter este contacto en su lista

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
    }    //esta perfect


    public static void convertLead(List<Lead> listaLeads, List<Contact> listaContactos, List<Opportunity> listaOpportunities, int id, List<Account> listaAccounts){

        for (int i = 0; i < listaLeads.size(); i++) {
            int a = listaLeads.get(i).getLeadId();
            if (a == id) {
                Contact contact1 = new Contact(listaLeads.get(i).getName(), listaLeads.get(i).getPhoneNumber(), listaLeads.get(i).getEmail(), listaLeads.get(i).getCompanyName());
                listaContactos.add(contact1);
                System.out.println("The lead " + listaLeads.get(i).getLeadId() + " has been transferred to the contact list.\n");
                Product product = PideDatos.pideProduct();
                int quantity = PideDatos.pideValorMinMaxCamiones(1, 50);
                Opportunity opportunity1 = new Opportunity(contact1, product, quantity);
                listaOpportunities.add(opportunity1);
                System.out.println("The lead " + listaLeads.get(i).getLeadId() + " has been converted to opportunity and added to the list of opportunities, with the following data : " + opportunity1.toString() + ".\n");
                createAccount(listaAccounts);
                listaLeads.remove(i);
            }
        }
    } //


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
        for (int i = 0; i <lista.size(); i++) {
            System.out.println(lista.get(i).getLeadId() + " " + lista.get(i).getName());

        }
        System.out.println();
    } // está ok


    public static void showContacts(List<Contact> listaContacts){
        for (int i = 0; i <listaContacts.size(); i++) {
            System.out.println(listaContacts.get(i).toString());
        }
        System.out.println();
    } // está ok



    public static void showOpportunities(List<Opportunity> listaOpportunities){
        for (int i = 0; i <listaOpportunities.size(); i++) {
            System.out.println(listaOpportunities.get(i).toString());
        }
        System.out.println();
    } // está ok

    public static void showAccounts(List<Account> listaAccounts){
        for (int i = 0; i <listaAccounts.size(); i++) {
            System.out.println(listaAccounts.get(i).toString());
        }
        System.out.println();
    } // está ok

    public static void showSalesReps(List<SalesRep> listaSalesRep){
        for (int i = 0; i <listaSalesRep.size(); i++) {
            System.out.println(listaSalesRep.get(i).toString());
        }
        System.out.println();
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
    }

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
    } //ESTÁ OK




}