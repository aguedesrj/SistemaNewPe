<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasActionErrors()">
	<div class="ui negative message" style="height: 80px;">
		<i class="close icon"></i>
	  	<div class="header">
	    	Ocorreu o seguinte erro:
	  	</div>
	  	<s:actionerror/>
	</div>		
</s:if>	