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
public class BonusOhnik extends Bonus {
    
    public BonusOhnik(int x, int y) {
        super(x, y);
    }
    
    public void pouzi(Bomberman bomberman) {
        bomberman.pridajOhnik();
    }
    
    
}
