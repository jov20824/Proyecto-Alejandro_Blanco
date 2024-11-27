package com.alamesa.proyecto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamesa.proyecto.dto.usuario.UsuarioRequestDto;
import com.alamesa.proyecto.dto.usuario.UsuarioResponseDto;
import com.alamesa.proyecto.entity.Usuario;
import com.alamesa.proyecto.mapper.UsuarioMapper;
import com.alamesa.proyecto.repository.ClienteRepository;
import com.alamesa.proyecto.repository.UsuarioRepository;
import com.alamesa.proyecto.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioMapper usuarioMapper;

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public UsuarioResponseDto findById(Long id) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

		if (usuarioOptional.isEmpty()) {
			log.error("No existe un usuario con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un usuario con ese id");
		}
		return usuarioMapper.mapToUsuarioDto(usuarioOptional.get());
	}

	@Override
	public List<UsuarioResponseDto> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarioMapper.mapToUsuarioDto(usuarios);
	}
	
	@Override
	public List<UsuarioResponseDto> findByClienteIsNull() {
		List<Usuario> usuarios = usuarioRepository.findByClienteIsNull();
		return usuarioMapper.mapToUsuarioDto(usuarios);
	}

	@Override
	public UsuarioResponseDto add(UsuarioRequestDto dto) {
		usuarioRepository.save(usuarioMapper.mapUsuarioRequestDtoToUsuario(dto));
		return usuarioMapper.mapUsuarioRequestDtoToUsuarioResponseDto(dto);
	}

	@Override
	public UsuarioResponseDto update(Long id, UsuarioRequestDto dto) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioMapper.mapToUsuario(id, dto);

			usuarioRepository.save(usuario);

			return usuarioMapper.mapUsuarioRequestDtoToUsuarioResponseDto(dto);
		}
		log.error("No existe un usuario con ese id, id: " + id);
		throw new IllegalArgumentException("No existe un usuario con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!usuarioRepository.findById(id).isPresent()) {
			log.error("No existe un usuario con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un usuario con ese id");
		}
		clienteRepository.deleteById(clienteRepository.findByUsuarioId(id).getId());
		
	}
}
