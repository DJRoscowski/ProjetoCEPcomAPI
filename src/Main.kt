import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

//Ponto de partida (local de execução)
fun main() {

    //Exibe o testo entre as aspas
    print("Digite o CEP: ")
    //Variável que lê o readln e guarda o resultado
    val cepDigitado = readln()

    /* Variável que acessa a API do viaCEP com o "$cepDigitado" no meio.
    Esse $ pega o valor guardado na variável cepDigiado e bota alí naquele lugar do link,
    que por sua vez retorna um JSON com o dados do CEP. */
    val url = "https://viacep.com.br/ws/$cepDigitado/json/"

    /* Cria um cliente para fazer a comunicação com a internet, funcionando como um telefone.
    Você (programa) quer ligar pra alguém (API ViaCEP), mas precisa de um meio pra fazer isso,
    que seria um telefone (HttpClient) */
    val client = HttpClient.newHttpClient()

    /* O newBuilder é como um metodo de HttpRequest que serve pra montarmos uma nova requisição.
    Com ela vem os parâmetros que também temos de preencher para que tudo funcione corretamente */
    val request = HttpRequest.newBuilder()
        //Ela define o endereço de destino usando o texto guardado na val url
        .uri(URI.create(url))
        //Consulta informações da url destino
        .GET()
        //Finaliza a montagem da requisição, deixando-a pronta para ser enviada ao ViaCEP
        .build()

    /* A variável recebe o metodo send e seus parâmetros de client, logo, o response é o responsável por enviar a nossa
    requisição montada na val request e depois receber sua resposta também */
    val response = client.send(
        //É como dizer "Envie este pedido que preparei (val request) para consultar o CEP"
        request,
        //HttpResponse - representa a resposta HTTP que recebemos.
        //BodyHandlers - fornece maneiras de lidar com o conteúdo da resposta.
        //ofString() - escolhe receber o conteúdo como um texto (String).
        HttpResponse.BodyHandlers.ofString()
    )

    //Imprime na tela o response - guarda o objeto da resposta recebida do ViaCEP. e
    //.body() - pega o conteúdo principal dessa resposta, que, no nosso caso, é o texto com os dados do CEP.
    println(response.body())
}