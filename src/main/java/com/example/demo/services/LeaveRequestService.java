package com.example.demo.services;

import com.example.demo.models.HandoverAcceptance;
import com.example.demo.models.LeaveApproval;
import com.example.demo.models.LeaveRequest;
import org.flowable.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LeaveRequestService {

    @Autowired
    private RuntimeService runtimeService;

    public ResponseEntity<String> submitLeaveRequest(LeaveRequest leaveRequest) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("employeeName", leaveRequest.getEmployeeName());
        variables.put("startDate", leaveRequest.getStartDate());
        variables.put("numOfDays", leaveRequest.getNumOfDays());
        variables.put("reason", leaveRequest.getReason());

        runtimeService.startProcessInstanceByKey("leaveRequestProcess", variables);
        return ResponseEntity.ok("Leave request submitted successfully.");
    }

    public ResponseEntity<String> acceptHandover(HandoverAcceptance handoverAcceptance) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("handoverAccepted", handoverAcceptance.isAccepted());
        variables.put("comments", handoverAcceptance.getComments());

        runtimeService.signalEventReceived("handoverAcceptedSignal", variables);
        return ResponseEntity.ok("Handover acceptance submitted successfully.");
    }

    public ResponseEntity<String> approveLeave(LeaveApproval leaveApproval) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("approvalGranted", leaveApproval.isApproved());
        variables.put("comments", leaveApproval.getComments());

        runtimeService.signalEventReceived("leaveApprovalSignal", variables);
        return ResponseEntity.ok("Leave approval submitted successfully.");
    }
}
