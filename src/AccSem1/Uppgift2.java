package AccSem1;

import java.util.Scanner;

interface Database {
    boolean addEmployee(int employeeId, String name, String accountNumber);
    boolean setSalary(int employeeId, double salaray);
    double getSalary(int employeeId);
    String getAccountNumber(int employeeId);
}

interface PaymentSystem {
    void transfer(String fromAccount, String toAccount, double amount);
}

interface Command {
    void execute(Database db, PaymentSystem ps);
}

class AddEmployeeCommand implements Command {
    private int employeeId;
    private String name;
    private String accountId;
    private double salary;

    public AddEmployeeCommand(int employeeId, String name, String accountId, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.accountId = accountId;
        this.salary = salary; 
    }

    public static Command create(String[] parts) { //Vi skickar tillbaka ett command istället för ett AddEmployeeCommand för att vi vill kunna skicka tillbaka en command som innebär ett illegalCommand
        try {
            var employeeId = Utils.parseInt(parts[1]);
            var name = parts[2];
            var salary = Utils.parseDouble(parts[3]);
            var accountNumber = parts[4];
            return new AddEmployeeCommand(employeeId, name, accountNumber, salary);
        } catch (Exception dontCare) {
            return new IllegalCommand.create(parts);
        }
    }

    public void execute(Database db, PaymentSystem ps) {
        db.addEmployee(employeeId, name, accountId);
        db.setSalary(employeeId, salary);
    }
    
}

class Admin {
    public void process(Database db, PaymentSystem ps) {
        var input = new Scanner(System.in).useDelimiter("\n");
        var parser = new CommandParser();
        while (input.hasNext()) {
            parser.parse(input.nextLine()).execute(db, ps);
        }
    }
}

class IllegalCommand {

}

class CommandParser {
    public Command parse(String line) {
        var parts = line.split(",");
        return 
            swtich (parts[0]) {
            case "add" -> AddEmployeeCommand.create(parts);   
            default -> IllegalCommand.create(parts); 
            }
    }
}