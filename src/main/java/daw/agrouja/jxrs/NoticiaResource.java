/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.jxrs;

import daw.agrouja.model.Noticia;
import daw.agrouja.model.NoticiasDAO.NoticiasDAO;
import java.util.List;
import javax.validation.Valid;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Carlos
 */

@Path("/noticia")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class NoticiaResource {
    @Inject 
    private NoticiasDAO noticiasDAO;
    
    @GET
    public List<Noticia> listado(){
        return noticiasDAO.buscaTodos();
    }
    
    @GET
    public Noticia rescataNoti(String titulo){
        return noticiasDAO.buscaTitulo(titulo);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevoLibro (@Valid Noticia n){
        noticiasDAO.crea(n);
        return Response.ok(n).build();
    }
    
    @DELETE
    @Path("/{titulo}")
    public Response borraNoticia(@PathParam("titulo") String isbn) {
        noticiasDAO.borra(isbn);
        return Response.ok(isbn).build();
   
    }
}
