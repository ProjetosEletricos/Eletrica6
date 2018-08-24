package br.aplicacao.eletrica.uteis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GravarCSV {

	private static final char DEFAULT_SEPARATOR = ';';
	private FileWriter writer;

	public GravarCSV(String file) throws IOException {
		writer = new FileWriter(file);
	}

	public void writeLine(List<String> values) throws IOException {
		writeLine(values, DEFAULT_SEPARATOR, ' ');
	}

	public void writeLine(List<String> values, char separators) throws IOException {
		writeLine(values, separators, ' ');
	}

	// https://tools.ietf.org/html/rfc4180
	private String followCVSformat(String value) {

		String result = value;
		if (result.contains("\"")) {
			result = result.replace("\"", "\"\"");
		}
		return result;

	}

	public void writeLine(List<String> values, char separators, char customQuote) throws IOException {

		boolean first = true;

		// default customQuote is empty

		if (separators == ' ') {
			separators = DEFAULT_SEPARATOR;
		}

		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			if (!first) {
				sb.append(separators);
			}
			if (customQuote == ' ') {
				sb.append(followCVSformat(value));
			} else {
				sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
			}

			first = false;
		}
		sb.append("\n");
		writer.append(sb.toString());

	}
	
	public void salva() {
		try {
			writer.flush();
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
