
public class ContaCorrente {
    private float saldo;
    private float chequeEspecial;
    private float deposito;
    private float saque;
    private float transferencia;
    
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

    public void Sacar() throws Exception {
        if (saque <= 0) {
            throw new Exception("\n--- Operação Cancelada! valor zerado ou negativo \n--- Saldo: R$" + saque);
        } else if (saque > (saldo + chequeEspecial)) {
            throw new Exception("\n--- Saldo Insuficiente! \n--- Saldo: R$" + (saldo + chequeEspecial));
        } else {
            saldo -= saque;
            System.out.println("\n--- Saque realizado com sucesso!\n ---Valor do saque: R$" + saque
                    + "\n--- Saldo atual: R$" + saldo);
        }
    }

    public void Depositar() throws Exception {
        if (deposito <= 0) {
            throw new Exception("\n--- Depósito não realizado! Valor nulo ou negativo");
        } else {
            saldo += deposito;
            System.out.println("\n--- Depósito realizado com sucesso! \n--- Valor depositado: R$" + deposito
                    + " \n--- Saldo atual: R$ " + saldo);
        }
    }

    public void MostrarSaldo() {
        System.out.println("\n--- Saldo Atual: R$" + saldo);
    }
    
    public void Tranferir() throws Exception {
        if(transferencia <= 0) {
            throw new Exception("\n--- Transferência não realizada! Valor nulo ou negativo");
        } else if (transferencia > (saldo + chequeEspecial)) {
            throw new Exception("\n--- Saldo Insuficiente para transferência! \n--- Saldo: R$" + (saldo + chequeEspecial));
        } else {
            saldo -= transferencia;
            System.out.println("\n--- Transferência realizada com sucesso! \n--- Valor transferido: R$" + transferencia
                    + " \n--- Saldo atual: R$ " + saldo);
        }
    }
    
    public void transferir(ContaCorrente contaDestino, float valor) throws Exception {
        if(valor <= 0) {
            throw new Exception("\n--- Transferência não realizada! Valor nulo ou negativo.");
        } else if (valor > (this.saldo + this.chequeEspecial)) {
            throw new Exception("\n--- Saldo Insuficiente para transferência! \n--- Saldo disponível: R$" + (this.saldo + this.chequeEspecial));
        } else {
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("\n--- Transferência realizada com sucesso! ---");
            System.out.println("--- Valor transferido: R$" + valor);
            System.out.println("--- Saldo atual da sua conta: R$" + this.saldo);
            System.out.println("--- Saldo atual da conta de destino: R$" + contaDestino.saldo);
        }
    }
}
