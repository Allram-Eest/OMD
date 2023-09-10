package Sem1;

public class Up2 {
    
}

interface Database {
    boolean addEmployee(int employeeId, String name, String accountNumber);
    boolean setSalary(int employeeId, double salary);
    double getSalary(int employeeId);
    String getAccountNumber(int employeeId);
}

interface PaymentSystem {
    void transfer(String fromAccount, String toAccount, double amount);
}

interface employeeCommand {
    public void execute(Database database, PaymentSystem paySystem);
}

class addCommand implements employeeCommand {
    private int employeeId;
    private String name;
    private String accountNumber;

    public addCommand(int employeeId, String name, String accountNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public void execute(Database database, PaymentSystem paySystem) {
        database.addEmployee(employeeId, name, accountNumber);
    }

}

class payCommand implements employeeCommand {
    private int employeeId;

    public payCommand(int employeeId) {
        this.employeeId = employeeId;
    }

    public void execute(Database database, PaymentSystem paySystem) {
        paySystem.transfer("60-220-816", database.getAccountNumber(employeeId), database.getSalary(employeeId));
    }

}

class salaryCommand implements employeeCommand {
    private int employeeId;
    private double salary;

    public salaryCommand(int employeeId, double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void execute(Database database, PaymentSystem paySystem) {
        database.setSalary(employeeId, salary);
    }

}

class CommandCreator {



    public static employeeCommand createCommand(String s) {
        String[] commands = s.split(",");
        if (commands[0].equals("add")) {
            return new

        }

    } 

} 