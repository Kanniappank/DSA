package org.com.splitwise.Model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    private String expenseId;
    private String title;
    private String description;
    private String userId;
    private LocalDateTime expenseDate;
    private ExpenseStatus expenseStatus;
    private double expenseAmount;
    private ExpenseGroup expenseGroup;
}
