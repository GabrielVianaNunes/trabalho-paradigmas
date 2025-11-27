// Versão funcional do Analisador de Notas em JavaScript (Node)

const alunos = [
  { nome: "Ana", nota: 8.5 },
  { nome: "Bruno", nota: 6.0 },
  { nome: "Carlos", nota: 4.5 },
  { nome: "Daniela", nota: 7.2 },
  { nome: "Eduardo", nota: 5.8 }
];

const obterNotas = (alunos) => alunos.map((aluno) => aluno.nota);

const calcularMedia = (notas) =>
  notas.reduce((acc, nota) => acc + nota, 0) / notas.length;

const calcularMediana = (notas) => {
  const ordenadas = [...notas].sort((a, b) => a - b);
  const n = ordenadas.length;
  const meio = Math.floor(n / 2);

  if (n % 2 === 1) {
    return ordenadas[meio];
  } else {
    return (ordenadas[meio - 1] + ordenadas[meio]) / 2;
  }
};

const calcularDesvioPadrao = (notas) => {
  const media = calcularMedia(notas);
  const variancia =
    notas
      .map((nota) => Math.pow(nota - media, 2))
      .reduce((acc, v) => acc + v, 0) / notas.length;

  return Math.sqrt(variancia);
};

const classificarAluno = (nota) => {
  if (nota >= 7.0) return "aprovado";
  if (nota >= 5.0) return "recuperação";
  return "reprovado";
};

const main = () => {
  const notas = obterNotas(alunos);

  const media = calcularMedia(notas);
  const mediana = calcularMediana(notas);
  const desvioPadrao = calcularDesvioPadrao(notas);

  console.log("=== Analisador de Notas (Versão Funcional em JavaScript) ===");
  console.log(`Média: ${media.toFixed(2)}`);
  console.log(`Mediana: ${mediana.toFixed(2)}`);
  console.log(`Desvio padrão: ${desvioPadrao.toFixed(2)}`);
  console.log();

  console.log("Situação dos alunos:");
  alunos
    .map((aluno) => ({
      ...aluno,
      situacao: classificarAluno(aluno.nota),
    }))
    .forEach((aluno) => {
      console.log(`${aluno.nome} (${aluno.nota.toFixed(1)}) → ${aluno.situacao}`);
    });
};

main();
