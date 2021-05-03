package com.debugaholic.spendingsanalyzer.csvmappers;

import com.debugaholic.spendingsanalyzer.csvmappers.enums.Currency;
import com.debugaholic.spendingsanalyzer.csvmappers.enums.TransactionTypePBZ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PBZMapper extends MapperObject{

	private Date date;
	private TransactionTypePBZ transactionType;
	private String paymentDescription;
	private Double value;
	private Currency currency;

	public PBZMapper(String[] parsedArr) {
		try {
			date = convertDate(parsedArr[0].trim());
		} catch (ParseException exception){
			//TODO handle this
		}
		//TODO add enums and handle errors
		transactionType = TransactionTypePBZ.UNKNOWN;
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
