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
import java.util.Optional;
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
	public void saveAccount(Account account){
		accountRepository.save(account);
	}
	@Autowired
	OpportunityRepository opportunityRepository;
	public void saveOpportunity(Opportunity opportunity){
		opportunityRepository.save(opportunity);
	}



	public static void main(String[] args) {
		SpringApplication.run(Homework3Grupo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

////////////////////////////////////// HERE WE CREATE SOME LISTS, LEADS, OPPORTUNITIES, ACCOUNTS, CONTACTS, SALESREPS IN ORDER TO MAKE THE QUERYS EASIER TO USE ///////////////////////////////////////////////////

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




		Account account1 = new Account(Industry.ECOMMERCE, 478, "Arkansas", "EEUU", new ArrayList<Contact>(), new ArrayList<Opportunity>());
		accountRepository.save(account1);
		Account account2 = new Account(Industry.ECOMMERCE, 5321, "Barcelona", "Spain", new ArrayList<Contact>(), new ArrayList<Opportunity>());
		accountRepository.save(account2);
		Account account3 = new Account(Industry.MEDICAL, 554, "Barcelona", "Spain", new ArrayList<Contact>(), new ArrayList<Opportunity>());
		accountRepository.save(account3);
		Account account4 = new Account(Industry.PRODUCE, 3321, "Barcelona", "Spain", new ArrayList<Contact>(), new ArrayList<Opportunity>());
		accountRepository.save(account4);
		Account account5 = new Account(Industry.OTHER, 772, "Barcelona", "Spain", new ArrayList<Contact>(), new ArrayList<Opportunity>());
		accountRepository.save(account5);





		SalesRep salesRep1 = new SalesRep("Vendedor1", new ArrayList<Opportunity>(), new ArrayList<Leads>());
		salesRepRepository.save(salesRep1);
		SalesRep salesRep2 = new SalesRep("Vendedor2", new ArrayList<Opportunity>(), new ArrayList<Leads>());
		salesRepRepository.save(salesRep2);
		SalesRep salesRep3 = new SalesRep("Vendedor3", new ArrayList<Opportunity>(), new ArrayList<Leads>());
		salesRepRepository.save(salesRep3);
		SalesRep salesRep4 = new SalesRep("Vendedor4", new ArrayList<Opportunity>(), new ArrayList<Leads>());
		salesRepRepository.save(salesRep4);
		SalesRep salesRep5 = new SalesRep("Vendedor5", new ArrayList<Opportunity>(), new ArrayList<Leads>());
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


		account1.addOpportunityList(opportunity1);
		account1.addContactList(contact1);
		accountRepository.save(account1);
		account2.addOpportunityList(opportunity2);
		account2.addContactList(contact2);
		accountRepository.save(account2);
		account3.addOpportunityList(opportunity3);
		account3.addContactList(contact3);
		accountRepository.save(account3);
		account4.addOpportunityList(opportunity4);
		account4.addContactList(contact4);
		accountRepository.save(account4);
		account5.addOpportunityList(opportunity5);
		account5.addContactList(contact5);
		accountRepository.save(account5);


		salesRep1.addLeadToSalesRepList(lead1);
		salesRep1.addOpportunityListToSalesRep(opportunity1);
		salesRepRepository.save(salesRep1);
		salesRep2.addLeadToSalesRepList(lead2);
		salesRep2.addOpportunityListToSalesRep(opportunity2);
		salesRepRepository.save(salesRep2);
		salesRep3.addLeadToSalesRepList(lead3);
		salesRep3.addOpportunityListToSalesRep(opportunity3);
		salesRepRepository.save(salesRep3);
		salesRep4.addLeadToSalesRepList(lead4);
		salesRep4.addOpportunityListToSalesRep(opportunity4);
		salesRepRepository.save(salesRep4);
		salesRep5.addLeadToSalesRepList(lead5);
		salesRep5.addOpportunityListToSalesRep(opportunity5);
		salesRepRepository.save(salesRep5);


		lead1.setSalesRepLead(salesRep1);
		leadRepository.save(lead1);
		lead2.setSalesRepLead(salesRep2);
		leadRepository.save(lead2);
		lead3.setSalesRepLead(salesRep3);
		leadRepository.save(lead3);
		lead4.setSalesRepLead(salesRep4);
		leadRepository.save(lead4);
		lead5.setSalesRepLead(salesRep5);
		leadRepository.save(lead5);


		contact1.setAccount(account1);
		contact1.setOpportunity(opportunity1);
		contactRepository.save(contact1);

		contact2.setAccount(account2);
		contact2.setOpportunity(opportunity2);
		contactRepository.save(contact2);

		contact3.setAccount(account3);
		contact3.setOpportunity(opportunity3);
		contactRepository.save(contact3);

		contact4.setAccount(account4);
		contact4.setOpportunity(opportunity4);
		contactRepository.save(contact4);

		contact5.setAccount(account5);
		contact5.setOpportunity(opportunity5);
		contactRepository.save(contact5);






//////////////////////////////////////////////  HERE STARTS OUR PROJECT   ////////////////////////////////////////////////////////////////////////////

		

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

					case "convert id":
						List<Leads> listaCConvert = leadRepository.findAll();
						Leads.showLeads(leadRepository.findAll());

						if (listaCConvert.size() == 0) {
							System.err.println("Currently our systems don't have any Leads in the database.");
							} else {
								int id = PideDatos.pideEntero("Select the Lead's ID you want to convert.");
								for (int q = 0; q < listaCConvert.size(); q++) {
									Long b = listaCConvert.get(q).getLeadId();
									if (b == id) {
										Leads leadConvert = listaCConvert.get(q);

										Contact contactNew = Leads.convertLead_fase1(leadRepository.findAll(), contactRepository.findAll(), id);
										contactRepository.save(contactNew);
										//,
										Opportunity opportunityNew = Leads.convertLead_fase2(contactNew, opportunityRepository.findAll());
										opportunityRepository.save(opportunityNew);

										Account accountNew = Leads.convertLead_fase3(contactNew, opportunityNew, accountRepository.findAll());
										accountRepository.save(accountNew);

										leadRepository.delete(leadConvert);

									} else {
										System.err.println("This ID doesn't exist."); break;
									}
								}
						}

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

					case ("statistics"):
						System.err.println("Service under construction.");
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













}

