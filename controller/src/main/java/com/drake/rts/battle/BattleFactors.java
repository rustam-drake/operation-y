package com.drake.rts.battle;

public class BattleFactors {

    private Float generalsSkills;
    private Float terrain;

    public BattleFactors(Float generalsSkills, Float terrain) {
        this.generalsSkills = generalsSkills;
        this.terrain = terrain;
    }

    public Float getGeneralsSkills() {
        return generalsSkills;
    }

    public void setGeneralsSkills(Float generalsSkills) {
        this.generalsSkills = generalsSkills;
    }

    public Float getTerrain() {
        return terrain;
    }

    public void setTerrain(Float terrain) {
        this.terrain = terrain;
    }

    public Float getResult() {
        return generalsSkills + terrain;
    }
}
