package com.masters.oops;

/**
 * @author nikithaperumalla
 * @id 87312
 */
public class SodaCanNikithaPerumalla {
    private double radius; //in inches
    private double height; //in inches
    private double capacity; //in ounces

    public SodaCanNikithaPerumalla(){
        this.radius = 1.2109;
        this.height = 4.704;
    }

    public SodaCanNikithaPerumalla(double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    /**
     * Volume/Capacity of a cylinder = PI * r * r * h
     * 1 Cubic Inch = 0.554112554 Ounces
     * Capacity in ounces =  capacity in cubic inches * 0.554112554
     */
    public double getCapacity() {
        capacity = Math.PI * this.getRadius() * this.getRadius() * this.getHeight() * 0.554112554;
        return capacity;
    }

    /**
     * Simulates drinking from the can
     */
    public void drink(double ounces){
         capacity = this.getCapacity() - ounces;
    }

    //yields the fl. oz. of soda remaining in the can
    public double getRemaining() {
       return capacity;
    }

    public static void main(String[] args){
        SodaCanNikithaPerumalla can1 = new SodaCanNikithaPerumalla(1, 3.5);
        SodaCanNikithaPerumalla can2 = new SodaCanNikithaPerumalla();

        //Can1
        System.out.println("_________________________________________________________________________________");
        System.out.println("Radius of can1:  " + can1.getRadius() + " inches");
        System.out.println("Height of can1: " + can1.getHeight() + " inches");
        System.out.println("Capacity of can1: " + can1.getCapacity() + " Fl. Ounces");

        System.out.println("Drinking 1.5 Ounces from the can1");
        can1.drink(1.5);

        System.out.println("Remaining Capacity of can1: " + can1.getRemaining() + " Fl. Ounces ");

        //Can2
        System.out.println("_________________________________________________________________________________");
        System.out.println("Radius of can2 (default):  " + can2.getRadius() + " inches");
        System.out.println("Height of can2 (default): " + can2.getHeight() + " inches");
        System.out.println("Capacity of can2 (default): " + can2.getCapacity() + " Fl. Ounces");

        System.out.println("Drinking 1.5 Ounces from the can2 (default)");
        can2.drink(1.5);

        System.out.println("Remaining Capacity of can2 (default): " + can2.getRemaining() + " Fl. Ounces ");
        System.out.println("_________________________________________________________________________________");
    }

}
