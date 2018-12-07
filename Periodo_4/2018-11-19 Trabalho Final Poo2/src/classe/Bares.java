package classe;

/**
 *
 * @author lucas
 */
public class Bares {
    private int id, capacidade = 1;
    private String nome, fantasias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
    	if(nome.trim().isEmpty())
    		throw new Exception("Nome deve ser Preenchido");
    	
        this.nome = nome.toUpperCase().trim();
    }

	public String getFantasias() {
		return fantasias;
	}

	public void setFantasias(String fantasias) {
		this.fantasias = fantasias;
	}
    
}
