package daw.agrouja.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Equipo
 */
@Named(value = "carr")
public class Carrousel implements Serializable {

    private List<String> images;

    @PostConstruct
    public void init() {

        images = new ArrayList<String>();
        for (int i = 1; i < 3; i++) {
            images.add("img" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }

}
