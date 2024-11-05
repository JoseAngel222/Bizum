package jose.org.demobizum.Entidades;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Cuenta {
    private Double saldo = 1000.0;

}
