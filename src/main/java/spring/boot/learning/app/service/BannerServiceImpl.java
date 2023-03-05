package spring.boot.learning.app.service;

import org.springframework.stereotype.Service;
import spring.boot.core.api.CoreServiceImpl;
import spring.boot.learning.app.dto.BannerDTO;
import spring.boot.learning.app.dto.NotificationDTO;
import spring.boot.learning.app.entity.BannerEntity;
import spring.boot.learning.app.entity.NotificationEntity;

@Service
public class BannerServiceImpl
    extends CoreServiceImpl<BannerDTO, BannerEntity> implements BannerService {

}
