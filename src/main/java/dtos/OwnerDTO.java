package dtos;

public class OwnerDTO {
    int ownerid;
    int boatid;

    public OwnerDTO(int ownerid, int boatid) {
        this.ownerid = ownerid;
        this.boatid = boatid;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getBoatid() {
        return boatid;
    }

    public void setBoatid(int boatid) {
        this.boatid = boatid;
    }
}
