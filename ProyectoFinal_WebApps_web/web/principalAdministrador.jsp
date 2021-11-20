
<%@page import="Blog.Comun"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Blog.Normal"%>

<c:if test="${empty usuario}">
    <c:redirect url = "Login.html"/>
</c:if>

<!DOCTYPE html>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Página Principal</title>
        <link rel="stylesheet" href="styleAdministrador.css">
        <script src="https://kit.fontawesome.com/d1149c8381.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <h1>Bienvenid@: usuario</h1>
        </header>
        <main>
            <form class="btnCrearPublicacion">
                <input type="submit" value="Crear publicación">
            </form>
            <section class="publicaciones">
                <article class="anclado">
                    <section class="datosPublicacion">
                        <h2>Titulo</h2> 
                        <p>Por: nombreCreador </p>
                        <p>Fecha de creación: fecha/hora </p>
                        <p>editado: fecha/hora </p>
                        <i class="fas fa-anchor fa-2x"></i>
                        <form>
                            <input type="submit" value="Eliminar">
                        </form>
                    </section>
                    <section class="contenidoPublicacion">
                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta accusantium sequi praesentium quam officia? Itaque voluptates voluptate dolorum obcaecati quod, perferendis id dolore velit qui iste nemo ad. Sit, delectus.</p>
                    </section>                
                </article>
                <article>
                    <section class="datosPublicacion">
                        <h2>Titulo</h2> 
                        <p>Por: nombreCreador </p>
                        <p>Fecha de creación: fecha/hora </p>
                        <p>editado: fecha/hora </p>
                        <form>
                            <input type="submit" value="Eliminar">
                        </form>
                    </section>
                    <section class="contenidoPublicacion">
                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta accusantium sequi praesentium quam officia? Itaque voluptates voluptate dolorum obcaecati quod, perferendis id dolore velit qui iste nemo ad. Sit, delectus.</p>
                    </section>
                    <section class="comentarios"> 
                        <h1>Comentarios:</h1>
                        <section class="comentario">
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit officiis maxime ab fugiat in quam illo placeat accusamus minima repellat? Perspiciatis saepe illo qui aliquid dolorum praesentium. Dolores, suscipit. Ut!</p>
                            <form>
                                <input type="submit" value="Eliminar">
                            </form>
                        </section>
                    </section>                
                </article>
                <article>
                    <section class="datosPublicacion">
                        <h2>Titulo</h2> 
                        <p>Por: nombreCreador </p>
                        <p>Fecha de creación: fecha/hora </p>
                        <p>editado: fecha/hora </p>
                        <form>
                            <input type="submit" value="Eliminar">
                        </form>
                    </section>
                    <section class="contenidoPublicacion">
                        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta accusantium sequi praesentium quam officia? Itaque voluptates voluptate dolorum obcaecati quod, perferendis id dolore velit qui iste nemo ad. Sit, delectus.</p>
                    </section> 
                    <section class="comentarios"> 
                        <h1>Comentarios:</h1>
                        <section class="comentario">
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit officiis maxime ab fugiat in quam illo placeat accusamus minima repellat? Perspiciatis saepe illo qui aliquid dolorum praesentium. Dolores, suscipit. Ut!</p>
                            <form>
                                <input type="submit" value="Eliminar">
                            </form>
                        </section>
                        <section class="comentario">
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit officiis maxime ab fugiat in quam illo placeat accusamus minima repellat? Perspiciatis saepe illo qui aliquid dolorum praesentium. Dolores, suscipit. Ut!</p>
                            <form>
                                <input type="submit" value="Eliminar">
                            </form>
                        </section>
                    </section>                 
                </article>
            </section>

        </main>
    </body>
</html>