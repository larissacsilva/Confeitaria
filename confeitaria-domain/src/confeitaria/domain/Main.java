package confeitaria.domain;

import confeitaria.domain.dao.IFuncionarioDAO;
import confeitaria.domain.dao.list.FuncionarioDAOImpl;
import confeitaria.domain.entidades.Funcionario;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IFuncionarioDAO banco = new FuncionarioDAOImpl();
        Scanner t = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Consultar");
            System.out.println("5 - Sair");
            System.out.println("Digite a opção:");
            opcao = t.nextInt();
            
            switch(opcao){
                case 1:
                    System.out.println("Cadastrando.....");
                    Funcionario nova = new Funcionario();
                    System.out.println("Digite o nome:");
                    t.nextLine();
                    nova.setNome(t.nextLine());
                    try{
                        banco.cadastrar(nova);
                        System.out.println("Inserido com Sucesso!");
                    }catch(Exception erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Atualizando...");
                    System.out.println("Digite o ID:");
                    Funcionario c = new Funcionario();
                    c.setCpf(t.nextInt());
                    System.out.println("Digite o nome atualizado:");
                    c.setNome(t.next());
                    banco.alterar(c);
                    System.out.println("Atualizado com Sucesso!");
                    break;
                case 3:
                    System.out.println("Removendo...");
                    System.out.println("Digite o ID:");
                    banco.excluir(t.nextInt());
                    System.out.println("Removido com Sucesso!");
                    break;
                case 4:
                    System.out.println("Listando...");
                    for(Funcionario ent : banco.consultar()){
                        System.out.println(ent.getCpf() + " - " + ent.getNome());
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
            
        } while (opcao != 5);

    }

}
