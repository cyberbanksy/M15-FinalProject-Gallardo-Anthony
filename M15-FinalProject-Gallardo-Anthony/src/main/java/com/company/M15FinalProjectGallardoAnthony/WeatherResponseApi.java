package com.company.M15FinalProjectGallardoAnthony;

import com.company.M15FinalProjectGallardoAnthony.weather.WeatherResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WeatherResponseApi {

	public static WeatherResponse weatherCheck(String url) {
		//SpringApplication.run(M15FinalProjectGallardoAnthonyApplication.class, args);
		//https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
		WebClient client = WebClient.create(url);
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
		return weatherResponse;
	}
}

