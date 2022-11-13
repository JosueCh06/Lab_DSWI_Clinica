package com.proyect.consorcio.dao;
import java.util.List;

import com.proyect.consorcio.entity.Cliente;

public interface ClienteDAO {
	public void save(Cliente bean);
	public void update(Cliente bean);
	public void delete(int cod);
	public Cliente find (int cod);
	public List<Cliente> list();
}
