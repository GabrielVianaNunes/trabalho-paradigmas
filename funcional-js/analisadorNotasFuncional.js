// Versão funcional do Analisador de Notas em JavaScript (Node)

const main = () => {
  console.log("Versão funcional em JavaScript funcionando!");

  const notas = [7.5, 8.0, 6.0, 9.0];

  // Só como teste: média com reduce (estilo funcional)
  const soma = notas.reduce((acc, nota) => acc + nota, 0);
  const media = soma / notas.length;

  console.log("Notas:", notas);
  console.log("Média (teste):", media.toFixed(2));

  // Depois vamos:
  // - Implementar média, mediana, desvio padrão
  // - Classificação dos alunos usando map/filter/reduce
};

main();
