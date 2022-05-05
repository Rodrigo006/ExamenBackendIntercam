package com.examen.intercam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.intercam.dao.UsuarioEntity;
import com.examen.intercam.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repositorio;

	@Override
	public UsuarioEntity guardarUsuario(UsuarioEntity usuario) {
		return repositorio.save(usuario);
	}

	@Override
	public UsuarioEntity modificarUsuario (UsuarioEntity usuarioModificado) {
		return repositorio.save(usuarioModificado);
	}

	@Override
	public Optional<UsuarioEntity> consultaUsuario(int idUsuario) {
		return repositorio.findById(idUsuario);
	}

	@Override
	public List<UsuarioEntity> consultarUsuarios() {
		return repositorio.findAll();
	}

	@Override
	public boolean elimarUsuario(int idUsuario) {
		try {
			repositorio.deleteById(idUsuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}	
}
