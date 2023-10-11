package Sem3;

class Account {

    private String accountNumber;
    private String customerId;
    private String bankBranch;
    private double balance;
    private double interestRate;

    public Account  (Builder builder) {
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

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder bankBranch(String bankBranch) {
            this.bankBranch = bankBranch;
            return this;
        }

        public Builder balance(double balance) {
            this.balance= balance;
            return this;
        }

        public Builder interestRate(double interestRate) {
            this.interestRate= interestRate;
            return this;
        }

        public Account build() {
            return new Bui
        }

    }

    // ... omitted code ...
}
class Ex04 {

}
