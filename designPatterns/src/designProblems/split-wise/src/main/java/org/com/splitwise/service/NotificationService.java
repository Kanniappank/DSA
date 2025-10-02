package org.com.splitwise.service;

import org.com.splitwise.Model.Expense;
import org.com.splitwise.Model.User;
import org.com.splitwise.repository.UserRepository;

public class NotificationService implements INotificationService {
    @Override
    public void notifyUser(User user, Expense expense) {
        System.out.println("Notify");
    }
}

