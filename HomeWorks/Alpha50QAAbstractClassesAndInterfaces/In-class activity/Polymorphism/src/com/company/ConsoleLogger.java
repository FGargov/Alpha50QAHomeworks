package com.company;

import com.company.contracts.Logger;

public class ConsoleLogger implements Logger {

    @Override
    public void log(String value) {
        System.out.println(value);
    }
}
