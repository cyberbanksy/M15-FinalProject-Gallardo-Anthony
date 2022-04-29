package com.company.M15FinalProjectGallardoAnthony;

import com.company.M15FinalProjectGallardoAnthony.crypto.CryptoResponse;
import com.company.M15FinalProjectGallardoAnthony.weather.WeatherResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

    @SpringBootApplication
    public class CryptoResponseApi {

        public static void main(String[] args) {
            //SpringApplication.run(M15FinalProjectGallardoAnthonyApplication.class, args);

            WebClient client = WebClient.create("https://rest.coinapi.io/v1/assets/ETH?apikey=C3611BC9-3432-4DEB-B827-692780ADD2B3");
            CryptoResponse cryptoResponse = null;
            try {
                Mono <CryptoResponse[]> response = client
                        .get()
                        .retrieve()
                        .bodyToMono(CryptoResponse[].class);

                cryptoResponse = response.share().block()[0];
            }
            catch (WebClientResponseException we) {
                int statusCode = we.getRawStatusCode();
                if (statusCode >= 400 && statusCode <500){
                    System.out.println("Client Error");
                }
                else if (statusCode >= 500 && statusCode <600){
                    System.out.println("Server Error");
                }
                System.out.println("Message: " + we.getMessage());
            }
            catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            if (cryptoResponse != null){
                System.out.println(cryptoResponse.price_usd);
            }
        }
    }
