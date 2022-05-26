package domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Permission")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;
    @Column(name = "name")
    private String name;

    @ToString.Exclude
//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "UserPermission",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @ManyToMany(mappedBy = "permissions", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public void addUser(User user){
        users.add(user);
        user.getPermissions().add(this);
    }
    public void removeUser(User user){
        users.remove(user);
        user.getPermissions().remove(this);
    }
}
