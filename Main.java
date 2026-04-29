import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);               

        menu(sc);

        sc.close();


    }

    public static int calcularSoma(ArrayList<Integer> numeros) {
        int soma = 0;

        for (int num : numeros) {
            soma += num;
        }

        return soma;
    }


    public static void adicionarNumeros(Scanner sc, ArrayList<Integer> numeros) {
    
    
    System.out.print("Quantos números você quer digitar?: ");
    int quantidade = lerInteiro(sc); 

    
    for (int i = 0; i < quantidade; i++ ) {
    System.out.print("digite um número: " );
    int numero = lerInteiro(sc); 
    numeros.add(numero);
    }
    } 


    public static void mostrarNumeros(ArrayList<Integer> numeros) {
    
    int tamanho = numeros.size();    

    for (int i = 0; i < tamanho; i++) {
        
        int num = numeros.get(i);
        
        String tipo = (num % 2 == 0) ? "Par" : "Ímpar";
        System.out.println("Posição " + i + ": " + num + " (" + tipo + ")");
        
        }
    }
    
    public static double calcularMedia(ArrayList<Integer> numeros) {
        if (numeros.isEmpty()) {
            return 0;
        }
        
        int soma = calcularSoma(numeros);
        return (double) soma / numeros.size();

    }

    public static int maiorNumero(ArrayList<Integer> numeros) {
        int maior = Integer.MIN_VALUE;
        
        
        for (int num : numeros) {
            if (num > maior) {
                maior = num;
            }
        }
        return maior;
    }

    public static int menorNumero(ArrayList<Integer> numeros) {
        int menor = Integer.MAX_VALUE;
        
        
        for (int num : numeros) {
            if (num < menor) {
                menor = num;
            }
        }
        return menor;
    }

    public static int contarPares(ArrayList<Integer> numeros) {
    int pares = 0;

    for (int num : numeros) {
        if (num % 2 == 0) {
            pares++;
        }
    }

    return pares;
    }

    public static int contarImpares(ArrayList<Integer> numeros) {
    int impares = 0;

    for (int num : numeros) {
        if (num % 2 != 0) {
            impares++;
        }
    }

    return impares;
    }   

    public static int lerInteiro(Scanner sc) {
        while (true) {
            String texto = sc.nextLine();

            try {
                int numero = Integer.parseInt(texto);
                return numero;
            } catch (NumberFormatException e) {
                System.out.print("Você não digitou um número inteiro! digite um número inteiro: ");
            }
        }
    }

    public static int lerOpcaoMenu(Scanner sc) {
        
        while (true) { 
            
        

        int opcaoVálida = lerInteiro(sc);
        if (opcaoVálida >= 1 && opcaoVálida <= 5) {
            return opcaoVálida;
            } else {
                System.out.print("Opção inválida, digite um número entre 1 e 5: ");
            }
        }
    }

    public static int lerOpcaoRemocao(Scanner sc) {
        while (true) { 
            
            int remocaoCerta = lerInteiro(sc);
            if (remocaoCerta >= 1 && remocaoCerta <= 3) {
                return remocaoCerta;
            } else {
                System.out.print("Opção inválida, digite um número entre 1 e 3: ");
            }

        }
    }

    public static boolean verificarListaVazia(ArrayList<Integer> numeros, String mensagem) {
        if (numeros.isEmpty()) {
            System.out.println(mensagem);
            return true;
        }
        return false;
        
    }

    public static void mostrarEstatisticas(ArrayList<Integer> numeros) {
        
        int soma = 0;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int pares = 0;
        int impares = 0;
        
        if (verificarListaVazia(numeros, "\nNão há números para calcular estatísticas.")) {
            return;
        }

        int quantidade = numeros.size();

        for (int num : numeros) {
            soma += num;
            if (num > maior) {
                maior = num;
            }
            if (num < menor) {
                menor = num;
            }
            if (num % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
            
        } 
        double media = (double) soma / quantidade;

        System.out.println("\n------ RESULTADOS ------");
            
        System.out.println("A soma dos números é igual a: " + soma);
        
        System.out.println("A média total foi de: " + media);
        
        System.out.println("O maior número foi: " + maior);
        
        System.out.println("O menor número foi: " + menor);

        System.out.println("O total de pares foi de: " + pares);

        System.out.println("O total de ímpares foi de: " + impares);

    }

    public static void menu (Scanner sc) {

    boolean rodando = true;

    ArrayList<Integer> numeros = new ArrayList<>();

    do { 

    System.out.println("\n=== MENU ===");

    System.out.println("Opção 1 - Inserir números");

    System.out.println("Opção 2 - Mostrar números");

    System.out.println("Opção 3 - Ver estatísticas");

    System.out.println("Opção 4 - Remover números");

    System.out.println("Opção 5 - Sair");

    System.out.print("Escolha uma opção: ");
    
    int opcao = lerOpcaoMenu(sc); 

    switch (opcao) {
        case 1:
            adicionarNumeros(sc, numeros);
            break;

        
        case 2:
            if (!verificarListaVazia(numeros, "\nNão há números para mostrar.")) {
            mostrarNumeros(numeros);
            }
            break;

        case 3: 
            mostrarEstatisticas(numeros);
            
            break;

            case 4:
                if (verificarListaVazia(numeros,"\nNão há números para remover.")) {
                    break;
                }
                
                boolean menuRemocao = true;

                while (menuRemocao) {
                System.out.println("\n=== MENU DE REMOÇÃO ===");
                System.out.println("1 - Remover um número");
                System.out.println("2 - Apagar todos os números");
                System.out.println("3 - Voltar pro menu principal");
                System.out.print("Escolha uma opção: ");

                int opcaoRemover = lerOpcaoRemocao(sc); 

                switch (opcaoRemover) {
                    case 1:
                    
                    System.out.println("\nLista Atual: ");
                    mostrarNumeros(numeros);

                    while (true) { 
                            
                        System.out.print("Escolha uma posição para remover (ou -1 para voltar): ");
                        int indice = lerInteiro(sc); 

                    if (indice == -1) {
                        break;
                    }    
                    else if (indice >= 0 && indice < numeros.size()) {
                        int removido = numeros.remove(indice);
                        System.out.println("\nNúmero removido: " + removido);
                        System.out.println("Lista atual:");
                        mostrarNumeros(numeros);
                        break;
                            } else {
                                System.out.println("Posição inválida. digite um número entre 0 até " + (numeros.size() -1) + ", ou -1 para sair!");
    
                            }
                    }
                    break;
                        case 2:
                            
                            System.out.print("Tem certeza que quer apagar? (s/n): ");
                            String certeza = sc.nextLine();
                        
                            if (certeza.equalsIgnoreCase("s")) {
                            numeros.clear();
                            System.out.println("\nLista apagada com sucesso!");
                            menuRemocao = false;
                            break;
                            }

                            else {
                                System.out.println("\nOperação cancelada, Nenhum número foi removido!");
                                break;
                            }

                        case 3:
                            menuRemocao = false;
                            break;
                        

                        default:
                            System.out.println("Opção inválida");
                            break;
                        }
                    }
                break;
            
            
            case 5:
                rodando = false;
                System.out.println("Programa encerrado!"); 
                break;

            default:
                System.out.println("Opção inválida!");
            

    
    } } while (rodando);
    

    }
}
    

