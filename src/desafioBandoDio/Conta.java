package desafioBandoDio;

public abstract class Conta implements InterfaceConta {

	protected int agencia;
	protected int numConta;
	protected double saldo;
	private Cliente cliente;
	
	private static final int AGENCIA_PADRAO = 1;
	
	private static int SEQUENCIAL = 1;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numConta = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumConta() {
		return numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	protected void imprimirInfoConta() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numConta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	//ver extrato?
	
	
}
