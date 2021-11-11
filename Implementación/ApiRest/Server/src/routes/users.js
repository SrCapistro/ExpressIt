const express = require('express');
const pool = require('../database');
const router = express.Router();


router.get('/login', (req, res) => {
    pool.query("SELECT * FROM Usuario we")
})

router.post('/login', async (req, res) =>{
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

