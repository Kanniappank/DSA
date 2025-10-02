package org.com.splitwise.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class ExpenseGroup {
    private final Set<User> groupMembers;
    private final String expenseGroupId;
    @Setter
    private Map<String, UserShare> userContributions;

    public ExpenseGroup() {
        this.expenseGroupId = UUID.randomUUID().toString();
        this.groupMembers = new HashSet<>();
        this.userContributions = new HashMap<>();
    }
}
