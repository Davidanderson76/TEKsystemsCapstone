package capstone.fullstack.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "employees_stores",
//            joinColumns = @JoinColumn(
//                    name = "employee_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "store_id", referencedColumnName = "id"))
//
//    private Collection<StoreEntity> stores;

    public EmployeeEntity() {
        // NO ARGS CONSTRUCTOR
    }


    public EmployeeEntity(String firstName, String lastName, String email
//            , Collection<StoreEntity> stores
    ) {
        // ALL ARGS CONSTRUCTOR
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.stores = stores;
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

//    public Collection<StoreEntity> getStores() {
//        return stores;
//    }
//
//    public void setStores(Collection<StoreEntity> stores) {
//        this.stores = stores;
//    }
}
