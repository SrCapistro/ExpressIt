
//Aqui van las direcciones para manipular usuarios
const express = require('express');
const pool = require('../database');
const router = express.Router();

//Metodo prueba de registro de usuario
router.post('/signup', async (req, res) =>{
    const { usr_nombreUsuario, usr_contraseña, usr_nombre, usr_estatus} = req.body;
    const nuevoUsuario = {
        usr_nombreUsuario ,
        usr_contraseña,
        usr_nombre,
        usr_estatus
    };
    await pool.query('INSERT INTO Usuario set ?', [nuevoUsuario]);
    res.send('Recibido');
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

module.exports = router;
