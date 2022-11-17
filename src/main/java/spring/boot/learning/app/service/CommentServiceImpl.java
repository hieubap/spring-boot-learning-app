package spring.boot.learning.app.service;

import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.CommentDTO;
import spring.boot.learning.app.entity.CommentEntity;

@Service
public class CommentServiceImpl
    extends CoreServiceImpl<CommentDTO, CommentEntity> implements CommentService {

}
