import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;


/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica72 {
    private static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.print("Arquivo a ser processado: ");
        String path = scn.next();
        
        ContadorPalavras ct = new ContadorPalavras(path);
        HashMap<String, Integer> palavras = ct.getPalavras();
        Map.Entry<String, Integer>[] entries = palavras.entrySet().toArray(new Map.Entry[0]);
        Arrays.sort(entries, (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e2.getValue() - e1.getValue());
        
        try (FileWriter fw = new FileWriter(path + ".out");
             BufferedWriter writer = new BufferedWriter(fw)) {
            for (Map.Entry<String, Integer> entry: entries) {
                writer.write(String.format("%s,%d%n", entry.getKey(), entry.getValue()));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado: " + ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println("Erro de escrita: " + ex.getLocalizedMessage());
        }
    }
    
}
