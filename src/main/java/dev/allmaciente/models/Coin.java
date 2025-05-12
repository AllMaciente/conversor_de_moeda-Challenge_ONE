package dev.allmaciente.models;

import com.google.gson.annotations.SerializedName;

public class Coin {
    private String base_code;

    @SerializedName("conversion_rates")
    private Rates conversionRates;

    public float exchangeToUSD(float amount){
        return amount * conversionRates.usd;
    }
    public float exchangeToBRL(float amount){
        return amount * conversionRates.brl;
    }
    public float exchangeToCLP(float amount){
        return amount * conversionRates.clp;
    }
    public float exchangeToCOP(float amount){
        return amount * conversionRates.cop;
    }
    public float exchangeToBOB(float amount){
        return amount * conversionRates.bob;
    }
    public float exchangeToARS(float amount){
        return amount * conversionRates.ars;
    }

    public String getBase_code() {
        return base_code;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "base_code='" + base_code + '\'' +
                ", conversionRates=" + conversionRates +
                '}';
    }

    private static class Rates {
        @SerializedName("USD")
        private float usd;
        @SerializedName("BRL")
        private float brl;
        @SerializedName("CLP")
        private float clp;
        @SerializedName("COP")
        private float cop;
        @SerializedName("BOB")
        private float bob;
        @SerializedName("ARS")
        private float ars;

        @Override
        public String toString() {
            return "Rates{" +
                    "usd=" + usd +
                    ", brl=" + brl +
                    ", clp=" + clp +
                    ", cop=" + cop +
                    ", bob=" + bob +
                    ", ars=" + ars +
                    '}';
        }
    }
}
