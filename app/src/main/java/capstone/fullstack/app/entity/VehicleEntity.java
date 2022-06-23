package capstone.fullstack.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    private String make;
    private int year;
    private String color;

    private boolean insured;


    public VehicleEntity() {
        // NO ARGS CONSTRUCTOR
    }

    public VehicleEntity(String model, String make, int year, String color, boolean insured) {
        // ALL ARGS CONSTRUCTOR
        this.model = model;
        this.make = make;
        this.year = year;
        this.color = color;
        this.insured = insured;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
