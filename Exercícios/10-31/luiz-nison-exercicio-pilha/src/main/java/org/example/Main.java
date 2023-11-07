package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void gravaArquivoCsv(ListaObj<Animal> lista, String nomeArquivo) {
        FileWriter arq = null; // representa o arquivo que será gravado
        Formatter saida = null; // objeto de saída será usado para escrever no arquivo
        Boolean deuRuim = false;

        try {
            arq = new FileWriter(nomeArquivo + ".csv");
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo!");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Animal animal = lista.getElemento(i);
                saida.format("%d;%s;%d;%s;%s;%.2f;%.2f\n",
                        animal.getId(), animal.getNome(), animal.getIdade(), animal.getEspecie(),
                        animal.getSexo(), animal.getPeso(), animal.getAltura());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar arquivo!");
            deuRuim = true;

        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv(String nomeArquivo) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArquivo += ".csv";

        try {
            arq = new FileReader(nomeArquivo);
            entrada = new Scanner(arq).useDelimiter(";|\\n");

        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo inexistente!");
            System.exit(1);
        }

        try {
            System.out.printf("%-6s %-9s %-5s %-12s %-12s %-8s %-6s\n",
                    "CÓDIGO", "NOME", "IDADE", "ESPECIE", "SEXO", "PESO", "ALTURA");
            /*
             * hasNext() retorna "true" enquanto tem linha para ler do arquivo
             * quando ele encontra o fim de arquivo (EOF), o hasNext() retorna "false"
             * */

            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                Integer idade = entrada.nextInt();
                String especie = entrada.next();
                String sexo = entrada.next();
                Double peso = entrada.nextDouble();
                Double altura = entrada.nextDouble();

                System.out.printf("%06d %-9s %-5d %-12s %-12s %-8.2f %-6.2f\n",
                        id, nome, idade, especie, sexo, peso, altura);
            }
        } catch (NoSuchElementException erro) {
            System.out.printf("Arquivo com problemas!\n");
            erro.printStackTrace();
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.printf("Erro na leitura do arquivo!\n");
            erro.printStackTrace();
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar arquivo!");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    // métodos de TXT
    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
        }

        // Bloco try-catch para gravar o registro e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

    public static void gravaArquivoTxt(ListaObj<Animal> lista, String nomeArq) {
        int contaRegDadosGravados = 0;

        String header = "00ZOOLOGICO20232";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        gravaRegistro(header, nomeArq);

        for (int i = 0; i < lista.getTamanho(); i++) {
            Animal a = lista.getElemento(i);
            String corpo = "02";

            corpo += String.format("%-6.6s", a.getId());
            corpo += String.format("%-9.9s", a.getNome());
            corpo += String.format("%05d", a.getIdade());
            corpo += String.format("%-12.12s", a.getEspecie());
            corpo += String.format("%-12.12s", a.getSexo());
            corpo += String.format("%8.2f", a.getPeso());
            corpo += String.format("%6.2f", a.getAltura());

            gravaRegistro(corpo, nomeArq);

            contaRegDadosGravados++;
        }

        String trailer = "01";
        trailer += String.format("%010d", contaRegDadosGravados);

        gravaRegistro(trailer, nomeArq);
    }


    public static void lerArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, especie, sexo;
        Integer id, idade;
        Double peso, altura;
        int contaRegDadosLidos = 0;

        List<Animal> listaLida = new ArrayList<>();

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
        }

        try {
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("02")) {
                    id = Integer.parseInt(registro.substring(2, 8).trim());
                    nome = registro.substring(8, 17).trim();
                    idade = Integer.parseInt(registro.substring(17, 22));
                    especie = registro.substring(22, 34).trim();
                    sexo = registro.substring(34, 46).trim();
                    peso = Double.parseDouble(registro.substring(46, 54).replace(',', '.'));
                    altura = Double.parseDouble(registro.substring(54, 60).replace(',', '.'));

                    Animal a = new Animal(id, idade, nome, peso, especie, altura, sexo);
                    listaLida.add(a);

                    contaRegDadosLidos++;
                }

                registro = entrada.readLine();
            }

            entrada.close();

        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }

        System.out.println("\nLista lida:");
        for (Animal a : listaLida) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Integer opcao = 0;
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNl = new Scanner(System.in);
        ListaObj<Animal> animais = new ListaObj(5);

        System.out.println("|                  ZOOLÓGICO                  |");
        do {
            System.out.println("Escolha a opção desejada: (digite 1, 2 ou 3)");
            System.out.println("1 - Adicionar um animal");
            System.out.println("2 - Exibir lista de animais");
            System.out.println("3 - Gravar arquivo CSV");
            System.out.println("4 - Ler arquivo CSV");
            System.out.println("5 - Gravar arquivo TXT");
            System.out.println("6 - Ler arquivo TXT");
            System.out.println("7 - Sair");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o id do animal:");
                    int id = leitor.nextInt();

                    System.out.println("Digite o nome:");
                    String nome = leitorNl.nextLine();

                    System.out.println("Digite a idade:");
                    Integer idade = leitor.nextInt();

                    System.out.println("Digite o peso:");
                    Double peso = leitor.nextDouble();

                    System.out.println("Digite o especie:");
                    String especie = leitorNl.nextLine();

                    System.out.println("Digite o altura:");
                    Double altura = leitor.nextDouble();

                    System.out.println("Digite o sexo:");
                    String sexo = leitorNl.nextLine();

                    animais.adiciona(new Animal(id, idade, nome, peso, especie, altura, sexo));

                    System.out.println("Animal cadastrado!");
                    break;

                case 2:
                    System.out.println("");
                    System.out.printf("%-6s %-9s %-5s %-12s %-12s %-8s %-7s\n",
                            "CÓDIGO", "NOME", "IDADE", "SEXO", "ESPECIE", "PESO", "ALTURA");
                    for (int i = 0; i < animais.getTamanho(); i++) {
                        Animal p = animais.getElemento(i);
                        System.out.printf("%06d %-9s %-5d %-12s %-12s %-8.2f %-7.2f\n",
                                p.getId(), p.getNome(), p.getIdade(), p.getSexo(),
                                p.getEspecie(), p.getPeso(), p.getAltura());
                    }
                    System.out.printf("");
                    break;

                case 3:
                    if (animais.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há nada a gravar.");
                        break;
                    } else {
                        gravaArquivoCsv(animais, "zoologico");
                        break;
                    }
                case 4:
                    leExibeArquivoCsv("zoologico");
                    break;

                case 5:
                    gravaArquivoTxt(animais, "animais-zoologico");
                    break;

                case 6:
                    lerArquivoTxt("animais-zoologico");
                    break;

                case 7:
                    System.out.println("Obrigada por vir ao Zoológico e volte sempre.");
                    break;

                default:
                    System.out.println("Opção digitada inválida");
                    break;
            }
        } while (opcao != 5);

        Repositorio repositorio = new Repositorio();
        int opcao2 = 0;
        Scanner leitor2 = new Scanner(System.in);
        Scanner leitorNl2 = new Scanner(System.in);

        do {
            System.out.println("Escolha a opção desejada: (digite 1, 2, 3, 4 ou 5)");
            System.out.println("1 - Salvar objeto");
            System.out.println("2 - Deletar objeto");
            System.out.println("3 - Exibir");
            System.out.println("4 - Desfazer");
            System.out.println("5 - Fim");
            opcao2 = leitor2.nextInt();

            switch (opcao2) {
                case 1:
                    System.out.println("Digite o id do animal:");
                    int id = leitor2.nextInt();

                    System.out.println("Digite o nome:");
                    String nome = leitorNl2.nextLine();

                    System.out.println("Digite a idade:");
                    Integer idade = leitor2.nextInt();

                    System.out.println("Digite o peso:");
                    Double peso = leitor2.nextDouble();

                    System.out.println("Digite o especie:");
                    String especie = leitorNl2.nextLine();

                    System.out.println("Digite o altura:");
                    Double altura = leitor2.nextDouble();

                    System.out.println("Digite o sexo:");
                    String sexo = leitorNl2.nextLine();

                    repositorio.salvar(new Animal(id, idade, nome, peso, especie, altura, sexo));

                    System.out.println("Animal cadastrado!");
                    break;

                case 2:
                    System.out.println("Digite o id do animal a ser deletado:");
                    int id2 = leitor2.nextInt();

                    repositorio.deletar(id2);
                    break;

                case 3:
                    repositorio.exibir();
                    break;

                case 4:
                    repositorio.desfazer();
                    break;

                case 5:
                    System.out.println("Obrigada por vir ao Zoológico e volte sempre.");
                    break;

                default:
                    System.out.println("Opção digitada inválida");
                    break;
            }
        } while (opcao2 != 5);
    }
}