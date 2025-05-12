package dev.allmaciente.models;

public class Coin {
    private String base_code;
    private float usd;
    private float brl;
    private float clp;
    private float cop;
    private float bob;
    private float ars;

    public float exchangeToUSD(float amount){
        return amount * this.usd;
    }
    public float exchangeToBRL(float amount){
        return amount * this.brl;
    }
    public float exchangeToCLP(float amount){
        return amount * this.clp;
    }
    public float exchangeToCOP(float amount){
        return amount * this.cop;
    }
    public float exchangeToBOB(float amount){
        return amount * this.bob;
    }
    public float exchangeToARS(float amount){
        return amount * this.ars;
    }
    public String getBase_code() {
        return base_code;
    }
}

