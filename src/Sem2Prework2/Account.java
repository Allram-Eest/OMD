package Sem2Prework2;

public class Account {

    private String accountNumber;
    private String customerId;
    private String bankBranch;
    private double balance;
    private double interestRate;

    private Account  (Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.customerId = builder.customerId;
        this.bankBranch = builder.bankBranch;
        this.balance = builder.balance;
        this.interestRate = builder.interestRate;
    }

    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String accountNumber;
        private String customerId;
        private String bankBranch;
        private double balance;
        private double interestRate;

        private Builder() {

        }

        public Builder accountNumber(String acc) {
            this.accountNumber = acc;
            return this;
        }

        public Builder customerId(String id) {
            this.customerId = id;
            return this;
        }

        public Builder bankBranch(String branch) {
            this.bankBranch = branch;
            return this;
        }
        
        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder interestRate(double rate) {
            this.interestRate = rate;
            return this;
        }

        public Account build() {
            return new Account  (this);
        }
        
    }  
}

