package com.codewithcup.subscriptionmanagement.service;

import com.codewithcup.subscriptionmanagement.payload.SubscriptionPayload;

public interface SubscriptionService {
    public SubscriptionPayload createSubscription(String userId);

    public SubscriptionPayload getSubScriptions(String userId);
}
