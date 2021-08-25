package com.codewithcup.usermanage.payload;

import lombok.Data;

import java.util.Date;

@Data
public class SubscriptionPayload {
    private Date startDate;
    private Date expireDate;
    private Integer days;

    public SubscriptionPayload(Date startDate, Date expireDate){
        super();
        this.startDate = startDate;
        this.expireDate = expireDate;
    }

//    public SubscriptionPayload(Subscription subscription) {
//        if(subscription != null){
//            setStartDate(subscription.getStartDate());
//            setExpireDate(subscription.getExpireDate());
//
//        }
//    }
}
