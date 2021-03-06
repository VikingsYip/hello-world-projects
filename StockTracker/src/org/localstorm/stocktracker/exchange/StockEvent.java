package org.localstorm.stocktracker.exchange;

import org.localstorm.stocktracker.util.io.Printable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Stock event class.
 * @author Alexey Kuznetsov
 */
public final class StockEvent extends Printable implements Serializable
{
    private static final long serialVersionUID = 1L;

    private final StockEventType  type;
    private final String          symbol;
    private final BigDecimal      threshold;
    private final Date            start;
    private final Date            end;

    public StockEvent(StockEventType type, 
                      String symbol,
                      BigDecimal threshold,
                      Date start,
                      Date end) {
        this.type = type;
        this.symbol = symbol;
        this.threshold = threshold;
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public String getSymbol() {
        return symbol;
    }

    public StockEventType getType() {
        return type;
    }

}
