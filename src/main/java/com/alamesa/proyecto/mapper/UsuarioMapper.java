package com.alamesa.proyecto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.alamesa.proyecto.dto.usuario.UsuarioRequestDto;
import com.alamesa.proyecto.dto.usuario.UsuarioResponseDto;
import com.alamesa.proyecto.entity.Usuario;

@Mapper(componentModel="spring")
public interface UsuarioMapper {

	public UsuarioResponseDto mapToUsuarioDto(Usuario usuario);

	public List<UsuarioResponseDto> mapToUsuarioDto(List<Usuario> usuarios);
	
	public Usuario mapUsuarioRequestDtoToUsuario(UsuarioRequestDto usuarioDto);
	
	public Usuario mapToUsuario(Long id, UsuarioRequestDto usuarioDto);
	
	public UsuarioResponseDto mapUsuarioRequestDtoToUsuarioResponseDto(UsuarioRequestDto usuarioDto);
}
