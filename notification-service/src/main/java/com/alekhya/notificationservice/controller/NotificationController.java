package com.alekhya.notificationservice.controller;

import com.alekhya.notificationservice.entity.Notification;
import com.alekhya.notificationservice.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public Notification sendNotification(
            @Valid @RequestBody Notification notification) {

        return notificationService.sendNotification(notification);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {

        return notificationService.getAllNotifications();
    }
}