package jose.org.demobizum.Entidades;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Bizum {
    private int idBizum;
    private LocalDate fecha;
    double cantidad;
    private String concepto;
    private String destinatario;
}
