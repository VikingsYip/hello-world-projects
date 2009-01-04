package org.localstorm.mcc.web.gtd;

import javax.servlet.http.HttpServletRequest;
import net.sourceforge.stripes.action.ActionBeanContext;
import org.localstorm.mcc.ejb.ContextLookup;
import org.localstorm.mcc.ejb.gtd.dao.DashboardReportBean;
import org.localstorm.mcc.ejb.gtd.reports.GtdReporter;
import org.localstorm.mcc.ejb.users.User;
import org.localstorm.mcc.web.SessionKeys;
import org.localstorm.mcc.web.util.SessionUtil;

import org.localstorm.mcc.web.RequestAttributes;

/**
 * @author localstorm
 */
public class GtdDashboardAgent {

    public static void prepare(ActionBeanContext context)
    {
        GtdReporter rep = ContextLookup.lookup(GtdReporter.class, GtdReporter.BEAN_NAME);
        HttpServletRequest request = context.getRequest();

        User u = (User) SessionUtil.getValue(
                                      request.getSession(true),
                                      SessionKeys.USER
                                    );

        DashboardReportBean drb = rep.getDashboardReport(u);
        request.setAttribute(RequestAttributes.GTD_DASHBOARD_REPORT_BEAN, drb);
    }
    
}