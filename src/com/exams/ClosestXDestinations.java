package com.exams;

import java.util.*;

/**
 * Given A number of destinations (List of List of Integer)
 * Find all the k closest deliveries starting from an intial state (represented by coordonates 0,0 on a matrix)
 */

public class ClosestXDestinations {
    public static void main(String[] args) {

    }

    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        PriorityQueue<DeliveryDistance> heap =
                new PriorityQueue<DeliveryDistance>(new DeliveryComparator());

        double distance;
        int x ,y;
        for (int i=0; i < allLocations.size(); i++){
            List<Integer> location = allLocations.get(i);
            x = location.get(0);
            y = location.get(1);
            distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            DeliveryDistance deliveryDistance = new DeliveryDistance(distance,
                    x, y);
            heap.add(deliveryDistance);
            if (heap.size() > numDeliveries){
                heap.poll();
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (!heap.isEmpty()){
            DeliveryDistance deliveryDistance = heap.poll();
            result.add(deliveryDistance.getlocation());
        }
        return result;
    }

    public class DeliveryDistance {
        public double distance;
        public int x;
        public int y;

        public DeliveryDistance(double distance, int x, int y){
            this.distance = distance;
            this.x = x;
            this.y = y;
        }

        public List<Integer> getlocation(){
            List<Integer> location = new ArrayList<Integer>();
            location.add(x);
            location.add(y);
            return location;
        }
    }

    public class DeliveryComparator implements Comparator<DeliveryDistance>{

        public int compare(DeliveryDistance o1, DeliveryDistance o2) {
            double distance1 = o1.distance;
            double distance2 = o2.distance;
            if (distance1 < distance2){
                return 1;
            } else if (distance2 < distance1){
                return -1;
            } else{
                return 0;
            }
        }
    }
}
