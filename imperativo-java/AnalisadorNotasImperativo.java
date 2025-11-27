import java.util.Arrays;

public class AnalisadorNotasImperativo {

    public static void main(String[] args) {
        // Mesmo conjunto de alunos que usaremos nas outras versões
        String[] nomes = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo"};
        double[] notas = {8.5, 6.0, 4.5, 7.2, 5.8};

        double media = calcularMedia(notas);
        double mediana = calcularMediana(notas);
        double desvioPadrao = calcularDesvioPadrao(notas);

        System.out.println("=== Analisador de Notas (Versão Imperativa) ===");
        System.out.printf("Média: %.2f%n", media);
        System.out.printf("Mediana: %.2f%n", mediana);
        System.out.printf("Desvio padrão: %.2f%n", desvioPadrao);
        System.out.println();

        System.out.println("Situação dos alunos:");
        for (int i = 0; i < notas.length; i++) {
            String situacao = classificarAluno(notas[i]);
            System.out.printf("%s (%.1f) → %s%n", nomes[i], notas[i], situacao);
        }
    }

    public static double calcularMedia(double[] notas) {
        double soma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        return soma / notas.length;
    }

    public static double calcularMediana(double[] notas) {
        double[] copia = Arrays.copyOf(notas, notas.length);
        Arrays.sort(copia);

        int n = copia.length;
        if (n % 2 == 1) {
            // n ímpar → valor do meio
            return copia[n / 2];
        } else {
            // n par → média dos dois valores centrais
            double meio1 = copia[(n / 2) - 1];
            double meio2 = copia[n / 2];
            return (meio1 + meio2) / 2.0;
        }
    }

    public static double calcularDesvioPadrao(double[] notas) {
        double media = calcularMedia(notas);
        double somaQuadrados = 0.0;

        for (int i = 0; i < notas.length; i++) {
            double diff = notas[i] - media;
            somaQuadrados += diff * diff;
        }

        // Desvio padrão populacional
        double variancia = somaQuadrados / notas.length;
        return Math.sqrt(variancia);
    }

    public static String classificarAluno(double nota) {
        if (nota >= 7.0) {
            return "aprovado";
        } else if (nota >= 5.0) {
            return "recuperação";
        } else {
            return "reprovado";
        }
    }
}
