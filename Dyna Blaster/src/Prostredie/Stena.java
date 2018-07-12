/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prostredie;

/**
 *
 * @author Uzivatel
 */
public class Stena implements INeprechodne {
    private final int suradniceX;
    private final int suradniceY;
    public Stena(int x, int y){
        this.suradniceX = x;
        this.suradniceY = y;
    }
    
    @Override
    public boolean porovnajSuradnice(int x, int y){
       boolean vysledok = false;
        if(x == this.suradniceX && y == this.suradniceY){
            vysledok = true;
        }
        return vysledok;
    }
}
