
<%@page import="Blog.Comun"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Blog.Normal"%>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Página Principal</title>
        <link rel="stylesheet" href="stylePrincipal.css">
        <script src="https://kit.fontawesome.com/d1149c8381.js" crossorigin="anonymous"></script>
    </head>
    <%
        Normal usuario = (Normal) request.getAttribute("usuario");
    %>
    <body>
        <header>
            <h1>Bienvenid@: <%=usuario.getNombreCompleto()%></h1>
        </header>
        <main>
            <form class="btnCrearPublicacion">
                <input type="crear_publicacion" value="Crear publicación">
            </form>
            <section class="publicaciones">
                <article class="anclado">
                    <section class="datosPublicacion">
                        <h2>Titulo</h2> 
                        <p>Por: nombreCreador </p>
                        <p>Fecha de creación: fecha/hora </p>
                        <p>editado: fecha/hora </p>
                        <i class="fas fa-anchor fa-2x"></i>
                    </section>
                    <section class="contenidoPublicacion">
                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta accusantium sequi praesentium quam officia? Itaque voluptates voluptate dolorum obcaecati quod, perferendis id dolore velit qui iste nemo ad. Sit, delectus.</p>
                    </section>                
                </article>
                <c:forEach var="post" items="${commonPosts}">
                    <article>
                        <section class="datosPublicacion">
                            <h2>${post.titulo}</h2> 
                            <p>Por: ${post.autor} </p>
                            <p>Fecha de creación: ${post.fechaHoraCreacion} </p>
                            <p>editado: ${post.fechaHoraEdicion} </p>
                            <form>
                                <input type="botones" value="Comentar">
                                <input type="botones" value="Editar">
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
                <!--
                <article>
                    <section class="datosPublicacion">
                        <h2>Titulo</h2> 
                        <p>Por: nombreCreador </p>
                        <p>Fecha de creación: fecha/hora </p>
                        <p>editado: fecha/hora </p>
                        <form>
                            <input type="botones" value="Comentar">
                        </form>
                    </section>
                    <section class="contenidoPublicacion">
                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta accusantium sequi praesentium quam officia? Itaque voluptates voluptate dolorum obcaecati quod, perferendis id dolore velit qui iste nemo ad. Sit, delectus.</p>
                    </section> 
                    <section class="comentarios"> 
                        <h1>Comentarios:</h1>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit officiis maxime ab fugiat in quam illo placeat accusamus minima repellat? Perspiciatis saepe illo qui aliquid dolorum praesentium. Dolores, suscipit. Ut!</p>
                    </section>                 
                </article>
                -->
            </section>
        </main>
    </body>
</html>