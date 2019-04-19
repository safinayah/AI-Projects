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
public class FeasiblityCalc {

//    Algorithm algorithm = new Algorithm();
//    Individual individual = new Individual();
    Population pop = new Population();
    private double weight[] = pop.getWeight();
    private int populationSize = pop.getPopulationSize();
    private int noOfElements = pop.getNoOfElements();

    public int isFeasibile(Individual individual) {
        int size = individual.size()-1;
        byte[] temp = new byte[size]; 
        int max = pop.getCapacity();
        int total  =0;
         temp = individual.getGenes();

        for (int i =0 ; i <=size; i++) {

            if (temp[i] == 1 && total <= max) {
              
                    total += weight[i];
            }//end of outer if statement
            
        }//end of for loop
        return total; 
        
    }//end of method

    public double[] getWeight() {
        return weight;
    }

    public void setWeight(double[] weight) {
        this.weight = weight;
    }
}//end of class
