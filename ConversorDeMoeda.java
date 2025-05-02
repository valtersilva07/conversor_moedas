//aprendizagens obtidas nos cursos da alura
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoeda {

    public double converter(String origem, String destino, double valor) throws Exception {

        HttpClient cliente = HttpClient.newHttpClient();


        String url = String.format("https://v6.exchangerate-api.com/v6/bd2abd69e55aaf884e8898a4/latest/%s", origem, destino);




        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();


        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());



        JsonObject json = JsonParser.parseString(resposta.body()).getAsJsonObject();


        if (json.has("conversion_rates")) {
            JsonObject taxas = json.getAsJsonObject("conversion_rates");

            if (!taxas.has(destino)) {
                throw new Exception("Código de moeda de destino inválido.");
            }

            double taxa = taxas.get(destino).getAsDouble();
            double resultado = valor * taxa;

            return resultado;
        } else {
            throw new Exception("Erro ao obter as taxas de conversão.");
        }
    }
}
