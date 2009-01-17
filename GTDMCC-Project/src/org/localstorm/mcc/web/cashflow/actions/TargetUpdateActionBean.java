package org.localstorm.mcc.web.cashflow.actions;

import org.localstorm.mcc.web.util.RoundUtil;
import java.math.BigDecimal;
import java.math.MathContext;
import net.sourceforge.stripes.action.After;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.Validate;
import org.localstorm.mcc.ejb.cashflow.asset.AssetManager;
import org.localstorm.mcc.ejb.cashflow.asset.Cost;
import org.localstorm.mcc.ejb.cashflow.asset.MoneyMathContext;
import org.localstorm.mcc.ejb.cashflow.asset.Target;
import org.localstorm.mcc.ejb.cashflow.asset.TargetManager;
import org.localstorm.mcc.ejb.cashflow.asset.ValuableObject;
import org.localstorm.mcc.web.SessionKeys;
import org.localstorm.mcc.web.util.SessionUtil;

/**
 *
 * @author localstorm
 */
@UrlBinding("/actions/UpdateTarget")
public class TargetUpdateActionBean extends TargetViewActionBean {

    @Validate(required=true)
    private String name;

    @Validate( required=true )
    private BigDecimal buy;

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @After( LifecycleStage.BindingAndValidation )
    public void doPostValidationStuff() throws Exception {
        if ( getContext().getValidationErrors().hasFieldErrors() )
        {
            super.filling();
        }
    }

    @DefaultHandler
    public Resolution update() throws Exception {

        AssetManager  am = super.getAssetManager();
        TargetManager tm = super.getTargetManager();
        Target target    = tm.findTargetById(this.getTargetId());

        ValuableObject vo = target.getValuable();

        MathContext rounding = MoneyMathContext.ROUNDING;

        Cost cost = new Cost(vo);
        {
            cost.setBuy(RoundUtil.round(this.getBuy(), rounding));
            cost.setSell(RoundUtil.round(this.getBuy(), rounding));
        }
        
        vo.setUsedInBalance(false);
        target.setName(this.getName());

        tm.update(target);
        am.updateCost(vo, cost);
        am.updateValuableObject(vo);

        SessionUtil.clear(super.getSession(), SessionKeys.TARGETS);
        
        RedirectResolution rr = new RedirectResolution(TargetViewActionBean.class);
        {
            rr.addParameter(TargetViewActionBean.IncommingParameters.TARGET_ID, this.getTargetId());
        }

        return rr;
    }
    

}
