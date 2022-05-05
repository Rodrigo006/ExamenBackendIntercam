package com.examen.intercam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.intercam.dao.CuentaEntity;
import com.examen.intercam.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	private CuentaRepository repositorio;

	@Override
	public CuentaEntity guardarCuenta(CuentaEntity cuenta) {
		return repositorio.save(cuenta);
	}

	@Override
	public CuentaEntity modificarCuenta(CuentaEntity cuentaModificada) {
		return repositorio.save(cuentaModificada);
	}

	@Override
	public Optional<CuentaEntity> consultaCuenta(int idCuenta) {
		return repositorio.findById(idCuenta);
	}

	@Override
	public List<CuentaEntity> consultarCuentas() {
		return repositorio.findAll();
	}

	@Override
	public boolean elimarCuenta(int idCuenta) {
		try {
			repositorio.deleteById(idCuenta);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
