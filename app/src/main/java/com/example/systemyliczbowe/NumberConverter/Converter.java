package com.example.systemyliczbowe.NumberConverter;

public class Converter {

    private Conversion conversionAlgorithm;

    public void setConversionAlgorithm(Conversion conversion) {
        this.conversionAlgorithm = conversion;
    }

    public String convert(Long number) {
        return this.conversionAlgorithm.convert(number);
    }
}
