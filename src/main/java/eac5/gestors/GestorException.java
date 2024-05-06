/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eac5.gestors;

import lombok.NoArgsConstructor;

/**
 *
 * @author joan
 */

@NoArgsConstructor

public class GestorException extends Exception {


    public GestorException(String message) {
        super(message);
    }

    public GestorException(String message, Throwable cause) {
        super(message, cause);
    }

    public GestorException(Throwable cause) {
        super(cause);
    }

    public GestorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}