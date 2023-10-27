package br.com.danieleleao.main.controller;

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

}
