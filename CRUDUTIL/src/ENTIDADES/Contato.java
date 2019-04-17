package ENTIDADES;

import java.io.Serializable;

public class Contato implements Serializable {

	private static final long serialVersionUID = -515634448441981960L;
	private Long id;
	private String tipo;
	private String registro;
	private Integer pessoaid;

	public Contato() {
		super();
	}

	public Contato(Long id, String tipo, String registro, int pessoaid) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.registro = registro;
		this.pessoaid = pessoaid;
	}

	public Contato(String tipo, String registro, int pessoaid) {
		this.tipo = tipo;
		this.registro = registro;
		this.pessoaid = pessoaid;
	}

	public long getId() {
		return id;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Integer getPessoaid() {
		return pessoaid;
	}

	public void setPessoaid(Integer pessoaid) {
		this.pessoaid = pessoaid;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoaid != other.pessoaid)
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contato [id=");
		builder.append(id);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", registro=");
		builder.append(registro);
		builder.append(", pessoaid=");
		builder.append(pessoaid);
		builder.append("]");
		return builder.toString();
	}

}
