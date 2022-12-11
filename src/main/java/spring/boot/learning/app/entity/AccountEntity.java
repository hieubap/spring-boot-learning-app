package spring.boot.learning.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import spring.boot.core.api.CoreEntity;

@Entity
@Table(name = "account")
@Where(clause = "deleted=0")
@Getter
@Setter
@NoArgsConstructor
public class AccountEntity extends CoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String avatar;

    private String phone;

    private String description;

    private String aboutMe;

    /**
     * 1: tutor
     * 2: user
     */
    private Short role;

    private String twitter;

    private String linkedIn;

    private String facebook;

    private String github;
}
