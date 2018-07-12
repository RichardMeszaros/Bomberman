/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hrac;

import Bomba.Bomba;
import Engine.Engi;
import Prostredie.Plocha;


public class Bomberman {
    private int suradniceX;
    private int suradniceY;
    private Plocha plocha;
    private Bomba bomba;
    private Engi engi;
    private final int cisloHraca;
    private int pocetBomb;
    private int velkostVybuchu;
    private boolean zivi;
    private boolean jeToBot;
    private int score;
    public Bomberman(Plocha plocha, Engi engi, int cisloHraca, boolean jeToBot){
        this.velkostVybuchu = 1;
        this.pocetBomb = 1;
        this.cisloHraca = cisloHraca;
        this.zivi = true;
        this.jeToBot = jeToBot;
        this.score = 0;
        this.plocha = plocha;
        this.engi = engi;
    }

    public boolean jeToBot() {
        return jeToBot;
    }

    public int getCisloHraca() {
        return cisloHraca;
    }

    public int getSuradniceX() {
        return suradniceX;
    }

    public int getSuradniceY() {
        return suradniceY;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void pridajOhnik(){
        this.velkostVybuchu++;
    }
    
    public void pridajBombu(){
        this.pocetBomb++;
    }
    
    public void polozilBombu(){
        this.pocetBomb--;
    }
    
    public boolean getZivi(){
        return this.zivi;
    }
    
    public void zabi(){
        this.zivi = false;
    }
    
    public void setScore(){
        this.score++;
    }
    
    private void pohyb(int x, int y){
        if(this.suradniceX + x > this.plocha.getSirka()){
            System.out.println("Tam nemozes ist");
            return;
        }
        if(this.suradniceX + x < 1){
            System.out.println("Tam nemozes ist");
            return;
        }
        if(this.suradniceY + y > this.plocha.getVyska()){
            System.out.println("Tam nemozes ist");
            return;
        }
        if(this.suradniceY + y < 1){
            System.out.println("Tam nemozes ist");
            return;
        }
        if(!this.plocha.jeTamPrekazka(this.suradniceX + x, this.suradniceY + y, true)){
            System.out.println("Tam nemozes ist");
            return;
        }
        if(this.engi.jeTamBomba(this.suradniceX + x, this.suradniceY + y, false)){
            System.out.println("Sekla ta bomba");
            return;
        }
        this.suradniceX += x;
        this.suradniceY += y;
        if(engi.jeTamNpc(this.suradniceX, this.suradniceY, false)){
            this.zabi();
        }
        
    }
    
    public void hore(){
        this.pohyb(0,-1);
    }
    
    public void dole(){
        this.pohyb(0,1);
    }
    
    public void dolava(){
        this.pohyb(-1,0);
    }
    
    public void doprava(){
        this.pohyb(1,0);
    }
    
    public void polozBombu(int x, int y){
        if(this.pocetBomb == 0){
            return;
        }
        Bomba bomba = new Bomba(this.suradniceX, this.suradniceY, this.velkostVybuchu, this, this.engi, this.plocha);
        engi.pridajBombu(bomba);
        this.polozilBombu();
    }
    
}
