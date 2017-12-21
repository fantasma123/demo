<!DOCTYPE html>
<%@page import="group4.assignment.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<Link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style-import-screen.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/my_javascript.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>Import</title>
</head>
<body>
        <div class="body_container">
            
            <div class="top">
                <p><strong>IMPORT DATA</strong></p>
            </div>
            <div class="bh_container">
                <p>
                    <h>User:</h><a href="#" id="user"><strong><%=session.getAttribute("name") %></strong></a>
                    <a class="bh_container" href="${pageContext.request.contextPath}/logout">Log out</a>
                </p>
            </div>

            <form:form action="handlingFiles" method="post" modelAttribute="uploadForm" enctype="multipart/form-data">
            <div class="center">
                <table>
                    <tr>
                            <p class="text"><strong>Select file(s) to import:</strong></p>
                    </tr>
                    <tr>
                        <table  class="cfile" id="myTable" width="80%" align="center">
                            <tr >
                                <td width="90%"><input type="text" id="textbox0"></td>
                                <td >
                                    <input type="file" name= 'files' id="browse" style="display: none" accept=".csv" onChange="HandlechangeDeFault()">
                                    <input type="button" value="Brower" onclick="HandleBrowseClickDeFault()"/></td>
                                <td >
                            </tr>
                        </table>
                    </tr>
                </table>

                <div class="bottomtable2">
                    <a href="#" onclick="addRow()" >Add</a> <input type="submit" name="" value="Import" >    
                </div>        
            </div>
            </form:form>
            <div class="bottom">
                <table>
                    <tr>
                        <p class="text"><strong>List of users which is imported into DB:</strong></p>
                    </tr>
                    <tr>
                        <table id="myTable2" border="1px" width="80%" align="center">
                            
                            <tr>
                                <th width="10%">NO</th>
                                <th width="20%">User ID</th>
                                <th width="20%">Group ID</th>
                                <th width="20%">First Name</th>
                                <th width="20%">Last Name</th>
                                <th width="20%">Password</th>
                            </tr>
                            <%
								int i=0;
								if(session.getAttribute("listUser")!=null){
									ArrayList<User> listUser = (ArrayList<User>)session.getAttribute("listUser");
									for(User user : listUser){
										i++;								
							%>
							
							<tr align="center">
								<td><%=i %></td>
								<td><%=user.getId() %></td>
								<td><%=user.getGroupID() %></td>
								<td><%=user.getFirstName() %></td>
								<td><%=user.getLastName() %></td>
								<td>********</td>
							</tr>
							<%}} %>
 
                        </table>
                        
                    </tr>
                   
                    <tr>
                        <table class="table2" cellpadding="10px">
                            <td align="left">
                            <div id="pageNavPosition"></div>
								<script type="text/javascript">
								       $(document).ready(function(){
                                       var pager = new Pager('myTable2',10);
								       pager.init();
								       pager.showPageNav('pager', 'pageNavPosition');
								       pager.showPage(1);
                                   });
								</script>
                            </td>
                        </table>
                    </tr>
                </table>        
            </div>
        </div>
    </body>


</html>

