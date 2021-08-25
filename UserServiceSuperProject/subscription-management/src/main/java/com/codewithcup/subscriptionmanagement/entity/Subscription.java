package com.codewithcup.subscriptionmanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
//@Entity
@Document
public class Subscription {

    @Id
    private String sId;
    private String userId;
    private Date startDate;
    private Date expireDate;
}
