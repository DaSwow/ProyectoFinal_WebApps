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
import java.util.List;

/**
 * Clase interfaz de los metodos de datos
 *
 * @author
 */
public interface iDatos {

    /**
     * Busca un estado en la base de datos
     *
     * @param id
     * @return Regresa un estado en caso de que se haya encontrado
     */
    public Estado buscarEstado(int id);

    /**
     * Guarda un estado en la base de datos
     *
     * @param estado Recibe un estado el cual se guardara en la base de datos
     */
    public void guardarEstado(Estado estado);

    /**
     * Actualiza un estado en la base de datos
     *
     * @param id
     * @param estado Recibe un estado el cual se actualizara en la base de datos
     */
    public void actualizarEstado(int id, Estado estado);

    /**
     * Elimnar un estado de la base de datos
     *
     * @param entidad
     */
    public void eliminarEstado(Estado entidad);

    /**
     * Obtiene todos los estados de la base de datos mediante una consulta
     *
     * @return Regresa todos los estados que se hayan podido recuperar de la base de datos
     */
    public List<Estado> buscaEstado();

    /**
     * Busca un anclado en la base de datos
     *
     * @param id
     * @return Regresa un anclado en caso de que se haya encontrado
     */
    public Anclado buscarAnclado(int id);

    /**
     * Guarda un anclado en la base de datos
     *
     * @param anclado Recibe un anclado el cual se guardara en la base de datos
     */
    public void guardarAnclado(Anclado anclado);

    /**
     * Actualiza un anclado en la base de datos
     *
     * @param id
     * @param anclado Recibe un anclado el cual se actualizara en la base de datos
     */
    public void actualizarAnclado(int id, Anclado anclado);

    /**
     * Elimnar un anclado de la base de datos
     *
     * @param entidad
     */
    public void eliminarAnclado(Anclado entidad);

    /**
     * Obtiene todos los anclados de la base de datos mediante una consulta
     *
     * @return Regresa todos los anclados que se hayan podido recuperar de la base de datos
     */
    public List<Anclado> buscaAnclado();

    /**
     * Busca un comentario en la base de datos
     *
     * @param id
     * @return Regresa un comentario en caso de que se haya encontrado
     */
    public Comentario buscarComentario(int id);

    /**
     * Guarda un comentario en la base de datos
     *
     * @param comentario Recibe un comentario el cual se guardara en la base de datos
     */
    public void guardarComentario(Comentario comentario);

    /**
     * Actualiza un comentario en la base de datos
     *
     * @param id
     * @param comentario Recibe un comentario el cual se actualizara en la base de datos
     */
    public void actualizarComentario(int id, Comentario comentario);

    /**
     * Elimnar un comentario de la base de datos
     *
     * @param entidad
     */
    public void eliminarComentario(Comentario entidad);

    /**
     * Obtiene todos los comentarios de la base de datos mediante una consulta
     *
     * @return Regresa todos los comentarios que se hayan podido recuperar de la base de datos
     */
    public List<Comentario> buscaComentario();

    /**
     * Busca un municipio en la base de datos
     *
     * @param id
     * @return Regresa un municipio en caso de que se haya encontrado
     */
    public Admor buscarAdmor(int id);

    /**
     * Guarda un municipio en la base de datos
     *
     * @param admor Recibe un municipio el cual se guardara en la base de datos
     */
    public void guardarAdmor(Admor admor);

    /**
     * Actualiza un municipio en la base de datos
     *
     * @param id
     * @param admor Recibe un municipio el cual se actualizara en la base de datos
     */
    public void actualizarAdmor(int id, Admor admor);

    /**
     * Elimnar un municipio de la base de datos
     *
     * @param entidad Recibe el ID de un municipio el cual se eliminara de la base de datos
     */
    public void eliminarAdmor(Admor entidad);

    /**
     * Obtiene todos los municipios de la base de datos mediante una consulta
     *
     * @return Regresa todos los municipios que se hayan podido recuperar de la base de datos
     */
    public List<Admor> buscaAdmor();

    /**
     * Busca un municipio en la base de datos
     *
     * @param id
     * @return Regresa un municipio en caso de que se haya encontrado
     */
    public Municipio buscarMunicipio(int id);

    /**
     * Guarda un municipio en la base de datos
     *
     * @param municipio Recibe un municipio el cual se guardara en la base de datos
     */
    public void guardarMunicipio(Municipio municipio);

    /**
     * Actualiza un municipio en la base de datos
     *
     * @param id
     * @param municipio Recibe un municipio el cual se actualizara en la base de datos
     */
    public void actualizarMunicipio(int id, Municipio municipio);

    /**
     * Elimnar un municipio de la base de datos
     *
     * @param entidad
     */
    public void eliminarMunicipio(Municipio entidad);

    /**
     * Obtiene todos los municipios de la base de datos mediante una consulta
     *
     * @return Regresa todos los municipios que se hayan podido recuperar de la base de datos
     */
    public List<Municipio> buscaMunicipio();

    /**
     * Busca un post en la base de datos
     *
     * @param id
     * @return Regresa un post en caso de que se haya encontrado
     */
    public Post buscarPost(int id);

    /**
     * Guarda un post en la base de datos
     *
     * @param post Recibe un post el cual se guardara en la base de datos
     */
    public void guardarPost(Post post);

    /**
     * Actualiza un post en la base de datos
     *
     * @param id
     * @param post Recibe un post el cual se actualizara en la base de datos
     */
    public void actualizarPost(int id, Post post);

    /**
     * Elimnar un post de la base de datos
     *
     * @param entidad
     */
    public void eliminarPost(Post entidad);

    /**
     * Obtiene todos los posts de la base de datos mediante una consulta
     *
     * @return Regresa todos los posts que se hayan podido recuperar de la base de datos
     */
    public List<Post> buscaPost();

    /**
     * Busca un comun en la base de datos
     *
     * @param id
     * @return Regresa un comun en caso de que se haya encontrado
     */
    public Comun buscarComun(int id);

    /**
     * Guarda un comun en la base de datos
     *
     * @param comun Recibe un comun el cual se guardara en la base de datos
     */
    public void guardarComun(Comun comun);

    /**
     * Actualiza un comun en la base de datos
     *
     * @param id
     * @param comun Recibe un comun el cual se actualizara en la base de datos
     */
    public void actualizarComun(int id, Comun comun);

    /**
     * Elimnar un comun de la base de datos
     *
     * @param entidad
     */
    public void eliminarComun(Comun entidad);

    /**
     * Obtiene todos los comuns de la base de datos mediante una consulta
     *
     * @return Regresa todos los comuns que se hayan podido recuperar de la base de datos
     */
    public List<Comun> buscaComun();

    /**
     * Busca un normal en la base de datos
     *
     * @param id
     * @return Regresa un normal en caso de que se haya encontrado
     */
    public Normal buscarNormal(int id);

    /**
     * Guarda un normal en la base de datos
     *
     * @param normal Recibe un normal el cual se guardara en la base de datos
     */
    public void guardarNormal(Normal normal);

    /**
     * Actualiza un normal en la base de datos
     *
     * @param id
     * @param normal Recibe un normal el cual se actualizara en la base de datos
     */
    public void actualizarNormal(int id, Normal normal);

    /**
     * Elimnar un normal de la base de datos
     *
     * @param entidad
     */
    public void eliminarNormal(Normal entidad);

    /**
     * Obtiene todos los normals de la base de datos mediante una consulta
     *
     * @return Regresa todos los normals que se hayan podido recuperar de la base de datos
     */
    public List<Normal> buscaNormal();

    /**
     * Busca un usuario en la base de datos
     *
     * @param id
     * @return Regresa un usuario en caso de que se haya encontrado
     */
    public Usuario buscarUsuario(int id);

    /**
     * Guarda un usuario en la base de datos
     *
     * @param usuario Recibe un usuario el cual se guardara en la base de datos
     */
    public void guardarUsuario(Usuario usuario);

    /**
     * Actualiza un usuario en la base de datos
     *
     * @param id
     * @param usuario Recibe un usuario el cual se actualizara en la base de datos
     */
    public void actualizarUsuario(int id, Usuario usuario);

    /**
     * Elimnar un usuario de la base de datos
     *
     * @param entidad
     */
    public void eliminarUsuario(Usuario entidad);

    /**
     * Obtiene todos los usuarios de la base de datos mediante una consulta
     *
     * @return Regresa todos los usuarios que se hayan podido recuperar de la base de datos
     */
    public List<Usuario> buscaUsuario();

}
