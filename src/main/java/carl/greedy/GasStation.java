package carl.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // gas = [1,2,3,4,5]
        // cost = [3,4,5,1,2]
        // 局部最优和全局最优
        int curSum = 0;
        // *还要记录totalSum，totalSum小于0那么一定不可达
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i]-cost[i];
            curSum += rest;
            totalSum += rest;
            if (curSum < 0){
                curSum = 0;
                start = i+1;
            }
        }

        if (totalSum < 0){
            return -1;
        }

        return start;


    }
}
