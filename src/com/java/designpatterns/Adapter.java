package com.java.designpatterns;

public class Adapter {

    public static void main(String[] args) {

    }

    public interface Movable{
        double getSpeed();
    }

    public class BugattiVeyron implements Movable{
        @Override
        public double getSpeed() {
            return 268;
        }
    }

    public interface MovableAdapter{
        double getSpeed();
    }

    public class MovableAdapterImpl implements  MovableAdapter{
        private Movable luxryCars;

        @Override
        public double getSpeed() {
            return convertMPHtoKMPH(luxryCars.getSpeed());
        }

        private double convertMPHtoKMPH(double speed) {
            return speed * 1.60934;
        }
    }
}
