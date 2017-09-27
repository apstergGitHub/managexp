package ap.ac.combiner;

import ap.ac.expense.Transaction;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccumulatorTest {

    private static final double FIRST_EXPENSE = 10.5;
    private static final double REIMBURSEMENT = -3.68;
    private static final double SECOND_EXPENSE = 7.78;

    private final Transaction expense1 = mock(Transaction.class);
    private final Accumulator underTest = new Accumulator();
    private Transaction reimbursement = mock(Transaction.class);
    private Transaction expense3 = mock(Transaction.class);

    @BeforeEach
    void setUp() {
        when(expense1.getAmount()).thenReturn(FIRST_EXPENSE);
        when(reimbursement.getAmount()).thenReturn(REIMBURSEMENT);
        when(expense3.getAmount()).thenReturn(SECOND_EXPENSE);
    }

    @Test
    void sumsUpAllAmounts() {
        final double actual = underTest.sumUpTransactions(asList(expense1, reimbursement, expense3));

        assertThat(actual, Matchers.closeTo(14.6, 0.001));
    }
}