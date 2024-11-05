package jose.org.demobizum.Servicios;

import jakarta.annotation.PostConstruct;
import jose.org.demobizum.Entidades.Contactos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ContactosService {
    private List<Contactos> repositorio = new ArrayList<>();

    public List<Contactos> findAll(){
        return repositorio;
    }

    public Contactos findByName(String nombre) {
        Contactos personas = repositorio.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findAny().orElse(null);
        return personas;
    }
    public Contactos findByNumber(String numeroTelefono) {
        Contactos personas = repositorio.stream()
                .filter(p -> p.getNumeroTelefono().equals(numeroTelefono))
                .findAny().orElse(null);
        return personas;
    }

    public Contactos add(Contactos personas) {
        repositorio.add(personas);
        return personas;
    }

    public void delete(Contactos personas) {
        repositorio.remove(personas);
    }

    @PostConstruct
    public void init() {
        repositorio.addAll(
                Arrays.asList(
                        Contactos.builder()
                                .nombre("Martyna")
                                .apellido("Contreras")
                                .numeroTelefono("650896574")
                                .build(),
                        Contactos.builder()
                                .nombre("Juan")
                                .apellido("Ramirez")
                                .numeroTelefono("655342511")
                                .build(),
                        Contactos.builder()
                                .nombre("David")
                                .apellido("Colon")
                                .numeroTelefono("699876523")
                                .build()
                )
        );
    }
}
