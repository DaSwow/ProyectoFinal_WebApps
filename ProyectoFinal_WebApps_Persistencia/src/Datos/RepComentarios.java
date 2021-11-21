/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Blog.Comentario;
import Exceptions.DAOException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author carls
 */
public class RepComentarios extends BaseDAO<Comentario> {

    @Override
    public List<Comentario> buscar() throws DAOException {
        MongoCollection<Comentario> coleccion = this.getColeccion();
        FindIterable<Comentario> comentarios = coleccion.find();
        ArrayList<Comentario> listaComentarios = new ArrayList();
        return comentarios.into(listaComentarios);
    }

    @Override
    public void guardar(Comentario entidad) throws DAOException {
        MongoCollection<Comentario> coleccion = this.getColeccion();
        coleccion.insertOne(entidad);
    }

    @Override
    public void actualizar(Comentario entidad) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comentario buscar(ObjectId id) throws DAOException {
        MongoCollection<Comentario> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("_id", id);
        FindIterable<Comentario> comentarios = coleccion.find(filtroBusqueda);
        Comentario comentario = comentarios.first();
        return comentario;
    }

    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Comentario> coleccion = this.getColeccion();
        Document filtroEliminacion = new Document("_id", id);
        coleccion.deleteOne(filtroEliminacion);
    }

    @Override
    public MongoCollection getColeccion() {
        MongoDatabase bd = this.getDatabase();
        MongoCollection<Comentario> coleccion = bd.getCollection("comentarios", Comentario.class);
        return coleccion;
    }

}
