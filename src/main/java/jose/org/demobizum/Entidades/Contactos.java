package jose.org.demobizum.Entidades;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contactos {
    private String nombre;
    private String apellido;
    private String numeroTelefono;
}
