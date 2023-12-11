package br.com.renanalencar

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado nesta formação.")
        }
    }

    fun desmatricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            inscritos.remove(usuario)
            println("Usuário ${usuario.nome} desmatriculado da formação $nome.")
        } else {
            println("Usuário ${usuario.nome} não estava matriculado nesta formação.")
        }
    }

    fun exibirInscritos() {
        println("Inscritos na formação $nome:")
        for (usuario in inscritos) {
            println("- ${usuario.nome}")
        }
    }
}

fun main() {
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin")
    val kotlinAvancado = ConteudoEducacional("Recursos Avançados em Kotlin", 90)
    val androidBasico = ConteudoEducacional("Desenvolvimento Android Básico")

    val formacaoKotlin = Formacao("Formação Kotlin", listOf(kotlinBasico, kotlinAvancado))
    val formacaoAndroid = Formacao("Formação Android", listOf(androidBasico))

    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario1) // Tentando matricular novamente o mesmo usuário

    formacaoKotlin.exibirInscritos()

    formacaoKotlin.desmatricular(usuario2)
    formacaoKotlin.exibirInscritos()

    formacaoAndroid.matricular(usuario1)
    formacaoAndroid.exibirInscritos()
}
