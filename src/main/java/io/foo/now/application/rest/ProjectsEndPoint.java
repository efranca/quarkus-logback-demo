package io.foo.now.application.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.foo.now.domain.model.Project;
import io.foo.now.domain.service.IProjectService;

@Path("/projects")
public class ProjectsEndPoint {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectsEndPoint.class);

    @Inject
    protected IProjectService service;

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@Context UriInfo uriInfo) {
        try {
            return Response.ok(service.get()).build();
        } catch (Throwable x) {
            return logError(x);
        }
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@Context UriInfo uriInfo, @PathParam("id") Long id) {
        try {
            Project entity = service.get(id);
            if (entity == null)
                return Response.noContent().build();
            return Response.ok(entity).build();
        } catch (Throwable x) {
            return logError(x);
        }
    }

    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(@Context UriInfo uriInfo, Project entity) {
        try {
            return Response.ok(service.create(entity)).build();
        } catch (Throwable x) {
            return logError(x);
        }
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@Context UriInfo uriInfo, @PathParam("id") Long id, Project project) {
        try {
            return Response.ok(service.update(id, project)).build();
        } catch (Throwable x) {
            return logError(x);
        }
    }

    @Path("{id}")
    @DELETE
    public Response delete(@Context UriInfo uriInfo, @PathParam("id") Long id) {
        try {
            Boolean result = service.delete(id);
            if (!result)
                return Response.status(400).build();

            return Response.ok().status(204).build();
        } catch (Throwable x) {
            return logError(x);
        }
    }

    private Response logError(Throwable x) {
        LOG.error(x.getMessage());
        return Response.serverError().entity("Internal Server Error").build();
    }
}
