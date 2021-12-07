package com.example.systemyliczbowe.NumberConverter;

public class ConversionToBin implements Conversion {

    @Override
    public String convert(Long number) {
        return Long.toBinaryString(number);
    }
}
