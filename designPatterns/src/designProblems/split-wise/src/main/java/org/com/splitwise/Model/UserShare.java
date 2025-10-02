package org.com.splitwise.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserShare {
    private final String userId;
    private final double share;
    private final List<Contribution> contributions;

    public UserShare(String userId, double share) {
        this.userId = userId;
        this.share = share;
        contributions=new ArrayList<>();
    }

}
