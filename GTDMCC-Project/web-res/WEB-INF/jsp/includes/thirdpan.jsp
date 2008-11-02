<%@ page pageEncoding="UTF-8" language="java" %>
<%@ include file="include.jsp" %>

<div id="bodyThirdPan">
    <h2><span>Reference</span> pane</h2>       
    <p class="more"><a href="<c:url value="/actions/EditRefObj"/>">EDIT</a></p>
    <table class="refobjs">
        <c:forEach items="${refObjects}" var="ro">
            <tr>
                <td width="18px" valign="top"><img src="<c:url value="/images/refobj.png"/>"/></td>
                <td><a href="<c:url value="/actions/ViewRefObj">
                                <c:param name="objectId" value="${ro.id}"/>
                            </c:url>"><c:out value="${ro.name}" /></a></td>
            </tr>
        </c:forEach>
    </table>                
</div>
