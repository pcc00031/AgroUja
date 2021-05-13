/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.NoticiasDAO;

import daw.agrouja.model.Noticia;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Carlos
 */

@ApplicationScoped
public class NoticiasDAO {
    private Map<String, Noticia> noticias=null;
    
    
    public NoticiasDAO(){
        if (noticias==null){
            noticias = new HashMap<>();
            noticias.put("1 millón de seguidores",new Noticia("1 millón de seguidores", "En el día de hoy hemos llegado a la "
                    + "maravillosa cantidad de 1 millón de seguidores, gracias a vosotros por seguir creyendo en nuestra aplicación", "12-05-2021"));
        }
    }
    public Noticia buscaTitulo(String titulo){
        return new Noticia(noticias.get(titulo)); //Tenemos que crear el constructor de copia en la clase Noticia
    }
    public List<Noticia> buscaTodos(){
        return noticias.values().stream().collect(Collectors.toList());
    }
    public int numNoticias(){
        return noticias.size();
    }

    public boolean crea(Noticia n) {
        noticias.put(n.getTitulo(), n);
        return true;
    }
    
    public boolean borra(String titulo) {
        boolean result=false;
        if (noticias.containsKey(titulo)) {
            noticias.remove(titulo);
            result = true;
        }
        return result;
    }
    
    public List<Noticia> busca (String titulo){
        Map<String, Noticia> noticiasEnc=null;
        noticiasEnc=new HashMap<>();
        for (Map.Entry<String, Noticia> entry: noticias.entrySet()){
            if (entry.getValue().getTitulo().contains(titulo))
                noticiasEnc.put(entry.getKey(), entry.getValue());
        }
        return noticiasEnc.values().stream().collect(Collectors.toList());
    }
}
