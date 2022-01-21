<%-- 
    Document   : student
    Created on : 21/01/2022, 7:46:09 PM
    Author     : Admin
--%>
<%@page import="controller.Student"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*,controller.*"%>        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <% ArrayList MyList = new ArrayList(); %>
        <% String regex = "";%> 

        <!-- ABC--> 
        <style>
            .table-border tr td{
             border : solid 1px black;   
             
            }
            
            </style>
    </head>
    <body>
        <form name = "input"  action = "student.jsp" method = "post">
            <table>
                <tr>
                    <td> Number of student</td>
                    <td> <input type = "text" name ="myinput"> </td>
                    <td> <input type = "submit" name = "mybutton" value="generate"> </td>
                </tr>    
            </table>                           
        </form>


        <table class="table-border">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Gender</td>
                <td>DOB</td>        
            </tr>
            <% String input = request.getParameter("myinput");
                try {
                    int taken = Integer.parseInt(input);
                    ArrayList<Student> newList = Student.generate(taken);

                    for (int i = 0; i < newList.size(); i++) {
                        //out.println(newList.get(i).getId() + " " + newList.get(i).getName() + " " + newList.get(i).getGender() + " " + newList.get(i).getDOB());
%>          
            <tr> 
                <td> <%=newList.get(i).getId()%> </td>
                <td> <%=newList.get(i).getName()%> </td>
                <td> 
                    <input type = "checkbox" disabled=""

                           <% if (newList.get(i).getGender() == true) {
                                   out.println("checked");
                               }
                           %>
                           > 
                </td>
                <td> <%=newList.get(i).fixedDate()%> </td>

            </tr>
            <%
                    }

                } catch (Exception e) {
                    out.println("not number");
                }
            %>        
        </table>
    </body>
</body>
</html>
