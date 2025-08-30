package org.example.adventureworks.exceptions;

//En esta clase definimos una excepcion personalizada para cuando no se encuentra un cliente
//En este caso, la excepción personalizada CustomerNotFoundException extiende RuntimeException y se utiliza para indicar que un cliente no fue encontrado en la base de datos.
//Al extender RuntimeException, no es necesario declarar la excepción en la firma de los métodos que pueden lanzarla, lo que simplifica el código en muchos casos.
//Esta excepción puede ser lanzada desde cualquier parte del código donde se intente acceder a un cliente que no existe.
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
