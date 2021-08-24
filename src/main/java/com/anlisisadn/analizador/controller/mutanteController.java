package com.anlisisadn.analizador.controller;

import com.anlisisadn.analizador.detector.DetectorMutants;
import com.anlisisadn.analizador.model.Mutante;
import com.anlisisadn.analizador.service.MutanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mutant")
public class mutanteController {

    @Autowired
    MutanteService mutanteService;

    @GetMapping("")
    public List<Mutante> list() {
        return mutanteService.listAllMutante();
    }


    @PostMapping("/")
    ResponseEntity<String> add(@RequestBody Map<Object, String[]> mutante) {
        DetectorMutants detector = new DetectorMutants();
        boolean status = detector.isMuntant(mutante.get("dna"));
        if (status) {
            mutanteService.saveUser(new Mutante(0, String.join(",", mutante.get("dna")), 1));
            return ResponseEntity.status(HttpStatus.OK).body("200-OK");
        }
        mutanteService.saveUser(new Mutante(0, String.join(",", mutante.get("dna")), 0));
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("403-FORBIDEN");
    }

    @GetMapping("/stats")
    Map stats() {
        return mutanteService.statsMutants();
    }
}
