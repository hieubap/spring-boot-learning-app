package spring.boot.core.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class PropertiesConfiguration {
  private final String secretKey = "spring-security-jwt-token-private-key";
  private final String tokenPrefix= "Bearer";
  private final String authorizationHeader="Authorization";
}
