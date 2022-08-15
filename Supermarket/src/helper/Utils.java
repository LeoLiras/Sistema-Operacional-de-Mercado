package helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utils {
	
	static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	static NumberFormat number = new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
	
	public static String dateString(Date data) {
		return Utils.date.format(data);
	}
	
	public static String numberToString(Double valor) {
		return Utils.number.format(valor);
	}
	
	public static Double stringToNumber(String txt) {
		try {
			return (Double)Utils.number.parse(txt);
		}catch(ParseException e) {
			return null;
		}
	}
	
	public static void stop(int seg) {
		try {
			TimeUnit.SECONDS.sleep(seg);
		}catch(InterruptedException e) {
			System.out.println("Erro ao pausar por " + seg + " segundos.");
		}
	}
}
