
<%@page import="Blog.Comun"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Blog.Normal"%>

<c:if test="${(empty usuario) and (empty admin)}">
    <c:redirect url = "Login.html"/>
</c:if>
<!DOCTYPE html>
<html lang="es" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Crear publicación</title>
        <link rel="stylesheet" href="css/styleCrearPublicacion.css">
    </head>
    <body>
        <header>
            <img src='<c:url value="${url}"></c:url>' width="100" height="100" alt="avatar"/>    
            <h1>Bienvenid@: ${usuario.nombreCompleto}</h1>
        </header>
        <section name="FormularioPublicar" class="centerPublicar">
            <header>
                <h1 name="CabeceraPublicar">Crear publicación</h1><br>
            </header>
            <form method="post" class="publicar">
                <section class="contenido">
                    <fieldset class="txt_field">
                        <input name="titulo" type="text" required>
                        <span></span>
                        <label>Titulo</label>
                    </fieldset>
                    <img src="https://cdn.discordapp.com/attachments/505038447870869524/899763967558307910/unknown.png" alt="">
                    <fieldset class="txt_field">
                        <input name="contenido" type="text" required>
                        <span></span>
                        <label>Contenido</label>
                    </fieldset>
                    <br><br>
                </section>
                <section class="configuracion">
                    <h3>Configuraci&oacute;n</h3>
                    <label>Etiquetas</label><br><br>
                    <input type="etiquetas" placeholder="Buscar...">
                    <br><br>
                    <input type="checkbox" id="cbox2" value="second_checkbox"> <label for="cbox2">Anclado</label>
                </section>
            </form>
            <input name="Publicar" type="submit" value="Publicar">
            <input name="Volver" type="volver" value="Volver">

        </section>
    </body>

    <footer class="footer">
        <section name="EnlacesFooter" class="link">
            <a href="#">Acerca de&nbsp;</a>
            <a class="tab" href="#">Privacidad y Seguridad&nbsp;</a>
            <a class="tab" href="#">T&eacute;rminos y Condiciones de Uso&nbsp;</a>
        </section>
    </footer>

</html>
