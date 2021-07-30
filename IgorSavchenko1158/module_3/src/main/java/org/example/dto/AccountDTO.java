package org.example.dto;

public class AccountDTO {
    private String alias;
    private Long balance;

    public AccountDTO(String alias, Long balance) {
        this.alias = alias;
        this.balance = balance;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
