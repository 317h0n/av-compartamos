package com.avantica.compartamos.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.avantica.compartamos.domain.Banco;
import com.avantica.compartamos.domain.tmp.BancosDB;

@Path("/bancos")
@Produces("application/json")
public class BancoResource {

	static {
		BancosDB.createBanco("BCP", "Av. Brasil 769");
		BancosDB.createBanco("Interbank", "Av. Brasil 769");
    }
	
	@GET
    public List<Banco> getBancos() {          
        List<Banco> list = BancosDB.getAll();        
        return list;
    }
	
	@GET
    @Path("/{id}")
    public Response getConfigurationById(@PathParam("id") Integer id){
        Banco banco = BancosDB.getBanco(id);
        if(banco == null) {
            return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
        } 
        return Response.status(javax.ws.rs.core.Response.Status.OK).entity(banco).build();
    }
}
