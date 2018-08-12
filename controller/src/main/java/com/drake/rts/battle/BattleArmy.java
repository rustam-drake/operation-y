package com.drake.rts.battle;

import com.drake.rts.battle.enums.BattleOutcome;

public class BattleArmy {

    private Long foot;
    private Long cavalry;
    private BattleFactors factors;
    private Float strength;
    private BattleOutcome victory = BattleOutcome.NIL;

    public BattleArmy(
            Long foot,
            Long cavalry,
            BattleFactors factors
    ) {
        this.foot = foot;
        this.cavalry = cavalry;
        this.factors = factors;
    }

    public Long getFoot() {
        return foot;
    }

    public void setFoot(Long foot) {
        this.foot = foot;
    }

    public Long getCavalry() {
        return cavalry;
    }

    public void setCavalry(Long cavalry) {
        this.cavalry = cavalry;
    }

    public BattleFactors getFactors() {
        return factors;
    }

    public BattleOutcome isVictory() {
        return victory;
    }

    public void setVictory(BattleOutcome victory) {
        this.victory = victory;
    }

    public void setFactors(BattleFactors factors) {
        this.factors = factors;
    }

    public Float getStrength() {

        float factorsResult = factors.getResult();

        return foot.floatValue() * (1 + factorsResult);
    }


}
