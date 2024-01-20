package com.example.Sem3HW.services;

import com.example.Sem3HW.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис регистрации новых ползователей.
 */
@Service
public class RegistrationService {
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    /**
     * Поле сервиса работы с хранилищем пользователей
     */

    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Поле сервиса создания пользователей
     */
    @Autowired
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }

    /**
     * Поле сервиса уведомлений
     */
    @Autowired
    private NotificationService notificationService;
    public NotificationService getNotificationService() {
        return notificationService;
    }


public void processRegistration(String name, int age, String email){
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(createUser);
        notificationService.sendNotification("Пользователь создан");
}
}