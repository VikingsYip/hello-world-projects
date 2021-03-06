package org.localstorm.stocktracker.camel.analyzer;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultProducer;
import org.localstorm.stocktracker.camel.util.ExchangeUtil;
import org.localstorm.stocktracker.exchange.AnalyzerInstruction;

/**
 * Apache Camel Producer for Instructor endpoint
 * @author Alexey Kuznetsov
 */
public class InstructorProducer extends DefaultProducer<DefaultExchange>
{

    public InstructorProducer(InstructorEndpoint endpoint) {
        super(endpoint);
    }

    public void process(Exchange exchange) throws Exception {
        InstructorEndpoint    ep = this.getEndpoint();
        AnalyzerInstruction   ai = ExchangeUtil.inBody(exchange);

        ep.processInstruction(ai);
    }

    @Override
    public InstructorEndpoint getEndpoint() {
        return (InstructorEndpoint) super.getEndpoint();
    }

}
