/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hra;

import Engine.Engi;
import GameManagers.PvpManager;
import Level.Level;



public class Hra {
    private Level level;
    private Engi engi;
    
    
    public Hra(){
       this.engi = engi; 
       this.level = new Level(this.engi,1,8,8);
        while(!this.level.zomrelBomber()){
            while(this.level.isVyhra()){
                Level level = new Level(this.engi,this.level.getLevel() + 1,8,8);
                this.level = level;
            }
        }
        
    }
}
