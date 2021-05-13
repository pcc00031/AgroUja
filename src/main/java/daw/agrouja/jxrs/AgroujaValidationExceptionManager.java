/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.jxrs;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author Carlos
 */
public class AgroujaValidationExceptionManager implements ExceptionMapper<ConstraintViolationException>{
    @Override
    public Response toResponse(ConstraintViolationException e){
        List<Object> errors = new ArrayList<>();
        
        for (ConstraintViolation<?> cv : e.getConstraintViolations()){
            String[] parts = cv.getPropertyPath().toString().split("\\.");
            
            Object m = new Object (){
                public String name = parts [parts.length-1];
                public String message = cv.getMessage();
            };
            errors.add(m);
        };
        return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
    }
}
