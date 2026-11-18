package com.alekhya.leaveservice.service;

import com.alekhya.leaveservice.entity.Leave;


import java.util.List;

public interface LeaveService {

    Leave applyLeave(Leave leave);

    List<Leave> getAllLeaves();

    Leave getLeaveById(Long id);

    Leave approveLeave(Long id);

    Leave rejectLeave(Long id);
}
