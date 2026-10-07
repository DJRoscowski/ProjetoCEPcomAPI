import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

//Ponto de partida (local de execução)
fun main() {

    //Exibe o testo entre as aspas
    print("Digite o CEP: ")
    //Variavel que lê o readln e guarda o resultado
    val cep = readln()

    //Variavel que
    val url = "https://viacep.com.br/ws/$cep/json/"


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