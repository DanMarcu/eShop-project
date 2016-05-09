<%-- 
    Document   : menuCategorie
    Created on : Apr 26, 2016, 1:09:29 PM
    Author     : Dan
--%>

    <body>
        
        <table cellpadding="5">

            <tr>
                <th> CATEGORIE PRODUSE </th>
                <td><a href="${pageContext.request.contextPath}/ListaProduseServ?select=pc">PC</a></td> 
                <td><a href="${pageContext.request.contextPath}/ListaProduseServ?select=notebook">Notebook</a></td> 
                <td><a href="${pageContext.request.contextPath}/ListaProduseServ?select=smartphone">Smartphone</a></td>  
                <td><a href="${pageContext.request.contextPath}/ListaProduseServ?select=tv">TV</a></td>  
            </tr>    
        </table>  
    </body>
