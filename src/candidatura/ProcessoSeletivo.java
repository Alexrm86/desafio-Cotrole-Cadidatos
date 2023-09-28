package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    // selecaoCandidatos();
    // imprimirSelecionados();
    String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };

    for (String candidato : candidatos) {
      entrandoEmContato(candidato);
    }

  }

  public static void entrandoEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;

    do {

      atendeu = atender();
      continuarTentando = !atendeu;
      if (continuarTentando)
        tentativasRealizadas++;
      else
        System.out.println("Contato realizado com sucesso!");

    } while (continuarTentando && tentativasRealizadas < 3);
    if (atendeu) {
      System.out.println(
          "O candidato " + candidato + " atendeu na " + tentativasRealizadas + " tentativa realizada.");
    } else {
      System.out.println("Não conseguimos contato com  " + candidato + " na " + tentativasRealizadas
          + " tentativas realizadas.");

    }
  }

  public static boolean atender() {
    return new Random().nextInt(3) == 1;
  }

  public static void imprimirSelecionados() {
    String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };

    for (String candidato : candidatos) {
      System.out.println("O candidato " + candidato + " foi selecionado.");
    }

  }

  public static void selecaoCandidatos() {
    String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA",
        "DANIELA", "JORGE" };

    int candidatosSelecionados = 0;
    int candidatoAtual = 0;
    double salarioBase = 2000.0;

    while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {

      String candidato = candidatos[candidatoAtual];
      double salarioPretendido = valorPretendido();

      System.out.println("O candidato " + candidato + " solicitou este valor de salário R$ " + salarioPretendido);
      if (salarioBase >= salarioPretendido) {
        System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
        candidatosSelecionados++;
      }
      candidatoAtual++;

    }

  }

  public static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void analizarCandidatos(double salarioPretendido) {
    double salarioBase = 2000.0;
    if (salarioBase > salarioPretendido) {
      System.out.println("LIGAR PARA O CANDIDATO");

    } else if (salarioBase == salarioPretendido) {
      System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");

    } else {
      System.out.println("AGUARDANDO OS RESULTADOS DOS DEMAIS CANDIDATOS");
    }
  }
}