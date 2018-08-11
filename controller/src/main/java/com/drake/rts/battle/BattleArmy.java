package com.drake.rts.battle;

public class BattleArmy {

    private Long foot;
    private Long cavalry;

    public BattleArmy(
            Long foot,
            Long cavalry
    ) {
        this.foot = foot;
        this.cavalry = cavalry;
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


}
