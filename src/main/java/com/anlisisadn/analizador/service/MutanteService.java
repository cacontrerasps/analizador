package com.anlisisadn.analizador.service;

import com.anlisisadn.analizador.model.Mutante;
import com.anlisisadn.analizador.repository.MutanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MutanteService {

    @Autowired
    private MutanteRepository mutanteRepository;

    public List<Mutante> listAllMutante() {
        return mutanteRepository.findAll();
    }

    public void saveUser(Mutante mutante) {
        if (mutanteRepository.findAll().stream().
                filter(a -> a.getDna().equals(mutante.getDna())).
                findFirst().stream().count() == 0) {
            mutanteRepository.save(mutante);
        }
    }

    public Map statsMutants() {
        double mutantes = mutanteRepository.findAll().stream().filter(a -> (a.getEsMutante() == 1)).count();
        double noMutantes = mutanteRepository.findAll().stream().filter(a -> (a.getEsMutante() == 0)).count();
        double averageMutante = (mutantes / noMutantes);
        Map<String, Double> stats = new HashMap<String, Double>();
        stats.put("count_mutant_dna", mutantes);
        stats.put("count_human_dna", noMutantes);
        stats.put("ratio", averageMutante);
        return stats;
    }

}
