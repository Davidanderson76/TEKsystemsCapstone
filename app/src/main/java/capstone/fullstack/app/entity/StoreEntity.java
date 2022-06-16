package capstone.fullstack.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "stores")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    public StoreEntity() {
        // NO ARGS CONSTRUCTOR
    }

    public StoreEntity(String name, String address) {
        // ALL ARGS CONSTRUCTOR
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}