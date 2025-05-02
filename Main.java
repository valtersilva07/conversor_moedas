//aprendizagens obtidas nos cursos da alura
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ConversorDeMoeda conversor = new ConversorDeMoeda();

        String[] moedas = {"USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "ARS", "NZD", "BRL"};

        String[] nomesMoedas = {
                "Dólar Americano",
                "Euro",
                "Iene Japonês",
                "Libras Esterlinas",
                "Dólar Australiano",
                "Dólar Canadense",
                "Franco Suíço",
                "Yuan Chinês",
                "Peso Argentino",
                "Dólar Neozelandês",
                "Real Brasileiro"
        };

        System.out.println("Conversor de Moedas Atualizado");
        System.out.println("-------------------");

        while (true) {
            System.out.println("\nnEscolha a moeda de ORIGEM pelo número correspondente:");
            for (int i = 0; i < moedas.length; i++) {
                System.out.printf("[%d] %s - %s\n", i, moedas[i], nomesMoedas[i]);
            }

            int indiceOrigem = entrada.nextInt();
            String moedaOrigem = moedas[indiceOrigem];

            System.out.println("\nEscolha uma nova moeda de destino:");
            for (int i = 0; i < moedas.length; i++) {
                System.out.printf("[%d] %s - %s\n", i, moedas[i], nomesMoedas[i]);
            }

            int indiceDestino = entrada.nextInt();
            String moedaDestino = moedas[indiceDestino];

            System.out.print("\nDigite um novo valor para converter: ");
            double valor = entrada.nextDouble();

            try {
                double resultado = conversor.converter(moedaOrigem, moedaDestino, valor);
                System.out.printf("\n%.2f %s (%s) = %.2f %s (%s)\n",
                        valor, moedaOrigem, nomesMoedas[indiceOrigem],
                        resultado, moedaDestino, nomesMoedas[indiceDestino]);
            } catch (Exception e) {
                System.out.println("Erro na conversão: " + e.getMessage());
            }

            System.out.print("\nDeseja fazer uma nova conversão? (s/n): ");
            String resposta = entrada.next();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }

        entrada.close();
        System.out.println("Programa encerrado.");
    }
}