/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmp.BE;

/**
 *
 * @author dell
 */
public class MovieList {
    
    private String name;
    private String rating;
    private String prating;
    private String path;

    public MovieList(String name, String rating, String prating, String path) {
        this.name = name;
        this.rating = rating;
        this.prating = prating;
        this.path = path;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the prating
     */
    public String getPrating() {
        return prating;
    }

    /**
     * @param prating the prating to set
     */
    public void setPrating(String prating) {
        this.prating = prating;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    
    
}
