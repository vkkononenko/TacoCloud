package de.vkononenko.TacoCloud.models;

import de.vkononenko.TacoCloud.models.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SystemUser extends EntityBase implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_system_user")
    @SequenceGenerator(name = "seq_system_user", allocationSize = 1)
    @Column(updatable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    @Size(min=1, message="Login must be not empty")
    private String login;

    @NotEmpty
    @Size(min=5, message="Password must be at least 5 characters long")
    private String password;

    private String role;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    public SystemUser(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = "ROLE_USER";
        this.accountNonExpired = false;
        this.accountNonLocked = false;
    }

    @PrePersist
    public void prePersist() {
        if(this.role == null) {
            this.role = "ROLE_USER";
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(getRole()));
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
