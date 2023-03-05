package spring.boot.learning.app.service;

import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.CategoryDTO;
import spring.boot.learning.app.dto.NotificationDTO;
import spring.boot.learning.app.entity.CategoryEntity;
import spring.boot.learning.app.entity.NotificationEntity;

@Service
public class NotificationServiceImpl
    extends CoreServiceImpl<NotificationDTO, NotificationEntity> implements NotificationService {

}
