package spring.boot.learning.app.service;

import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.CourseDTO;
import spring.boot.learning.app.entity.CourseEntity;

@Service
public class CourseServiceImpl
    extends CoreServiceImpl<CourseDTO, CourseEntity> implements CourseService {

}
