package com.ErickHubForo.ForoErick.domain.topicos;

public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        String nombreCurso
) {
}
