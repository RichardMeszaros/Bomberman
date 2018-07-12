/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bomba;

import Engine.Engi;
import Hrac.Bomberman;
import Prostredie.Plocha;

/**
 *
 * @author Uzivatel
 */
public class Bomba {
    private Bomberman bomberman;
    private Engi engi;
    private Plocha plocha;
    private final int velkostVybuchu;
    private final int suradniceX;
    private final int suradniceY;
    
    public Bomba(int x, int y, int velkostVybuchu, Bomberman bomberman, Engi engi, Plocha plocha){
        this.velkostVybuchu = velkostVybuchu;
        this.suradniceX = x;
        this.suradniceY = y;
        this.bomberman = bomberman;
        this.engi = engi;
        this.plocha = plocha;
                
    }

    public int getSuradniceX() {
        return suradniceX;
    }

    public int getSuradniceY() {
        return suradniceY;
    }
    
    private boolean bum(int suradnicaX, int suradnicaY, int smer){
        boolean vysledok = false;
        for(int i = 0; i < this.velkostVybuchu;i++){
            suradnicaX = suradnicaX + (1 * smer);
            if(this.plocha.jeTamPrekazka(suradnicaX, this.suradniceY, false)){
                i = this.velkostVybuchu;
            }
            if(engi.jeTamBomberman(suradnicaX,this.suradniceY,this.bomberman.jeToBot())){
                i = this.velkostVybuchu;
                vysledok = true;
            }
            if(this.engi.jeTamNpc(suradnicaX, this.suradniceY, true)){
                i = this.velkostVybuchu;
                vysledok = true;
            }  
        }
         for(int i = 0; i < this.velkostVybuchu;i++){
            suradnicaY = suradnicaY + (1 * smer);
            if(this.plocha.jeTamPrekazka(this.suradniceX, suradnicaY, false)){
                i = this.velkostVybuchu;
            }
            if(engi.jeTamBomberman(this.suradniceX, suradnicaY, this.bomberman.jeToBot())){
                i = this.velkostVybuchu;
                vysledok = true;
            }
            if(this.engi.jeTamNpc(suradnicaX, this.suradniceY, true)){
                i = this.velkostVybuchu;
                vysledok = true;
            }  
        }
        return vysledok;
    }
    
    public void detonacia(){
        this.bum(this.suradniceX, this.suradniceY, 1);
        this.bum(this.suradniceX, this.suradniceY, -1);
        if(this.bum(this.suradniceX, this.suradniceY, -1)){
            this.bomberman.setScore();
        }
        if(this.bum(this.suradniceX, this.suradniceY, 1)){
            this.bomberman.setScore();
        }
    }
    
}
