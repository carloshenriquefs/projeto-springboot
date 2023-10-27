package br.com.danieleleao.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {

    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id) {
        return "O paramêtro é: " + id;
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoCOmQueryParams(@RequestParam String id) {
        return "O paramêtro com metodoComQueryParams é: " + id;
    }

    @GetMapping("/metodoComQueryParams2")
    public String metodoCOmQueryParams2(@RequestParam Map<String, String> allParams) {
        return "O paramêtro com metodoComQueryParams é: " + allParams.entrySet();
    }

    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario) {
        return "metodoComBodyParams " + usuario.username;
    }

    @PostMapping("/metodoComHeaders")
    public String metodoComHeaders(@RequestHeader("name") String name) {
        return "metodoComHeaders " + name;
    }

    @PostMapping("/metodoComListHeaders")
    public String metodoComListHeaders(@RequestHeader Map<String, String> headers) {
        return "metodoComListHeaders " + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity")
    public ResponseEntity<Object> metodoResponseEntity() {
        return ResponseEntity.status(400).body("Mensagem de Erro");
    }

    @GetMapping("/metodoResponseEntity1/{id}")
    public ResponseEntity<Object> metodoResponseEntity1(@PathVariable Long id) {
        var usuario = new Usuario("danieleao");

        if (id > 5) {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }
        return ResponseEntity.badRequest().body("Número menor que 5");
    }

    record Usuario(String username) {
    }

}
