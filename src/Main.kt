import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

//Ponto de partida (local de execução)
fun main() {

    //Exibe o testo entre as aspas
    print("Digite o CEP: ")
    //Variavel que lê o readln e guarda o resultado
    val cepDigitado = readln()

    /* Variavel que acessa a API do viaCEP com o "$cepDigitado" no meio.
    Esse $ pega o valor guardado na variável cepDigiado e bota alí naquele lugar do link,
    que por sua vez retorna um JSON com o dados do CEP. */
    val url = "https://viacep.com.br/ws/$cepDigitado/json/"

    /* Cria um cliente para fazer a comunicação com a internet, funcionando como um telefone.
    Você (programa) quer ligar pra alguém (API ViaCEP), mas precisa de um meio pra fazer isso,
    que seria um telefone (HttpClient)*/
    val client = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build()

    val response = client.send(
        request,
        HttpResponse.BodyHandlers.ofString()
    )

    println(response.body())
}