/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bonusy;

import Hrac.Bomberman;

/**
 *
 * @author Uzivatel
 */
public class Bonus {
    private final int suradniceX;
    private final int suradniceY;
    public Bonus(int x, int y){
        this.suradniceX = x;
        this.suradniceY = y;
    }

    public int getSuradniceX() {
        return suradniceX;
    }

    public int getSuradniceY() {
        return suradniceY;
    }
    
    public void pouzi(Bomberman bomberman){
        //nic
    }
    
}
