package Principal.TPAPI.services;

import Principal.TPAPI.entities.Libro;
import Principal.TPAPI.repositories.BaseRepository;
import Principal.TPAPI.repositories.DomicilioRepository;
import Principal.TPAPI.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro,Long> implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository) {
        super(baseRepository);
    }
}
