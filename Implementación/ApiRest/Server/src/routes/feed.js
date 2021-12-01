

//Aqui van las direcciones referentes a las entradas o "tuits"
const express = require('express');
const pool = require('../database');
const router = express.Router();

//Trae los twitts de los seguidores del usuario logeado
router.get('/entradas_seguidores/:idUsuario/:idEntrada', (req, res) => {
    pool.query('select e.ent_idEntrada, e.ent_fechaEntrada, e.ent_textEntrada, s.sg_idSeguido, ' +
        '(SELECT COUNT(*) from MeGusta mg where mg.lk_idEntrada = e.ent_idEntrada) as likes_totales, ' +
        '(select lk_idUsuario from MeGusta mg2 where mg2.lk_idEntrada = e.ent_idEntrada and lk_idUsuario = ?) as tuLike, u.usr_nombreUsuario ' +
        'from Entrada e join Seguidor s on e.ent_idUsuario = s.sg_idSeguido and s.sg_idSeguidor = ?'+
        'join Usuario u on u.usr_idUsuario = s.sg_idSeguido and e.ent_idEntrada < ? order by e.ent_idEntrada desc limit 6;' ,[req.params.idUsuario, req.params.idUsuario, req.params.idEntrada], (err, rows)=>{
        if(err) return res.send(err);
        res.json(rows);
    })
})

//Este metodo trae los twitts de un usuario en especial
router.get('/entradas/:nombreUsuario/:idUsuario', (req, res)=>{
  pool.query('select e.ent_idEntrada, e.ent_idUsuario, e.ent_fechaEntrada, e.ent_textEntrada, u.usr_nombreUsuario, '+
  '(SELECT COUNT(*) from MeGusta mg where mg.lk_idEntrada = e.ent_idEntrada) as likes_totales, ' +
  '(select lk_idUsuario from MeGusta mg2 where mg2.lk_idEntrada = e.ent_idEntrada and lk_idUsuario = ?) as tuLike '+
  'from Entrada e join Usuario u on u.usr_idUsuario = e.ent_idUsuario and u.usr_nombreUsuario = ? ORDER BY e.ent_fechaEntrada asc limit 6;', [req.params.idUsuario, req.params.nombreUsuario], (err,rows) =>{
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
  pool.query('select * from MeGusta where lk_idEntrada = ? and lk_idUsuario = ?;', [req.params.idEntrada, req.params.idUsuario], (err,rows) =>{
    if(err) return res.send(err)
    res.json(rows)
  })
})

//Registra un like cuando un usuario le da like a una entrada
router.post('/likear_entrada', (req, res)=>{
  pool.query('insert into MeGusta set ?;', [req.body], (err, rows) =>{
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

//registra una entrada
router.post('/registrar_entrada', (req, res)=>{
  var idUsuario = req.body.ent_idUsuario
  var EntradaContenido = req.body.ent_textEntrada
  console.log("hola", EntradaContenido)
  pool.query('INSERT INTO Entrada set ent_idUsuario = ?, ent_fechaEntrada = (select CURRENT_TIMESTAMP()), ent_textEntrada = ?;', [idUsuario, EntradaContenido], (err, rows)=>{
    if(err) return res.send(err.message)
    res.send("Registro exitoso")
  })
})

//obtener id de la última entrada registrada
router.get('/obtenerId_ultimaEntrada', (req, res)=>{
  pool.query('SELECT MAX(ent_idEntrada) as ent_idEntrada FROM Entrada;', (err,rows)=>{
    if(err) return res.send(err)
    res.json(rows)
  })
})

//obtener id del ultimo hashtag registrado
router.get('/obtenerId_ultimoHashtag', (req, res)=>{
  pool.query('SELECT MAX(htg_idHashtag) as idHashtag FROM Hashtag;', (err,rows)=>{
    if(err) return res.send(err)
    res.json(rows)
    console.log("Hola: ", rows)
  })
})

//registrar HashTag
router.post('/registrar_hashtag', (req, res)=>{
  var hashtag = req.body.htg_nombre
  console.log("HashTag:", hashtag)
  pool.query('INSERT INTO Hashtag set htg_nombre = ?;', [hashtag], (err, rows)=>{
    if(err) return console.log(err.message)
    res.send("Registro exitoso")
  })
})

//obtener los ID de los hashtag recién registrados
router.get('/obtenerId_hashtags/:idHashtag', (req, res)=>{
  pool.query('SELECT htg_idHashtag as idHashtag FROM Hashtag WHERE htg_idHashtag > ?;', [req.params.idHashtag], (err,rows)=>{
    if(err) return res.send(err)
    res.json(rows)
    console.log("Hola: ", rows)
  })
})

//asociar hashtags con entrada
router.post('/asociar_hashtags', (req, res)=>{
  var idHashtag = req.body.eh_idHashtag
  var idEntrada = req.body.eh_idEntrada
  console.log("hola", req.body.eh_idHashtag)
  pool.query('INSERT INTO EntradaHashtag set eh_idHashtag = ?, eh_idEntrada = ?;', [idHashtag, idEntrada], (err, rows)=>{
    if(err) return res.send(err.message)
    res.send("Registro exitoso")
  })
})

//Obtener un hashtag
router.post('/hashtag/', (req, res) =>{
  pool.query('select h.htg_idHashtag, h.htg_nombre from Hashtag h where h.htg_nombre = "?";', [req.body.htg_nombre], (err, rows)=>{
    if(err) return res.send(req.body.htg_nombre)
    res.json(rows)
  })
})


router.get('/hashtags/:idEntrada', (req, res)=>{
  pool.query('select h.htg_nombre from Hashtag h join EntradaHashtag eh '+
  'on eh.eh_idHashtag = h.htg_idHashtag and eh.eh_idEntrada = ?;', [req.params.idEntrada], (err, rows)=>{
    if(err) return res.send(err.message)
    res.json(rows)
  })
})
//eliminar entrada
router.delete('/borrarEntrada_moderador/:idEntrada', (req, res) =>{
  pool.query('DELETE from Entrada WHERE ent_idEntrada = ?;', [req.params.idEntrada], (err,rows)=>{
    if(err) return res.send(err)
    res.send('Entrada eliminada borrado')
    console.log("id entrada borrar:", req.params.idEntrada)
  })
})

//obtener los ID de los hashtag asociados con la entrada eliminada
router.get('/obtenerId_hashtags_entradaBorrada/:idEntrada', (req, res)=>{
  pool.query('SELECT eh_idHashtag as idHashtag FROM EntradaHashtag WHERE eh_idEntrada = ?;', [req.params.idEntrada], (err,rows)=>{
    if(err) return res.send(err)
    res.json(rows)
    console.log("Hola id hashtags: ", rows)
  })
})

//des asociar entradas con hashtags
router.delete('/desAsociarEntrada_moderador/:idEntrada', (req, res) =>{
  pool.query('DELETE from EntradaHashtag WHERE eh_idEntrada = ?;', [req.params.idEntrada], (err,rows)=>{
    if(err) return res.send(err)
    res.send('Entrada eliminada borrado')
    console.log("id entrada desasociar:", req.params.idEntrada)
  })
})

// borrar hashtags asociados con la entrada eliminada
router.delete('/borrarHashtag_moderador/:idHashtag', (req, res) =>{
  pool.query('DELETE from Hashtag WHERE htg_idHashtag = ?;', [req.params.idHashtag], (err,rows)=>{
    if(err) return res.send(err)
    res.send('hashtag borrado')
    console.log("id hashtag a borrar:", req.params.idHashtag)
  })
})

router.get('/busqueda/hashtag/:nombreHashtag', (req, res) =>{
  var hashtagRecibid = '#' + req.params.nombreHashtag
  console.log(hashtagRecibid)
  pool.query('SELECT H.htg_idHashtag, H.htg_nombre, E.ent_idEntrada, E.ent_fechaEntrada, E.ent_textEntrada, E.ent_idUsuario, U.usr_nombreUsuario, ' +
             ' (SELECT COUNT(ME.lk_idEntrada) FROM MeGusta AS ME WHERE ME.lk_idEntrada = E.ent_idEntrada) AS lk_cantidad,' +
             '(SELECT lk_idUsuario FROM MeGusta mg2 WHERE mg2.lk_idEntrada = E.ent_idEntrada AND lk_idUsuario = U.usr_idUsuario) AS tu_Like' +
             ' FROM Hashtag AS H ' +
             ' LEFT JOIN EntradaHashtag AS EH on H.htg_idHashtag = EH.eh_idHashtag ' +
             ' LEFT JOIN Entrada AS E ON  EH.eh_idEntrada = E.ent_idEntrada '+
             ' LEFT JOIN Usuario AS U ON E.ent_idUsuario = U.usr_idUsuario  '+
             ' WHERE LOWER(H.htg_nombre) = LOWER(?);', [hashtagRecibid], (err, rows)=>{
    if(err) return res.send(err.message)
    res.json(rows)
  })
})

module.exports = router;
