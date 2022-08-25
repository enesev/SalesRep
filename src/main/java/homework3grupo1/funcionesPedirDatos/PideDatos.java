package homework3grupo1.funcionesPedirDatos;

import homework3grupo1.enums.Industry;
import homework3grupo1.enums.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PideDatos {

    public static int pideEntero(String pregunta) {
        System.out.println(pregunta);
        int num = 0;
        boolean repite = true;
        while (repite) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String op = br.readLine();
                num = Integer.parseInt(op);
                repite = false;
            } catch (Exception a) {
                System.err.println("Must be a numeric value. Please, try again.");
            }
        }

        return num;
    }



    public static int pideValorMinMax(int valorMinimo, int valorMaximo) {
        return pideValorMinMax(valorMinimo,valorMaximo,"Enter a value between "+valorMinimo+" and "+valorMaximo);
    }
    public static int pideValorMinMax(int valorMinimo, int valorMaximo, String pregunta) {
        int valor = 0;
        do {
            valor = pideEntero(pregunta);
            if ((valor < valorMinimo) || (valor > valorMaximo)) {
                System.err.println("The value must be between "
                        + valorMinimo + " and " + valorMaximo);
            }
        } while ((valor < valorMinimo) || (valor > valorMaximo));
        return valor;
    }

    public static String pideString(String txt) {
        System.out.println(txt);
        boolean repeat;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            repeat = false;
            try {
                return br.readLine();
            } catch (IOException ex) {
                repeat = true;
            }
        } while (repeat);
        return null;
    }//para que no se puedan poner numeros --> (br.readLine().matches("\\D")); // d --> si los contiene


    public static int pideValorMinMaxCamiones(int valorMinimo, int valorMaximo) {
        return pideValorMinMax(valorMinimo,valorMaximo,"How many trucks does it want to buy? ");
    }
    public static int pideValorMinMaxCamiones(int valorMinimo, int valorMaximo, String pregunta) {
        int valor = 0;
        do {
            valor = pideEntero(pregunta);
            if ((valor < valorMinimo) || (valor > valorMaximo)) {
                System.err.println("The value must be between "
                        + valorMinimo + " and " + valorMaximo);
            }
        } while ((valor < valorMinimo) || (valor > valorMaximo));
        return valor;
    }

    public static int pideValorMinMaxEmpleados(int valorMinimo, int valorMaximo) {
        return pideValorMinMax(valorMinimo,valorMaximo,"How many employees does it have? ");
    }
    public static int pideValorMinMaxEmpleados(int valorMinimo, int valorMaximo, String pregunta) {
        int valor = 0;
        do {
            valor = pideEntero(pregunta);
            if ((valor < valorMinimo) || (valor > valorMaximo)) {
                System.err.println("The value must be between "
                        + valorMinimo + " and " + valorMaximo);
            }
        } while ((valor < valorMinimo) || (valor > valorMaximo));
        return valor;
    }

    public static Product pideProduct(){
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        do {
            try {
                System.out.println("Choose an option between Box, Hybrid or Flatbed");
                String option = scan.nextLine().toUpperCase().trim();

                switch (option) {
                    case "BOX":
                        return Product.BOX;
                    case "HYBRID":
                        return Product.HYBRID;
                    case "FLATBED":
                        return Product.FLATBED;
                    default:
                        System.err.println("You have to select an appropriate option.");
                        exit = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                scan.next();
            }
        } while (!exit);
        return pideProduct();
    } //ESTÁ PERFECT!

    public static Industry pideIndustry(){
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        do {
            try {
                System.out.println("In which sector does the company work? Choose an option between PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER");
                String option = scan.nextLine().toUpperCase().trim();

                switch (option) {
                    case "PRODUCE":
                        System.out.println("PRODUCE selected.");
                        return Industry.PRODUCE;
                    case "ECOMMERCE":
                        System.out.println("ECOMMERCE selected.");
                        return Industry.ECOMMERCE;
                    case "MANUFACTURING":
                        System.out.println("MANUFACTURING selected.");
                        return Industry.MANUFACTURING;
                    case "MEDICAL":
                        System.out.println("MEDICAL selected.");
                        return Industry.MEDICAL;
                    case "OTHER":
                        System.out.println("OTHER selected.");
                        return Industry.OTHER;
                    default:
                        System.err.println("Error. Choose one of the indicated options.");
                        exit = true;
                }
            } catch (Exception e) {
                System.err.println("Numbers are not allowed in this camp. Please, enter a text.");
                e.printStackTrace();
                scan.next();
            }
        } while (!exit);
        return pideIndustry();
    }


}
