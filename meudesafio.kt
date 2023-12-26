enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class ConteudoEducacional(val nome: String, val duracao: Int) {
    init {
        require(duracao == 30 || duracao == 45 || duracao == 60)
    }
}

class Usuario(val nome: String)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println()
        println("${usuario.nome} matriculado na formação $nome")
        println()
    }

    fun listarInscritos() {
        println()
        println("usuários matriculados na formação $nome")
        for (usuario in inscritos) {
            println("-- ${usuario.nome} --")
        }
    }

}

fun main() {
    val usuario1 = Usuario("Victor")
    val usuario2 = Usuario("Elise")

    val conteudo1 = ConteudoEducacional("Análise de Dados", 60)
    val conteudo2 = ConteudoEducacional("Unity", 45)
    val conteudo3 = ConteudoEducacional("Python", 30)
    val conteudo4 = ConteudoEducacional("C++", 30)

    val formacao1 = Formacao("Analista de Dados", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo3))
    val formacao2 = Formacao("Unity Developer", Nivel.AVANCADO, listOf(conteudo2, conteudo4))

    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)

    formacao1.listarInscritos()
    formacao2.listarInscritos()
}