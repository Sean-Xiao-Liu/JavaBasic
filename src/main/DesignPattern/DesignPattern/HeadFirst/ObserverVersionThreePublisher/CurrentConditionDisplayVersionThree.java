package DesignPattern.HeadFirst.ObserverVersionThreePublisher;

import java.util.concurrent.Flow;

public class CurrentConditionDisplayVersionThree implements Flow.Subscriber {
    private Flow.Subscription subscription;


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Object item) {
        System.out.println("Received Letter: " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error Occurred: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Every Element has been received");
    }
}
