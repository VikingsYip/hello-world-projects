<%@ page pageEncoding="UTF-8" language="java" %>
<%@ include file="include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mission-Control Center</title>
<link rel="alternate stylesheet" type="text/css" media="all" href="<c:url value="/css/calendar-blue2.css"/>" title="blue">
<link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="/js/calendar.js"/>"></script>
<script type="text/javascript" src="<c:url value="/lang/calendar-en.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/showhide.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/calendarSupport.js"/>"></script>
</head>
<body>

<script type="text/javascript">
setActiveStyleSheet(this, 'blue');
</script>

<div id="topPan">
	<a href="<c:url value="/" />"><img src="<c:url value="/images/logo.png" />" alt="Mission-Control Center" width="245" height="37" border="0"  class="logo" title="Mission-Control Center"/></a>
	<p>Be aware!</p>

  <div id="topContactPan" ></div>

  <div id="topMenuPan">
    <div id="topMenuLeftPan"></div>
    <div id="topMenuMiddlePan">
        <ul>
            <li class="home"><a href="<c:url value="/actions/Dashboard" />">&nbsp;Dash&nbsp;</a></li>
            <li><a href="<c:url value="/actions/ViewFlightPlan" />">&nbsp;GTD&nbsp;</a></li>
            <li><a href="<c:url value="/actions/ViewAssets" />">&nbsp;Cash&nbsp;</a></li>
            <li><a href="#">People</a></li>
            <li><a href="<c:url value="/actions/Configure" />">&nbsp;Tweak&nbsp;</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Contact</a></li>
            <li class="contact"><a href="<c:url value="/actions/Logout" />">&nbsp;Sign&nbsp;Out&nbsp;</a></li>
	</ul>
    </div>
    <div id="topMenuRightPan"></div>
  </div>
</div>
<div id="bodyPan">