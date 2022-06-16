package capstone.fullstack.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public PositionEntity() {
        // NO ARGS CONSTRUCTOR
    }

    public PositionEntity(String name) {
        // ALL ARGS CONSTRUCTOR
        this.name = name;
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
}
