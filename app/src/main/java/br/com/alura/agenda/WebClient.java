package br.com.alura.agenda;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebClient {
    public String  post(String json)  {
        try {
            URL url = new URL("https://www.caelum.com.br/mobile");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //para avisar o tipo de conteúdo que o método está enviando
            connection.setRequestProperty("Content-type","application/json");

            //para avisar o tipo de conteúdo que a aplicação deseja como retorno
            connection.setRequestProperty("Accept","application/json");

            //o valor true representa que queremos realizar um post
            connection.setDoOutput(true);

            //para escrever a requisição para o servidor
            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println(json);

            //para de fato, conectar ao servidor e enviar os dados
            connection.connect();

            //para realizar a leitura dos dados vindos do servidor
            Scanner scanner = new Scanner(connection.getInputStream());
            String resposta = scanner.next();

            return resposta; //retorno dos dados do servidor


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; //caso algo dê errado
    }
}
