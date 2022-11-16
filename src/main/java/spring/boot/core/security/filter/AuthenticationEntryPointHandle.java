package spring.boot.core.security.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import spring.boot.core.api.ResponseDTO;
import spring.boot.core.msg.Message;
import spring.boot.core.utils.ResponseUtil;

@Component
public final class AuthenticationEntryPointHandle implements
    AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest request,
      HttpServletResponse httpServletResponse, AuthenticationException e)
      throws IOException {
    ResponseDTO response = new ResponseDTO(401,
        Message.getMessage("AuthenticationEntryPointImpl.invalidToken"));

    ResponseUtil.writeResponse(HttpStatus.UNAUTHORIZED, httpServletResponse,
        ResponseUtil.convertObjectToJson(response));
  }
}
