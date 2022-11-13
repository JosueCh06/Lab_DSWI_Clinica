package com.proyect.consorcio.service;
import java.util.List;

import com.proyect.consorcio.entity.Cliente;

public interface ClienteService {
	public void save(Cliente bean);
	public void update(Cliente bean);
	public void delete(int cod);
	public Cliente find (int cod);
	public List<Cliente> list();
}
