package com.ciandt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Item")
public class Item {
	
	@Id
	@GeneratedValue(generator="sqlite_item")
	@TableGenerator(name="sqlite_item", table="item_sequence",
	    pkColumnName="item", valueColumnName="seq",
	    pkColumnValue="bigint",
	    initialValue=1, allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@NotEmpty
	@Column(name="etiqueta", length=30)
	private String etiqueta;
	
	@NotEmpty
	@Column(name="descricao", length=30)
	private String descricao;
	
	@Column(name="dataaquisicao")
	private String dataAquisicao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
