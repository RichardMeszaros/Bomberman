/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Bomba.Bomba;
import Bots.Npc;
import Hrac.Bomberman;
import java.util.ArrayList;

/**
 *
 * @author Uzivatel
 */
public class Engi {
   
    private Bomba bomba;
    private Bomberman bomberman;
    private Npc npc;
    private ArrayList<Bomba>bomby;
    private ArrayList<Bomberman>bombermani;
    private ArrayList<Npc>nepriatelia;
    private boolean zasah;
    public int dajPocetBombermanov;
    public Engi(){
        this.bombermani = new ArrayList<>();
        this.nepriatelia = new ArrayList<>();
        this.bomby = new ArrayList<>();

    }

    public void pridajBombermana(Bomberman bomberman){
        this.bombermani.add(bomberman);
    }
    
    public boolean jeTamBomberman(int x, int y, boolean jeToAiBomba){
        boolean vysledok = false;
        Bomberman odstran = null;
        for(Bomberman bomberman : this.bombermani){
            if(this.zhoda(x, y, bomberman.getSuradniceX(), bomberman.getSuradniceY())){
                if((jeToAiBomba && !bomberman.jeToBot()) || (!jeToAiBomba)){
                    vysledok = true;
                    bomberman.zabi();
                    System.out.println("Zomrel hrac cislo " + bomberman.getCisloHraca());
                    odstran = bomberman;
                }
            }
        }
        this.bombermani.remove(odstran);
        return vysledok;
    }
    
    public int dajPocetBombermanov(){
        return this.bombermani.size();
    }
    
    public Bomberman dajBombera(int i){
        return this.bombermani.get(i);
    }
    
    public void odstranBombermana(Bomberman bomberman){
        this.bombermani.remove(bomberman);
    }

    public void pridajNpc(Npc npc){
        this.nepriatelia.add(npc);
    }
    
    public boolean jeTamNpc(int x, int y, boolean jeToVybuch){
        boolean vysledok = false;
        for(Npc npc : this.nepriatelia){
            if(this.zhoda(x, y, npc.getSuradniceX(), npc.getSuradniceY())){
                vysledok = true;
                if(jeToVybuch){
                    npc.zabi();
                    this.nepriatelia.remove(npc);
                }
            } 
        }
        return vysledok;
    }
    
    public int kolkoJeNpc(){
        return this.nepriatelia.size();
    }
    
    public void odstranNpc(Npc npc){
        this.nepriatelia.remove(npc);
    }
    
    public void pridajBombu(Bomba bomba){
        this.bomby.add(bomba);
    }
    
    public boolean jeTamBomba(int x, int y, boolean vybuch){
        boolean vysledok = false;
        for(Bomba bomba : this.bomby){
            if(this.zhoda(x, y, bomba.getSuradniceX(), bomba.getSuradniceY())){
                vysledok = true;
                if(vybuch){
                    bomba.detonacia();
                    this.bomby.remove(bomba);
                }
            }
        }
        return vysledok; 
    }
    
    public void odstranBombu(Bomba bomba){
        this.bomby.remove(bomba);
    }
    
    private boolean zhoda(int suradnicaX1, int suradnicaY1, int suradnicaX2, int suradnicaY2){
        boolean vysledok = false;
        if(suradnicaX1 == suradnicaX2 && suradnicaY1 == suradnicaY2){
            vysledok = true;
        }
        return vysledok;
    }

}
