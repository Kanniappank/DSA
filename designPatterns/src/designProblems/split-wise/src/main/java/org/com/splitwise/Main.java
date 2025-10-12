package org.com.splitwise;

import org.com.splitwise.Exceptions.ContributionExceededException;
import org.com.splitwise.Exceptions.ExpenseDoesNotExistException;
import org.com.splitwise.Exceptions.ExpenseSettledException;
import org.com.splitwise.Exceptions.InvalidExpenseState;
import org.com.splitwise.Model.*;
import org.com.splitwise.repository.ExpenseRepository;
import org.com.splitwise.service.ExpenseService;
import org.com.splitwise.service.UserService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ExpenseService expenseService;
    static UserService userService;

    public static void main(String[] args) throws ContributionExceededException, InvalidExpenseState, ExpenseSettledException {
        try {
            expenseService = new ExpenseService();
            userService = new UserService();
            createTestUser();
            Expense expense = createLunchExpense();
            try {
                bifurcateExpense(expense.getExpenseId());

            } catch (ExpenseDoesNotExistException e) {
                System.out.println(e.getMessage());
            }
            expense.setExpenseStatus(ExpenseStatus.PENDING);

            Set<User> users = expense.getExpenseGroup().getGroupMembers();

            for (User user : users) {
                if(user!=null){
                    contributeToExpense(expense.getExpenseId(), user.getEmail());
                }
            }
            if(expenseService.isExpenseSettled(expense.getExpenseId())){
                System.out.println("Expense settled");
                expenseService.setExpenseStatus(expense.getExpenseId(),ExpenseStatus.SETTLED);
            }
            System.out.println("BYEEE......");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    private static void contributeToExpense(String expenseId, String userId) throws ContributionExceededException, InvalidExpenseState, ExpenseSettledException {
        Contribution contribution = new Contribution();
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        ExpenseGroup expenseGroup = expense.getExpenseGroup();
        UserShare userShare = expenseGroup.getUserContributions().get(userId);
        contribution.setContributionValue(userShare.getShare());
        contribution.setContributionDate(LocalDateTime.now());
        contribution.setTransactionId("T" + Instant.EPOCH);
        contribution.setTransactionDescription("Transferred from UPI");
        userService.contributeToExpense(expenseId, userId, contribution);
    }

    private static void bifurcateExpense(String expenseId) throws ExpenseDoesNotExistException {

        expenseService.addUserToExpense(expenseId, "bob.johnson@example.com");
        expenseService.addUserToExpense(expenseId, "charlie.davis@example.com");
        expenseService.addUserToExpense(expenseId, "diana.lee@example.com");
        expenseService.addUserToExpense(expenseId, "ethan.brown@example.com");

        expenseService.assignExpenseShare(expenseId, ExpenseRepository.expenseMap.get(expenseId).getUserId(), 1000); //expense creater also contributes to the expense

        expenseService.assignExpenseShare(expenseId, "bob.johnson@example.com", (double) 1000);
        expenseService.assignExpenseShare(expenseId, "charlie.davis@example.com", (double) 1000);
        expenseService.assignExpenseShare(expenseId, "diana.lee@example.com", (double) 1000);
        expenseService.assignExpenseShare(expenseId, "ethan.brown@example.com", (double) 1000);

    }

    public static Expense createLunchExpense() {
        return expenseService.createExpense("Team Lunch", "we had a team lunch at KFC", LocalDateTime.of(2025, Month.OCTOBER, 10, 10, 10), 5000, "alice.smith@example.com");
    }

    private static void createTestUser() {

        User user1 = userService.createUser("Alice Smith", "alice.smith@example.com", "123-456-7890");
        User user2 = userService.createUser("Bob Johnson", "bob.johnson@example.com", "234-567-8901");
        User user3 = userService.createUser("Charlie Davis", "charlie.davis@example.com", "345-678-9012");
        User user4 = userService.createUser("Diana Lee", "diana.lee@example.com", "456-789-0123");
        User user5 = userService.createUser("Ethan Brown", "ethan.brown@example.com", "567-890-1234");
        User user6 = userService.createUser("Fiona Clark", "fiona.clark@example.com", "678-901-2345");
        User user7 = userService.createUser("George Miller", "george.miller@example.com", "789-012-3456");
        User user8 = userService.createUser("Hannah Wilson", "hannah.wilson@example.com", "890-123-4567");
        User user9 = userService.createUser("Ian Moore", "ian.moore@example.com", "901-234-5678");
        User user10 = userService.createUser("Julia Taylor", "julia.taylor@example.com", "012-345-6789");
        User user12 = userService.createUser("Kevin Anderson", "kevin.anderson@example.com", "123-123-1234");
        User user13 = userService.createUser("Laura Thomas", "laura.thomas@example.com", "234-234-2345");
        User user14 = userService.createUser("Michael White", "michael.white@example.com", "345-345-3456");
        User user15 = userService.createUser("Nina Harris", "nina.harris@example.com", "456-456-4567");
        User user16 = userService.createUser("Oscar Martin", "oscar.martin@example.com", "567-567-5678");
        User user17 = userService.createUser("Paula King", "paula.king@example.com", "678-678-6789");
        User user18 = userService.createUser("Quinn Scott", "quinn.scott@example.com", "789-789-7890");
        User user19 = userService.createUser("Rachel Green", "rachel.green@example.com", "890-890-8901");
        User user20 = userService.createUser("Sam Young", "sam.young@example.com", "901-901-9012");
        User user21 = userService.createUser("Tina Adams", "tina.adams@example.com", "012-012-0123");

    }
}