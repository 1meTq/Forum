package kz.forum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "t_users")
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "t_users_roles",
//            joinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "roles_id", referencedColumnName = "id")}
//    )
    private List<Roles> roles;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "t_users_favourite_articles",
//            joinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "favourite_articles_id", referencedColumnName = "id")}
//    )
    private List<Articles> favouriteArticles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
