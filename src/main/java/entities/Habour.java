package entities;


import javax.persistence.*;
import java.util.List;

@Table(name = "habour")
@Entity
public class Habour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "habour", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Boat> boats;

    public Habour() {
    }

    public Habour(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Boat> getBoats() {
        return boats;
    }

    public void setBoats(List<Boat> boats) {
        this.boats = boats;
    }

}