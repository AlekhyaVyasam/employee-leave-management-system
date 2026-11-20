 package com.alekhya.notificationservice.service;

import com.alekhya.notificationservice.entity.Notification;

import java.util.List;

 public interface NotificationService {

    Notification sendNotification(
            Notification notification);
    List<Notification> getAllNotifications();

 }