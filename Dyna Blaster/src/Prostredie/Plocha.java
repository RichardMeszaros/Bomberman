/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prostredie;

import Bonusy.Bonus;
import Hrac.Bomberman;
import java.util.ArrayList;
/**
 *
 * @author Uzivatel
 */
public class Plocha {
   
    private Kococka kococka;
    
    private Stena stena;
    private Bonus bonus;
    private Bomberman bomberman; 
    private ArrayList<Bonus>bonusy;
    private ArrayList<INeprechodne>prekazky;
    private final int vyska;
    private final int sirka;
   
    public Plocha(int sirka, int vyska, boolean pve){
        this.sirka = sirka;
        this.vyska = vyska;
        this.bonusy = new ArrayList<>();
        this.prekazky = new ArrayList<>();
        int surX = 0;
        int surY = 0;
        for(int x = 0; x < this.sirka; x++){
            surX++;
            for(int y = 0; y < this.vyska; y++){
                surY++;
                if(surY > this.vyska){
                    surY = 1;  
                }
                kococka = new Kococka(surX,surY);
                this.prekazky.add(kococka);
                    
            }
        }
    }

    public int getVyska() {
        return vyska;
    }

    public int getSirka() {
        return sirka;
    }
    
    
    private void RozbiKocku(int x, int y){
        INeprechodne odstran = null;
        for(INeprechodne neprechodne : this.prekazky){    
            if(neprechodne.porovnajSuradnice(x, y) && neprechodne instanceof Kococka ){
                odstran = neprechodne;   
                if(((Kococka) neprechodne).mamBonus()){
                    System.out.println("BONUS");
                    Bonus bonus = new Bonus(x,y);
                    System.out.println("surX " + bonus.getSuradniceX());
                    System.out.println("surY " + bonus.getSuradniceY());
                    this.bonusy.add(((Kococka) neprechodne).dajBonus());
                
                }
            }
        }        
    this.prekazky.remove(odstran);         
    }
    
    public void dajBonus(Bomberman bomberman){
        Bonus odstran = null;
        for(Bonus test : this.bonusy){
            if(test.getSuradniceX() == bomberman.getSuradniceX() && 
                test.getSuradniceY() == bomberman.getSuradniceY()){
                    odstran = test;    
                    test.pouzi(bomberman);          
            }
        }
        this.bonusy.remove(odstran);
    }
    
    public void pridajBonus(Bonus bonus){
        this.bonusy.add(bonus);
    }
    
    public void pridajPrekazku(INeprechodne neprechodne){
        this.prekazky.add(neprechodne);
    }
    
    public boolean jeTamPrekazka(int x, int y, boolean jeToKrok){
       boolean vysledok = false;
        for(INeprechodne neprechodne : this.prekazky){
            if(neprechodne.porovnajSuradnice(x, y)){
                vysledok = true;
                if(!jeToKrok){
                    if (neprechodne instanceof Kococka) {
                        this.RozbiKocku(x, y);
                    }
                }
            }
        }
        return vysledok;
    }
}
