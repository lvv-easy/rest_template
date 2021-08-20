package jm.rest_template;

import jm.rest_template.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);

        final String url = "http://91.241.64.178:7081/api/users";

        RestTemplate template = new RestTemplate();
        HttpEntity<String> response = template.getForEntity(url, String.class);
        HttpHeaders headers = response.getHeaders();
        String cookie = headers.getFirst(headers.SET_COOKIE);
            System.out.println("Response: " + response.toString() + "\n");
            System.out.println("Set-Cookie: " + cookie + "\n");

        //
        User user = new User(3, "James", "Brown", (byte) 30);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Cookie", cookie);

        HttpEntity requestEntity = new HttpEntity(user, requestHeaders);
        response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String code1 = response.getBody();
            System.out.println(code1);
        //

            user.setName("Thomas");
            user.setLastName("Shelby");
        requestEntity = new HttpEntity(user, requestHeaders);

        response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String code2 = response.getBody();
            System.out.println(code1 + code2);

        //
        requestEntity = new HttpEntity(user, requestHeaders);

        response = restTemplate.exchange(url + "/3", HttpMethod.DELETE, requestEntity, String.class);
        String code3 = response.getBody();
        String codeF = code1 + code2 + code3;
            System.out.println(codeF);

    }
}
