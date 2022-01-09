package dtos;

import entities.Owner;

import javax.persistence.Column;
import java.util.List;

public class OwnerDTO {
    private Integer id;
    private String name;
    private String address;
    private String phone;

    public OwnerDTO(Integer id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public OwnerDTO(Owner ow) {
        this.id = ow.getId();
        this.name = ow.getName();
        this.address = ow.getAddress();
        this.phone = ow.getPhone();
    }

    //    public OwnerDTO(Integer id, String name, String address, String phone, List<BoatDTO> boats) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//        this.boats = boats;
//    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
