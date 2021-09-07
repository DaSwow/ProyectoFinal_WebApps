package Fabrica;

/**
 * Clase Factory
 *
 * @author Equipo 4 Diseno Software
 */
public class Fabrica {

    /**
     * Atributo instancia
     */
    private FachadaRN instancia;

    /**
     * Obtiene la instancia existente. Si no existe una entonces se crea una
     * nueva
     *
     * @return Regresa la instancia actual si es que existe, o la instancia
     * nueva si es que no existia una instancia previa
     */
    public iNegocios dameInstancia() {
        if (instancia == null) {
            instancia = new FachadaRN();
        }
        return instancia;
    }
}
