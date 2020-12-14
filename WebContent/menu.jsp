<%@ page import="java.util.Date"%>

<table width="100%" cellpadding="0" cellspacing="0">
	<tr height="70">
		<td align="center" class="cabecera" colspan="5">TEORIA SOBRE AJAX - Ultimo envio <%=new Date()%><br></td>
	</tr>
	<%
		Integer menu = -1;
		if (request.getParameter("menu") != null) {
			menu = Integer.parseInt(request.getParameter("menu"));
		}
	%>
	<tr>
		<td>
			<% if (menu == 3) { %> 
				<span class="seleccionado">Envio con el Framework DWR</span> 
			<% } else { %> 
 				<a class="menu" href="ejemploAjaxBusquedaDWR.jsp?menu=3">Envio con el Framework DWR***</a> 
 			<% } %>
		</td>
		<td>
			<% if (menu == 4) {	%> 
				<span class="seleccionado">Ejemplo de Selector</span> 
			<% } else { %> 
				<a class="menu" href="ejemploAjaxSelector.jsp?menu=4">Ejemplo de Selector***</a> 
			<% } %>
		</td>
	</tr>
</table>