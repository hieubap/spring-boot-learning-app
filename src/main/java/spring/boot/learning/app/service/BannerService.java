package spring.boot.learning.app.service;

import spring.boot.core.api.CoreService;
import spring.boot.learning.app.dto.BannerDTO;
import spring.boot.learning.app.dto.NotificationDTO;
import spring.boot.learning.app.entity.BannerEntity;
import spring.boot.learning.app.entity.NotificationEntity;

public interface BannerService extends CoreService<BannerDTO, BannerEntity> {

}
