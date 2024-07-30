package usuario_service.usuario_service.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {


    //Creacion de la configuracion
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }




}
