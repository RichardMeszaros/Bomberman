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
public class BonusBomba extends Bonus {
    public BonusBomba(int x, int y){
        super(x,y);
    }
    
    
    @Override
    public void pouzi(Bomberman bomberman){
        bomberman.pridajBombu();
    }
    
}
