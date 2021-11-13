

//Aqui van las direcciones referentes a las entradas o "tuits"
const express = require('express');
const pool = require('../database');
const router = express.Router();

//Trae los twitts de los seguidores del usuario logeado
router.get('/entradas_seguidores/:idUsuario', (req, res) => {
    pool.query('select e.ent_idEntrada, e.ent_fechaEntrada, e.ent_textEntrada, s.sg_idSeguido, u.usr_nombreUsuario ' +
        'from Entrada e join Seguidor s on ent_idUsuario = sg_idSeguido and sg_idSeguidor = ? ' +
        'join Usuario u on u.usr_idUsuario = s.sg_idSeguido;' ,[req.params.idUsuario], (err, rows)=>{
        if(err) return res.send(err);
        res.json(rows);
    })
})

//Este metodo trae los twitts de un usuario en especial
router.get('/entradas/:idUsuario', (req, res)=>{
  pool.query('select e.ent_idEntrada, e.ent_fechaEntrada, e.ent_textEntrada, u.usr_nombreUsuario' +
    ' from Entrada e join Usuario u on u.usr_idUsuario = e.ent_idUsuario and e.ent_idUsuario =?;', [req.params.idUsuario], (err,rows) =>{
    if(err) return res.send(err)
    res.json(rows)
  })
})

//Cuenta los likes de los twitts
router.get('/entrada_likes/:idEntrada', (req, res) =>{
  pool.query('select COUNT(*) as likes from MeGusta where lk_idEntrada = ?;', [req.params.idEntrada],(err, rows) =>{
    if(err) return res.send(err);
    res.json(rows);
  })
})

//Obtiene los hashtags de un twits
router.get('/entrada_hashtags/:idEntrada', (req,res)=>{
  pool.query('select h.htg_nombre, h.htg_idHashtag from '+
  'EntradaHashtag eh join Hashtag h on h.htg_idHashtag = eh.eh_idHashtag '+
  'and eh.eh_idEntrada = ?;',[req.params.idEntrada],(err, rows)=>{
    if(err) return res.send(err);
    res.json(rows);
  })
})

//Verifica si un usuario ha dado like a una entrada
router.get('/entrada_likeusuario/:idEntrada/:idUsuario', (req,res)=>{
  pool.query('select * from MeGusta where lk_idEntrada = ? and lk_idUsuario = ?', [req.params.idEntrada, req.params.idUsuario], (err,rows) =>{
    if(err) return res.send(err)
    res.json(rows)
  })
})

//Registra un like cuando un usuario le da like a una entrada
router.post('/likear_entrada', (req, res)=>{
  pool.query('insert into MeGusta set ?', [req.body], (err, rows) =>{
    if(err) return res.send(err)
    res.send('Registro completado')
  })
})

//Elimina un like cuando un usuario elimina un like
router.delete('/entrada_borrarlike/:idEntrada/:idUsuario', (req, res) =>{
  pool.query('DELETE from MeGusta where lk_idEntrada = ? AND lk_idUsuario = ?;', [req.params.idEntrada, req.params.idUsuario], (err,rows)=>{
    if(err) return res.send(err)
    res.send('Elemento borrado')
  })
})


module.exports = router;
