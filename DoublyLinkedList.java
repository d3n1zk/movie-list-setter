/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doublylinkedlistdemo;

/**
 *
 * @author 90542
 */
public class DoublyLinkedList 
{
    private class TwoWayNode
    {
        private Movie movie;
        private TwoWayNode previous;
        private TwoWayNode next;
       
        
        public TwoWayNode(){
        movie=null;
      
        }
        public TwoWayNode(Movie newMovie){
        movie=new Movie(newMovie);
        previous=null;
        next=null;
        }
           
    } // TwoWayNode classının sonu
    
    private TwoWayNode head,tail; //listenin başını ve sonunu temsil eden değişkenler.
    public void addNodeInSorted(Movie theMovie)
    {
        TwoWayNode Node=new TwoWayNode(theMovie);
                
            if (head == null) { //Listemiz boş ise;
            head = Node;
            tail = Node;
            return;
        }
        if (theMovie.getYapımYıl() < head.movie.getYapımYıl() || //Eklenecek node'un başa eklenme ihtimalinin kontrölü;
                
            (theMovie.getYapımYıl()== head.movie.getYapımYıl()&& theMovie.getFilmAd().compareTo(head.movie.getFilmAd()) < 0)) {
            Node.next = head;
            head.previous = Node;
            head = Node;
            return;
        }

        TwoWayNode current = head;
        while (current != null && (theMovie.getYapımYıl()> current.movie.getYapımYıl()||
                (theMovie.getYapımYıl()== current.movie.getYapımYıl()&& theMovie.getFilmAd().compareTo(current.movie.getFilmAd()) >= 0))) {
            current = current.next;
        }

        if (current == null) {
            Node.previous = tail;
            tail.next = Node;
            tail = Node;
        } else {
            Node.previous = current.previous;
            Node.next = current;
            if (current.previous != null)
                current.previous.next = Node;
            current.previous= Node;
        }
                
    }
    public void printNode(String theName){ //Adı verilen filmi bulup tüm verilerini yazdırmak için;
    TwoWayNode current=head;
    while (current!=null){
        if (current.movie.getFilmAd().equalsIgnoreCase(theName)) 
        {
        System.out.println(current.movie);
        }
        current=current.next;  
    }
    }
    public void deleteNode(String theName){
         TwoWayNode current=head;
         while (current!=null)
                 {
                     if (current.movie.getFilmAd().equalsIgnoreCase(theName)) 
                     {
                         if (current.previous==null) //Silinecek node head node ise;
                         {
                             head=current.next;
                         }
                         else {
                          current.previous.next=current.next;
                         }                        
                         if (current.next==null) //Silinecek node tail node ise;
                         {
                             tail=current.previous;
                         }
                         else {
                         current.next.previous=current.previous;
                         }
                         break;
                         
                     }
                     current=current.next;
                 }                             
    }
    
     
    public void printForward(){ // Verileri headten taile yazdırmak icin;
    TwoWayNode current=head;
    while (current!=null) {
    System.out.println(current.movie);
    current=current.next;}
    }
    
    public void printBackward() //Verileri tailden heade doğru sırayla yazdırmak için;
    {
      TwoWayNode current=tail;
      while (current!=null){
      System.out.println(current.movie);
      current=current.previous;}   
    }
    
    public void printMoviesTakenBefore2000()//2000'den önce çekilmiş filmleri yazdırmak için;
    {
        TwoWayNode current=head;
        while (current!=null)
        {
        if (current.movie.getYapımYıl()<2000){
        System.out.println(current.movie);
        }
        current=current.next;
        }
    } 
    //Listenin son halini file'a kaydetmek için tüm movie nesnelerinin alt alta yazılmış halini oluşturdum;
    public String returnAllNodes(){
    TwoWayNode current=head;
    String yapi="";
    String actorsInfo=""; //Listeye yeniden ekleniyorken [] parantezleri ortadan kaldırmak için
   
    while(current!=null)
    {
         for (Actor actor:current.movie.getActors())
    {
       actorsInfo+="("+actor.getAd_soyad()+", "+actor.getCinsiyet()+", "+actor.getÜlke()+")";
    }
 
        yapi+=current.movie.getYapımYıl()+","+current.movie.getFilmAd()+","+current.movie.getFilmType()+","+current.movie.getYönetmenAd()+",{"+actorsInfo+"}"+"\n";
        actorsInfo="";
        current=current.next;
    }
    return yapi;
    }
}
