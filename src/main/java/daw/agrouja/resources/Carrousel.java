package daw.agrouja.resources;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Equipo
 */
@Named(value = "carr")
@RequestScoped
public class Carrousel implements Serializable {

    private ArrayList<String> images;

    @PostConstruct
    public void init() {

        images = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            images.add("img" + i + ".jpg");
        }
    }

    public ArrayList<String> getImages() {
        return images;
    }

}
