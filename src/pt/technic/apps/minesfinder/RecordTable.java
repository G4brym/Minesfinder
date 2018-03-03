/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.technic.apps.minesfinder;

/**
 *
 * @author someone
 */
public class RecordTable {
    private String name;
    private long score;

    public RecordTable() {
        name = "Anonymous";
        score = 9999999;
    }

    public String getName() {
        return name;
    }

    public long getScore() {
        return score/1000;
    }
    
    public void setRecord(String name, long score){
        if(score < this.score){
            this.name = name;
            this.score = score;
        }
    }
    
}
