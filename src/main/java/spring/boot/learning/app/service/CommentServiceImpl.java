package spring.boot.learning.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.CommentDTO;
import spring.boot.learning.app.entity.CommentEntity;
import spring.boot.learning.app.repository.CommentRepository;

@Service
public class CommentServiceImpl
    extends CoreServiceImpl<CommentDTO, CommentEntity> implements CommentService {
  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private AccountService accountService;

  @Override
  public Long countByCourseId(Long courseId) {
    return commentRepository.countByCourseId(courseId);
  }

  @Override
  public CommentDTO mapToDTO(CommentEntity entity) {
    CommentDTO commentDTO = super.mapToDTO(entity);
    commentDTO.setUser(accountService.getUserDTO(entity.getUserId()));
    return commentDTO;
  }
}
