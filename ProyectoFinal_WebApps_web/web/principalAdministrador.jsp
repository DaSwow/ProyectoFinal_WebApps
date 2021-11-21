
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
                <input type="hidden" name="correo" value="${usuario.correo}" required >  
                <input type="hidden" name="destino" value="crearPublicacion.jsp" required>  
                <input class="submit" type="submit" value="Crear publicaci&oacute;n" name="crear_publicacion">
            </form>
            <section class="publicaciones" style="overflow-y: scroll; height:75%;">
                <c:forEach var="post" items="${pinnedPosts}">
                    <article >
                        <section class="datosPublicacion">
                            <h2>${post.titulo}</h2> 
                            <p>Por: ${post.nombreAutor}</p>
                            <i class="fas fa-anchor fa-2x"></i>
                        </section>
                        <section class="contenidoPublicacion">
                            <p>${post.contenido}</p>
                        </section>          
                    </article>
                </c:forEach>
                <c:forEach var="post" items="${commonPosts}">
                    <article >
                        <section class="datosPublicacion">
                            <h2>${post.titulo}</h2> 
                            <p>Por: ${post.nombreAutor}</p>
                            <p>Fecha de creación: ${post.fechaHoraCreacion} </p>
                            <p>Editado: ${post.fechaHoraEdicion} </p>

                        </section>
                        <section class="contenidoPublicacion">
                            <p>${post.contenido}</p>

                        </section>
                        <section class="etiquetaComentarios"> 
                            <h1>Comentarios:</h1>

                            <c:forEach var="com" items="${comments}" >
                                <c:if test="${com.idPublicacion == post.id}">
                                    <p>${com.autor}: ${com.contenido}</p>
                                    <form  method="POST">
                                        <input class="eliminarComentario" type="submit" value="Eliminar^" name="botonEliminar" style="height: 20px;">
                                    </form>
                                </c:if>
                            </c:forEach>
                            <br><br>
                        </section>   
                        <section id="eliminar">
                            <form  method="POST">
                                <input type="submit" value="Eliminar" name="botonEliminar">
                            </form>
                        </section>
                    </article>
                </c:forEach>

                <br>
            </section>

        </main>
    </body>
</html>