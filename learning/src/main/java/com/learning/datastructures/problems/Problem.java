package com.learning.datastructures.problems;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// distribute the amount equally with minimal transactions
public class Problem {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("a", 10, 0, 0, ""));
        users.add(new User("b", 30, 0, 0, ""));
        users.add(new User("c", 200, 0, 0, ""));
        users.add(new User("d", 300, 0, 0, ""));
        users.add(new User("e", 700, 0, 0, ""));
        int avgAmount = getAverageAmount(users);
        users = addVariableAmount(users, avgAmount);

        users = distributeAmount(users);

    }

    private static List<User> distributeAmount(List<User> users) {
        boolean isContinue = true;
        boolean nonZeroFound = false;
        users.sort(Comparator.comparing(User::getVariableAmount));
        while(isContinue){
            users = distribute(users);
            for (User user : users) {
                if (user.getVariableAmount() != 0) {
                    nonZeroFound = true;
                    break;
                }else{
                    nonZeroFound = false;
                }
            }
            if (!nonZeroFound) {
                break;
            }
        }
        System.out.println("After sorting" + users);
        return users;
    }

    private static List<User> distribute(List<User> users) {
        int firstIndex = 0;
        int lastIndex = users.size() - 1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getVariableAmount() != 0) {
                if (i < users.size())
                    firstIndex = i;
                break;
            }
        }
        for (int j = users.size() - 1; j > 0; j--) {
            if (users.get(j).getVariableAmount() != 0) {
                lastIndex = j;
                break;
            }
        }
        System.out.println("Distribute : " + users);

        if ((users.get(lastIndex).getVariableAmount() + users.get(firstIndex).getVariableAmount()) < 0) {
            users.get(firstIndex).setUsernames(users.get(lastIndex).getName() + "," + users.get(firstIndex).getUsernames());
            users.get(firstIndex).setTransactions(users.get(firstIndex).getTransactions() + 1);
            users.get(firstIndex).setVariableAmount(users.get(lastIndex).getVariableAmount() + users.get(firstIndex).getVariableAmount());
            users.get(lastIndex).setVariableAmount(0);
        } else if ((users.get(lastIndex).getVariableAmount() + users.get(firstIndex).getVariableAmount()) > 0) {
            users.get(firstIndex).setUsernames(users.get(lastIndex).getName() + "," + users.get(firstIndex).getUsernames());
            users.get(firstIndex).setTransactions(users.get(firstIndex).getTransactions() + 1);
            users.get(firstIndex).setVariableAmount(0);
            users.get(lastIndex).setVariableAmount(users.get(lastIndex).getVariableAmount() + users.get(firstIndex).getVariableAmount());
        } else if ((users.get(lastIndex).getVariableAmount() + users.get(firstIndex).getVariableAmount()) == 0) {
            users.get(firstIndex).setUsernames(users.get(lastIndex).getName() + "," + users.get(firstIndex).getUsernames());
            users.get(firstIndex).setTransactions(users.get(firstIndex).getTransactions() + 1);
            users.get(firstIndex).setVariableAmount(0);
            users.get(lastIndex).setVariableAmount(0);
        }
        return users;
    }

    private static List<User> addVariableAmount(List<User> users, int avgAmount) {
        for (User user : users) {
            user.setVariableAmount(avgAmount - user.getInitialAmount());
        }
        System.out.println(users);
        return users;
    }

    private static int getAverageAmount(List<User> users) {
        int averageAmount = 0;
        int totalAmount = 0;
        for (User user : users) {
            totalAmount = totalAmount + user.getInitialAmount();
        }
        averageAmount = totalAmount / users.size();
        return averageAmount;
    }
}

@Data
@AllArgsConstructor
class User {

    private String name;
    private int initialAmount;
    private int variableAmount;
    private int transactions;
    private String usernames;
}