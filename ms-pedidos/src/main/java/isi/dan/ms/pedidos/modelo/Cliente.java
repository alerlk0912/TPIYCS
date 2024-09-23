package isi.dan.ms.pedidos.modelo;


import lombok.Data;

@Data
public class Cliente {
    
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correoElectronico;
    private String cuit;
    private String direccion;
    private Integer numero;

}
