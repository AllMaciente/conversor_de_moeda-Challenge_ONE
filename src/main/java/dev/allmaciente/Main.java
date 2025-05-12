package dev.allmaciente;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.allmaciente.models.Coin;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();

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
        String url_str = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", dotenv.get("API_KEY"), baseCurrency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Coin coin = gson.fromJson(response.body(), Coin.class);

        coin.viewOptions();
        System.out.println("Select the currency you want to convert to:");
        int opConvert = scanner.nextInt();
        System.out.println("Enter the amount you want to convert:");
        float amount = scanner.nextFloat();
        switch (opConvert){
            case 1:
                System.out.println(String.format("The amount of %.2f %s is equal to %.2f USD", amount, baseCurrency, coin.exchangeToUSD(amount)));
                break;
            case 2:
                System.out.println(String.format("The amount of %.2f %s is equal to %.2f BRL", amount, baseCurrency, coin.exchangeToBRL(amount)));
                break;
            case 3:
                System.out.println(String.format("The amount of %.2f %s is equal to %.2f CLP", amount, baseCurrency, coin.exchangeToCLP(amount)));
                break;
            case 4:
                System.out.println(String.format("The amount of %.2f %s is equal to %.2f COP", amount, baseCurrency, coin.exchangeToCOP(amount)));
                break;
            case 5:
                System.out.println(String.format("The amount of %.2f %s is equal to %.2f BOB", amount, baseCurrency, coin.exchangeToBOB(amount)));
                break;
            case 6:
                System.out.println(String.format("The amount of %.2f %s is equal to %.2f ARS", amount, baseCurrency, coin.exchangeToARS(amount)));
                break;
            default:
                System.out.println("Invalid selection.");
        }
    }
}