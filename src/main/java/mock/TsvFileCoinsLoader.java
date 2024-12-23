package mock;

import interfaces.CoinsLoader;
import model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TsvFileCoinsLoader implements CoinsLoader {

    private final InputStream file;

    public TsvFileCoinsLoader(InputStream file) {
        this.file = file;
    }

    @Override
    public List<Currency> load() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file))) {
            return load(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo", e);
        }
    }

    private List<Currency> load(BufferedReader bufferedReader) throws IOException {
        List<Currency> result = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.add(toCurrency(line));
        }
        return result;
    }

    private Currency toCurrency(String line) {
        String[] split = line.split("\t");
        if (split.length < 2) {
            System.err.println("Línea mal formateada: " + line);
            return null;
        }
        String symbol = split[0];
        String description = split[1];
        String symbolRepresentation = (split.length > 2) ? split[2] : "";
        return new Currency(symbol, description, symbolRepresentation);
    }
}