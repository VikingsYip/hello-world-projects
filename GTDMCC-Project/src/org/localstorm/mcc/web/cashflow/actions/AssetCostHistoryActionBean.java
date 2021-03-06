package org.localstorm.mcc.web.cashflow.actions;


import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import org.localstorm.mcc.ejb.cashflow.entity.Asset;
import org.localstorm.mcc.web.ReturnPageBean;
import org.localstorm.mcc.web.cashflow.CashflowBaseActionBean;
import org.localstorm.mcc.web.cashflow.Views;
import org.localstorm.mcc.web.cashflow.actions.wrap.WrapUtil;
import org.localstorm.tools.aop.runtime.Logged;


/**
 * @secure-by assetId parameter
 * @author Alexey Kuznetsov
 */
@UrlBinding("/actions/cash/asset/ViewAssetCostHistory")
public class AssetCostHistoryActionBean extends CashflowBaseActionBean
{
    @Validate( required=true )
    private int assetId;

    private Asset assetResult;

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public Asset getAssetResult() {
        return assetResult;
    }

    public void setAssetResult(Asset assetResult) {
        this.assetResult = assetResult;
    }
    
    @DefaultHandler
    @Logged
    public Resolution filling() throws Exception {
        Asset asset = super.getAssetManager().find(this.getAssetId());
        
        this.setAssetResult( WrapUtil.wrapAsset(asset, super.getOperationManager()) );

        ReturnPageBean rpb = new ReturnPageBean(Pages.ASSET_COST_HISTORY.toString());
        {
            rpb.setParam(IncomingParameters.ASSET_ID, Integer.toString(this.getAssetId()));
        }

        super.setReturnPageBean(rpb);
        
        return new ForwardResolution(Views.VIEW_ASSET_COST_HISTORY);
    }
    
    public static interface IncomingParameters {
        public static final String ASSET_ID = "assetId";
    }
}
