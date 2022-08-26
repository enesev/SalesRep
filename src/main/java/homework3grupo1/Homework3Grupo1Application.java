package homework3grupo1;

import homework3grupo1.enums.Industry;
import homework3grupo1.enums.Product;
import homework3grupo1.enums.Status;
import homework3grupo1.funcionesPedirDatos.PideDatos;
import homework3grupo1.funcionesPedirDatos.subMenu;
import homework3grupo1.models.*;
import homework3grupo1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Homework3Grupo1Application implements CommandLineRunner {

	@Autowired
	LeadRepository leadRepository;

	@Autowired
	SalesRepRepository salesRepRepository;

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	OpportunityRepository opportunityRepository;



	public static void main(String[] args) {
		SpringApplication.run(Homework3Grupo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Leads> listaDeLeads = new ArrayList<>();

		List<Contact> listaContactos = new ArrayList<>();

		List<Opportunity> listaOpportunities = new ArrayList<>();

		List<Account> listaAccounts = new ArrayList<>();

		List<SalesRep> listaSalesRep = new ArrayList<>();



		Leads lead1 = new Leads("Sergio", 652325489, "sergio@sergio", "Microsoft");
		leadRepository.save(lead1);
		Leads lead2 = new Leads("Antonio", 456789123, "antonio@antonio", "Dropbox");
		leadRepository.save(lead2);
		Leads lead3 = new Leads("Anna", 123456789, "anna@anna", "CloudService");
		leadRepository.save(lead3);
		Leads lead4 = new Leads("Darwin", 741852963, "darwin@darwin", "Microsoft");
		leadRepository.save(lead4);
		Leads lead5 = new Leads("Karim", 147258369, "karim@karim", "Microsoft");
		leadRepository.save(lead5);


		Contact contact1 = new Contact("Sergio",652325489, "sergio@sergio", "Microsoft");
		contactRepository.save(contact1);
		Contact contact2 = new Contact("Antonio", 456789123, "antonio@antonio", "Dropbox");
		contactRepository.save(contact2);
		Contact contact3 = new Contact("Anna", 123456789, "anna@anna", "CloudService");
		contactRepository.save(contact3);
		Contact contact4 = new Contact("Darwin", 741852963, "darwin@darwin", "Microsoft");
		contactRepository.save(contact4);
		Contact contact5 = new Contact("Karim", 147258369, "karim@karim", "Microsoft");
		contactRepository.save(contact5);




		Account account1 = new Account(Industry.ECOMMERCE, 478, "Arkansas", "EEUU", listaContactos, listaOpportunities);
		accountRepository.save(account1);
		Account account2 = new Account(Industry.ECOMMERCE, 5321, "Barcelona", "Spain", listaContactos, listaOpportunities);
		accountRepository.save(account2);
		Account account3 = new Account(Industry.MEDICAL, 554, "Barcelona", "Spain", listaContactos, listaOpportunities);
		accountRepository.save(account3);
		Account account4 = new Account(Industry.PRODUCE, 3321, "Barcelona", "Spain", listaContactos, listaOpportunities);
		accountRepository.save(account4);
		Account account5 = new Account(Industry.OTHER, 772, "Barcelona", "Spain", listaContactos, listaOpportunities);
		accountRepository.save(account5);





		SalesRep salesRep1 = new SalesRep("Vendedor1", listaOpportunities, listaDeLeads);
		salesRepRepository.save(salesRep1);
		SalesRep salesRep2 = new SalesRep("Vendedor2", listaOpportunities, listaDeLeads);
		salesRepRepository.save(salesRep2);
		SalesRep salesRep3 = new SalesRep("Vendedor3", listaOpportunities, listaDeLeads);
		salesRepRepository.save(salesRep3);
		SalesRep salesRep4 = new SalesRep("Vendedor4", listaOpportunities, listaDeLeads);
		salesRepRepository.save(salesRep4);
		SalesRep salesRep5 = new SalesRep("Vendedor5", listaOpportunities, listaDeLeads);
		salesRepRepository.save(salesRep5);


		Opportunity opportunity1 = new Opportunity(contact1, Product.BOX, 50, salesRep1);
		opportunityRepository.save(opportunity1);
		Opportunity opportunity2 = new Opportunity(contact2, Product.FLATBED, 45, salesRep2);
		opportunityRepository.save(opportunity2);
		Opportunity opportunity3 = new Opportunity(contact3, Product.HYBRID, 33, salesRep3);
		opportunityRepository.save(opportunity3);
		Opportunity opportunity4 = new Opportunity(contact4, Product.BOX, 37, salesRep4);
		opportunityRepository.save(opportunity4);
		Opportunity opportunity5 = new Opportunity(contact5, Product.BOX, 47, salesRep5);
		opportunityRepository.save(opportunity5);




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		

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
						"Statistics \n" +
						"Exit \n");
				String option = scan.nextLine().toLowerCase().trim();

				switch (option){

					case "new lead":
						Leads leadNew = Leads.createNewLead(salesRepRepository.findAll());
						leadRepository.save(leadNew);
						Leads.addSalesRepToLead(salesRepRepository.findAll(), leadNew);
						leadRepository.save(leadNew);

						break;

					case "new salesrep":
						SalesRep newSalesRep = SalesRep.createNewSalesRep();
						salesRepRepository.save(newSalesRep);


						break;

					case "show leads":
						Leads.showLeads(leadRepository.findAll());

						break;

					case "lookup lead id":
						Leads.lookupLeadId(leadRepository.findAll());
						break;

					case "convert id": //TODO --> ACABAR ESTO. HACERLO COMO EL CLOSE-LOST PARA QUE NO DE ERRORES AL ELIMINAR ALGUIEN DE LA LISTA
						int id = PideDatos.pideEntero("Select a lead's id to convert it to contact.");
						convertLead(listaDeLeads, listaContactos, listaOpportunities, id, listaAccounts, listaSalesRep);

						break;

					case "show contacts":
						Contact.showContacts(contactRepository.findAll());

						break;

					case "show opportunities":
						Opportunity.showOpportunities(opportunityRepository.findAll());
						break;

					case "show accounts":
						Account.showAccounts(accountRepository.findAll());
						break;

					case "show salesreps":
						SalesRep.showSalesReps(salesRepRepository.findAll());;
						break;

					case "close-lost id":
						Opportunity opportunityLost = Opportunity.closeLostId(opportunityRepository.findByStatus(Status.OPEN));
						opportunityRepository.save(opportunityLost);
						break;

					case "close-won id":
						Opportunity opportunityWon = Opportunity.closeWonId(opportunityRepository.findByStatus(Status.OPEN));
						opportunityRepository.save(opportunityWon);
						break;
					case "statistics": //TODO --> HACER QUERYS
						subMenu.statistics();
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




	public static void convertLead(List<Leads> listaLeads, List<Contact> listaContactos, List<Opportunity> listaOpportunities, int id, List<Account> listaAccounts, List<SalesRep> listaSalesRep){
		//we check to see if the arraylist is empty, so we can display the proper message
		if (listaLeads.size() == 0) {
			System.err.println("Currently our systems don't have any Leads in the database.");
		}
		//otherwise, we proceed to print out all of the leads in the system.
		else {
			for (int i = 0; i < listaLeads.size(); i++) {
				Long a = listaLeads.get(i).getLeadId();
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
										Account.showAccounts(listaAccounts);
										boolean found = false;
										do {
											int accountId = PideDatos.pideEntero("Select an account id.");
											for (int q = 0; q < listaAccounts.size(); q++) {
												Long b = listaAccounts.get(q).getAccountId();
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








}

