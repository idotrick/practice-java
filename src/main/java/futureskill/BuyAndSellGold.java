package futureskill;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyAndSellGold {
    @Test
    void t1(){
        API api = new API(List.of(1, 2, 3));
        Solution solution = new Solution(api);
        assertEquals(0,solution.getBuyDay());
        assertEquals(2,solution.getSellDay());
    }

    @Test
    void t2(){
        API api = new API(List.of(1, 2, 1));
        Solution solution = new Solution(api);
        assertEquals(0,solution.getBuyDay());
        assertEquals(1,solution.getSellDay());
    }

    @Test
    void t3(){
        API api = new API(new ArrayList<>());
        Solution solution = new Solution(api);
        assertEquals(0,solution.getBuyDay());
        assertEquals(0,solution.getSellDay());
    }

    @Test
    void t4(){
        API api = new API(List.of(7,12,2,5,3,6,10,11,9,2));
        Solution solution = new Solution(api);
        assertEquals(2,solution.getBuyDay());
        assertEquals(7,solution.getSellDay());
    }

    @Test
    void t5(){
        API api = new API(List.of(12,8,22,4,10,8,12,11,16,10));
        Solution solution = new Solution(api);
        assertEquals(1,solution.getBuyDay());
        assertEquals(2,solution.getSellDay());
    }

    @Test
    void t6(){
        API api = new API(List.of(12,8));
        Solution solution = new Solution(api);
        assertEquals(0,solution.getBuyDay());
        assertEquals(1,solution.getSellDay());
    }
}

interface SolutionInterface {
    int getBuyDay();
    int getSellDay();
}

class API {
    private List<Integer> prices;

    API(List<Integer> prices) {
        this.prices = prices;
    }

    int getNumDays() {
        return this.prices.size();
    }

    int getPriceOnDay(int day) {
        return this.prices.get(day);
    }
}

class Solution implements SolutionInterface {
    int buyDay, sellDay;
    private API API;

    public Solution(API api) {
        this.API=api;
        this.buyDay=0;
        this.sellDay=0;
        getPricesGen2();
    }

    /**
     * Gen1 Solution with O(n^2) complexity
     */
    void getPricesGen1() {
        int numDays = API.getNumDays();
        int maxProfit = 0;
        for(int i=0;i<numDays;i++) {
            for(int j=i+1;j<numDays;j++) {
                int buyPrice = API.getPriceOnDay(i);
                int sellPrice = API.getPriceOnDay(j);
                if(buyPrice<sellPrice) {
                    int profit = sellPrice - buyPrice;
                    if(maxProfit<profit) {
                        maxProfit = profit;
                        buyDay = i;
                        sellDay = j;
                    }
                }
            }
        }
    }

    /**
     * Gen2 solution with O(n) complexity
     */
    void getPricesGen2() {
        int numDays = API.getNumDays();
        int maxProfit = -1;
        int temptedProfit = -1;
        int buyPrice = 0;
        int buyDay = -1;
        int sellPrice = 0;
        int sellDay = -1;

        for(int i=0;i<numDays;i++) {
            int todayPrice = API.getPriceOnDay(i);
            if(i==0) {
                buyPrice = todayPrice;
                buyDay = i;
            } else {
                if (todayPrice >= buyPrice) {
                    if (todayPrice > sellPrice) {
                        sellPrice = todayPrice;
                        sellDay = i;
                    }
                } else {
                    buyPrice = todayPrice;
                    buyDay = i;
                    sellPrice = 0;
                    sellDay = -1;
                }
            }

            temptedProfit = sellPrice - buyPrice;
            if(i == 0 || temptedProfit > maxProfit) {
                maxProfit = temptedProfit;
                this.buyDay = buyDay;
                this.sellDay = sellDay;
            }
        }

    }

    public int getBuyDay() {
        return this.buyDay;
    }

    public int getSellDay() {
        return this.sellDay;
    }
}