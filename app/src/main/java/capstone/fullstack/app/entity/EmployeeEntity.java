package capstone.fullstack.app.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;

    @ElementCollection(targetClass = RolesEnum.class)
    @CollectionTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(name = "employeeid")
    )
    @Column(name = "EnumId")
    private final Set<RolesEnum> enumSet= new HashSet<>();

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "employee_positions",
//            joinColumns = @JoinColumn(
//                    name = "employee_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "position_id", referencedColumnName = "id"))
//    private Collection<PositionEntity> positions;

    public EmployeeEntity() {
        // NO ARGS CONSTRUCTOR
    }



    public EmployeeEntity(String firstName, String lastName, String email, boolean active) {
        // ALL ARGS CONSTRUCTOR
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<RolesEnum> getEnumSet() {
        return enumSet;
    }

    //    public Collection<PositionEntity> getPositions() {
//        return positions;
//    }
//
//    public void setPositions(Collection<PositionEntity> positions) {
//        this.positions = positions;
//    }
}
