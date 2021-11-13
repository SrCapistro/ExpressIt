

//Aquí van las direcciones de autenticación
const express = require('express');
const pool = require('../database');
const router = express.Router();


//Metodo para obtener el login de un usuario
router.post('/login', (req, res) => {
    pool.query('Select * from Usuario WHERE usr_nombreUsuario = ? AND usr_contraseña = ?',[req.body.nombreUsuario, req.body.contraseña], (err, rows)=>{
        if(err) return res.send(err);
        res.json(rows);
    })
})


module.exports = router;
