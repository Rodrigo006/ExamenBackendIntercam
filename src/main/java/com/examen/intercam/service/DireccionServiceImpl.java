package com.examen.intercam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.intercam.dao.DireccionEntity;
import com.examen.intercam.repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionRepository repositorio;

	@Override
	public DireccionEntity guardarDireccion(DireccionEntity direccion) {
		return repositorio.save(direccion);
	}

	@Override
	public DireccionEntity modificarDireccion(DireccionEntity direccionModificada) {
		return repositorio.save(direccionModificada);
	}

	@Override
	public Optional<DireccionEntity> consultaDireccion(int idDireccion) {
		return repositorio.findById(idDireccion);
	}

	@Override
	public List<DireccionEntity> consultarDirecciones() {
		return repositorio.findAll();
	}

	@Override
	public boolean elimarDireccion(int idDireccion) {
		try {
			repositorio.deleteById(idDireccion);
			return true;
		} catch (Exception e) {
			return false;
		}
	}	
}
