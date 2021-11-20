
<%@page import="Blog.Comun"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Blog.Normal"%>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>P&aacute;gina Principal</title>
        <link rel="stylesheet" href="stylePrincipal.css">
        <script src="https://kit.fontawesome.com/d1149c8381.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <img src='<c:url value="${url}"></c:url>' width="100" height="100" alt="avatar"/>    
            <h1>Bienvenid@: ${usuario.nombreCompleto}</h1>
        </header>
        <main>
            <form class="btnCrearPublicacion">
                <a href="crearPublicacion.html">
                <input type="crear_publicacion" value="Crear publicaci�n">
                </a>
            </form>
            <section class="publicaciones">
                <c:forEach var="post" items="${pinnedPosts}">
                    <article class="anclado">
                        <section class="datosPublicacion">
                            <h2>${post.titulo}</h2> 
                            <p>Por: ${post.autor.nombreCompleto}</p>
                            <p>Fecha de creaci�n: ${post.fechaHoraCreacion} </p>
                            <p>editado: ${post.fechaHoraEdicion} </p>
                            <form>
                                <input type="botones" value="Comentar">
                                <c:if test="${post.autor.id==usuario.id}">
                                    <input type="botones" value="Editar">
                                </c:if> 
                            </form>
                            <i class="fas fa-anchor fa-2x"></i>
                        </section>
                        <section class="contenidoPublicacion">
                            <p>${post.contenido}</p>
                        </section>          
                    </article>
                </c:forEach>
                <c:forEach var="post" items="${commonPosts}">
                    <article>
                        <section class="datosPublicacion">
                            <h2>${post.titulo}</h2> 
                            <p>Por: ${post.autor.nombreCompleto}</p>
                            <p>Fecha de creaci�n: ${post.fechaHoraCreacion} </p>
                            <p>editado: ${post.fechaHoraEdicion} </p>
                            <form>
                                <input type="botones" value="Comentar">
                                <c:if test="${post.autor.id==usuario.id}">
                                    <input type="botones" value="Editar">
                                </c:if> 
                            </form>
                        </section>
                        <section class="contenidoPublicacion">
                            <p>${post.contenido}</p>
                        </section>
                        <section class="comentarios"> 
                            <h1>Comentarios:</h1>
                            <c:forEach items="${post.comentarios}" var="comments">
                                <p>${comments.contenido}</p>
                            </c:forEach>

                        </section>                
                    </article>
                </c:forEach>
            </section>
        </main>
    </body>
</html>