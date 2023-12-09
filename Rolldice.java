
import java.util.*;

class Dice{
     public Dice(){
        System.out.println("Dice Initialized");
     }
     public int roll(){
        Random rm=new Random(); //random class instance created
        return rm.nextInt(6)+1; //returns number between 1 and 6
     }
}




class MaxDiceCount{
    private  int[] diceCount; //stores count of dice frequency in map
    public MaxDiceCount(){
        diceCount=new int[7];
        System.out.println("Start throwing Dice. Begin the Game!!!!");
    }
    public void insert(int num){
        diceCount[num]++;  //updating the dice throw in diceCount.
    }
    public void displayAll(){  //prints all dice frequencies
        System.out.println("\nFrequencies: ");
        for(int i=1;i<diceCount.length;i++){
            System.out.println("Dice "+i+": "+diceCount[i]);
        }
    }
    public List<Integer> maxFrequencyDice(){
      
      int maxThrow=0;
      for(int i=1;i<diceCount.length;i++){   //find maxfrequency in diceCount array
        maxThrow=Math.max(diceCount[i],maxThrow);
      }

      List<Integer> list=new ArrayList<>();  
      for(int i=1;i<diceCount.length;i++){   //add all dice to list whose frequency matches maxfrequcy
        if(diceCount[i]==maxThrow)
            list.add(i);
      }
      return list;
    }

}



class Rolldice{

    public static void main(String ar[]){
       
        Dice dc=new Dice();  //initialized dice object
        MaxDiceCount  mdc=new MaxDiceCount();  //initialize maxdice object


        //rolling dice 20 times
        for(int i=0;i<20;i++){  
           int top= dc.roll();  // dice throw
           mdc.insert(top);
           System.out.println("Roll "+(i+1)+" :"+top);
        }



        mdc.displayAll();  //printing frequencies for all
        System.out.print("Finally Dice that appeared max number of times is ");
        System.out.println(mdc.maxFrequencyDice());

    }
}