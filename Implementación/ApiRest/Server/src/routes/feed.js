

//Aqui van las direcciones referentes a las entradas o "tuits"
const express = require('express');
const pool = require('../database');
const router = express.Router();

router.get('/entradas_seguidores/:idUsuario', (req, res) => {
  console.log(req.params.idUsuario)
    pool.query('select e.ent_idEntrada, e.ent_fechaEntrada, e.ent_textEntrada, s.sg_idSeguido, u.usr_nombreUsuario ' +
        'from Entrada e join Seguidor s on ent_idUsuario = sg_idSeguido and sg_idSeguidor = ? ' +
        'join Usuario u on u.usr_idUsuario = s.sg_idSeguido;' ,[req.params.idUsuario], (err, rows)=>{
        if(err) return res.send(err);
        res.json(rows);
    })
})

router.get('/entrada_likes/:idEntrada', (req, res) =>{
  pool.query('select COUNT(*) as likes from MeGusta where lk_idEntrada = ?;', [req.params.idEntrada],(err, rows) =>{
    if(err) return res.send(err);
    res.json(rows);
  })
})

router.get('/entrada_hashtags/:idEntrada', (req,res)=>{
  pool.query('select h.htg_nombre, h.htg_idHashtag from '+
  'EntradaHashtag eh join Hashtag h on h.htg_idHashtag = eh.eh_idHashtag '+
  'and eh.eh_idEntrada = ?;',[req.params.idEntrada],(err, rows)=>{
    if(err) return res.send(err);
    res.json(rows);
  })
})

module.exports = router;
