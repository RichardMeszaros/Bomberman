/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameManagers;

import Engine.Engi;
import Hra.Hra;
import Hrac.Bomberman;
import Prostredie.Plocha;

public class PvpManager {
    private Plocha plocha;
    private Engi engi;
    public PvpManager(int pocetHracov, Hra hra){
        this.plocha = new Plocha(8,8,false);
        this.engi = new Engi();
        for(int i = 0; i < pocetHracov; i++){
            if(i == 0){
                Bomberman bomberman = new Bomberman(plocha, engi,i + 1, false);
                this.engi.pridajBombermana(bomberman);
            }
            Bomberman bomberman = new Bomberman(plocha, engi, i + 1, true);
            this.engi.pridajBombermana(bomberman);
        }
    }
    public boolean koniecHry(){
        boolean vysledok = false;
        if(engi.dajPocetBombermanov == 1){
            vysledok = true;
        }
        return vysledok;
    }
    
    public void vypisVytaza(){
        System.out.println("Hrac cislo : " + engi.dajBombera(0).getCisloHraca());
        System.out.println("Score : " + engi.dajBombera(0));
    }
}
