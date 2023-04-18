package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
    @NotBlank(message = "Usuário é obrigatório") String username,

    @NotBlank(message = "Avatar é obrigatório") String avatar) {
}
