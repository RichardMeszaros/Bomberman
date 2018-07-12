/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bots;

import Engine.Engi;
import Prostredie.Plocha;

/**
 *
 * @author Uzivatel
 */
public class Npc {
    private Engi engi;
    private final Plocha plocha;
    private int suradniceX;
    private int suradniceY;
    public Npc(int x, int y, Plocha plocha, Engi engi){
        this.suradniceX = x;
        this.suradniceY = y;
        this.plocha = plocha;
        this.engi = engi;
        this.engi.pridajNpc(this);
    }

    public int getSuradniceX() {
        return suradniceX;
    }

    public int getSuradniceY() {
        return suradniceY;
    }
    
    public boolean porovnajSuradnice(int x, int y){
        boolean vysledok = false;
        if(this.suradniceX == x && this.suradniceY == y){
            vysledok = true;
        }
        return vysledok;
    }
    
    private void pohyb(int x, int y){
        
    if(this.suradniceX + x > this.plocha.getSirka()){
        System.out.println("Tam NPC nemoze ist");
        return;
    }
    if(this.suradniceX + x < 1){
        System.out.println("Tam NPC nemoze ist");
        return;
    }
    if(this.suradniceY + y > this.plocha.getVyska()){
        System.out.println("Tam NPC nemoze ist");
        return;
    }
    if(this.suradniceY + y < 1){
        System.out.println("Tam NPC nemoze ist");
        return;
    }
    if(!this.plocha.jeTamPrekazka(this.suradniceX + x, this.suradniceY + y, true)){
        System.out.println("Tam n NPC nemoze ist");
        return;
    }
    if(engi.jeTamBomba(this.suradniceX + x,this.suradniceY + y, false)){
        System.out.println("Sekla ta bomba");
        return;
    }
    
    this.suradniceX += x;
    this.suradniceY += y;
    this.engi.jeTamBomberman(this.suradniceX,this.suradniceY,false);
    }
    
    void hore(){
        this.pohyb(0,-1);
    }
    
    void dole(){
       
        this.pohyb(0,1);
    }
    
    void doprava(){
        this.pohyb(1,0);
    }
    
    void dolava(){
        this.pohyb(-1,0);
    }
    
    public void zabi(){
        
    }
}
