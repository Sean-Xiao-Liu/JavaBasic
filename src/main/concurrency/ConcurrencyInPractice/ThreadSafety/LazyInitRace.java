package ConcurrencyInPractice.ThreadSafety;

import ConcurrencyInPractice.Annotation.NotThreadSafe;

import java.util.ArrayList;


/**
 * “LazyInitRace has race conditions that can undermine its correctness.
 * Say that threads A and B execute getInstance at the same time.
 * A sees that instance is null, and instantiates a new ExpensiveObject.
 * B also checks if instance is null. Whether instance is null at this point depends unpredictably on timing,
 * including the vagaries of scheduling and how long A takes to instantiate the ExpensiveObject and set the instance field.
 * If instance is null when B examines it, the two callers to getInstance may receive two different results,
 * even though getInstance is always supposed to return the same instance.”
 *
 * **/
@NotThreadSafe
public class LazyInitRace {
    private ArrayList instance = null;

    public ArrayList getInstance() {
        if (instance == null)
            instance = new ArrayList<>();
        return instance;
    }
}
