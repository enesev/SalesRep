package homework3grupo1.funcionesPedirDatos;

import homework3grupo1.models.Leads;
import homework3grupo1.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class subMenu {


    public static void statistics() {
        boolean exit = false;
        do{
            try{
                System.out.println("Welcome to the Statistics section of our app");

                System.out.println("Chose one option between these groups: \n" +
                        "-By SalesRep \n" +
                                "   · Report Lead by SalesRep \n"+
                                "   · Report Opportunity by SalesRep\n" +
                                "   · Report CLOSED-WON by SalesRep\n" +
                                "   · Report CLOSED-LOST by SalesRep\n" +
                                "   · Report OPEN by SalesRep\n"+

                        "-By Product \n" +
                                "   · Report Opportunity by the product\n"+
                                "   · Report CLOSED-WON by the product\n" +
                                "   · Report CLOSED-LOST by the product\n" +
                                "   · Report OPEN by the product\n" +

                        "-By Country \n" +
                                "   · Report Opportunity by Country\n"+
                                "   · Report CLOSED-WON by Country\n" +
                                "   · Report CLOSED-LOST by Country\n" +
                                "   · Report OPEN by the Country\n" +

                        "-By City \n" +
                                "   · Report Opportunity by City\n"+
                                "   · Report CLOSED-WON by City\n" +
                                "   · Report CLOSED-LOST by City\n" +
                                "   · Report OPEN by the City\n" +

                        "-By Industry \n" +
                                "   · Report Opportunity by Industry\n"+
                                "   · Report CLOSED-WON by Industry\n" +
                                "   · Report CLOSED-LOST by Industry\n" +
                                "   · Report OPEN by the Industry\n" +

                        "-EmployeeCountStates \n" +
                                "   · Mean EmployeeCount\n"+
                                "   · Median EmployeeCount\n"+
                                "   · Max EmployeeCount\n"+
                                "   · Min EmployeeCount\n"+

                        "-Quantity States \n" +
                                "   · Mean Quantity\n"+
                                "   · Median Quantity\n"+
                                "   · Max Quantity\n"+
                                "   · Min Quantity\n"+

                        "-Opportunity States \n" +
                                "   · Mean Opps per Account\n"+
                                "   · Median Opps per Account\n"+
                                "   · Max Opps per Account\n"+
                                "   · Min Opps per Account\n"+

                        "-Exit statistics \n");
                String answer = PideDatos.pideString("").trim();

                switch (answer){

                    case "Report Lead by SalesRep":
                        System.out.println("Enhorabuena, esto funciona");
                        break;
                    case "Report Opportunity by SalesRep":
                        //ksnlfs
                        break;
                    case "Report CLOSED-WON by SalesRep":
                        //sfdfsd
                        break;
                    case "Report CLOSED-LOST by SalesRep":
                        //ksnlfs
                        break;
                    case "Report OPEN by SalesRep":
                        //sdsd
                        break;

                    //Hasta aquí los by salesrep

                    case "Report Opportunity by the product":
                        //ksnlfs
                        break;
                    case "Report CLOSED-WON by the product":
                        //ksnlfs
                        break;
                    case "Report CLOSED-LOST by the product":
                        //ksnlfs
                        break;
                    case "Report OPEN by the product":
                        //ksnlfs
                        break;

                    //Hasta aquí los by opportunity

                    case "Report Opportunity by Country":
                        //ksnlfs
                        break;
                    case "Report CLOSED-WON by Country":
                        //ksnlfs
                        break;
                    case "Report CLOSED-LOST by Country":
                        //ksnlfs
                        break;
                    case "Report OPEN by the Country":
                        //ksnlfs
                        break;

                    //hasta aquí los by country
                    case "Report Opportunity by City":
                        //ksnlfs
                        break;
                    case "Report CLOSED-WON by City":
                        //ksnlfs
                        break;
                    case "Report CLOSED-LOST by City":
                        //ksnlfs
                        break;
                    case "Report OPEN by the City":
                        //ksnlfs
                        break;

                    //hasta aquí los by city
                    case "Report Opportunity by Industry":
                        //ksnlfs
                        break;
                    case "Report CLOSED-WON by Industry":
                        //ksnlfs
                        break;
                    case "Report CLOSED-LOST by Industry":
                        //ksnlfs
                        break;
                    case "Report OPEN by the Industry":
                        //ksnlfs
                        break;

                    //hasta aquí los by industry

                    case "Mean EmployeeCount":
                        //ksnlfs
                        break;
                    case "Median EmployeeCount":
                        //ksnlfs
                        break;
                    case "Max EmployeeCount":
                        //ksnlfs
                        break;
                    case "Min EmployeeCount":
                        //ksnlfs
                        break;

                    // hasta aquí los by employeecount

                    case "Mean Quantity":
                        //ksnlfs
                        break;
                    case "Median Quantity":
                        //ksnlfs
                        break;
                    case "Max Quantity":
                        //ksnlfs
                        break;
                    case "Min Quantity":
                        //ksnlfs
                        break;
                    // hasta aquí los by quantity states

                    case "Mean Opps per Account":
                        //ksnlfs
                        break;
                    case "Median Opps per Account":
                        //ksnlfs
                        break;
                    case "Max Opps per Account":
                        //ksnlfs
                        break;
                    case "Min Opps per Account":
                        //ksnlfs
                        break;

                    // hasta aquí los by opportunity states
                    case "Exit statistics":
                        System.out.println("You have returned to the main menu");
                        exit = true;
                        break;

                    default:
                        System.err.println("You have to select an appropriate option. Be careful with the UpperCase. Try again.");
                }
            }catch (Exception e){
                e.printStackTrace();
                //scan.next();
            }
        }while (!exit);
    }
}
