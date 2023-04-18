package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
  @NotBlank(message = "Usuário é obrigatório") String username,

  @NotBlank(message = "Tweet é obrigatório") String tweet) {
}
