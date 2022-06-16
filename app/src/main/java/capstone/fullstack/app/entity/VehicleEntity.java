package capstone.fullstack.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int year;
    private String color;
    private int driverRating;
    private boolean insured;
    private int driverId;

    public VehicleEntity() {
        // NO ARGS CONSTRUCTOR
    }

    public VehicleEntity(String model, int year, String color, int driverRating, boolean insured, int driverId) {
        // ALL ARGS CONSTRUCTOR
        this.model = model;
        this.year = year;
        this.color = color;
        this.driverRating = driverRating;
        this.insured = insured;
        this.driverId = driverId;
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

    public int getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
