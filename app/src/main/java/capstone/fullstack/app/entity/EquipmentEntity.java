package capstone.fullstack.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "equipment")
public class EquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;
    private Boolean status;
    private String store;

    public EquipmentEntity() {
        // NO ARGS CONSTRUCTOR
    }

    public EquipmentEntity(String name, Double cost, Boolean status, String store) {
        // ALL ARGS CONSTRUCTOR
        this.name = name;
        this.cost = cost;
        this.status = status;
        this.store = store;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}