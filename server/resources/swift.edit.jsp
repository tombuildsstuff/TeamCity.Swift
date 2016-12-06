<%@ include file="/include.jsp"%>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>
<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="bean" class="uk.co.ibuildstuff.teamcity.swift.common.SwiftBuildBean"/>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<forms:workingDirectory/>

<tr>
  <th><label for="${bean.commandLineParameterKey}">Additional command line parameters:</label></th>
  <td>
    <props:multilineProperty name="${bean.commandLineParameterKey}"  cols="58" linkTitle="Expand" rows="5"/>
    <span class="smallNote">
      Enter additional command line parameters for Swift. Put each parameter on a new line
      <br />
      <em>--teamcity.properties.all</em> and <em>--teamcity.properties</em> parameters are added implicitly
      pointing to JSON files with all TeamCity properties and system properties respectively
    </span>
    <span class="error" id="error_${bean.commandLineParameterKey}"></span>
  </td>
</tr>

