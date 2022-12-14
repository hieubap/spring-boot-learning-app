package spring.boot.core.security;

import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SecretConfiguration {
  @Autowired
  private PropertiesConfiguration propertiesConfiguration;

  @Bean
  public SecretKey secretKey(){
    return Keys.hmacShaKeyFor(propertiesConfiguration.getSecretKey().getBytes());
  }
}
