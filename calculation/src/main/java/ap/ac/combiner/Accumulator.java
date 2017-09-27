package ap.ac.combiner;

import ap.ac.expense.Transaction;

import java.util.List;
import java.util.function.BinaryOperator;

public class Accumulator {

    private static final BinaryOperator<Double> DOUBLE_SUM = (first, second) -> first + second;

    public double sumUpTransactions(final List<Transaction> transactions) {
        return transactions
                .stream()
                .map(Transaction::getAmount)
                .reduce(DOUBLE_SUM)
                .orElse(0.0);
    }
}
