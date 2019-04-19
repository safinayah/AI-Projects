package knapsack;



/**
 *
 * @author ayah
 */

public class FitnessCalc {

    Population pop = new Population(10,10);
    double profit[] = pop.getProfit();
    int populationSize = pop.getPopulationSize();
    int noOfElements = pop.getNoOfElements();

   public int isFeasibile(Individual individual) {
        int size = individual.size()-1;
        byte[] temp = new byte[size]; 
//                System.out.println("ooooooooooooo"+Arrays.toString(individual.getGenes()));
     
        int total  =0;
//        System.out.println(Arrays.toString(pop.getWeight()));
         temp = individual.getGenes();

        for (int i =0 ; i <=size; i++) {

            if (temp[i] == 1) {
              total += profit[i];
//                    System.out.println("profit summary : \n" + "individual = " + Arrays.toString(temp) + " , i = " + i + " , item : " + temp[i] + " , weight = " + profit[i] + " , total = " + total);

              
            }//end of outer if statement
            
        }//end of for loop
        return total; 

    }//end of method
}

