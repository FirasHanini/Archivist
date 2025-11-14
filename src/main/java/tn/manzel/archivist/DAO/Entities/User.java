package tn.manzel.archivist.DAO.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users") // 'User' peut être un mot-clé SQL
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password; // Sera ignoré avec Keycloak

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private boolean enabled = true;
}