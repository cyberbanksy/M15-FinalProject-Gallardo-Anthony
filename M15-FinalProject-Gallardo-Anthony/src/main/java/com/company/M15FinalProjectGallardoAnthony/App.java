package com.company.M15FinalProjectGallardoAnthony;
import com.company.M15FinalProjectGallardoAnthony.crypto.CryptoResponse;
import com.company.M15FinalProjectGallardoAnthony.iss.IssResponse;
import com.company.M15FinalProjectGallardoAnthony.weather.WeatherResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Scanner;

public class App {
    public static void errorMessage(String msg) {
        System.out.println("an error has occurred. + msg");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String[] numbers = new String[5];
        String userIn;
        int choice = 0;

        do {
            System.out.println("Weather, Crypto & ISS");
            System.out.println("1 to check weather.");
            System.out.println("2 to check ISS cords.");
            System.out.println("3 ISS Weather.");
            System.out.println("4 Check crypto price.");
            System.out.println("5 to exit the program.");
            System.out.println("Please make a choice buy entering a number: ");
            userIn = scanner.nextLine();


            try {
                choice = Integer.parseInt(userIn);

                switch(choice){
                    case 1:
                        System.out.println("Please enter a city that you want to check the weather at? ");
                        String cityName = scanner.nextLine();
                        String searchUrl = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=3953adf3d398184ad92cc5e29db4ca97&units=imperial",cityName);
                        WeatherResponse weatherData = WeatherResponseApi.weatherCheck(searchUrl);
                        if (weatherData != null){
                            System.out.println(weatherData.main.temp);
                            System.out.println(weatherData.weather.get(0).description);
                        }
                        break;
                    case 2:
                        //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
                        System.out.println("Locating the ISS... ");
                        IssResponse issReturn = IssResponseApi.issCheck();
                        if (issReturn != null){
                            String searchWeb = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=3953adf3d398184ad92cc5e29db4ca97&units=imperial",issReturn.iss_position.latitude,issReturn.iss_position.longitude);
                            WeatherResponse issLocation = WeatherResponseApi.weatherCheck(searchWeb);
                            System.out.println("Latitude: " + issReturn.iss_position.latitude+ " Longitude: "+ issReturn.iss_position.longitude);
                            if (issLocation.sys.country == null) {
                                System.out.println("ISS is not in a country!");
                            }
                            else {
                                System.out.println(issLocation.name +"," + issLocation.sys.country);
                            }
                        }
                        break;
                    case 3:
                        //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
                        System.out.println("Here is the ISS weather!");
                        IssResponse issBack = IssResponseApi.issCheck();
                        if (issBack != null){
                            String searchLink = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=3953adf3d398184ad92cc5e29db4ca97&units=imperial",issBack.iss_position.latitude,issBack.iss_position.longitude);
                            WeatherResponse issLocation = WeatherResponseApi.weatherCheck(searchLink);
                            System.out.println(" Latitude: " + issBack.iss_position.latitude + " Longitude: "+ issBack.iss_position.longitude);
                            if (issLocation != null) {
                                if (issLocation.sys.country == null) {
                                    System.out.println("ISS is not in a country!");
                                } else {
                                    System.out.println(issLocation.name + "," + issLocation.sys.country);
                                }
                                System.out.println(issLocation.main.temp);
                                System.out.println(issLocation.weather.get(0).description);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Enter a crypto coin ticker to check the price: ");
                        String tickerName = scanner.nextLine();
                        CryptoResponse cryptoCheck = CryptoResponseApi.cryptoCheck(tickerName);
                        if (cryptoCheck != null){
                            System.out.println(cryptoCheck.name);
                            System.out.println(cryptoCheck.asset_id);
                            System.out.format("$%.2f\n", cryptoCheck.price_usd);
                        }
                        break;

                    case 5:
                        System.out.println("Program is exiting");
                        //end program
                        break;
                    default:
                        System.out.println("You entered an invalid number. You must enter a number between 1 and 5. Goodbye.");

                        // repeat for options

                }

            } catch (Exception e) {
                System.out.println("an error occurred" + e.getMessage());
            }
        }
        while (choice != 5);


    }
}
