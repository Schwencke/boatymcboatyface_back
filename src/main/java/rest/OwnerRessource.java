package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Owner;
import facades.OwnerFacade;
import facades.UserFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("owner")
public class OwnerRessource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final OwnerFacade FACADE = OwnerFacade.getOwnerFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOwners(){

        return Response.ok().entity((FACADE.getAllOwners())).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOwnerOnId(@PathParam("id") Integer id){

        return Response.ok().entity(FACADE.getOwnerById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newOwner(String owner){
        return Response.ok().entity(FACADE.createNewOwner
                (GSON.fromJson(owner, Owner.class))).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editOwner(String owner){

        return Response.ok().entity(FACADE.editOwner
                (GSON.fromJson(owner, Owner.class))).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOwner(@PathParam("id")Integer id){
        FACADE.deleteOwner(id);
        return Response.ok().build();
    }
}
