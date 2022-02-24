/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.MovieDTO;
import entities.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
         EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("puTest");
        MovieFacade fe = MovieFacade.getFacadeExample(emf);
        fe.create(new MovieDTO(new Movie("First 1","22" )));
        fe.create(new MovieDTO(new Movie("First 2", "12")));
        fe.create(new MovieDTO(new Movie("First 3", "10")));
    }
    
    public static void main(String[] args) {
        //populate();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        MovieFacade fe = MovieFacade.getFacadeExample(emf);
        MovieDTO m1 = fe.create(new MovieDTO(new Movie("Rød","22")));
        System.out.println(m1.getMovieName());


    }
}
