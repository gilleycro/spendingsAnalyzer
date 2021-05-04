package com.debugaholic.spendingsanalyzer.csvmappers;

import com.debugaholic.spendingsanalyzer.csvmappers.enums.Currency;
import com.debugaholic.spendingsanalyzer.csvmappers.enums.TransactionTypePBZ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
public class PBZMapper extends MapperObject{

	private TransactionTypePBZ transactionType;

	//TODO move this logic from constructor
	public PBZMapper(String[] parsedArr) {
		NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

		try {
			this.setDate(convertDate(parsedArr[0].trim()));
			this.setValue(format.parse(parsedArr[3].trim()).doubleValue());

		} catch (ParseException exception){
			//TODO handle this
		}
		//TODO add enums and handle errors
		this.setTransactionType(TransactionTypePBZ.UNKNOWN);
		this.setPaymentDescription(parsedArr[2].trim());
		this.setCurrency(Currency.valueOf(parsedArr[4].trim()));
	}

	private Date convertDate(String dateString) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Date date = format.parse(dateString);

		return date;
	}
}
