package org.example.model.products;

import lombok.Getter;


public class ElectronicsProduct extends Product {
    @Getter
    private final String brand;
    @Getter
    private final int warrantyPeriod; //in Months
    @Getter
    private final String modelNumber;
    @Getter
    private final boolean isWirelessConnectivity;
    @Getter
    private final int powerConsumption;


    private ElectronicsProduct(ElectronicsBuilder builder) {
        super(builder);
        this.brand=builder.brand;
        this.warrantyPeriod = builder.warrantyPeriod;
        this.modelNumber = builder.modelNumber;
        this.isWirelessConnectivity = builder.wirelessConnectivity;
        this.powerConsumption = builder.powerConsumption;
    }

    public static class ElectronicsBuilder extends Builder<ElectronicsBuilder>{
        private final String brand;
        private int warrantyPeriod = 12; // in months
        private String modelNumber="";
        private boolean wirelessConnectivity =false;
        private int powerConsumption=0;

        public ElectronicsBuilder(String id, String name,double price, String brand){
            super(id,name,price,ProductCategory.ELECTRONIC);
            this.brand=brand;
        }

        public ElectronicsBuilder warrantPeriod(int warrantyPeriod){
                this.warrantyPeriod = warrantyPeriod;
                return this;
        }
        public ElectronicsBuilder modelNumber(String modelNumber){
            this.modelNumber = modelNumber;
            return this;
        }

        public ElectronicsBuilder wirelessConnectivity(boolean wirelessConnectivity){
            this.wirelessConnectivity = wirelessConnectivity;
            return this;
        }
        public ElectronicsBuilder powerConsumption(int powerConsumption){
            this.powerConsumption = powerConsumption;
            return this;
        }


        @Override
        protected ElectronicsBuilder self() {
            return this;
        }

        @Override
        protected ElectronicsProduct build() {
            return new ElectronicsProduct(this);
        }
    }


}
