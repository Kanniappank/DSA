package org.com.splitwise.service;

import org.com.splitwise.Exceptions.ContributionExceededException;
import org.com.splitwise.Exceptions.ExpenseSettledException;
import org.com.splitwise.Exceptions.InvalidExpenseState;
import org.com.splitwise.Model.*;
import org.com.splitwise.repository.ExpenseRepository;
import org.com.splitwise.repository.UserRepository;

public class UserService {
    public User createUser(String emailId, String name, String phoneNumber) {
        User user = new User(emailId, name, phoneNumber);
        UserRepository.userHashMap.putIfAbsent(emailId, user);
        return user;
    }

    public void contributeToExpense(String expenseId, String emailId, Contribution contribution) throws InvalidExpenseState, ExpenseSettledException, ContributionExceededException {
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        ExpenseGroup expenseGroup = expense.getExpenseGroup();
        if (expense.getExpenseStatus() == ExpenseStatus.CREATED) {
            throw new InvalidExpenseState("Invalid expense State");
        } else if (expense.getExpenseStatus() == ExpenseStatus.SETTLED) {
            throw new ExpenseSettledException("Expense is already settled");
        }

        UserShare userShare = expenseGroup.getUserContributions().get(emailId);
        if (contribution.getContributionValue() > userShare.getShare()) {
            throw new ContributionExceededException(String.format("User %s contribution %f exceeds the share %f", emailId, contribution.getContributionValue(), userShare.getShare()));
        }
        userShare.getContributions().add(contribution);

    }
}
