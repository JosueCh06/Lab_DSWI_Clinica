package com.proyect.consorcio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.consorcio.dao.ClienteDAO;
import com.proyect.consorcio.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public void save(Cliente bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int cod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente find(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> list() {
		// TODO Auto-generated method stub
		return clienteDAO.list();
	}

}
