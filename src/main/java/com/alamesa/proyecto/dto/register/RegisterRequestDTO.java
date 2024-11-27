package com.alamesa.proyecto.dto.register;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequestDTO {
	
	@NotBlank(message = "El nombre de usuario no puede estar vacío")
	private String username;

	@NotBlank(message = "La contraseña no puede estar vacía")
	private String password;

	@NotBlank(message = "El correo electrónico no puede estar vacío")
	@Email(message = "El correo electrónico debe tener un formato válido")
	private String correo;

	private String nombre;
	
	private int telefono;

}
