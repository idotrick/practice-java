package futureskill;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyAndSellGold {
    @Test
    void t1(){
        API api = new API(List.of(1, 2, 3));
        Solution solution = new Solution(api);
        assertEquals(solution.getBuyDay(),0);
        assertEquals(solution.getSellDay(),2);
    }

    @Test
    void t2(){
        API api = new API(List.of(1, 2, 1));
        Solution solution = new Solution(api);
        assertEquals(solution.getBuyDay(),0);
        assertEquals(solution.getSellDay(),1);
    }

    @Test
    void t3(){
        API api = new API(new ArrayList<>());
        Solution solution = new Solution(api);
        assertEquals(solution.getBuyDay(),0);
        assertEquals(solution.getSellDay(),0);
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
        getPrices();
    }

    void getPrices() {
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

    public int getBuyDay() {
        return this.buyDay;
    }

    public int getSellDay() {
        return this.sellDay;
    }
}