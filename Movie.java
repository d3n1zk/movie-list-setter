/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doublylinkedlistdemo;

import java.util.ArrayList;


public class Movie {
    private int yapımYıl;
    private String filmAd;
    private String filmType;
    private String yönetmenAd;
    private ArrayList <Actor> actors;

    public Movie(){
    this.yapımYıl=0;
    this.filmAd=null;
    this.filmType=null;
    this.yönetmenAd=null;
    this.actors=null;
    }
  
    public Movie(int yapımYıl,String filmAd,String filmType,String yönetmenAd,ArrayList actors){
        this.yapımYıl=yapımYıl;
        this.filmAd=filmAd;
        this.filmType=filmType;
        this.yönetmenAd=yönetmenAd;
        this.actors=actors;
    }
    
    public Movie(Movie object){
    this.yapımYıl=object.yapımYıl;
    this.filmAd=object.filmAd;
    this.filmType=object.filmType;
    this.yönetmenAd=object.yönetmenAd;
    this.actors=object.actors;
    }
    
    public int getYapımYıl() {
        return yapımYıl;
    }

   
    public void setYapımYıl(int yapımYıl) {
        this.yapımYıl = yapımYıl;
    }

    
    public String getFilmAd() {
        return filmAd;
    }

  
    public void setFilmAd(String filmAd) {
        this.filmAd = filmAd;
    }

    
    public String getFilmType() {
        return filmType;
    }

  
    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }
    
     public String getYönetmenAd() {
        return yönetmenAd;
    }

    
    public void setYönetmenAd(String yönetmenAd) {
        this.yönetmenAd = yönetmenAd;
    }

    public ArrayList <Actor> getActors() {
        return actors;
    }

  
    public void setActors(ArrayList <Actor> actors) {
        this.actors = actors;
    }
    @Override
    public String toString(){     
    return yapımYıl+" "+filmAd+" "+filmType+" "+yönetmenAd+" "+actors;
    }

 
   
    
    
}
