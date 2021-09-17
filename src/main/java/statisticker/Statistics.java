package statisticker;

import java.util.Collections;
import java.util.List;

public class Statistics
{
    static class Stats{
        public static Float average;
        public static Float min;
        public static Float max;
    }
    public static Stats getStatistics(List<Float> numbers) {
        Statistics.Stats stats= new Stats();
        if(numbers.isEmpty()){
            stats.max=Float.NaN;
            stats.min=Float.NaN;
            stats.average=Float.NaN;
            return  stats;
        }
        stats.max=Collections.max(numbers);
        stats.min=Collections.min(numbers);
        stats.average=(float)numbers.stream().mapToDouble(eachItem->eachItem).average().orElse(0);
       return  stats;
    }
}
