package com.codewithcup.subscriptionmanagement.repository;

import com.codewithcup.subscriptionmanagement.entity.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription ,String> {

     Subscription findByUserId(String userId);
}
