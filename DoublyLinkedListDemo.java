/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doublylinkedlistdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 90542
 */
public class DoublyLinkedListDemo {

   
    public static void main(String[] args) throws FileNotFoundException, IOException{
        DoublyLinkedList movies = new DoublyLinkedList();
        System.out.println("Dosyadan veriler okunuyor.....");
        try (BufferedReader br = new BufferedReader(new FileReader("src/doublylinkedlistdemo/bilgiler.txt"))) {
            String line;
            while ((line= br.readLine()) != null) {
                String[] parts = line.split(",", 5); //Öncelikle filme ait özellikler bölünüp aktarılıyor;
                int yapimYil = Integer.parseInt(parts[0]);
                String filmAd = parts[1];
                String filmType = parts[2];
                String yonetmenAd = parts[3];
                String actorsString = parts[4].substring(2, parts[4].length() - 2); //Aktörlere ait özelliklerin bölünerek aktör nesneleri oluşturulması;
                String[] actorParts = actorsString.split("\\)\\(");
                ArrayList<Actor> actors = new ArrayList<>();
                for (String actorInfo : actorParts) {
                    String[] actorOzellikleri = actorInfo.split(", ");
                    String adSoyad = actorOzellikleri[0];
                    String cinsiyet = actorOzellikleri[1];
                    String ulke = actorOzellikleri[2];
                    Actor actor = new Actor(adSoyad, cinsiyet, ulke);                 
                    actors.add(actor);
                } 
            
                Movie movie = new Movie(yapimYil, filmAd, filmType, yonetmenAd, actors);
                movies.addNodeInSorted(movie);                          
            }
            System.out.println("Liste oluşturuldu!");
        } catch (IOException e) {
            System.out.println("Error!");     
            System.exit(0);
        }
        
        Scanner keyboard= new Scanner(System.in); 
         //Kullanıcının menüden hangi işlemi seçecekse onun değerini tutan değişkenin tanımlanması     
        boolean durum=false;
        while (!durum)
        {
        System.out.println("Uygulama menüsü şu şekildedir;"+"\n"
                + "1-)Listeye film ekle."+"\n"
                + "2-)Adı girilen filme ait verileri yazdır."+"\n"
                + "3-)Adı girilen filme ait tüm verileri listeden sildir."+"\n"
                + "4-)Listedeki tüm kayıtları headden başlayarak yazdır."+"\n"
                + "5-)Listedeki tüm kayıtları tailden başlayarak yazdır."+"\n"
                + "6-)2000 yılından önce yapılmış tüm filmlerin bilgilerini yazdır."+"\n"
                + "7-)Listenin son hali bilgiler.txt isimli dosyaya kaydedilir ve çıkış yaparsınız."
        );
        System.out.print("Lütfen yapmak istediğiniz işlemin numarasını giriniz: ");
        int islem=Integer.parseInt(keyboard.nextLine());
        switch (islem) {
            case 1:
                    {   
                        int yapimYil=0;
                        boolean kontrol=false;
                        while (!kontrol){
                        try {
                        System.out.print("Listeye eklemek istediginiz filmin yapim yilini giriniz: ");
                        yapimYil=Integer.parseInt(keyboard.nextLine());
                        kontrol=true;                  
                        } catch(NumberFormatException e) {
                        System.out.println("Hata. Lutfen eklemek istediginiz filmin yilini sayilarla ifade ediniz!");                    
                        }
                        }
                        System.out.print("Filmin adini giriniz: ");
                        String filmAd = keyboard.nextLine();
                        System.out.print("Filmin turunu giriniz: ");
                        String filmType = keyboard.nextLine();
                        System.out.print("Filmin yonetmeninin adini giriniz: ");
                        String yonetmenAd = keyboard.nextLine();
                        System.out.print("Listeye eklemek istediginiz filmin aktor bilgilerini girin->{(AktorAdi, Cinsiyeti, ulkesi)(Aktör2Adi, Cinsiyeti, ulkesi)} olarak: ");// aktör özellikleri kısmındaki boşluklara dikkat edilmeli
                        String actorsString = keyboard.nextLine(); //Aktörlere ait özelliklerin bölünerek aktör nesneleri oluşturulması;
                        String[] actorParts = actorsString.split("\\)\\(");
                        ArrayList<Actor> actors = new ArrayList<>();
                        for (String actorInfo : actorParts) {
                            String[] actorOzellikleri = actorInfo.split(", ");
                            String adSoyad = actorOzellikleri[0];
                            String cinsiyet = actorOzellikleri[1];
                            String ulke = actorOzellikleri[2];
                            Actor actor = new Actor(adSoyad, cinsiyet, ulke);
                            actors.add(actor);
                        }       Movie movie = new Movie(yapimYil, filmAd, filmType, yonetmenAd, actors);
                        movies.addNodeInSorted(movie);
                        break;
                    }
            case 2:
                    {
                        System.out.print("Bilgilerini yazdırmak istediğiniz filmin adını girin: ");
                        String filmAd=keyboard.nextLine();
                        movies.printNode(filmAd);
                        break;
                    }
            case 3:
                    {
                        System.out.print("Listeden silmek istediğiniz filmin adını girin: ");
                        String filmAd=keyboard.nextLine();
                        movies.deleteNode(filmAd);
                        break;
                    }
            case 4:
                    System.out.println("Listedeki fimler baştan sona yazdırılıyor...");
                    movies.printForward();
                    break;
            case 5:
                    System.out.println("Listedeki filmler sondan başa doğru yazdırılıyor...");
                    movies.printBackward();
                    break;
            case 6:
                    System.out.println("Listede yılına göre 2000'den önce yapılmış olan filmler yazdırılıyor...");
                    movies.printMoviesTakenBefore2000();
                    break;
            case 7:
                    try ( //Önce dosyadaki tüm verileri silip sonra da listenin son halinin string halini returnallnodes methodu ile alıp dosyaya yazdırdım
                            FileWriter fileWriter = new FileWriter("src/DoublyLinkedListDemo/bilgiler.txt", false)) {
                        fileWriter.write("");
                        fileWriter.write(movies.returnAllNodes());
                    }
                    durum=true;
                    System.exit(0);
                default:
                    break;
            }
    }      
    }  
        }
    
