
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

module.exports = router;
