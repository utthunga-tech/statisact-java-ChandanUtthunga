package statisticker;

import java.util.Collections;
import java.util.List;

public class StatsChecker {

    private  IAlerter[] alerters;
    private float maxThreshold;
    public StatsChecker(float maxThreshold, IAlerter[] alerters) {
        this.alerters = alerters;
        this.maxThreshold = maxThreshold;
    }

    public void checkAndAlert(List<Float> numbers) {
        float max= Collections.max(numbers);
        if(max>this.maxThreshold){
            if(alerters.length ==2){
                if(alerters[0] instanceof  EmailAlert){
                    EmailAlert emailAlert=(EmailAlert)alerters[0];
                    emailAlert.emailSent=true;
                    LEDAlert ledAlert=(LEDAlert)alerters[1];
                    ledAlert.ledGlows=true;
                }else{
                    EmailAlert emailAlert=(EmailAlert)alerters[1];
                    emailAlert.emailSent=true;
                    LEDAlert ledAlert=(LEDAlert)alerters[0];
                    ledAlert.ledGlows=true;
                }
            }
        }
    }
}
