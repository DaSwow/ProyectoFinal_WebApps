
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
                <!--Desplegar nombre en base si es admin o usuario normal -->
            <c:choose>
                <c:when test="${not empty admin.nombreCompleto}">
                    <h1>Bienvenid@: ${admin.nombreCompleto}</h1>
                </c:when>    
                <c:otherwise>
                    <h1>Bienvenid@: ${usuario.nombreCompleto}</h1>
                </c:otherwise>
            </c:choose>
        </header>
        <section name="FormularioPublicar" class="centerPublicar">
            <header>
                <h1 name="CabeceraPublicar">Crear publicación</h1><br>
            </header>
            <!--Botón para crear publicación  -->
            <form action="manejoPublicacion" method="post" class="publicar">
                <section class="contenido">
                    <fieldset class="txt_field">
                        <input name="titulo" type="titulo" maxlength="60" size="60"  value="" class="titulo" required>
                        <span></span>
                        <label>Titulo</label>
                    </fieldset>
                    <br><label>Contenido</label>
                    <fieldset class="txt_field">
                        <textarea  name="contenido" rows="4" cols="120"  maxlength="480"  value="" required></textarea>
                    </fieldset>
                    <fieldset class="anclado">
                        <label>Publicaci&oacute;n anclada</label> 
                        <input type="checkbox" id="anclado" name="anclado" > 
                    </fieldset>
                    <fieldset class="botonPublicar">
                        <c:choose>
                            <c:when test="${not empty admin.correo}">
                                <input type="hidden" name="correo" value="${admin.correo}" required >  
                                <input class="submit" type="submit" value=" Publicar " name="crear" style="float: left;">
                            </c:when>    
                            <c:otherwise>
                                <input type="hidden" name="correo" value="${usuario.correo}" required >  
                                <input class="submit" type="submit" value="Publicar" name="crear" style="float: left;">
                            </c:otherwise>
                        </c:choose>
                    </fieldset>
                </section>  
                </form>
                <!--Botón para volver  -->
                <form action="abrirCrearPublicacion" method="POST" >
                    <c:choose>
                        <c:when test="${not empty admin.correo}">
                            <input type="hidden" name="correo" value="${admin.correo}" required >  
                        </c:when>    
                        <c:otherwise>
                            <input type="hidden" name="correo" value="${usuario.correo}" required >  
                        </c:otherwise>
                    </c:choose>
                    <input type="hidden" name="destino" value="regresar" required>  
                    <input class="submit" type="submit" value="Volver" name="volver">
                </form>

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
