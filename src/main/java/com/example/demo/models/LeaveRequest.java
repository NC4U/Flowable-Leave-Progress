package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveRequest {
    private String employeeName;
    private String startDate;
    private int numOfDays;
    private String reason;
}
