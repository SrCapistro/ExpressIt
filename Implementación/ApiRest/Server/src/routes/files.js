//Aquí van las direcciones de autenticación
const express = require('express');
const pool = require('../database');
const multer = require('multer')
const path = require('path');
const mimeTypes = require('mime-types')
const router = express.Router();

//Metodos para subir las fotos de perfil de los usuarios
const storagepp = multer.diskStorage({
  destination: './profile_pictures',
  filename: function(req, file, cb){
    var fileName = Date.now()+"."+mimeTypes.extension(file.mimetype)
    var idUsuario = req.params.idEntrada
    cb("", fileName);
    pool.query("INSERT into Archivo set arc_nombreArchivo = ?, arc_idUsuario = ?;",[fileName, idUsuario])
  }
})

const uploadpp = multer({
  storage: storagepp
})

router.get("/media/usuarios/:idUsuario", upload.single('archivo'),(req, res)=>{
  res.send("Listo")
})
//Metodos para subir un archivo a un servidor, registra contenido multimedia a las entradas
const storage = multer.diskStorage({
  destination: './media',
  filename: function(req, file, cb){
    var fileName = Date.now()+"."+mimeTypes.extension(file.mimetype)
    var idEntrada = req.params.idEntrada
    cb("", fileName);
    pool.query("INSERT into Archivo set arc_nombreArchivo = ?, arc_idEntrada = ?;",[fileName, idEntrada])
  }
})

const upload = multer({
  storage: storage
})

router.get("/media/entradas/:idEntrada", upload.single('archivo'),(req, res)=>{
  res.send("Listo")
})

//Obtener multimedia de entradas
router.get('/media/:idEntrada', (req, res)=>{
  pool.query("select arc_nombreArchivo from Archivo where arc_idEntrada = ?",[req.params.idEntrada], (err, rows) =>{
    if (err) return res.send(err)
    var nombreArchivo = JSON.parse(JSON.stringify(rows[0]))["arc_nombreArchivo"]
    res.sendFile(path.join("/home/josuecg/Documentos/Desarrollo red/ProyectoFinal/ExpressIt/Implementación/ApiRest/Server",
    "/profile_pictures/"+nombreArchivo))
  })

})

//Obtener fotos de perfil
router.get('/media/profile_pictures/:idUsuario', (req, res)=>{
  pool.query("select arc_nombreArchivo from Archivo where arc_idUsuario = ?",[req.params.idUsuario], (err, rows) =>{
    if (err) return res.send(err)
    var nombreArchivo = JSON.parse(JSON.stringify(rows[0]))["arc_nombreArchivo"]
    res.sendFile(path.join("/home/josuecg/Documentos/Desarrollo red/ProyectoFinal/ExpressIt/Implementación/ApiRest/Server",
    "/profile_pictures/"+nombreArchivo))
  })
})


module.exports = router;
