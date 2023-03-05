package spring.boot.learning.app.service;

import spring.boot.core.api.CoreService;
import spring.boot.learning.app.dto.CategoryDTO;
import spring.boot.learning.app.dto.NotificationDTO;
import spring.boot.learning.app.entity.CategoryEntity;
import spring.boot.learning.app.entity.NotificationEntity;

public interface NotificationService extends CoreService<NotificationDTO, NotificationEntity> {

}
