/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo9.proyectogrupo9;

import javafx.util.StringConverter;

/**
 *
 * @author sebas
 */
public class EnumConverter extends StringConverter<TipoCliente>{
    @Override public String toString(TipoCliente enumConstant) {
        return enumConstant+"";
    }

    @Override public TipoCliente fromString(String string) {
        return TipoCliente.valueOf(string);
    }
}
