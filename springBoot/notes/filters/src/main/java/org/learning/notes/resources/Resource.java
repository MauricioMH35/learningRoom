package org.learning.notes.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Resource {

    @GetMapping("/somente_get")
    public ResponseEntity<String> somenteGet() {
        return ResponseEntity.ok("recurso aceito, seja bem vindo!");
    }

    @PostMapping("/outra_rota")
    public ResponseEntity<String> outraRota(@RequestBody String nome) {
        return ResponseEntity.ok("seu nome é " + nome);
    }

}
