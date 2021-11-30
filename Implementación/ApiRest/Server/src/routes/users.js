
//Aqui van las direcciones para manipular usuarios
const express = require('express');
const pool = require('../database');
const router = express.Router();

//Metodo prueba de registro de usuario
router.post('/signup', async (req, res) =>{
    const { usr_nombreUsuario, usr_contraseña, usr_nombre, usr_correo, usr_fechaNacimiento, usr_descripcion, usr_estatus, usr_tipoUsuario} = req.body;
    const nuevoUsuario = {
        usr_nombreUsuario ,
        usr_contraseña,
        usr_nombre,
        usr_correo,
        usr_fechaNacimiento,
        usr_descripcion,
        usr_estatus,
        usr_tipoUsuario
    };
    await pool.query('INSERT INTO Usuario set ?', [nuevoUsuario]);
    res.send('Usuario registrado correctamente');
})

router.get('/',(req, res) =>{
  res.send("Conexión éxitosa")
})


//registrar nuevo usuario
router.post('/registrar_nuevo_usuario', (req, res)=>{
  var nombreUsuario = req.body.usr_nombreUsuario
  var descripcion = req.body.usr_descripcion
  var estatus = req.body.usr_estatus
  var nombreCompleto = req.body.usr_nombre
  var correo = req.body.usr_correo
  var tipoUsuario = req.body.usr_tipoUsuario
  var contra = req.body.usr_contraseña
  var nacimiento = req.body.usr_fechaNacimiento

  pool.query('INSERT INTO Usuario set usr_nombreUsuario = ?, usr_descripcion = ?, usr_estatus = ?, usr_nombre = ?,'
  + ' usr_correo = ?, usr_tipoUsuario = ?, usr_contraseña = ?, usr_fechaNacimiento = ?;',
  [nombreUsuario, descripcion, estatus, nombreCompleto, correo, tipoUsuario, contra, nacimiento], (err, rows)=>{
    if(err) return res.send(err.message)
    res.send("Registro exitoso")
  })
})


//Metodo para saber si un nombre usuario ya se encuentra registrado
router.get('/obtener_Usuarios/:nombreUsuario', (req, res) => {
  var nombreUsuario = req.params.nombreUsuario
  pool.query('SELECT usr_nombreUsuario FROM usuario WHERE usr_nombreUsuario = ?;', [nombreUsuario], (err, rows)=>{
      if(err) return res.send(err);
      res.json(rows);
  })
})

router.get('/:nombreUsuario', async (req, res)=>{
  var nombreUsuario = req.params.nombreUsuario
  pool.query('select u.usr_idUsuario, u.usr_nombreUsuario, u.usr_descripcion, u.usr_nombre, u.usr_fechaNacimiento,' +
  '(SELECT COUNT(*) from Entrada e where e.ent_idUsuario = u.usr_idUsuario) as entradasTotales, ' +
  '(SELECT COUNT(s.sg_idSeguidor) from Seguidor s where s.sg_idSeguido = u.usr_idUsuario) as seguidores from Usuario u '+
  ' where u.usr_nombreUsuario = ?;', [nombreUsuario],(err,rows)=>{
    if(err) return res.send(err)
    res.json(rows)
  })
})

//obtener el id del seguidor de un usuario especifico
router.get('/obtener_seguidor/:idSeguido/:idSeguidor', (req, res)=>{
  pool.query('SELECT sg_idSeguidor from Seguidor WHERE sg_idSeguido = ? and sg_idSeguidor =?;', [req.params.idSeguido, req.params.idSeguidor], (err,rows)=>{
    if(err) return res.send(err)
    res.json(rows)
    console.log("Hola: ", rows)
    console.log("HSeguido: ", req.params.idSeguido)
    console.log("Seguidor: ", req.params.idSeguidor)
  })
})

//seguir
router.post('/seguir', (req, res)=>{
  var idSeguidor = req.body.sg_idSeguidor
  var idSeguido = req.body.sg_idSeguido
  console.log("hola", req.body)
  pool.query('INSERT INTO Seguidor set sg_idSeguidor = ?, sg_idSeguido = ?;', [idSeguidor, idSeguido], (err, rows)=>{
    if(err) return res.send(err.message)
    res.send("Registro exitoso")
  })
})

//dejar de seguir
router.delete('/dejar_seguir/:idSeguidor/:idSeguido', (req, res) =>{
  pool.query('DELETE from Seguidor WHERE sg_idSeguidor = ? AND sg_idSeguido = ?;', [req.params.idSeguidor, req.params.idSeguido], (err,rows)=>{
    if(err) return res.send(err)
    res.send('Elemento borrado')
    console.log("Seguidos", req.params)
  })
})

//Datos de un unico usuario
router.get('/datos/usuario/:idUsuario', async (req, res)=>{
  var idUsuario = req.params.idUsuario
  pool.query('SELECT * FROM Usuario where usr_idUsuario = ?;', [idUsuario],(err,rows)=>{
    if(err) return res.send(err)
    res.json(rows)
  })
})

//actualizar datos de usuario
router.post('/actualizarUsuario', (req, res)=>{
  var idUsuario = req.body.usr_idUsuario
  var nombreUsuario = req.body.usr_nombreUsuario
  var descripcion = req.body.usr_descripcion
  var nombreCompleto = req.body.usr_nombre
  var correo = req.body.usr_correo
  var contra = req.body.usr_contraseña
  var nacimiento = req.body.usr_fechaNacimiento

  pool.query('UPDATE Usuario SET usr_nombreUsuario = ?, usr_descripcion = ?, usr_nombre = ?, usr_correo =?, usr_contraseña = ?, usr_fechaNacimiento = ? WHERE usr_idUsuario = ?;',
  [nombreUsuario, descripcion, nombreCompleto, correo, contra, nacimiento, idUsuario], (err, rows)=>{
    if(err) return res.send(err.message)
    res.send("Actualizacion exitoso")
  })
})

//Verificar que la actualizacion del usuario no exista
router.get('/obtenerUsuario/:idUsuario/:nombreUsuario', (req, res) => {
  pool.query('SELECT COUNT(usr_idUsuario) AS cantidad FROM Usuario WHERE usr_nombreUsuario = ? AND usr_idUsuario != ?;', [req.params.nombreUsuario, req.params.idUsuario], (err, rows)=>{
    if (err) return res.send(err)
    try{
      var cantidadArchivo = rows[0];
        res.send(cantidadArchivo)
    }catch(error){
      res.send(error)
    }
  })
})

//Se elimina la foto de perfil del usuario que se va a modificar
router.delete('/eliminarFotoPerfil/:idUsuario', (req, res)=>{
  pool.query('DELETE FROM Archivo WHERE arc_idUsuario = ?;', [req.params.idUsuario], (err, rows)=>{
    if(err) return res.send(err.message)
    res.json({"respuesta":200})
  })
})

// Se actualiza el estatus del usuario de uno a cero
router.post('/DarDeBajaUsuario', (req, res)=>{
  var idUsuario = req.body.usr_idUsuario
  var estatus = req.body.usr_estado

  pool.query('UPDATE Usuario SET  usr_estatus = ? WHERE usr_idUsuario = ?;', [estatus, idUsuario], (err, rows)=>{
    if(err) return res.send(err.message)
    res.send("Dada de baja")
  })
})

//Datos especificos de los usuarios
router.get('/datos/todos', async (req, res)=>{
  var idUsuario = req.params.idUsuario
  pool.query('SELECT usr_idUsuario, usr_nombreUsuario, usr_nombre, usr_tipoUsuario FROM Usuario ;', [idUsuario],(err,rows)=>{
    if(err) return res.send(err)
    res.json(rows)
  })
})

module.exports = router;
