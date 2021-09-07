package Datos;

import Blog.Admor;
import Blog.Anclado;
import Blog.Comentario;
import Blog.Comun;
import Blog.Estado;
import Blog.Municipio;
import Blog.Normal;
import Blog.Post;
import Blog.Usuario;
import Exceptions.DAOException;
import java.util.List;

/**
 * Clase fachada de datos de los repositorios
 *
 * @author
 */
public class FachadaDatos implements iDatos {

    /**
     * Atributos instancia de los repositorios
     */
    private final RepEstado repositorioEstados = new RepEstado();
    private final RepAnclado repositorioAnclados = new RepAnclado();
    private final RepComentario repositorioComentarios = new RepComentario();
    private final RepAdmor repositorioAdmors = new RepAdmor();
    private final RepMunicipio repositorioMunicipios = new RepMunicipio();
    private final RepPost repositorioPosts = new RepPost();
    private final RepComun repositorioComunes = new RepComun();
    private final RepNormal repositorioNormales = new RepNormal();
    private final RepUsuario repositorioUsuarios = new RepUsuario();

    /**
     * Busca un estado en la base de datos
     *
     * @param id
     * @return Regresa un estado en caso de que se haya encontrado
     */
    @Override
    public Estado buscarEstado(int id) {
        try {
            return repositorioEstados.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un estado en la base de datos
     *
     * @param estado Recibe un estado el cual se guardara en la base de datos
     */
    @Override
    public void guardarEstado(Estado estado) {
        try {
            repositorioEstados.guardar(estado);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un estado en la base de datos
     *
     * @param estado Recibe un estado el cual se actualizara en la base de datos
     */
    @Override
    public void actualizarEstado(int id, Estado estado) {
        try {
            repositorioEstados.actualizar(id, estado);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un estado de la base de datos
     *
     * @param entidad Recibe el ID de un estado el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarEstado(Estado entidad) {
        try {
            repositorioEstados.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los estados de la base de datos mediante una consulta
     *
     * @return Regresa todos los estados que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Estado> buscaEstado() {
        try {
            return repositorioEstados.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Busca un anclado en la base de datos
     *
     * @param id
     * @return Regresa un anclado en caso de que se haya encontrado
     */
    @Override
    public Anclado buscarAnclado(int id) {
        try {
            return repositorioAnclados.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un anclado en la base de datos
     *
     * @param anclado Recibe un anclado el cual se guardara en la base de datos
     */
    @Override
    public void guardarAnclado(Anclado anclado) {
        try {
            repositorioAnclados.guardar(anclado);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un anclado en la base de datos
     *
     * @param anclado Recibe un anclado el cual se actualizara en la base de
     * datos
     */
    @Override
    public void actualizarAnclado(int id, Anclado anclado) {
        try {
            repositorioAnclados.actualizar(id, anclado);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un anclado de la base de datos
     *
     * @param entidad Recibe el ID de un anclado el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarAnclado(Anclado entidad) {
        try {
            repositorioAnclados.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los anclados de la base de datos mediante una consulta
     *
     * @return Regresa todos los anclados que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Anclado> buscaAnclado() {
        try {
            return repositorioAnclados.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Busca un comentario en la base de datos
     *
     * @param id
     * @return Regresa un comentario en caso de que se haya encontrado
     */
    @Override
    public Comentario buscarComentario(int id) {
        try {
            return repositorioComentarios.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un comentario en la base de datos
     *
     * @param comentario Recibe un comentario el cual se guardara en la base de
     * datos
     */
    @Override
    public void guardarComentario(Comentario comentario) {
        try {
            repositorioComentarios.guardar(comentario);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un comentario en la base de datos
     *
     * @param comentario Recibe un comentario el cual se actualizara en la base
     * de datos
     */
    @Override
    public void actualizarComentario(int id, Comentario comentario) {
        try {
            repositorioComentarios.actualizar(id, comentario);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un comentario de la base de datos
     *
     * @param entidad Recibe el ID de un comentario el cual se eliminara de la
     * base de datos
     */
    @Override
    public void eliminarComentario(Comentario entidad) {
        try {
            repositorioComentarios.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los comentarios de la base de datos mediante una consulta
     *
     * @return Regresa todos los comentarios que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Comentario> buscaComentario() {
        try {
            return repositorioComentarios.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Busca un municipio en la base de datos
     *
     * @param id
     * @return Regresa un municipio en caso de que se haya encontrado
     */
    @Override
    public Admor buscarAdmor(int id) {
        try {
            return repositorioAdmors.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un municipio en la base de datos
     *
     * @param admor Recibe un municipio el cual se guardara en la base de datos
     */
    @Override
    public void guardarAdmor(Admor admor) {
        try {
            repositorioAdmors.guardar(admor);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un municipio en la base de datos
     *
     * @param admor Recibe un municipio el cual se actualizara en la base de
     * datos
     */
    @Override
    public void actualizarAdmor(int id, Admor admor) {
        try {
            repositorioAdmors.actualizar(id, admor);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un municipio de la base de datos
     *
     * @param entidad Recibe el ID de un municipio el cual se eliminara de la
     * base de datos
     */
    @Override
    public void eliminarAdmor(Admor entidad) {
        try {
            repositorioAdmors.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los municipios de la base de datos mediante una consulta
     *
     * @return Regresa todos los municipios que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Admor> buscaAdmor() {
        try {
            return repositorioAdmors.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Busca un municipio en la base de datos
     *
     * @param id
     * @return Regresa un municipio en caso de que se haya encontrado
     */
    @Override
    public Municipio buscarMunicipio(int id) {
        try {
            return repositorioMunicipios.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un municipio en la base de datos
     *
     * @param municipio Recibe un municipio el cual se guardara en la base de
     * datos
     */
    @Override
    public void guardarMunicipio(Municipio municipio) {
        try {
            repositorioMunicipios.guardar(municipio);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un municipio en la base de datos
     *
     * @param municipio Recibe un municipio el cual se actualizara en la base de
     * datos
     */
    @Override
    public void actualizarMunicipio(int id, Municipio municipio) {
        try {
            repositorioMunicipios.actualizar(id, municipio);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un municipio de la base de datos
     *
     * @param entidad Recibe el ID de un municipio el cual se eliminara de la
     * base de datos
     */
    @Override
    public void eliminarMunicipio(Municipio entidad) {
        try {
            repositorioMunicipios.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los municipios de la base de datos mediante una consulta
     *
     * @return Regresa todos los municipios que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Municipio> buscaMunicipio() {
        try {
            return repositorioMunicipios.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Busca un post en la base de datos
     *
     * @param id
     * @return Regresa un post en caso de que se haya encontrado
     */
    @Override
    public Post buscarPost(int id) {
        try {
            return repositorioPosts.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un post en la base de datos
     *
     * @param post Recibe un post el cual se guardara en la base de datos
     */
    @Override
    public void guardarPost(Post post) {
        try {
            repositorioPosts.guardar(post);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un post en la base de datos
     *
     * @param post Recibe un post el cual se actualizara en la base de datos
     */
    @Override
    public void actualizarPost(int id, Post post) {
        try {
            repositorioPosts.actualizar(id, post);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un post de la base de datos
     *
     * @param entidad Recibe el ID de un post el cual se eliminara de la base de
     * datos
     */
    @Override
    public void eliminarPost(Post entidad) {
        try {
            repositorioPosts.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los posts de la base de datos mediante una consulta
     *
     * @return Regresa todos los posts que se hayan podido recuperar de la base
     * de datos
     */
    @Override
    public List<Post> buscaPost() {
        try {
            return repositorioPosts.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Busca un comun en la base de datos
     *
     * @param id
     * @return Regresa un comun en caso de que se haya encontrado
     */
    @Override
    public Comun buscarComun(int id) {
        try {
            return repositorioComunes.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un comun en la base de datos
     *
     * @param comun Recibe un comun el cual se guardara en la base de datos
     */
    @Override
    public void guardarComun(Comun comun) {
        try {
            repositorioComunes.guardar(comun);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un comun en la base de datos
     *
     * @param comun Recibe un comun el cual se actualizara en la base de datos
     */
    @Override
    public void actualizarComun(int id, Comun comun) {
        try {
            repositorioComunes.actualizar(id, comun);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un comun de la base de datos
     *
     * @param entidad Recibe el ID de un comun el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarComun(Comun entidad) {
        try {
            repositorioComunes.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los comuns de la base de datos mediante una consulta
     *
     * @return Regresa todos los comuns que se hayan podido recuperar de la base
     * de datos
     */
    @Override
    public List<Comun> buscaComun() {
        try {
            return repositorioComunes.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Busca un normal en la base de datos
     *
     * @param id
     * @return Regresa un normal en caso de que se haya encontrado
     */
    @Override
    public Normal buscarNormal(int id) {
        try {
            return repositorioNormales.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un normal en la base de datos
     *
     * @param normal Recibe un normal el cual se guardara en la base de datos
     */
    @Override
    public void guardarNormal(Normal normal) {
        try {
            repositorioNormales.guardar(normal);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un normal en la base de datos
     *
     * @param normal Recibe un normal el cual se actualizara en la base de datos
     */
    @Override
    public void actualizarNormal(int id, Normal normal) {
        try {
            repositorioNormales.actualizar(id, normal);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un normal de la base de datos
     *
     * @param entidad Recibe el ID de un normal el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarNormal(Normal entidad) {
        try {
            repositorioNormales.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los normals de la base de datos mediante una consulta
     *
     * @return Regresa todos los normals que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Normal> buscaNormal() {
        try {
            return repositorioNormales.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Busca un usuario en la base de datos
     *
     * @param id
     * @return Regresa un usuario en caso de que se haya encontrado
     */
    @Override
    public Usuario buscarUsuario(int id) {
        try {
            return repositorioUsuarios.buscar(id);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

    /**
     * Guarda un usuario en la base de datos
     *
     * @param usuario Recibe un usuario el cual se guardara en la base de datos
     */
    @Override
    public void guardarUsuario(Usuario usuario) {
        try {
            repositorioUsuarios.guardar(usuario);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Actualiza un usuario en la base de datos
     *
     * @param usuario Recibe un usuario el cual se actualizara en la base de
     * datos
     */
    @Override
    public void actualizarUsuario(int id, Usuario usuario) {
        try {
            repositorioUsuarios.actualizar(id, usuario);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Elimnar un usuario de la base de datos
     *
     * @param entidad Recibe el ID de un usuario el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarUsuario(Usuario entidad) {
        try {
            repositorioUsuarios.eliminar(entidad);
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
    }

    /**
     * Obtiene todos los usuarios de la base de datos mediante una consulta
     *
     * @return Regresa todos los usuarios que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Usuario> buscaUsuario() {
        try {
            return repositorioUsuarios.buscar();
        } catch (DAOException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Sucedio algo raro");
        }
        return null;
    }

}
