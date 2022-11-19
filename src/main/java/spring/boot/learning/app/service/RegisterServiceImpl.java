package spring.boot.learning.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.RegisterDTO;
import spring.boot.learning.app.entity.RegisterEntity;
import spring.boot.learning.app.repository.RegisterRepository;

@Service
public class RegisterServiceImpl
    extends CoreServiceImpl<RegisterDTO, RegisterEntity> implements RegisterService {
  @Autowired
  private RegisterRepository registerRepository;

  @Autowired
  private AccountService accountService;

  @Override
  public boolean checkRegister(Long id) {
    return registerRepository.existsByCourseIdAndStudentId(id, accountService.getCurrentUserId());
  }

  @Override
  protected void beforeSave(RegisterEntity entity, RegisterDTO dto) {
    if(entity.getId() == null){
      entity.setStudentId(accountService.getCurrentUserId());
    }
  }

  @Override
  public Long countByCourseId(Long courseId) {
    return registerRepository.countByCourseId(courseId);
  }
}
