
<%@page import="Blog.Comun"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Blog.Normal"%>


<c:if test="${(empty usuario) and (empty admin)}">
    <c:redirect url = "Login.html"/>
</c:if>

<!-- menu admin-->
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>P&aacute;gina Principal admin</title>
        <link rel="stylesheet" href="css/stylePrincipal.css">
        <script src="https://kit.fontawesome.com/d1149c8381.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <img src='<c:url value="${url}"></c:url>' width="100" height="100" alt="avatar"/>    
            <h1>Bienvenid@: ${admin.nombreCompleto}</h1>
        </header>
        <main>
            <form action="abrirCrearPublicacion" method="POST" style="padding-bottom: 1%;">
                <input type="hidden" name="correo" value="${admin.correo}" required >  
                <input type="hidden" name="destino" value="crearPublicacion.jsp" required>  
                <input class="submit" type="submit" value="Crear publicaci&oacute;n" name="crear_publicacion">
            </form>
            <section class="publicaciones" style="overflow-y: scroll; height:75%;">
                <table>
                    <c:forEach var="post" items="${pinnedPosts}">

                        <tr>
                            <td>${post.titulo}</td>
                            <td>Por: ${post.nombreAutor}</td>
                            <td>Fecha de creación: ${post.fechaHoraCreacion}</td>
                            <td>Editado: ${post.fechaHoraEdicion}</td>
                            <td><i class="fas fa-anchor fa-2x"></i></td>
                        </tr>
                        <tr>
                            <td colspan="5">${post.contenido}</td>
                        </tr>
                        <tr><th colspan="5"></th></tr>

                    </c:forEach>
                    <c:forEach var="post" items="${commonPosts}">


                            <tr>
                                <td>${post.titulo}</td>
                                <td>Por: ${post.nombreAutor}</td>
                                <td>Fecha de creación: ${post.fechaHoraCreacion} </td>
                                <td>Editado: ${post.fechaHoraEdicion}</td>
                            </tr>
                            <tr>
                                <td colspan="5">${post.contenido}</td>
                            </tr>
                            <tr>
                                <td colspan="5">
                                    <h3>Comentarios:</h3>
                                    <c:forEach var="com" items="${comments}" >
                                        <c:if test="${com.idPublicacion == post.id}">
                                            <p>${com.contenido}</p>
                                            <form  method="POST">
                                                <input class="eliminarComentario"  value="Eliminar comentario" name="botonEliminar" style="height: 20px;">
                                            </form>
                                        </c:if>
                                    </c:forEach>
                                    <section id="eliminar">
                                        <form  >
                                            <input type="submit" value="Eliminar publicaci&oacute;n" name="botonEliminar">
                                        </form>
                                    </section>
                                </td>
                            </tr>
                            <tr><th colspan="5"></th></tr>
                    </c:forEach>
                </table>
                <br>
            </section>

        </main>
    </body>
</html>