package Principal.TPAPI.services;

import Principal.TPAPI.entities.Persona;
import Principal.TPAPI.repositories.BaseRepository;
import Principal.TPAPI.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    //'search' SIN PAGINACION
    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            //Metodo de Query:
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);

            //JPQL parametros indexados:
            //List<Persona> personas = personaRepository.searchIndex(filtro);

            //JPQL parametros nombrados:
            //List<Persona> personas = personaRepository.searchNamed(filtro);

            //JPQL con Query Nativo:
            List<Persona> personas = personaRepository.searchNativo(filtro);

            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    //'search' CON PAGINACION
    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Metodo de Query:
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContainingPaged(filtro, filtro, pageable);

            //JPQL parametros indexados:
            //Page<Persona> personas = personaRepository.searchIndexPaged(filtro, pageable);

            //JPQL parametros nombrados:
            //Page<Persona> personas = personaRepository.searchNamedPaged(filtro, pageable);

            //JPQL con Query Nativo:
            Page<Persona> personas = personaRepository.searchNativoPaged(filtro, pageable);

            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
