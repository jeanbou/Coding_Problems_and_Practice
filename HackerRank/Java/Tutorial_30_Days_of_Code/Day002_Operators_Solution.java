package hackerRank_Java30DaysOfCode;

import java.util.Scanner;

public class Day002_Operators_Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        
        double totalCost = meal_cost*(1+0.01*(tip_percent + tax_percent));
        System.out.println("The total meal cost is "+Math.round(totalCost)+" dollars.");
        
        in.close();
    }
}
