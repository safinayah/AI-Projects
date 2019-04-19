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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Population population = new Population(100, 100);
        Algorithm a = new Algorithm();
        byte[] temp1 = new byte[population.getNoOfElements()];
        byte[] temp2 = new byte[population.getNoOfElements()];

        FitnessCalc f = new FitnessCalc();
        double percentage = 0.77;

        int size = (int) (population.getPopulationSize() * percentage);
//        for (int i=0 ; i<size; i++){
        Individual indOne = new Individual();
//        System.out.println(indOne.toString());
        Individual indTwo = new Individual();
        indTwo.getGenes();
//      System.out.println(Arrays.toString(population.getWeight()));
//              System.out.println(Arrays.toString(indTwo.getGenes()));
        System.out.println(Arrays.toString(population.getProfit()));
//        System.out.println("ind :::: "+indTwo.toString());
//        System.out.println("profit ::::    "+f.calculateFitness(indTwo));
////       }
   
//            //selection
          a.randomSelection(population);
//            //TODO crossOver
//            //TODO mutation
//            //TODO replacement
//            
//            
//            
   

//       System.out.println(population.toString());
//
     
    }

}
