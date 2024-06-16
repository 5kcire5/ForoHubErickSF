package com.ErickHubForo.ForoErick.domain.topicos;

import com.ErickHubForo.ForoErick.domain.topicos.validaciones.ValidadorDeTopicos;
import com.ErickHubForo.ForoErick.domain.usuarios.UsuarioRepository;
import com.ErickHubForo.ForoErick.infras.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CrudTopicoServiceCrudTopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    List<ValidadorDeTopicos> validadores;
    /*
    @Autowired
    List<ValidadorCancelamientoDeConsulta> validadoresCancelamiento;
     */

    public DatosDetalleTopico crear(DatosCrearTopico datos){
        if(datos.idUsuario()!=null&&!usuarioRepository.existsById(datos.idUsuario())){
            throw new ValidacionDeIntegridad("Id de usuario no encontrado");
        }
        validadores.forEach(v->v.validar(datos));
        var usuario = usuarioRepository.findById(datos.idUsuario()).get();
        var topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.status(),
                usuario,
                datos.nombreCurso()
        );
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }


}