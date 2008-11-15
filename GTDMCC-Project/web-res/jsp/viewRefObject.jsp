<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/includes/include.jsp" %>

<%@ include file="/WEB-INF/jsp/includes/hdr.jsp" %>
		
<h2><span>OBJECT</span> details</h2>
    
    <div align="right" width="80%">Attach&nbsp;<a href="#" onclick="show('attachTextDiv', 'text-id'); hide('attachFileDiv'); hide('attachURLDiv'); return false">Note</a> | 
    <a href="#" onclick="show('attachURLDiv', 'text-id'); hide('attachFileDiv'); hide('attachTextDiv'); return false">URL</a> |
    <a href="#" onclick="show('attachFileDiv', 'desc-id'); hide('attachTextDiv'); hide('attachURLDiv'); return false">File</a> (<c:out value="${actionBean.objectResult.name}"/>)</div>
    <div align="center">

    <div id="attachTextDiv" width="75%" style="display:
            <c:choose>
             <c:when test="${not empty actionBean.context.validationErrors 
                             and empty urlForm and empty fileForm}">inline</c:when>
             <c:otherwise>none</c:otherwise>
            </c:choose>;">
        <stripes:form name="textForm" action="/actions/AttachRefObj" > 
            <stripes:hidden name="type" value="TEXT" />
            <stripes:hidden name="objectId" value="${actionBean.objectResult.id}" />
            <stripes:hidden name="description" value="--"/>
            <stripes:errors/>
        <table style="background:#FFFFD0; border:1px dotted #DADADA;" width="100%">
            <tr>
                <td align="center" colspan="4">Text:</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2">
                    <stripes:textarea rows="10" name="text" id="text-id" style="width: 100%;" />
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2"><hr/></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2" align="center">
                    <stripes:submit name="submit" value="Add" style="width: 7em;" />&nbsp;
                    <stripes:submit name="cancel" value="Cancel" style="width: 7em;" onclick="hide('attachTextDiv'); return false" />
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
        </stripes:form>
    </div>
    
    <div id="attachURLDiv" width="80%" style="display:
            <c:choose>
             <c:when test="${not empty actionBean.context.validationErrors 
                             and not empty urlForm and empty fileForm}">inline</c:when>
             <c:otherwise>none</c:otherwise>
            </c:choose>;">
        <stripes:form name="urlForm" action="/actions/AttachRefObj" > 
            <stripes:hidden name="type" value="URL" />
            <stripes:hidden name="objectId" value="${actionBean.objectResult.id}" />
            <stripes:errors/>
        <table style="background:#FFFFD0; border:1px dotted #DADADA;" >
            <tr>
                <td>&nbsp;</td>
                <td>Description: </td>
                <td><stripes:text name="description" style="width: 100%;" /></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>URL: </td>
                <td><stripes:text name="text" id="text-id" style="width: 100%;" /></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2"><hr/></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2" align="center">
                    <stripes:submit name="submit" value="Add" style="width: 7em;" />&nbsp;
                    <stripes:submit name="cancel" value="Cancel" style="width: 7em;" onclick="hide('attachURLDiv'); return false" />
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
        </stripes:form>
    </div>
    <div id="attachFileDiv" width="80%" style="display:
            <c:choose>
             <c:when test="${not empty actionBean.context.validationErrors
                             and not empty fileForm and empty urlForm}">inline</c:when>
             <c:otherwise>none</c:otherwise>
            </c:choose>;">
        <stripes:form action="/actions/UploadRefObj" >
            <stripes:hidden name="objectId" value="${actionBean.objectResult.id}" />
            <stripes:errors/>
        <table style="background:#FFFFD0; border:1px dotted #DADADA;" >
            <tr>
                <td>&nbsp;</td>
                <td>Description: </td>
                <td><stripes:text name="description" id="desc-id" style="width: 100%;" /></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>File: </td>
                <td><stripes:file name="file" style="width: 100%;" /></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2"><hr/></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="2" align="center">
                    <stripes:submit name="submit" value="Add" style="width: 7em;"/>&nbsp;
                    <stripes:submit name="cancel" value="Cancel" style="width: 7em;" onclick="hide('attachFileDiv'); return false" />
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
        </stripes:form>
    </div>
    </div>
    <c:forEach var="note" items="${actionBean.objectTextualNotes}">    
        <p><span>Text: <a title="Detach" href="<c:url value="/actions/DetachRefObj" >
            <c:param name="objectId" value="${actionBean.objectResult.id}" />
            <c:param name="noteId" value="${note.id}" />
        </c:url>"><img src="<c:url value="/images/trash.png"/>" border="0" alt="detach" /></a></span>&nbsp;<br/>
        <div align="center">
        <c:choose>
            <c:when test="${note.noteSize >= 175 and note.noteSize < 350}">
                <textarea style="width: 85%; border: dotted 1px;" rows="5" ><c:out value="${note.note}" /></textarea>
            </c:when>
            <c:when test="${note.noteSize >= 350}">
                <textarea style="width: 85%; border: dotted 1px;" rows="10" ><c:out value="${note.note}" /></textarea>
            </c:when>
            <c:otherwise>
                <c:out value="${note.note}" />
            </c:otherwise>
        </c:choose>
        </div>        
        </p>
    </c:forEach>
    <c:if test="${not empty actionBean.objectTextualNotes}">
        <hr/>
    </c:if>
    <c:forEach var="note" items="${actionBean.objectUrlNotes}">    
        <p><span><a title="Detach" href="<c:url value="/actions/DetachRefObj" >
            <c:param name="objectId" value="${actionBean.objectResult.id}" />
            <c:param name="noteId" value="${note.id}" />
        </c:url>"><img src="<c:url value="/images/trash.png"/>" border="0" alt="detach" /></a>&nbsp;Link</span>: <a href="<c:out value="${note.note}" />"><c:out value="${note.description}" /></a></p>
    </c:forEach>
    <c:if test="${not empty actionBean.objectUrlNotes}">
        <hr/>
    </c:if>
    <c:forEach var="file" items="${actionBean.objectFiles}">    
        <p><span><a title="Detach" href="<c:url value="/actions/DetachFileRefObj" >
            <c:param name="objectId" value="${actionBean.objectResult.id}" />
            <c:param name="fileId" value="${file.id}" />
    </c:url>"><img src="<c:url value="/images/trash.png"/>" border="0" alt="detach" /></a>&nbsp;File</span>: <a href="<c:url value="/actions/DownloadFile">
            <c:param name="fileId" value="${file.id}" />        
    </c:url>"><c:out value="${file.name}"/></a> (<c:out value="${file.description}" />)</p>
    </c:forEach>
    
<%@ include file="/WEB-INF/jsp/includes/rightpan.jsp" %>
<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>