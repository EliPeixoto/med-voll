package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {

        repository.save(new Medico(dados));

    }
@GetMapping
    public List<DadosListagemMedico> listar (Pageable paginacao){
        return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList();

    }
}


