package dev.allmaciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Currency Converter!");
        System.out.println("==================================");
        System.out.println("1) USD  : United States Dollar");
        System.out.println("2) BRL  : Brazilian Real");
        System.out.println("3) CLP  : Chilean Peso");
        System.out.println("4) COP  : Colombian Peso");
        System.out.println("5) BOB  : Bolivian Boliviano");
        System.out.println("6) ARS  : Argentine Peso");
        System.out.println("==================================");
        System.out.println("Select the currency you want to convert from:");
        int opCurrency = scanner.nextInt();
        String baseCurrency = "";
        switch (opCurrency){
            case 1:
                System.out.println("You selected USD");
                baseCurrency = "USD";
                break;
            case 2:
                System.out.println("You selected BRL");
                baseCurrency = "BRL";
                break;
            case 3:
                System.out.println("You selected CLP");
                baseCurrency = "CLP";
                break;
            case 4:
                System.out.println("You selected COP");
                baseCurrency = "COP";
                break;
            case 5:
                System.out.println("You selected BOB");
                baseCurrency = "BOB";
                break;
            case 6:
                System.out.println("You selected ARS");
                baseCurrency = "ARS";
                break;
            default:
                System.out.println("Invalid selection.");
        }
        System.out.println(baseCurrency);
    }
}