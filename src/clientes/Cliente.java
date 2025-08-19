package clientes;

import clientes.CifradoUtil;

/**
 * Cliente
 * -------
 * Representa a un cliente del sistema.
 * La cédula se almacena cifrada en disco, y solo se puede
 * ver en claro si el rol es "Administrador".
 */
public class Cliente {
    private String nombre;
    private String correo;
    private String cedulaCifrada;

    public Cliente(String nombre, String correo, String cedula) {
        this.nombre = nombre;
        this.correo = correo;
        // Almacenar cifrado inmediatamente
        this.cedulaCifrada = CifradoUtil.cifrar(cedula);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    /**
     * Obtener la cédula según el rol.
     * Si no es administrador, devolvemos la versión cifrada.
     */
    public String getCedula(String rol) {
        if ("Administrador".equalsIgnoreCase(rol)) {
            return CifradoUtil.descifrar(cedulaCifrada);
        } else {
            return "***Cédula protegida***";
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Correo: " + correo;
    }
}

