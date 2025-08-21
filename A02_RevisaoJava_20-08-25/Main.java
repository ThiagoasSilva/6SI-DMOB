public class Main {
    public static void main(String[] args) {
        ContaCorrente minhaConta = new ContaCorrente();
        minhaConta.setSaldo(1000.0f);
        minhaConta.setChequeEspecial(500.0f);

        ContaCorrente contaDestino = new ContaCorrente();
        contaDestino.setSaldo(200.0f);
        contaDestino.setChequeEspecial(100.0f);
        
        System.out.println("Saldos Iniciais:");
        System.out.println("Minha Conta: R$" + minhaConta.getSaldo());
        System.out.println("Conta do Amigo: R$" + contaDestino.getSaldo());

        System.out.println("\n--- Realizando Transferência ---");
        
        try {
            float valorDaTransferencia = 300.0f;
            minhaConta.transferir(contaDestino, valorDaTransferencia);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
