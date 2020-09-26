package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.component.Utilities;
import com.sda.javagda31.students.model.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2")
public class PathRestIndexController {
    private final Utilities utilities;

    public PathRestIndexController(Utilities utilities) {
        this.utilities = utilities;
    }

    // 1. Stwórz endpoint pod adresem /add który pobiera dwa parametry i dodaje je do siebie, po czym zwraca wynik nie opakowany w APIResponse
    //    http://localhost:8080/api/add/100/50
    @GetMapping("/add/{w1}/{w2}")
    public double addTwoValues(@PathVariable(name = "w1") double wartosc1, @PathVariable(name = "w2") double wartosc2) {
        return wartosc1 + wartosc2;
    }

    // 2. Stwórz endpoint pod adresem /sub który pobiera dwa parametry i odejmuje ich wartości od siebie, po czym zwraca wynik opakowany w APIResponse
    // http://localhost:8080/api/sub/100/50
    @GetMapping("/sub/{w1}/{w2}")
    public APIResponse subTwoValues(@PathVariable(name = "w1") double wartosc1, @PathVariable(name = "w2") double wartosc2) {
        return new APIResponse("Wynik = " + (wartosc1 - wartosc2));
    }

    // 3. Stwórz endpoint pod adresem /prime który sprawdza czy liczba jest pierwsza i w odpowiedzi zwraca "Yes" lub "No" wewenątrz APIResponse.
    // http://localhost:8080/api/prime/30
    // http://localhost:8080/api/prime/7
    @GetMapping("/prime/{check}")
    public APIResponse prime(@PathVariable(name = "check") int value) {
//        return new APIResponse(utilities.isPrime(value) ? "Yes" : "No");
        if (utilities.isPrime(value)) {
            return new APIResponse("Yes");
        } else {
            return new APIResponse("No");
        }
    }

    // 4. Stwórz endpoint pod adresem /check który sprawdza liczba pierwsza jest większa od drugiej. Wynik zwróć opakowany w APIResponse
    // http://localhost:8080/api/check/100/50
    // http://localhost:8080/api/check/99/51
    @GetMapping("/check/{w1}/{w2}")
    public APIResponse checkGrater(@PathVariable(name = "w1") double wartosc1, @PathVariable(name = "w2") double wartosc2) {
        return new APIResponse("Wynik = " + (wartosc1 > wartosc2 ? wartosc1 : wartosc2));
    }

    //5. Stwórz endpoint pod adresem /compare ktory zwraca wieksza liczbe. Wynik zwróć nieopakowany.
    // http://localhost:8080/api/compare/100/50
    // http://localhost:8080/api/compare/99/51
    @GetMapping("/compare/{w1}/{w2}")
    public double checkCompare(@PathVariable(name = "w1") double wartosc1, @PathVariable(name = "w2") double wartosc2) {
        return wartosc1 > wartosc2 ? wartosc1 : wartosc2;
    }

    // // 6. Stworz endpoint pod adresem /div który dzieli liczby. Jeśli dzielnik = 0, to zwróć kod błędu 400 - bez ciała odpowiedzi
    // http://localhost:8080/api/compare/100/50
    // http://localhost:8080/api/compare/99/51
    @GetMapping("/div/{dzielna}/{dzielnik}")
    public ResponseEntity divide(@PathVariable(name = "dzielna") double wartosc1, @PathVariable(name = "dzielnik") double wartosc2) {
        if(wartosc2 ==0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(wartosc1/wartosc2);
    }
}
