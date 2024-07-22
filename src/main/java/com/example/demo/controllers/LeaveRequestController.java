package com.example.demo.controllers;

import com.example.demo.models.HandoverAcceptance;
import com.example.demo.models.LeaveApproval;
import com.example.demo.models.LeaveRequest;
import com.example.demo.services.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave-request")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.submitLeaveRequest(leaveRequest);
    }

    @PostMapping("/handover-acceptance")
    public ResponseEntity<String> acceptHandover(@RequestBody HandoverAcceptance handoverAcceptance) {
        return leaveRequestService.acceptHandover(handoverAcceptance);
    }

    @PostMapping("/approval")
    public ResponseEntity<String> approveLeave(@RequestBody LeaveApproval leaveApproval) {
        return leaveRequestService.approveLeave(leaveApproval);
    }
}
