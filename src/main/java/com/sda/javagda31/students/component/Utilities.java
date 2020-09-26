package com.sda.javagda31.students.component;

import org.springframework.stereotype.Component;

@Component
public class Utilities {
    public boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }

        // 10
        // check < sqrt(10) = 3,...
        // 100 // sqrt(10)
        // 2 ,3 ,4, 5, 6, 7, 8, 9, 10
        // log2(value) -
        // value -
        double limit = Math.sqrt(value);
        for (int i = 2; i <= limit; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
