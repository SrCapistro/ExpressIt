
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

module.exports = router;
