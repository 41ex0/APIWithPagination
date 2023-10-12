package Principal.TPAPI.repositories;

import Principal.TPAPI.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    boolean existsByDni(int dni);

    //SIN PAGINACION
    //Anotacion Metodo de Query

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    List<Persona> searchIndex(String filtro);

    //Anotacion JPQL parametros nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> searchNamed(@Param("filtro") String filtro);

    //Anotacion JPQL conn Query Nativo
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(String filtro);


    //CON PAGINACION
    //Anotacion Metodo de Query
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    Page<Persona> searchIndexPaged(String filtro, Pageable pageable);

    //Anotacion JPQL parametros nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> searchNamedPaged(@Param("filtro") String filtro, Pageable pageable);

    //Anotacion JPQL conn Query Nativo
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativoPaged(@Param("filtro")String filtro, Pageable pageable);

}
