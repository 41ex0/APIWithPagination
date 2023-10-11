package Principal.TPAPI.services;

import Principal.TPAPI.entities.Autor;
import Principal.TPAPI.repositories.AutorRepository;
import Principal.TPAPI.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{
    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
        this.autorRepository = autorRepository;
    }
}
