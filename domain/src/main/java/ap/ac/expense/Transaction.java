package ap.ac.expense;

import ap.ac.Label;

public class Transaction {

    private final String comment;
    private final Label label;
    private final double amount;

    public Transaction(final String comment, final Label label, final double cost) {
        this.comment = comment;
        this.label = label;
        this.amount = cost;
    }

    public double getAmount() {
        return amount;
    }
}
