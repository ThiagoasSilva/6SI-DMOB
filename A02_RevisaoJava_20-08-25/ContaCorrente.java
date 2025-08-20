import java.util.Scanner;

public class ContaCorrente {
    private float saldo;
    private float chequeEspecial;

    Scanner sc = new Scanner(System.in);

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(float chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    /*
        public ContaCorrente(float saldo, float ChequeEspecial){
            this.saldo = saldo;
            this.chequeEspecial = chequeEspecial;
        }
        public float getSaldo(){
            return saldo;
        }
        public float getChequeEspecial(){
            return chequeEspecial;
        }
    */

    public void Menu(){
        System.out.println("\n============= MENU ==============");
        System.out.println("=== Selecione uma opção =========");
        System.out.println("=== 0 - Verificar Saldo   |======");
        System.out.println("=== 1 - Realizar Depósito |======");
        System.out.println("=== 2 - Realizar Saque    |======");
        System.out.println("=== 3 - Encerrar          |======");
        System.out.println("=================================");
        int opcao = sc.nextInt();
        switch (opcao){
            case 0:
                System.out.println("Opção: "+opcao);
                break;
            case 1:
                System.out.println("Opção: "+opcao);//solução para reaproveitamento já que todos os cases utilizam a mesmo lógica!!!
                break;
            case 2:
                System.out.println("Opção: "+opcao);
                break;
            case 3:
                System.out.println("Opção: "+opcao);
                break;
        }

    }
    public void Sacar() throws Exception{
        System.out.println("Insira um valor para sacar: ");
        float valor = sc.nextFloat();

        if (valor<=0) {
            throw new Exception("\n--- Operação Cancelada! valor zerado ou negativo \n--- Saldo: R$" + valor);
        } else if(valor > (saldo + chequeEspecial)){
            throw new Exception("\n--- Saldo Insuficiente! \n--- Saldo: R$" + (saldo + chequeEspecial));
        } else {
            saldo -= valor;
            System.out.println("\n--- Saque realizado com sucesso!\n ---Valor do saque: R$" + valor + "\n--- Saldo atual: R$" + saldo);
        }
    }
    public void Depositar() throws Exception{
        System.out.println("Insira um valor para depositar: ");
        float deposito = sc.nextFloat();

        if(deposito <= 0){
            throw new Exception("\n--- Depósito não realizado! Valor nulo ou negativo");
        } else {
            saldo+=deposito;
            System.out.println("\n--- Depósito realizado com sucesso! \n--- Valor depositado: R$"+deposito+" \n--- Saldo atual: R$ "+deposito);
        }
    }
    // CONSTRUIR UM MÉTODO PARA TRANSFERIR valores entrs contas
}
