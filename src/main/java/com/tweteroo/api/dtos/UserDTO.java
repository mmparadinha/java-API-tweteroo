package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(
    @NotBlank(message = "Usuário é obrigatório") String username,

    @NotBlank(message = "Avatar é obrigatório") @Pattern(regexp = "https?://", message = "Avatar deve ser uma URL") String avatar) {
}
