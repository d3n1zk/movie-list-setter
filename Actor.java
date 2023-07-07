/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doublylinkedlistdemo;

/**
 *
 * @author 90542
 */
public class Actor {
    private String ad_soyad;
    private String cinsiyet;
    private String ulke;
    
    public Actor(){       
    this.ad_soyad=null;
    this.cinsiyet=null;
    this.ulke=null;
    }
    
    public Actor(String ad_soyad,String cinsiyet,String ulke){
    this.ad_soyad=ad_soyad;
    this.cinsiyet=cinsiyet;
    this.ulke=ulke;
    }
    
    public Actor(Actor object){
    this.ad_soyad=object.ad_soyad;
    this.cinsiyet=object.cinsiyet;
    this.ulke=object.ulke;
    }
    
    public String getAd_soyad() {
        return ad_soyad;
    }

    
    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

   
    public String getCinsiyet() {
        return cinsiyet;
    }

    
    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

   
    public String getÜlke() {
        return ulke;
    }

    public void setÜlke(String ülke) {
        this.ulke = ülke;
    }
    @Override
    public String toString(){       
    return ad_soyad+" "+cinsiyet+" "+ulke;
    }
    
    
}
