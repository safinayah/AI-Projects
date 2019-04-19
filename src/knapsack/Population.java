/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.Arrays;

/**
 *
 * @author ayah
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Population {

    Individual[] individuals;
    private int populationSize = 10;//entered by user
    private int maxWeight = 90;//enterd by user 
    private Individual solution = new Individual();
    private int noOfElements = solution.getNoOfElements();//number of elements in the store
    private int capacity = 10;//represents knapsack weight
    private double weight[] = new double[noOfElements];//array of weights 
    private double profit[] = new double[noOfElements];//arrays of profits
    private byte individual[][];

    public Population() {
    }//empty constructor

    public Population(int populationSize, int noOfElements) {
        individual = new byte[populationSize][noOfElements];
        for (int i = 0; i < populationSize; i++) {
            solution = new Individual();

            individual[i] = solution.getNewGenes();
//            System.out.println(Arrays.toString(ind.getGenes()));

        }
    }

    

    public double[] getWeight() {
        for (int i = 0; i < noOfElements; i++) {
            weight[i] = Math.round(Math.random() * (capacity / 2) + 1);//to make sure that there is no item in the knapsack larger than capacity limit and +1 is to make sure that there is no zero values
        }
        return weight;
    }

    public void setWeight(double[] weight) {
        this.weight = weight;
    }

    public double[] getProfit() {
        for (int i = 0; i < noOfElements; i++) {
            profit[i] = Math.round(Math.random() * maxWeight + 1);//multiplied by max weight in the store and added to one to make sure that there is no zero values 
        }
        return profit;
    }
       public int size() {
        return individuals.length;
    }

    public void setProfit(double[] profit) {
        this.profit = profit;
    }
    //generated getters and setters

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public void setNoOfElements(int noOfElements) {
        this.noOfElements = noOfElements;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public byte[][] getIndividual() {
        return individual;
    }

    public void setIndividual(byte[][] individual) {
        this.individual = individual;
    }

    public Individual getSolution() {
        return solution;
    }

    public void setSolution(Individual solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "Population{" + Arrays.deepToString(individual) + "\npopulationSize=" + populationSize + "\nmaxWeight=" + maxWeight + "\nnoOfElements=" + noOfElements + "\ncapacity=" + capacity + "\nweight=" + Arrays.toString(getWeight()) + "\nprofit=" + Arrays.toString(getProfit()) + '}';
    }
//    
    
    

}
