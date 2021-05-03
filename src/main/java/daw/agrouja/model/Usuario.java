
package daw.agrouja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * @author Equipo
 */
@Entity()
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 20, message = "La longitud del nombre debe estar entre {min} y {max} caracteres")
    private String nombre = "";

    @Size(min = 2, max = 30, message = "La longitud de los apellidos debe estar entre {min} y {max} caracteres")
    private String apellidos = "";

    @Size(min = 2, max = 20, message = "La longitud del nombre de usuario debe estar entre {min} y {max} caracteres")
    private String nickname = "";

    @Size(min = 6, max = 20, message = "La longitud de la contraseña debe estar entre {min} y {max} caracteres")
    private String password = "";

    @Size(min = 8, max = 30, message = "La longitud del correo debe estar entre {min} y {max} caracteres")
    private String correo = "";

    private String direccion = "";
    private Integer tarjeta = 0;
    private Integer telef = 0;
    private String sexo = "Desconocido";
    private String fnac = "dd/mm/yyyy";
    private String avatar = "user.png";

    // Claves foraneas
 
    private List<Producto> prodsFavs = new ArrayList<>();
    private List<Formulario> formularios = new ArrayList<>();
    private List<Comentario> comentarios;


    public Usuario() {
        this.id = 0;
        this.prodsFavs = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    public Usuario(Integer _id, String _Nombre, String _Apellidos, String _Sexo, String _usuario, String _Contraseña, String _Correo, String _fnac, Integer _tarjeta, String _direccion, Integer _telef) {
        id = _id;
        nombre = _Nombre;
        apellidos = _Apellidos;
        nickname = _usuario;
        password = _Contraseña;
        correo = _Correo;
        sexo = _Sexo;
        fnac = _fnac;
        tarjeta = _tarjeta;
        direccion = _direccion;
        telef = _telef;

        prodsFavs = new ArrayList<>();
    }

    public Usuario(Usuario u) {
        id = u.id;
        nombre = u.nombre;
        apellidos = u.apellidos;
        nickname = u.nickname;
        password = u.password;
        sexo = u.sexo;
        correo = u.correo;
        fnac = u.fnac;
        tarjeta = u.tarjeta;
        direccion = u.direccion;
        telef = u.telef;
        avatar = u.avatar;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    /**
     * @return the Usuario
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the Usuario to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    /**
     * @return the fnac
     */
    public String getFnac() {
        return fnac;
    }

    /**
     * @param fnac the fnac to set
     */
    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    /**
     * @return the tarjeta
     */
    public Integer getTarjeta() {
        return tarjeta;
    }

    /**
     * @param tarjeta the tarjeta to set
     */
    public void setTarjeta(Integer tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telef
     */
    public Integer getTelef() {
        return telef;
    }

    /**
     * @param telef the telef to set
     */
    public void setTelef(Integer telef) {
        this.telef = telef;
    }

    /**
     * @return the Sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param Sexo the Sexo to set
     */
    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Producto> getProdsFavs() {
        return prodsFavs;
    }

    public void addFav(Producto p) {
        prodsFavs.add(p);
    }

    public void setProdsFavs(List<Producto> prodsFavs) {
        this.prodsFavs = prodsFavs;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the formularios
     */
    public List<Formulario> getFormularios() {
        return formularios;
    }

    /**
     * @param formularios the formularios to set
     */
    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }


    
}