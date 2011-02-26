<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes/include.jsp" %>

<%@ include file="/WEB-INF/jsp/includes/cashflow/hdr.jsp" %>

<h2><span>NET WEALTH</span> history</h2>
<div align="right">
    Truncate history up to: <a href="<c:url value="/actions/cash/nil/TruncateHistory">
        <c:param name="returnPageToken" value="${returnPageToken}" />
        <c:param name="valueTag" value="NET_WEALTH_CHECKPOINT,NET_WEALTH_WO_DEBT_CHECKPOINT"/>
        <c:param name="keepDays" value="365"/>
    </c:url>">1Y</a>, <a href="<c:url value="/actions/cash/nil/TruncateHistory">
        <c:param name="returnPageToken" value="${returnPageToken}" />
        <c:param name="valueTag" value="NET_WEALTH_CHECKPOINT,NET_WEALTH_WO_DEBT_CHECKPOINT"/>
        <c:param name="keepDays" value="182"/>
    </c:url>">6M</a>, <a href="<c:url value="/actions/cash/nil/TruncateHistory">
        <c:param name="returnPageToken" value="${returnPageToken}" />
        <c:param name="valueTag" value="NET_WEALTH_CHECKPOINT,NET_WEALTH_WO_DEBT_CHECKPOINT"/>
        <c:param name="keepDays" value="90"/>
    </c:url>">3M</a>, <a href="<c:url value="/actions/cash/nil/TruncateHistory">
        <c:param name="returnPageToken" value="${returnPageToken}" />
        <c:param name="valueTag" value="NET_WEALTH_CHECKPOINT,NET_WEALTH_WO_DEBT_CHECKPOINT"/>
        <c:param name="keepDays" value="30"/>
    </c:url>">1M</a>, <a onclick="return confirm('Are you sure?');" href="<c:url value="/actions/cash/nil/TruncateHistory">
        <c:param name="returnPageToken" value="${returnPageToken}" />
        <c:param name="valueTag" value="NET_WEALTH_CHECKPOINT,NET_WEALTH_WO_DEBT_CHECKPOINT"/>
        <c:param name="keepDays" value="-1"/>
    </c:url>">now</a>
</div>
<div align="center">
    <br/>
    <img src="<c:url value="/chart/netWealthHistory.png">
                    <c:param name="showTargets" value="true" />
                    <c:param name="includeDebt" value="false" />
              </c:url>"/>
    <br/><br/>
    <img src="<c:url value="/chart/netWealthHistory.png">
                    <c:param name="showTargets" value="true" />
                    <c:param name="includeDebt" value="true" />
              </c:url>"/>
    
</div>


<%@ include file="/WEB-INF/jsp/includes/cashflow/rightpan.jsp" %>
<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>