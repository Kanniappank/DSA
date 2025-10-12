package org.com.splitwise.service;

import org.com.splitwise.Exceptions.ExpenseDoesNotExistException;
import org.com.splitwise.Exceptions.ExpenseSettledException;
import org.com.splitwise.Model.*;
import org.com.splitwise.repository.ExpenseRepository;
import org.com.splitwise.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class ExpenseService {

    private INotificationService notificationService = new NotificationService();

    public Expense createExpense(String title, String description, LocalDateTime expenseDate, double expenseAmount, String userId) {
        Expense expense = Expense.builder()
                .expenseId(UUID.randomUUID().toString())
                .title(title)
                .description(description)
                .expenseDate(expenseDate)
                .expenseAmount(expenseAmount)
                .userId(userId)
                .expenseStatus(ExpenseStatus.CREATED)
                .expenseGroup(new ExpenseGroup())
                .build();

        ExpenseRepository.expenseMap.putIfAbsent(expense.getExpenseId(), expense);

        return expense;
    }

    public void addUserToExpense(String expenseId, String emailId) throws ExpenseDoesNotExistException {
        if (!ExpenseRepository.expenseMap.containsKey(expenseId)) {
            throw new ExpenseDoesNotExistException("Best create a expense and come here....");
        }
        ExpenseRepository.expenseMap.get(expenseId).getExpenseGroup().getGroupMembers().add(UserRepository.userHashMap.get(emailId));

        if (notificationService != null) {
            notificationService.notifyUser(UserRepository.userHashMap.get(emailId), ExpenseRepository.expenseMap.get(expenseId));
        }
    }

    public void assignExpenseShare(String expenseId, String emailId, double share) throws ExpenseDoesNotExistException {
        if (!ExpenseRepository.expenseMap.containsKey(expenseId)) {
            throw new ExpenseDoesNotExistException(String.format("Expense %s does not exist", expenseId));
        }
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        expense.getExpenseGroup().getUserContributions().putIfAbsent(emailId, new UserShare(emailId, share));
    }

    public void setExpenseStatus(String expenseId, ExpenseStatus expenseStatus) {
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        expense.setExpenseStatus(expenseStatus);
    }

    public boolean isExpenseSettled(String expenseId) {
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        ExpenseGroup expenseGroup = expense.getExpenseGroup();
        Map<String, UserShare> userContributions = expenseGroup.getUserContributions();

        double total = expense.getExpenseAmount();

        for (Map.Entry<String, UserShare> entry : userContributions.entrySet()) {
            UserShare share = entry.getValue();
            for (Contribution contribution : share.getContributions()) {
                total -= contribution.getContributionValue();
            }
        }
        return total <= 1;
    }


}
