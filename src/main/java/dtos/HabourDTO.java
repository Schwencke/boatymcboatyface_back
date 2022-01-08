package dtos;

import entities.Boat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class HabourDTO {
    private Integer id;
    private String name;
    private String address;
    private int capacity;
    private List<Integer> boats;

    public HabourDTO(Integer id, String name, String address, int capacity, List<Boat> boats) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        boats.forEach(boat -> {
            this.boats.add(boat.getId());
        });
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

    public List<Integer> getBoats() {
        return boats;
    }

    public void setBoats(List<Integer> boats) {
        this.boats = boats;
    }
}
