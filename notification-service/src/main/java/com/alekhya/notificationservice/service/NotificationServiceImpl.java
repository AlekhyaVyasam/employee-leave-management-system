package com.alekhya.notificationservice.service;

import com.alekhya.notificationservice.entity.Notification;
import com.alekhya.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl
        implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public Notification sendNotification(
            Notification notification) {

        notification.setNotificationTime(
                LocalDateTime.now());

        log.info(
                "Notification sent to {} with message {}",
                notification.getEmail(),
                notification.getMessage());

        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }

}