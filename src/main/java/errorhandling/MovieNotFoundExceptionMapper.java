package errorhandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;



@Provider
public class MovieNotFoundExceptionMapper implements ExceptionMapper<MovieNotFoundException> {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(MovieNotFoundException ex) {
        Logger.getLogger(GenericExceptionMapper.class.getName()).log(Level.SEVERE, null, ex);
        Response.StatusType type = Response.Status.NOT_FOUND;
        ExceptionDTO err;
        //   if (ex instanceof WebApplicationException) {
        //     err = new ExceptionDTO(type.getStatusCode(), ((WebApplicationException) ex).getMessage());
        //} else {

        err = new ExceptionDTO(type.getStatusCode(), ex.getMessage());
        //}
        return Response.status(type.getStatusCode())
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON).
                build();
    }





}
