package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.GeneroPersona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private CiudadRepo ciudadRepo;
    /*
    registrar usuario
     */
    @Test
    public void registrarUsuarioTest(){
        //guardar un registro
        //primero se registra una ciudad
        Ciudad ciudad = new Ciudad("Armenia");
        ciudadRepo.save(ciudad);
        //luego se agregan las direcciones
        Map<String, String> direcciones = new HashMap<>();
        direcciones.put("casa", "mz 6 cs. 16 b/virginia");
        direcciones.put("oficina", "cra.23 #3-24");
        //ahora se agregan los telefonos
        List<String> telefonos = new ArrayList<>();
        telefonos.add("3226646612");
        telefonos.add("6067321789");
        Usuario usuarioPrueba = new Usuario("111","Juanito", LocalDate.now(),  "juan@mail.com", telefonos, direcciones );

        //Guardar el registro
        Usuario guardado = usuarioRepo.save(usuarioPrueba);
        //Comprobar que si haya quedado
        Assertions.assertNotNull(guardado);
    }
    /*
    eliminar usuario
     */
        @Test
        public void eliminarUsuarioTest(){
            //guardar un registro
            //primero se registra una ciudad
            Ciudad ciudad = new Ciudad("Armenia");
            ciudadRepo.save(ciudad);
            //luego se agregan las direcciones
            Map<String, String> direcciones = new HashMap<>();
            direcciones.put("casa", "mz 6 cs. 16 b/virginia");
            direcciones.put("oficina", "cra.23 #3-24");
            //ahora se agregan los telefonos
            List<String> telefonos = new ArrayList<>();
            telefonos.add("3226646612");
            telefonos.add("6067321789");
            Usuario usuarioPrueba = new Usuario("111","Juanito", LocalDate.now(),  "juan@mail.com", telefonos, direcciones);
            //Guardamos el registro
            usuarioRepo.save(usuarioPrueba);
           //Luego lo eliminamos
            usuarioRepo.delete(usuarioPrueba);
           //Por último, verificamos que si haya quedado borrado
            Usuario buscado = usuarioRepo.findById("111").orElse(null);
            Assertions.assertNull(buscado);
        }
    /*
    actualizar usuario
     */
        @Test
        public void actualizarUsuarioTest(){
            //guardar un registro
            //primero se registra una ciudad
            Ciudad ciudad = new Ciudad("Armenia");
            ciudadRepo.save(ciudad);
            //luego se agregan las direcciones
            Map<String, String> direcciones = new HashMap<>();
            direcciones.put("casa", "mz 6 cs. 16 b/virginia");
            direcciones.put("oficina", "cra.23 #3-24");
            //ahora se agregan los telefonos
            List<String> telefonos = new ArrayList<>();
            telefonos.add("3226646612");
            telefonos.add("6067321789");
            Usuario usuarioPrueba = new Usuario("111","Juanito", LocalDate.now(),  "juan@mail.com", telefonos, direcciones );
            //Guardamos el registro
            Usuario guardado = usuarioRepo.save(usuarioPrueba );
            //Modificamos el nombre
            guardado.setNombre("John Alejandro");
            //Con save guardamos el registro modificado
            usuarioRepo.save(guardado);
            //Por último, verificamos que si haya quedado actualizado
            Usuario buscado = usuarioRepo.findById("111").orElse(null);
            Assertions.assertEquals("John Alejandro", buscado.getNombre());
        }

    @Test
    @Sql("classpath:usuarios.sql" )
    public void listarUsuariosTest(){

        //Obtenemos la lista de todos los usuarios
        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        //Imprimimos la lista
        listaUsuarios.forEach(usuario -> System.out.println(usuario));
        Assertions.assertEquals(2, listaUsuarios.size());
    }

}
