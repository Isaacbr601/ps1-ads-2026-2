package br.edu.fatecfranca.api.dtos;

public record UserRequest(
    String name,
    String email,
    String password
) {}