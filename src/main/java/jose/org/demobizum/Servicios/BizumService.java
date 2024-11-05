package jose.org.demobizum.Servicios;

import jose.org.demobizum.Entidades.Bizum;
import jose.org.demobizum.Entidades.Cuenta;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BizumService {
    private Cuenta cuenta;
    private List<Bizum> transacciones = new ArrayList<>();
    private Double saldo = 1000.00;

    public Double getSaldo() {
        return saldo;
    }

    /*public String enviarDinero(double monto, String concepto) {
            double saldo = cuenta.getSaldo();
            if (saldo >= monto) {
                saldo -= monto;
                cuenta.setSaldo(saldo); // Actualiza el saldo de la cuenta

                // Crea una nueva transacción y la añade a la lista de transacciones
                Bizum transaccion = Bizum.builder()
                        .idBizum(Integer.parseInt(UUID.randomUUID().toString()))
                        .cantidad(monto)
                        .concepto(concepto)
                        .fecha(LocalDate.now())
                        .build();

                transacciones.add(transaccion);
                return "Transacción exitosa. Enviado " + monto + " € para " + concepto;
            } else {
                return "Saldo insuficiente.";
            }
        }*/
    public String enviarDinero(double monto, String concepto, String nombre) {;
        if (saldo >= monto) {
            saldo -= monto;

            Bizum transaccion = Bizum.builder()
                    .idBizum(transacciones.size()+1)
                    .cantidad(monto)
                    .concepto(concepto)
                    .fecha(LocalDate.now())
                    .destinatario(nombre)
                    // .destinatario()
                    .build();
            transacciones.add(transaccion);

            return "Transacción exitosa. Enviado " + monto + " € para " + concepto;
        } else {
        return "Saldo insuficiente.";
    }




    }
    public List<Bizum> getTransacciones() {
        return transacciones; // Devuelve la lista de transacciones
    }
}
