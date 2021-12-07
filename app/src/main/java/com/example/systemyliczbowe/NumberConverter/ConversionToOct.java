package com.example.systemyliczbowe.NumberConverter;

public class ConversionToOct implements Conversion {

    @Override
    public String convert(Long number) {
        return Long.toOctalString(number);
    }
}
