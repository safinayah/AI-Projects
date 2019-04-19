/*///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package knapsack;
//

import java.util.Arrays;

/**
 *
 * @author ayah
 */
public class Algorithm {
//

    Population population = new Population(10, 10);
    FeasiblityCalc feasibile = new FeasiblityCalc();
    FitnessCalc fit = new FitnessCalc();
    Individual ind = new Individual();
    Individual indOne = new Individual();
    Individual indTwo = new Individual();
    private final double mutationRate = 15;
    private double mutationProb = 20;
    private final double crossoverRate = 85;
    private double crossoverProb = 90;
    byte[] first;
    byte[] sec;
    int  rn1 = (int) (Math.random() * population.getNoOfElements());//will represent first individual that will be randomlr choosen 
    int rn2 = (int) (Math.random() * population.getNoOfElements());//will represent sec individual that will be randomlr choosen 
    double rn3 = Math.random();//willMath.round( be used for both mutation and crossover propability

    public void randomSelection(Population population) {
//        System.out.println("old Population : " + Arrays.deepToString(population.getIndividual()));
//
//        for (int i=0; i <population.getNoOfElements() ; i++){
        first = population.getIndividual()[rn1];
        sec = population.getIndividual()[rn2];
       
//            if (rn3 <= crossoverProb) {
//                for (int j = 0; j < (int) (population.getNoOfElements() * crossoverRate); j++) {
                     onePointCrossOver(first, sec);
                     System.out.println("chp1");
//                }
//            }
            
//            else if(rn3 >crossoverProb)  {
//            System.out.println("crossover prob can't crossover the solution");
         
           
//            }  

    }
//
//    public void fittestSelection(Population population, double percentage) {
//
//        double sortedProfit[] = fit.getSortedProfit();
//        int indeces[] = fit.getIndex();
//        int n = sortedProfit.length;
//        double temp = 0;
//        int temp2 = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 1; j < (n - i); j++) {
//                if (sortedProfit[j - 1] > sortedProfit[j]) {
//                    //swap elements  
//                    temp = sortedProfit[j - 1];
//                    sortedProfit[j - 1] = sortedProfit[j];
//                    sortedProfit[j] = temp;
//                    //swap array2 elements 
//                    temp2 = indeces[j - 1];
//                    indeces[j - 1] = indeces[j];
//                    indeces[j] = temp2;
//                }
//
//            }
//
//        }
//
//        first = population.getIndividual()[indeces[0]];
//        sec = population.getIndividual()[indeces[1]];
////        System.err.println(Arrays.toString(first));
////        System.err.println(Arrays.toString(sec));
//
//        for (int i = 0; i < (int) (population.getPopulationSize() * percentage); i++) {
//            if (rn3 >= crossoverProb) {
//                for (int j = 0; j < (int) (population.getNoOfElements() * crossoverRate); j++) {
//                    onePointCrossOver(first, sec);
//                }
//
//            }
//
//        }
//    }

    public void onePointCrossOver(byte[] parentOne, byte[] parentTwo) {//this method to crossOver the individuals from half
        int size = (int) (population.getNoOfElements() * mutationRate);
        byte temp[] = new byte[parentOne.length];
        indOne.setGenes(parentOne);
        indOne.setGenes(parentTwo);
      
                     System.out.println("chppppp1");

        if (feasibile.isFeasibile(indOne) <= population.getCapacity() && feasibile.isFeasibile(indTwo) <= population.getCapacity()) {
                            System.out.println("chp2");

            for (int i = parentOne.length / 2; i < parentOne.length; i++) {
                               System.out.println("chp3");

                temp[i] = parentOne[i];
                parentOne[i] = parentTwo[i];
                parentTwo[i] = temp[i];
            }
            
            

            if (rn3 <= mutationProb) {
                for (int j = 0; j < (int) (population.getNoOfElements() * mutationRate); j++){
                     RandomMutation(first, sec);
                }
            }
         
        }     
    }

    public void RandomMutation(byte[] firstParent, byte[] secondParent) {//flips any item randomly 
        indOne.setGenes(firstParent);

        indOne.setGenes(secondParent);

        int randomNumber = (int) (Math.random() * firstParent.length);

        if (firstParent[randomNumber] == 0) {
            firstParent[randomNumber] = 1;
        } else if (firstParent[randomNumber] == 1) {
            firstParent[randomNumber] = 0;
        }

        if (secondParent[randomNumber] == 0) {
            secondParent[randomNumber] = 1;
        } else if (secondParent[randomNumber] == 1) {
            secondParent[randomNumber] = 0;
        }

       System.out.println("items after mutation: \nfirst individual  " + Arrays.toString(firstParent));
//        System.out.println("new Population  : " + Arrays.deepToString(population.getIndividual()));
        replacement(firstParent, secondParent, population);
    }

    public Population replacement(byte[] indOne, byte[] indTwo, Population pop) {
        Individual indiv = new Individual();

        System.out.println("Old Population  : " + Arrays.deepToString(pop.getIndividual()));

        int rnOne = (int) (Math.random() * pop.getPopulationSize());
        int rnTwo = (int) (Math.random() * pop.getPopulationSize());
        if (rnOne != rnTwo) {
            pop.getIndividual()[rnOne] = indOne;
            pop.getIndividual()[rnTwo] = indOne;
        }
        if (rnOne == rnTwo) {
            rnTwo = (int) (Math.random() * pop.getPopulationSize());
            pop.getIndividual()[rnOne] = indOne;
            pop.getIndividual()[rnTwo] = indTwo;
        }

            System.out.println("weight array " + Arrays.toString(feasibile.getWeight()));
            System.out.println( " profit : " + fit.isFeasibile(indiv) + " weight : " + feasibile.isFeasibile(indiv));
        
        return population;
    }

}
