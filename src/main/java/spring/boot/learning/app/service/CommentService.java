package spring.boot.learning.app.service;

import spring.boot.core.api.CoreService;
import spring.boot.learning.app.dto.CommentDTO;
import spring.boot.learning.app.entity.CommentEntity;

public interface CommentService extends CoreService<CommentDTO, CommentEntity> {

}
