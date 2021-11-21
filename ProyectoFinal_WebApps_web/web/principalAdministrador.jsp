
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
            <form action="abrirCrearPublicacion" method="POST" >
                <input type="hidden" name="correo" value="${admin.correo}" required >  
                <input type="hidden" name="destino" value="crearPublicacion.jsp" required>  
                <input class="submit" type="submit" value="Crear publicaci&oacute;n" name="crear_publicacion">
            </form> 

            <section class="publicaciones">


                <c:forEach var="post" items="${pinnedPosts}">
                    <article class="anclado">
                        <section class="datosPublicacion">
                            <h2>${post.titulo}</h2> 
                            <p>Por: ${post.nombreAutor}</p>
                            <p>Fecha de creaci�n: ${post.fechaHoraCreacion} </p>
                            <br><br>
                            <p>Editado: ${post.fechaHoraEdicion} </p>
                            <br><br>
                            <form>
                                    <input type="input" value="Borrar" name="botonBorrar">
                            </form>
                            <i class="fas fa-anchor fa-2x"></i>
                        </section>
                        <section class="contenidoPublicacion">
                            <p>${post.contenido}</p>
                        </section>          
                    </article>
                </c:forEach>




                <br>
            </section>

        </main>
    </body>
</html>