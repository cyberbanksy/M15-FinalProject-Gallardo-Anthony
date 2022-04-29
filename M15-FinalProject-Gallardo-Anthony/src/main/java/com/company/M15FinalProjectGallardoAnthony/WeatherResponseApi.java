package com.company.M15FinalProjectGallardoAnthony;

import com.company.M15FinalProjectGallardoAnthony.weather.WeatherResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WeatherResponseApi {

	public static void main(String[] args) {
		//SpringApplication.run(M15FinalProjectGallardoAnthonyApplication.class, args);

		WebClient client = WebClient.create("https://api.openweathermap.org/data/2.5/weather?q=Irvine&appid=3953adf3d398184ad92cc5e29db4ca97&units=imperial");
		WeatherResponse weatherResponse = null;
		try {
			Mono<WeatherResponse> response = client
					.get()
					.retrieve()
					.bodyToMono(WeatherResponse.class);

			weatherResponse = response.share().block();
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

		if (weatherResponse != null){
			System.out.println(weatherResponse.main.temp);
		}
	}
}

