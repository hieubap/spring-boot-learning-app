package spring.boot.learning.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.CourseDTO;
import spring.boot.learning.app.entity.AccountEntity;
import spring.boot.learning.app.entity.CategoryEntity;
import spring.boot.learning.app.entity.CourseEntity;

@Service
public class CourseServiceImpl
    extends CoreServiceImpl<CourseDTO, CourseEntity> implements CourseService {
  @Autowired
  private RegisterService registerService;

  @Autowired
  private CommentService commentService;
  @Autowired
  private AccountService accountService;

  @Autowired
  private CategoryService categoryService;

  @Override
  public CourseDTO mapToDTO(CourseEntity entity) {
    CourseDTO courseDTO = super.mapToDTO(entity);
    courseDTO.setNumberStudent(
        registerService.countByCourseId(entity.getId())
    );
    courseDTO.setNumberComment(
        commentService.countByCourseId(entity.getId())
    );
    AccountEntity accountEntity = accountService.getById(courseDTO.getCreatedBy());
    if(accountEntity != null){
      courseDTO.setAuthor(accountEntity.getFullName());
      courseDTO.setStk(accountEntity.getStk());
      courseDTO.setNganHang(accountEntity.getNganHang());
      courseDTO.setChuTaiKhoan(accountEntity.getChuTaiKhoan());
    }
    if(entity.getCategoryId() != null){
      CategoryEntity categoryEntity = categoryService.getById(entity.getCategoryId());
      courseDTO.setCategoryName(categoryEntity.getName());
    }
    if(entity.getLevel() != null){
      if(entity.getLevel()==1){
        courseDTO.setLevelName("Beginner");
      }else if(entity.getLevel()==2){
        courseDTO.setLevelName("Intermediate");
      }else if(entity.getLevel()==3){
        courseDTO.setLevelName("Advanced");
      }
    }
    return courseDTO;
  }
}
