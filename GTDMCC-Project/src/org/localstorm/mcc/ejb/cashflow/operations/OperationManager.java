package org.localstorm.mcc.ejb.cashflow.operations;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import org.localstorm.mcc.ejb.cashflow.assets.Cost;
import org.localstorm.mcc.ejb.cashflow.assets.ValuableObject;


/**
 *
 * @author localstorm
 */

public interface OperationManager
{
    public static final String BEAN_NAME="OperationManagerBean";
    
    public ValuableObject findValuableById(Integer valuableId);

    public Operation findOperationById(Integer operationId);
    
    public void updateCost(ValuableObject vo, Cost cost);

    public void remove(Operation op);

    public void update(ValuableObject vo);

    // Queries
    public BigDecimal getNetWealthSellCost(ValuableObject vo);

    public BigDecimal getInvestmentsCost(ValuableObject vo);

    public BigDecimal getTotalAmount(ValuableObject vo);

    public BigDecimal getRevenuAmount(ValuableObject vo);

    public BigDecimal getBalance(ValuableObject vo);

    public Cost getCurrentCost(ValuableObject vo);

    public Collection<Cost> getCostHistory(ValuableObject valuable, Date time);

    public Collection<Operation> getOperations(ValuableObject vo);

    // Operations
    public void buy(ValuableObject vo, BigDecimal amount, String comment, boolean exchange);

    public boolean sell(ValuableObject vo, BigDecimal amount, String comment, boolean exchange);

}
