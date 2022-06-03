package bg.softuni.mobilelele.model;

import bg.softuni.mobilelele.model.enums.UserRole;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private UserRole name;

    public UserRole getRole() {
        return name;
    }

    public void setRole(UserRole role) {
        this.name = role;
    }
}
