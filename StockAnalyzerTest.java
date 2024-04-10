import static org.junit.Assert.*;

import model.StockProfit;
import org.junit.Test;
import java.io.IOException;

public class StockAnalyzerTest {

    @Test
    public void testMaxProfit() throws IOException {

        // Trade found
        StockProfit sp1 = StockAnalyzer.maxProfit("AAPL", 2020);
        assertNotNull(sp1);
        assertEquals("2020-03-23", sp1.getBuyDate());
        assertEquals(57.02, sp1.getBuyPrice(), 0.000001);
        assertEquals("2020-12-28", sp1.getSellDate());
        assertEquals(136.690002, sp1.getSellPrice(), 0.000001);
        assertEquals(79.670002, sp1.getProfit(), 0.000001);

        // No profitable trades
        StockProfit sp2 = StockAnalyzer.maxProfit("NFLX", 2013);
        assertNull(sp2);

    }
}
