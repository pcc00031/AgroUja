/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.fileuploadbean1;
        
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.model.file.UploadedFile;
 
@ViewScoped
@Named
public class FileUploadBean implements Serializable{
	
	private static final long serialVersionUID = 4352236420460919694L;
	
	private UploadedFile file;  
    
    public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }  
  
    public void upload() {  
        FacesMessage msg = new FacesMessage("Ok", "Fichero " + file.getFileName() + " subido correctamente.");
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
    
}
