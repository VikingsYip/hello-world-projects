package org.localstorm.stocktracker.notifier;

import java.util.Map;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.apache.camel.impl.DefaultExchange;

/**
 * @author Alexey Kuznetsov
 */
public class NotifierComponent extends DefaultComponent<DefaultExchange>
{

    @Override
    protected Endpoint<DefaultExchange> createEndpoint(String uri,
                                                       String remaining,
                                                       Map parameters) throws Exception
    {
        return new NotifierEndpoint(uri, this);
    }
    
}