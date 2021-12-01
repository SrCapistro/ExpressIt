

//Aquí van las direcciones de autenticación
const express = require('express');
const pool = require('../database');
const router = express.Router();


//Metodo para obtener el login de un usuario
router.get('/login/:idUsuario/:idContra', (req, res) => {
  pool.query('select * from Usuario WHERE usr_nombreUsuario = ? AND usr_contraseña = ? AND usr_estatus = 1;', [req.params.idUsuario, req.params.idContra], (err, rows)=>{
      if(err) return res.send(err);
      res.json(rows);
  })
})


module.exports = router;
