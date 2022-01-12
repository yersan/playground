package org.example;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @EJB
    EmployeeController controller;

    @GET
    public Response getAll(){
        GenericEntity<List<Employee>> result = new GenericEntity<List<Employee>>(controller.getAll()) {};
        return Response.ok(
                UriBuilder.fromResource(EmployeeResource.class)
                        .build()).
                entity(result)
                .build();
    }
}
