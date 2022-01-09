package dtos;

import entities.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnersDTO {
    private List<OwnerDTO> all = new ArrayList<>();

    public OwnersDTO(List<Owner> entities) {
        entities.forEach(p -> {
            all.add(new OwnerDTO(p));
        });
    }

    public List<OwnerDTO> getAll(){
        return all;
    }
}
