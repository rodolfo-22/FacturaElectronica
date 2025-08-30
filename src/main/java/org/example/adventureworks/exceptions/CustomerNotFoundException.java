package org.example.adventureworks.exceptions;

//En este caso, la excepción personalizada CustomerNotFoundException extiende RuntimeException y se utiliza para indicar que un cliente no fue encontrado en la base de datos.
//Al extender RuntimeException, no es necesario declarar la excepción en la firma de los métodos que pueden lanzarla, lo que simplifica el código en muchos casos.
//Esta excepción puede ser lanzada desde cualquier parte del código donde se intente acceder a un
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
