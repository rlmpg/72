package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ContadorPalavras {
    
    private final BufferedReader reader;

    public ContadorPalavras(String arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo));
    }
    
    /**
     * Conta palavras. Este método não trata corretamente o caso de caracteres
     * acentuados.
     * @return O mapa de ocorrências de palavras encontradas no arquivo
     * @throws IOException Se ocorrer um erro na leitura do arquivo.
     */
    public HashMap<String, Integer> getPalavras() throws IOException {
        HashMap<String, Integer> contador = new HashMap<>();
        String linha;
        
        try {
            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.split("[\\W ]+");
                for (String p: palavras) {
                    Integer c = contador.get(p);
                    if (c == null) c = 0;
                    contador.put(p, ++c);
                }
            }
        } finally {
            reader.close();
        }
        return contador;
    }
    
}
