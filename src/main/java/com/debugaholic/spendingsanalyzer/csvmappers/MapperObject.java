package com.debugaholic.spendingsanalyzer.csvmappers;

import com.debugaholic.spendingsanalyzer.csvmappers.enums.Currency;
import com.debugaholic.spendingsanalyzer.csvmappers.enums.TransactionTypePBZ;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
@NoArgsConstructor
public abstract class MapperObject {

    private Date date;
    private String paymentDescription;
    private Double value;
    private Currency currency;

    public MapperObject(String[] parsedArr) {
        try {
            date = convertDate(parsedArr[0].trim());
        } catch (ParseException exception){
            //TODO handle this
        }
        //TODO add enums and handle errors
        paymentDescription = parsedArr[2].trim();
        value = Double.valueOf(parsedArr[3].trim());
        currency = Currency.valueOf(parsedArr[4].trim());
    }

    private Date convertDate(String dateString) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = format.parse(dateString);

        return date;
    }
}
