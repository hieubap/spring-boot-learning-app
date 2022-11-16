package spring.boot.core.security.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import spring.boot.core.api.ResponseDTO;
import spring.boot.core.msg.Message;
import spring.boot.core.utils.ResponseUtil;

@Component
public class AccessDeniedHandle implements AccessDeniedHandler {

  @Override
  public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
      AccessDeniedException e) throws IOException {
    ResponseDTO response = new ResponseDTO(403, Message
        .getMessage("AccessDeniedHandle.handleAccessDeniedException"));

    ResponseUtil.writeResponse(HttpStatus.OK,httpServletResponse,
        ResponseUtil.convertObjectToJson(response));

  }
}
