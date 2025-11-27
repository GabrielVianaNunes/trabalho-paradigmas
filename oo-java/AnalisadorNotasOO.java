import java.util.Arrays;

public class AnalisadorNotasOO {

    public static void main(String[] args) {
        Aluno[] alunos = {
            new Aluno("Ana", 8.5),
            new Aluno("Bruno", 6.0),
            new Aluno("Carlos", 4.5),
            new Aluno("Daniela", 7.2),
            new Aluno("Eduardo", 5.8)
        };

        double[] notas = extrairNotas(alunos);

        double media = calcularMedia(notas);
        double mediana = calcularMediana(notas);
        double desvioPadrao = calcularDesvioPadrao(notas);

        System.out.println("=== Analisador de Notas (Versão Orientada a Objetos) ===");
        System.out.printf("Média: %.2f%n", media);
        System.out.printf("Mediana: %.2f%n", mediana);
        System.out.printf("Desvio padrão: %.2f%n", desvioPadrao);
        System.out.println();

        System.out.println("Situação dos alunos:");
        for (Aluno aluno : alunos) {
            String situacao = classificarAluno(aluno.getNota());
            System.out.printf("%s (%.1f) → %s%n",
                    aluno.getNome(), aluno.getNota(), situacao);
        }
    }

    private static double[] extrairNotas(Aluno[] alunos) {
        double[] notas = new double[alunos.length];
        for (int i = 0; i < alunos.length; i++) {
            notas[i] = alunos[i].getNota();
        }
        return notas;
    }

    public static double calcularMedia(double[] notas) {
        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public static double calcularMediana(double[] notas) {
        double[] copia = Arrays.copyOf(notas, notas.length);
        Arrays.sort(copia);

        int n = copia.length;
        if (n % 2 == 1) {
            return copia[n / 2];
        } else {
            double meio1 = copia[(n / 2) - 1];
            double meio2 = copia[n / 2];
            return (meio1 + meio2) / 2.0;
        }
    }

    public static double calcularDesvioPadrao(double[] notas) {
        double media = calcularMedia(notas);
        double somaQuadrados = 0.0;

        for (double nota : notas) {
            double diff = nota - media;
            somaQuadrados += diff * diff;
        }

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
