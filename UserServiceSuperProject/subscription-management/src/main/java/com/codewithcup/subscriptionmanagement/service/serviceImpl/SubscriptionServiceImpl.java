package com.codewithcup.subscriptionmanagement.service.serviceImpl;
import com.codewithcup.subscriptionmanagement.entity.Subscription;
import com.codewithcup.subscriptionmanagement.payload.SubscriptionPayload;
import com.codewithcup.subscriptionmanagement.repository.SubscriptionRepository;
import com.codewithcup.subscriptionmanagement.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    protected SubscriptionRepository subscriptionRepository;

    @Override
    public SubscriptionPayload createSubscription(String userId) {

        Subscription subscription = subscriptionRepository.findByUserId(userId);
        if (subscription == null){
            subscription = new Subscription();
            subscription.setStartDate(new Date());
            subscription.setExpireDate(Date.from(Instant.now().plus(7, ChronoUnit.DAYS)));

        }else{
            subscription.setStartDate(new Date());
            subscription.setExpireDate(Date.from(Instant.now().plus(7, ChronoUnit.DAYS)));
        }
        subscription.setUserId(userId);
        Subscription save = subscriptionRepository.save(subscription);
        return new SubscriptionPayload(subscription);

    }

    @Override
    public SubscriptionPayload getSubScriptions(String userId) {
        Subscription subscription = subscriptionRepository.findByUserId(userId);
        return new SubscriptionPayload(subscription);
    }


}
