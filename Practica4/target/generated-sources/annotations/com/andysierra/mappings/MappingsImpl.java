package com.andysierra.mappings;

import com.andysierra.model.impl.Usuario;
import com.andysierra.request.UsuarioRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T16:19:46-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class MappingsImpl implements Mappings {

    @Override
    public Usuario usuarioRequest2usuario(UsuarioRequest usuarioRequest) {
        if ( usuarioRequest == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioRequest.getId() );
        usuario.setCorreo( usuarioRequest.getCorreo() );
        usuario.setEdad( usuarioRequest.getEdad() );
        usuario.setNombre( usuarioRequest.getNombre() );

        return usuario;
    }
}
