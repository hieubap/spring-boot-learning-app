package spring.boot.learning.app.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.CourseDTO;
import spring.boot.learning.app.dto.RegisterDTO;
import spring.boot.learning.app.entity.AccountEntity;
import spring.boot.learning.app.entity.CourseEntity;
import spring.boot.learning.app.entity.RegisterEntity;
import spring.boot.learning.app.repository.RegisterRepository;

@Service
public class RegisterServiceImpl
    extends CoreServiceImpl<RegisterDTO, RegisterEntity> implements RegisterService {
  @Autowired
  private RegisterRepository registerRepository;

  @Autowired
  private AccountService accountService;

  @Autowired
  private CourseService courseService;

  @Override
  public Map<String, Object> checkRegister(Long id) {
    RegisterEntity registerEntity = registerRepository.findByCourseIdAndStudentId(id,
        accountService.getCurrentUserId());
    Map<String,Object> output = new HashMap<>();
    output.put("isRegister", registerEntity != null);
    output.put("id", registerEntity != null ? registerEntity.getId() : null);
    output.put("approve", registerEntity != null ? registerEntity.getApprove() : null);
    return output;
  }

  @Override
  protected void beforeSave(RegisterEntity entity, RegisterDTO dto) {
    if(entity.getId() == null){
      entity.setStudentId(accountService.getCurrentUserId());
      entity.setAuthorId(courseService.getById(entity.getCourseId()).getCreatedBy());
    }
  }

  @Override
  public Long countByCourseId(Long courseId) {
    return registerRepository.countByCourseId(courseId);
  }


  @Override
  public RegisterDTO mapToDTO(RegisterEntity entity) {
    RegisterDTO courseDTO = super.mapToDTO(entity);
    courseDTO.setCourseName(
        courseService.getById(entity.getCourseId()).getName()
    );
    courseDTO.setStudentName(
        accountService.getById(entity.getStudentId()).getFullName()
    );
    return courseDTO;
  }
}
