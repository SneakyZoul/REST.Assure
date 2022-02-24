/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class MovieDTO {
    private long id;
    private String str1;
    private String str2;

    public MovieDTO(String name, String time) {
        this.str1 = name;
        this.str2 = time;
    }
    
    public static List<MovieDTO> getDtos(List<Movie> rms){
        List<MovieDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new MovieDTO(rm)));
        return rmdtos;
    }


    public MovieDTO(Movie rm) {
        if(rm.getId() != null)
            this.id = rm.getId();
        this.str1 = rm.getMovieName();
        this.str2 = rm.getTime();
    }

    public String getMovieName() {
        return str1;
    }

    public void setMovieName(String movieName) {
        this.str1 = movieName;
    }

    public String getTime() {
        return str2 ;
    }

    public void setTime(String time) {
        this.str2 = time;
    }

    @Override
    public String toString() {
        return "movieDTO{" + "id=" + id + ", str1=" + str1 + ", str2=" + str2 + '}';
    }
    
    
    
    
    
    
}
