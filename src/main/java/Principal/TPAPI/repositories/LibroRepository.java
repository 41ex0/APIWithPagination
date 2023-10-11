package Principal.TPAPI.repositories;

import Principal.TPAPI.entities.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long>{
}
