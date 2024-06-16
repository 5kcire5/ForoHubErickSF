package com.ErickHubForo.ForoErick.domain.topicos;

import java.time.LocalDateTime;

public record DatosRespuestasTopico(
        Long id,
        String titulo,
        String mensaje,
        Estado status,
        String autorx,
        String nombreCurso,
        LocalDateTime fecha
) {
}
