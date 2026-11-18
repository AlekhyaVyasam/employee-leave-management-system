package com.alekhya.leaveservice.service;

import com.alekhya.leaveservice.entity.Leave;
import com.alekhya.leaveservice.entity.LeaveStatus;
import com.alekhya.leaveservice.exception.LeaveNotFoundException;
import com.alekhya.leaveservice.repository.LeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    @Override
    public Leave applyLeave(Leave leave) {
        if (leave.getEndDate()
                .isBefore(leave.getStartDate())) {

            throw new IllegalArgumentException(
                    "End date cannot be before start date");
        }

        leave.setStatus(LeaveStatus.PENDING);

        return leaveRepository.save(leave);
    }

    @Override
    public List<Leave> getAllLeaves() {

        return leaveRepository.findAll();
    }

    @Override
    public Leave getLeaveById(Long id) {

        return leaveRepository.findById(id)
                .orElseThrow(() ->
                        new LeaveNotFoundException(
                                "Leave not found with id " + id));
    }

    @Override
    public Leave approveLeave(Long id) {

        Leave leave = getLeaveById(id);

        leave.setStatus(LeaveStatus.APPROVED);

        return leaveRepository.save(leave);
    }

    @Override
    public Leave rejectLeave(Long id) {

        Leave leave = getLeaveById(id);

        leave.setStatus(LeaveStatus.REJECTED);

        return leaveRepository.save(leave);
    }
}