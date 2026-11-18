package com.alekhya.leaveservice.controller;

import com.alekhya.leaveservice.entity.Leave;
import com.alekhya.leaveservice.service.LeaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping
    public Leave applyLeave(
            @Valid @RequestBody Leave leave) {

        return leaveService.applyLeave(leave);
    }

    @GetMapping
    public List<Leave> getAllLeaves() {

        return leaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Leave getLeaveById(
            @PathVariable Long id) {

        return leaveService.getLeaveById(id);
    }

    @PutMapping("/{id}/approve")
    public Leave approveLeave(
            @PathVariable Long id) {

        return leaveService.approveLeave(id);
    }

    @PutMapping("/{id}/reject")
    public Leave rejectLeave(
            @PathVariable Long id) {

        return leaveService.rejectLeave(id);
    }
}