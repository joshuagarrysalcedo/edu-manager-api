package ph.jsalcedo.edumanagerapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import ph.jsalcedo.edumanagerapi.enums.Role;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name="id")
    private Long id;
    @Column(nullable = false)
    private String user;
    @Column(nullable = false)
    private String pass;
    @Column(nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Institution institution = new Institution();

    public AppUser() {
    }

    public AppUser(String user, String pass, String email) {
        this.user = user;
        this.pass = pass;
        this.email = email;
//        this.institution = new Institution();
    }

    public AppUser(Long id, String user, String pass, String email, Institution institution) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.institution = institution;
    }

    private void setPass(String password){
        this.pass = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("Hashed password created from " + password + " to " +  this.pass);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return user;
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
        return false;
    }
}
