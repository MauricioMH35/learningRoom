package org.leraning.notes.resources;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Resource {

    @GetMapping("/primeiro-teste")
    public ResponseEntity<String> primeiroTeste() {
        return ResponseEntity
                .ok("Esse é o primeiro teste com o ResponseEntity"); // status acompanhado do corpo da resposta
    }

    @GetMapping("/segundo-teste/{number}")
    public ResponseEntity<String> segundoTeste(@PathVariable Long number) {
        if (number > 2l) {
            return ResponseEntity
                    .badRequest() // status da resposta
                    .body("Essa segunda requisição não foi bem sucedida"); // corpo da resposta
        }

        return ResponseEntity
                .badRequest() // irá usar o status BadRequest
                .build(); // o método build serve para finalizar a construção do ResponseEntity
    }

    @GetMapping("/terceiro-teste")
    public ResponseEntity<String> terceiroTeste() {
        HttpHeaders httpHeaders = new HttpHeaders(); // criando uma instância de um cabeçalho http
        httpHeaders.add("custom-header", "cabeçalho customizado"); // nome e valor do header

        return new ResponseEntity<>(
                "Criado com sucesso", // mensagem da resposta
                httpHeaders, // cabeçalho da resposta (pode ser usado para passar um token)
                HttpStatus.CREATED // status http da resposta
        );
    }

    @GetMapping("/quarto-teste")
    public ResponseEntity<Long> quartoTeste() {
        return ResponseEntity
                .status(HttpStatus.CONFLICT) // status http da resposta
                .header("custom-header", "valor A", "valor B") // cabeçalho da resposta
                .body(1024l); // mensagem da resposta
    }

}
