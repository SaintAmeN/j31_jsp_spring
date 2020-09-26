package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.component.Utilities;
import com.sda.javagda31.students.model.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestIndexController {

    private final Utilities utilities;

    public RestIndexController(Utilities utilities) {
        this.utilities = utilities;
    }

    @GetMapping("/")
    public APIResponse index() {
        return new APIResponse("Helloł łorld!");
    }

    // Request param
    // Path variable

    // localhost:8080/api/welcome?imieTwe=...
    // http://localhost:8080/api/welcome?imieTwe=pawel
    @GetMapping("/welcome")
    public APIResponse welcome(@RequestParam(name = "imieTwe") String imie) {
        return new APIResponse("Welcome " + imie + "!");
    }

    // 1. Stwórz endpoint pod adresem /add który pobiera dwa parametry i dodaje je do siebie, po czym zwraca wynik nie opakowany w APIResponse
    //    http://localhost:8080/api/add?w1=100&w2=50
    @GetMapping("/add")
    public double addTwoValues(@RequestParam(name = "w1") double wartosc1, @RequestParam(name = "w2") double wartosc2) {
        return wartosc1 + wartosc2;
    }

    // 2. Stwórz endpoint pod adresem /sub który pobiera dwa parametry i odejmuje ich wartości od siebie, po czym zwraca wynik opakowany w APIResponse
    // http://localhost:8080/api/sub?w1=100&w2=50
    @GetMapping("/sub")
    public APIResponse subTwoValues(@RequestParam(name = "w1") double wartosc1, @RequestParam(name = "w2") double wartosc2) {
        return new APIResponse("Wynik = " + (wartosc1 - wartosc2));
    }

    // 3. Stwórz endpoint pod adresem /prime który sprawdza czy liczba jest pierwsza i w odpowiedzi zwraca "Yes" lub "No" wewenątrz APIResponse.
    // http://localhost:8080/api/prime?check=30
    // http://localhost:8080/api/prime?check=7
    @GetMapping("/prime")
    public APIResponse prime(@RequestParam(name = "check") int value) {
//        return new APIResponse(utilities.isPrime(value) ? "Yes" : "No");
        if (utilities.isPrime(value)) {
            return new APIResponse("Yes");
        } else {
            return new APIResponse("No");
        }
    }

    // tablice
    // 4. Funkcja do sumowania wartości
    // http://localhost:8080/api/sum?tablica=3.0,4.0,5.0
    @GetMapping("/sum")
    public double sum(@RequestParam(name="tablica") List<Double> tablica){
        return tablica.stream().mapToDouble(Double::doubleValue).sum();
    }



}
