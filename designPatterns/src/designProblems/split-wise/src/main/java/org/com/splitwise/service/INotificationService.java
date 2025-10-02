package org.com.splitwise.service;

import org.com.splitwise.Model.Expense;
import org.com.splitwise.Model.User;

public interface INotificationService {
    void notifyUser(User user, Expense expense);
}
