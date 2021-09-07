package Fabrica;

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
 *
 *
 * @author
 */
public class FachadaRN implements iNegocios {

    /**
     * Atributos instancia de los controles
     */
    private final ctlEstado ctlEstados = new ctlEstado();
    private final ctlAnclado ctlAnclados = new ctlAnclado();
    private final ctlComentario ctlComentarios = new ctlComentario();
    private final ctlAdmor ctlAdmors = new ctlAdmor();
    private final ctlMunicipio ctlMunicipios = new ctlMunicipio();
    private final ctlPost ctlPosts = new ctlPost();
    private final ctlComun ctlComunes = new ctlComun();
    private final ctlNormal ctlNormales = new ctlNormal();
    private final ctlUsuario ctlUsuarios = new ctlUsuario();

    /**
     * Busca un estado en la base de datos
     *
     * @param id
     * @return Regresa un estado en caso de que se haya encontrado
     */
    @Override
    public Estado buscarEstado(int id) {
        return ctlEstados.buscar(id);
    }

    /**
     * Guarda un estado en la base de datos
     *
     * @param estado Recibe un estado el cual se guardara en la base de datos
     */
    @Override
    public void guardarEstado(Estado estado) {
        ctlEstados.guardar(estado);
    }

    /**
     * Actualiza un estado en la base de datos
     *
     * @param estado Recibe un estado el cual se actualizara en la base de datos
     */
    @Override
    public void actualizarEstado(int id, Estado estado) {
        ctlEstados.actualizar(id, estado);
    }

    /**
     * Elimnar un estado de la base de datos
     *
     * @param entidad Recibe el ID de un estado el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarEstado(Estado entidad) {
        ctlEstados.eliminar(entidad);
    }

    /**
     * Obtiene todos los estados de la base de datos mediante una consulta
     *
     * @return Regresa todos los estados que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Estado> buscaEstado() {
        return ctlEstados.buscar();
    }

    /**
     * Busca un anclado en la base de datos
     *
     * @param id
     * @return Regresa un anclado en caso de que se haya encontrado
     */
    @Override
    public Anclado buscarAnclado(int id) {
        return ctlAnclados.buscar(id);
    }

    /**
     * Guarda un anclado en la base de datos
     *
     * @param anclado Recibe un anclado el cual se guardara en la base de datos
     */
    @Override
    public void guardarAnclado(Anclado anclado) {
        ctlAnclados.guardar(anclado);
    }

    /**
     * Actualiza un anclado en la base de datos
     *
     * @param anclado Recibe un anclado el cual se actualizara en la base de
     * datos
     */
    @Override
    public void actualizarAnclado(int id, Anclado anclado) {
        ctlAnclados.actualizar(id, anclado);
    }

    /**
     * Elimnar un anclado de la base de datos
     *
     * @param entidad Recibe el ID de un anclado el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarAnclado(Anclado entidad) {
        ctlAnclados.eliminar(entidad);
    }

    /**
     * Obtiene todos los anclados de la base de datos mediante una consulta
     *
     * @return Regresa todos los anclados que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Anclado> buscaAnclado() {
        return ctlAnclados.buscar();
    }

    /**
     * Busca un comentario en la base de datos
     *
     * @param id
     * @return Regresa un comentario en caso de que se haya encontrado
     */
    @Override
    public Comentario buscarComentario(int id) {
        return ctlComentarios.buscar(id);
    }

    /**
     * Guarda un comentario en la base de datos
     *
     * @param comentario Recibe un comentario el cual se guardara en la base de
     * datos
     */
    @Override
    public void guardarComentario(Comentario comentario) {
        ctlComentarios.guardar(comentario);
    }

    /**
     * Actualiza un comentario en la base de datos
     *
     * @param comentario Recibe un comentario el cual se actualizara en la base
     * de datos
     */
    @Override
    public void actualizarComentario(int id, Comentario comentario) {
        ctlComentarios.actualizar(id, comentario);
    }

    /**
     * Elimnar un comentario de la base de datos
     *
     * @param entidad Recibe el ID de un comentario el cual se eliminara de la
     * base de datos
     */
    @Override
    public void eliminarComentario(Comentario entidad) {
        ctlComentarios.eliminar(entidad);
    }

    /**
     * Obtiene todos los comentarios de la base de datos mediante una consulta
     *
     * @return Regresa todos los comentarios que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Comentario> buscaComentario() {
        return ctlComentarios.buscar();
    }

    /**
     * Busca un municipio en la base de datos
     *
     * @param id
     * @return Regresa un municipio en caso de que se haya encontrado
     */
    @Override
    public Admor buscarAdmor(int id) {
        return ctlAdmors.buscar(id);
    }

    /**
     * Guarda un municipio en la base de datos
     *
     * @param admor Recibe un municipio el cual se guardara en la base de datos
     */
    @Override
    public void guardarAdmor(Admor admor) {
        ctlAdmors.guardar(admor);
    }

    /**
     * Actualiza un municipio en la base de datos
     *
     * @param admor Recibe un municipio el cual se actualizara en la base de
     * datos
     */
    @Override
    public void actualizarAdmor(int id, Admor admor) {
        ctlAdmors.actualizar(id, admor);
    }

    /**
     * Elimnar un municipio de la base de datos
     *
     * @param entidad Recibe el ID de un municipio el cual se eliminara de la
     * base de datos
     */
    @Override
    public void eliminarAdmor(Admor entidad) {
        ctlAdmors.eliminar(entidad);
    }

    /**
     * Obtiene todos los municipios de la base de datos mediante una consulta
     *
     * @return Regresa todos los municipios que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Admor> buscaAdmor() {
        return ctlAdmors.buscar();
    }

    /**
     * Busca un municipio en la base de datos
     *
     * @param id
     * @return Regresa un municipio en caso de que se haya encontrado
     */
    @Override
    public Municipio buscarMunicipio(int id) {
        return ctlMunicipios.buscar(id);
    }

    /**
     * Guarda un municipio en la base de datos
     *
     * @param municipio Recibe un municipio el cual se guardara en la base de
     * datos
     */
    @Override
    public void guardarMunicipio(Municipio municipio) {
        ctlMunicipios.guardar(municipio);
    }

    /**
     * Actualiza un municipio en la base de datos
     *
     * @param municipio Recibe un municipio el cual se actualizara en la base de
     * datos
     */
    @Override
    public void actualizarMunicipio(int id, Municipio municipio) {
        ctlMunicipios.actualizar(id, municipio);
    }

    /**
     * Elimnar un municipio de la base de datos
     *
     * @param entidad Recibe el ID de un municipio el cual se eliminara de la
     * base de datos
     */
    @Override
    public void eliminarMunicipio(Municipio entidad) {
        ctlMunicipios.eliminar(entidad);
    }

    /**
     * Obtiene todos los municipios de la base de datos mediante una consulta
     *
     * @return Regresa todos los municipios que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Municipio> buscaMunicipio() {
        return ctlMunicipios.buscar();
    }

    /**
     * Busca un post en la base de datos
     *
     * @param id
     * @return Regresa un post en caso de que se haya encontrado
     */
    @Override
    public Post buscarPost(int id) {
        return ctlPosts.buscar(id);
    }

    /**
     * Guarda un post en la base de datos
     *
     * @param post Recibe un post el cual se guardara en la base de datos
     */
    @Override
    public void guardarPost(Post post) {
        ctlPosts.guardar(post);
    }

    /**
     * Actualiza un post en la base de datos
     *
     * @param post Recibe un post el cual se actualizara en la base de datos
     */
    @Override
    public void actualizarPost(int id, Post post) {
        ctlPosts.actualizar(id, post);
    }

    /**
     * Elimnar un post de la base de datos
     *
     * @param entidad Recibe el ID de un post el cual se eliminara de la base de
     * datos
     */
    @Override
    public void eliminarPost(Post entidad) {
        ctlPosts.eliminar(entidad);
    }

    /**
     * Obtiene todos los posts de la base de datos mediante una consulta
     *
     * @return Regresa todos los posts que se hayan podido recuperar de la base
     * de datos
     */
    @Override
    public List<Post> buscaPost() {
        return ctlPosts.buscar();
    }

    /**
     * Busca un comun en la base de datos
     *
     * @param id
     * @return Regresa un comun en caso de que se haya encontrado
     */
    @Override
    public Comun buscarComun(int id) {
        return ctlComunes.buscar(id);
    }

    /**
     * Guarda un comun en la base de datos
     *
     * @param comun Recibe un comun el cual se guardara en la base de datos
     */
    @Override
    public void guardarComun(Comun comun) {
        ctlComunes.guardar(comun);
    }

    /**
     * Actualiza un comun en la base de datos
     *
     * @param comun Recibe un comun el cual se actualizara en la base de datos
     */
    @Override
    public void actualizarComun(int id, Comun comun) {
        ctlComunes.actualizar(id, comun);
    }

    /**
     * Elimnar un comun de la base de datos
     *
     * @param entidad Recibe el ID de un comun el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarComun(Comun entidad) {
        ctlComunes.eliminar(entidad);
    }

    /**
     * Obtiene todos los comuns de la base de datos mediante una consulta
     *
     * @return Regresa todos los comuns que se hayan podido recuperar de la base
     * de datos
     */
    @Override
    public List<Comun> buscaComun() {
        return ctlComunes.buscar();
    }

    /**
     * Busca un normal en la base de datos
     *
     * @param id
     * @return Regresa un normal en caso de que se haya encontrado
     */
    @Override
    public Normal buscarNormal(int id) {
        return ctlNormales.buscar(id);
    }

    /**
     * Guarda un normal en la base de datos
     *
     * @param normal Recibe un normal el cual se guardara en la base de datos
     */
    @Override
    public void guardarNormal(Normal normal) {
        ctlNormales.guardar(normal);
    }

    /**
     * Actualiza un normal en la base de datos
     *
     * @param normal Recibe un normal el cual se actualizara en la base de datos
     */
    @Override
    public void actualizarNormal(int id, Normal normal) {
        ctlNormales.actualizar(id, normal);
    }

    /**
     * Elimnar un normal de la base de datos
     *
     * @param entidad Recibe el ID de un normal el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarNormal(Normal entidad) {
        ctlNormales.eliminar(entidad);
    }

    /**
     * Obtiene todos los normals de la base de datos mediante una consulta
     *
     * @return Regresa todos los normals que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Normal> buscaNormal() {
        return ctlNormales.buscar();
    }

    /**
     * Busca un usuario en la base de datos
     *
     * @param id
     * @return Regresa un usuario en caso de que se haya encontrado
     */
    @Override
    public Usuario buscarUsuario(int id) {
        return ctlUsuarios.buscar(id);
    }

    /**
     * Guarda un usuario en la base de datos
     *
     * @param usuario Recibe un usuario el cual se guardara en la base de datos
     */
    @Override
    public void guardarUsuario(Usuario usuario) {
        ctlUsuarios.guardar(usuario);
    }

    /**
     * Actualiza un usuario en la base de datos
     *
     * @param usuario Recibe un usuario el cual se actualizara en la base de
     * datos
     */
    @Override
    public void actualizarUsuario(int id, Usuario usuario) {
        ctlUsuarios.actualizar(id, usuario);
    }

    /**
     * Elimnar un usuario de la base de datos
     *
     * @param entidad Recibe el ID de un usuario el cual se eliminara de la base
     * de datos
     */
    @Override
    public void eliminarUsuario(Usuario entidad) {
        ctlUsuarios.eliminar(entidad);
    }

    /**
     * Obtiene todos los usuarios de la base de datos mediante una consulta
     *
     * @return Regresa todos los usuarios que se hayan podido recuperar de la
     * base de datos
     */
    @Override
    public List<Usuario> buscaUsuario() {
        return ctlUsuarios.buscar();
    }

}
