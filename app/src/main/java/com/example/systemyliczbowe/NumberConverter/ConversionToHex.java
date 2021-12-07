package com.example.systemyliczbowe.NumberConverter;

public class ConversionToHex implements Conversion {

    @Override
    public String convert(Long number) {
        return Long.toHexString(number);
    }
}
