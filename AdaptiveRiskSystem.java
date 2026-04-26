import java.util.*;

class RiskFactor {
    int si; // severity score
    int rank; // importance weight

    RiskFactor(int si, int rank) {
        this.si = si;
        this.rank = rank;
    }
}

public class AdaptiveRiskSystem {

    // System sensitivity tuning parameter
    static double k = 1.0;

    // Computes weighted aggregate risk across all factors
    public static double calculateRisk(Map<String, RiskFactor> map) {
        double sum = 0;

        for (RiskFactor rf : map.values()) {
            sum += rf.si * rf.rank; // Weighted contribution of each factor
        }

        return k * sum;
    }

    // Converts real-world inputs into structured risk signals
    public static Map<String, RiskFactor> assignScores(
            double txnAmount, String location,
            int loginAttempts, String kyc,
            String fraudHistory,
            int customerAge, String txnType,
            String deviceType, int accountAge,
            String internationalTxn) {

        Map<String, RiskFactor> map = new HashMap<>();
        int si;

        // Transaction exposure scaling
        si = txnAmount > 100000 ? 5 : (txnAmount > 50000 ? 3 : 1);
        map.put("txnAmount", new RiskFactor(si, 4));

        // Geographic risk factor
        si = location.equalsIgnoreCase("International") ? 5 : 1;
        map.put("location", new RiskFactor(si, 5));

        // Access anomaly detection
        si = loginAttempts > 3 ? 4 : 1;
        map.put("login", new RiskFactor(si, 4));

        // Identity trust level
        si = kyc.equalsIgnoreCase("Incomplete") ? 5 : 1;
        map.put("kyc", new RiskFactor(si, 5));

        // Historical fraud weight
        si = fraudHistory.equalsIgnoreCase("Yes") ? 5 : 1;
        map.put("history", new RiskFactor(si, 5));

        // Behavioral unpredictability (age-based)
        si = (customerAge < 21 || customerAge > 60) ? 3 : 1;
        map.put("age", new RiskFactor(si, 2));

        // Transaction channel risk
        si = txnType.equalsIgnoreCase("Online") ? 4 : 1;
        map.put("txnType", new RiskFactor(si, 3));

        // Device trust evaluation
        si = deviceType.equalsIgnoreCase("Unknown") ? 5 : 1;
        map.put("device", new RiskFactor(si, 4));

        // Account maturity factor
        si = accountAge < 6 ? 4 : 1;
        map.put("accountAge", new RiskFactor(si, 3));

        // Explicit international activity validation
        si = internationalTxn.equalsIgnoreCase("Yes") ? 5 : 1;
        map.put("intlTxn", new RiskFactor(si, 5));

        return map;
    }

    // Dynamically adjusts tolerance based on trust vs risk signals
    public static double calculateThreshold(String accountType, double balance,
            String kyc, String fraudHistory,
            int loginAttempts) {

        double threshold = 80;

        // Threshold adjustments based on trust signals
        if (accountType.equalsIgnoreCase("Current"))
            threshold += 10;

        if (balance > 200000)
            threshold += 15;

        if (kyc.equalsIgnoreCase("Complete"))
            threshold += 5;

        // Risk penalties
        if (fraudHistory.equalsIgnoreCase("Yes"))
            threshold -= 20;

        if (loginAttempts > 3)
            threshold -= 10;

        return threshold;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input capture layer
        System.out.print("Account Type (Savings/Current): "); // Account type as a trust signal
        String accountType = sc.next();

        System.out.print("Balance: "); // Balance as a trust signal
        double balance = sc.nextDouble();

        System.out.print("Transaction Amount: "); // Transaction amount as a risk signal
        double txnAmount = sc.nextDouble();

        System.out.print("Location (Local/International): "); // Location as a risk signal (from a geographic
                                                              // perspective)
        String location = sc.next();

        System.out.print("Login Attempts: "); // Login attempts as a risk signal
        int loginAttempts = sc.nextInt();

        System.out.print("KYC Status (Complete/Incomplete): "); // KYC status as a trust signal
        String kyc = sc.next();

        System.out.print("Fraud History (Yes/No): "); // Fraud history as a strong risk signal
        String fraudHistory = sc.next();

        System.out.print("Customer Age: "); // Age as a behavioral risk signal
        int age = sc.nextInt();

        System.out.print("Transaction Type (Online/Offline): "); // Transaction type as a risk signal
        String txnType = sc.next();

        System.out.print("Device Type (Known/Unknown): "); // Device type as a risk signal
        String device = sc.next();

        System.out.print("Account Age (months): "); // Account age as a risk signal (new accounts are riskier)
        int accAge = sc.nextInt();

        System.out.print("International Transaction (Yes/No): "); // Explicit international transaction indicator as a
                                                                  // risk signal (this is used for cross border
                                                                  // transactions which are often riskier)
        String intl = sc.next();

        // Risk transformation layer
        Map<String, RiskFactor> map = assignScores(
                txnAmount, location, loginAttempts, kyc, fraudHistory,
                age, txnType, device, accAge, intl);

        double risk = calculateRisk(map);

        // Adaptive tolerance computation
        double threshold = calculateThreshold(
                accountType, balance, kyc, fraudHistory, loginAttempts);

        String decision;

        // Decision boundary logic
        if (risk > threshold)
            decision = "FRAUD";
        else if (risk > threshold * 0.7)
            decision = "VERIFY";
        else
            decision = "SAFE";

        // Output layer
        System.out.println("\n--- RESULT ---");
        System.out.println("Risk Score = " + risk);
        System.out.println("Adaptive Threshold = " + threshold);
        System.out.println("Decision = " + decision);

        sc.close();
    }
}