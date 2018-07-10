package br.aplicacao.eletrica.uteis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataUtil {

	public static String Atual() {

		String date = getDia() + "/" + getMes() + "/" + getAno();

		return date;
	}

	public static String DataToString(Calendar data) {

		int dia = data.get(Calendar.DAY_OF_MONTH);
		int mes = data.get(Calendar.MONTH) + 1;
		int ano = data.get(Calendar.YEAR);
		String date = dia + "/" + mes + "/" + ano;

		return date;
	}

	public static int getAno() {
		Calendar cal = new GregorianCalendar();
		int ano = cal.get(Calendar.YEAR);

		return ano;
	}

	public static int getDia() {
		Calendar cal = new GregorianCalendar();
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		return dia;
	}

	public static int getMes() {
		Calendar cal = new GregorianCalendar();
		int mes = cal.get(Calendar.MONTH) + 1;

		return mes;
	}

	public static Calendar stringToData(String data) {

		Calendar cal = null;
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			cal = Calendar.getInstance();
			cal.setTime(sdf.parse(data));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return cal;
	}

	private DataUtil() {
		throw new IllegalStateException("Utility class");

	}
}
