package pl.sda.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PokemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonApplication.class, args);
    }


//    @Bean
//    public RestTemplateBuilder restTemplate() {
////        CloseableHttpClient httpClient
////                = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
////                .build();
////        HttpComponentsClientHttpRequestFactory requestFactory
////                = new HttpComponentsClientHttpRequestFactory();
////        requestFactory.setHttpClient(httpClient);
//
//        //return new RestTemplateBuilder().requestFactory(requestFactory).build();
//        return new RestTemplateBuilder();
//    }

    //todo
    //add post request to add new custom pokemon
    //add exception handling when we ask for id where pokemon does not exist
    //add simple security
    //use logger!!!

}
