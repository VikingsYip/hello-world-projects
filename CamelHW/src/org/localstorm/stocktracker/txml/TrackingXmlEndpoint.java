package org.localstorm.stocktracker.txml;

import org.localstorm.stocktracker.camel.GenericConsumerableEndpoint;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultExchange;
import org.localstorm.stocktracker.*;
import org.localstorm.stocktracker.exchange.*;

/**
 * @in  XML (Stock racking Request format)
 * @out StockTrackingRequest instance
 * @author Alexey Kuznetsov
 */
public class TrackingXmlEndpoint extends GenericConsumerableEndpoint<DefaultExchange>
{
 
    public TrackingXmlEndpoint(String endpointUri,
                               TrackingXmlComponent component) {
        super(endpointUri, component);
    }

    public TrackingXmlEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public boolean isSingleton() {
        return true;
    }

    @Override
    public TrackingXmlComponent getComponent() {
        return (TrackingXmlComponent) super.getComponent();
    }

    public Producer<DefaultExchange> createProducer() throws Exception {
        return new TrackingXmlProducer(this);
    }

    @Deprecated
    /*package*/ StockTrackingRequest parseXmlRequest(String xml) {
        System.out.println("XML to be parsed:"+xml);

        StockTrackingRequest str = new StockTrackingRequest("localstorm");
        Calendar c = Calendar.getInstance();

        c.add(Calendar.SECOND, 10);
        Date end = c.getTime();

        str.addEvent(new StockEvent(StockChangeType.RAISE, "MSFT", new BigDecimal("10.1"), null, end));
        return str;
    }

}