/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import Bots.Npc;
import Engine.Engi;
import Prostredie.Plocha;
import java.util.Random;

/**
 *
 * @author Uzivatel
 */
public class Level {
    private Npc npc;
     private Engi engi;
    private Plocha plocha;
    private boolean vyhra;
    private int kOlevel;
     public Level(Engi engi,int kolkyLevel,int sirka, int vyska){
        Random suradnicaX = new Random();
        Random suradnicaY = new Random();
        this.kOlevel = kolkyLevel;
        this.vyhra = false;
        this.plocha = new Plocha (sirka,vyska,true);
        this.engi = engi;
        for(int i = 0; i < kolkyLevel;i++){
            int surX;
            int surY;
            surX = suradnicaX.nextInt(sirka);
            surY = suradnicaX.nextInt(vyska);
            if(!this.plocha.jeTamPrekazka(surX, surY, false)){
                Npc npc = new Npc(surX,surY, this.plocha, this.engi);
                engi.pridajNpc(npc);
            } else {
                i--;
            }
            
        }   
    }

    public int getLevel() {
        return kOlevel;
    }

    public boolean isVyhra() {
       boolean vysledok = false;
        if(this.engi.kolkoJeNpc() == 0){
           vysledok = true;
       }
        return vysledok;
    }
    
    public void zmenStav(){
        vyhra = true;
    }
    public boolean mrtvyNerpiatelia(){
       boolean vysledok = false;
        if(engi.kolkoJeNpc() == 0){
        vysledok = true;   
        }
        return vysledok;
    }
    
    public boolean zomrelBomber(){
        boolean vysledok = false;
        if(this.engi.dajPocetBombermanov == 0){
            vysledok = true;
        }
        
        return vysledok;
    }
}  
    

