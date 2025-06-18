package com.example.PedidoService;

public record Pedido(String id, ProductoDTO producto, int cantidad) {}