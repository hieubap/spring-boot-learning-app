package spring.boot.learning.app.service;

import spring.boot.core.api.CoreService;
import spring.boot.learning.app.dto.RegisterDTO;
import spring.boot.learning.app.entity.RegisterEntity;

public interface RegisterService extends CoreService<RegisterDTO, RegisterEntity> {
  boolean checkRegister(Long id);

  Long countByCourseId(Long courseId);
}
