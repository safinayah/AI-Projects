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
public class Individual {

    private static int noOfElements = 6;

    private byte[] genes = new byte[noOfElements];
    private int fitness = 0;

    // Create a random individual
    public Individual() {
        generateIndividual();

    }

    public void generateIndividual() {//individuals generated randomly
        for (int i = 0; i < noOfElements; i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }

    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public byte[] getGenes() {
      
        return genes;

    }
    
    public byte[] getNewGenes(){
          generateIndividual();
          return genes;
    }

    public void setGenes(byte[] genes) {
        this.genes = genes;
    }

    public static int getNoOfElements() {
        return noOfElements;
    }

    public static void setNoOfElements(int NoOfElements) {
        noOfElements = NoOfElements;
    }


    @Override
    public String toString() {
        return "Individual{" + "genes=" + Arrays.toString(genes) + '}';
    }

}
