# Adaptive-Risk-Threshould-Management-System-ARTMS-
Saksham Tyagi
Aditya Raghuvanshi

--------------------------------------------------

1. Project Title
Adaptive Risk Threshold Management System

--------------------------------------------------

2. Project Description
The Adaptive Risk Threshold Management System is a Java-based intelligent system designed to evaluate financial transactions and detect potential fraud. The system analyzes multiple parameters related to user behavior, transaction details, and account trust factors.

Unlike traditional systems that rely on fixed thresholds, this system uses an adaptive threshold mechanism. It dynamically adjusts the risk tolerance based on user credibility such as KYC status, account age, and account balance. This makes the system more flexible and realistic.

The system calculates a risk score using weighted parameters and compares it against a dynamically generated threshold. Based on the comparison, the system classifies the transaction into SAFE, VERIFY, or FRAUD.

--------------------------------------------------

3. Objectives of the Project
- To design a smart fraud detection system
- To implement adaptive threshold logic instead of static rules
- To combine multiple risk parameters effectively
- To minimize false positives and false negatives
- To simulate real-world banking security systems
- To improve decision-making using dynamic logic

--------------------------------------------------

4. System Features
- Multi-parameter risk analysis
- Severity-based scoring system
- Adaptive threshold calculation
- Real-time decision making
- User input-based simulation
- Simple command-line interface

--------------------------------------------------

5. Working Principle

Step 1: Input Collection
The system collects multiple inputs such as transaction amount, account type, login attempts, etc.

Step 2: Assign Severity
Each parameter is assigned a severity value based on its impact on risk.

Step 3: Risk Calculation
Risk Score = Sum of (Weight × Severity of each parameter)

Step 4: Adaptive Threshold Calculation
Threshold is dynamically adjusted based on trust factors like:
- KYC status
- Account balance
- Account age

Step 5: Decision Making
- If Risk < Threshold → SAFE
- If Risk ≈ Threshold → VERIFY
- If Risk > Threshold → FRAUD

--------------------------------------------------

6. Modules of the System

1. Input Module
Handles user input using Scanner class.

2. Risk Calculation Module
Calculates risk score using weighted parameters.

3. Threshold Module
Generates adaptive threshold based on trust signals.

4. Decision Module
Compares risk score with threshold and gives final output.

5. Output Module
Displays risk score, threshold, and decision.

--------------------------------------------------

7. Steps to Run the Code

System Requirements:
- JDK 8 or above
- Any IDE or terminal

Execution:
1. Save file as AdaptiveRiskSystem.java
2. Compile using: javac AdaptiveRiskSystem.java
3. Run using: java AdaptiveRiskSystem
4. Enter inputs when prompted

--------------------------------------------------

8. Inputs and Outputs

Inputs:
- Account Type
- Balance
- Transaction Amount
- Location
- Login Attempts
- KYC Status
- Fraud History
- Customer Age
- Transaction Type
- Device Type
- Account Age
- International Transaction

Outputs:
- Risk Score
- Adaptive Threshold
- Decision (SAFE / VERIFY / FRAUD)

--------------------------------------------------

9. Advantages
- Dynamic and flexible system
- Reduces false alarms
- Easy to implement
- Real-world applicability
- Scalable for future enhancements

--------------------------------------------------

10. Limitations
- Depends on predefined weights
- Not using real-time data
- No machine learning integration
- Basic UI (command line only)

--------------------------------------------------

11. Future Scope
- Integration with machine learning models
- Real-time banking system integration
- GUI development using Java Swing
- Database integration
- API-based system expansion

--------------------------------------------------

12. Applications
- Banking systems
- Online payment platforms
- Fraud detection systems
- Financial security systems

--------------------------------------------------

13. Individual Contribution

Saksham Tyagi:
- Designed core logic
- Developed risk calculation model
- Implemented adaptive threshold
- Integrated full system
- Testing and validation

Aditya Raghuvanshi:
- Structured program
- Assisted in integration
- Output formatting
- Documentation support
- Testing assistance

--------------------------------------------------

14. Conclusion
The Adaptive Risk Threshold Management System demonstrates how intelligent systems can be built using simple Java logic. It highlights the importance of adaptive decision-making in fraud detection. The project successfully combines risk analysis with dynamic thresholding, making it a practical and scalable solution.

--------------------------------------------------
