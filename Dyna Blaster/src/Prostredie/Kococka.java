/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prostredie;

import Bonusy.Bonus;
import Bonusy.BonusBomba;
import Bonusy.BonusOhnik;
import java.util.Random;

/**
 *
 * @author Uzivatel
 */
public class Kococka implements INeprechodne {
  
    private Bonus bonus;
    private final int suradniceX;
    private final int suradniceY;
    private boolean mamBonus;
    
    public Kococka(int x, int y){
        this.suradniceX = x;
        this.suradniceY = y;
        Random random = new Random();
        int bonus = random.nextInt(10);
        if(bonus % 3 == 0){
            this.mamBonus = true;
            if(this.mamBonus){
                int ktoriBonus = random.nextInt(2);
                if(ktoriBonus == 1){
                    BonusOhnik bonus2 = new BonusOhnik(x,y);    
                    this.bonus = bonus2;
                }
                if(ktoriBonus == 2){
                    BonusBomba bonus3 = new BonusBomba(x,y);
                    this.bonus = bonus3;
                }   
            }
        }
    }

    public int getSuradniceX() {
        return suradniceX;
    }

    public int getSuradniceY() {
        return suradniceY;
    }

    public boolean mamBonus() {
        return mamBonus;
    }
    
    @Override
    public boolean porovnajSuradnice(int x, int y){
      boolean vysledok = false;
        if(this.suradniceX == x && this.suradniceY == y){
            vysledok = true;
        }
        return vysledok;
    }
    
    public Bonus dajBonus(){
        return this.bonus;
    }

    
}
