package ExTentor.ExTenta2021;

class Simulation {
    private boolean trace = false;
    public Simulation() {
        // . . . omitted code . . .
    }

    public void showTrace(boolean trace) {
        this.trace = trace;
    }

    public void run() {
        if (trace) {
            System.out.println("Starting simulation");
        }
            // . . . omitted firs t half of simulation . . .
        if (trace) {
            System.out.println("Halfway through simulation");
        }
            // . . . omitted last half of simulation . . .
        if (trace) {
            System.out.println("Finishing simulation");
        }
    }
}

class ModifiedSimulation {
    private boolean trace = false;
    public ModifiedSimulation() {
        // . . . omitted code . . .
    }

    public void showTrace(boolean trace) {
        this.trace = trace;
    }

    public void run(Reporter reporter) {
        if (trace) {
            reporter.report("Starting simulation");
        }
            // . . . omitted firs t half of simulation . . .
        if (trace) {
            reporter.report("Halfway through simulation");
        }
            // . . . omitted last half of simulation . . .
        if (trace) {
            reporter.report("Finishing simulation");
        }
    }

    public static void main(String[] args) {
        ModifiedSimulation sim = new ModifiedSimulation();
        sim.run(new VoidReporter());
        sim.run(new SpeechReporter());
    }
}

interface Reporter {

   public void report(String s);

}

class VoidReporter implements Reporter {

    public void report(String s) {
        return;
    }
}

class SpeechReporter implements Reporter {
    private SpeechSynthesizer speaker;

    public SpeechReporter() {
        speaker = new SpeechSynthesizer();
    }

    public void report(String s) {
        speaker.say(s);
        return;
    }
}

