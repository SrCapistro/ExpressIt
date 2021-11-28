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
    var idUsuario = req.params.idUsuario
    cb("", fileName);
    pool.query("INSERT into Archivo set arc_nombreArchivo = ?, arc_idUsuario = ?;",[fileName, idUsuario])
  }
})

const uploadpp = multer({
  storage: storagepp
})

router.get("/media/usuarios/:idUsuario", uploadpp.single('archivo'),(req, res)=>{
  res.send("Listo")
})

//Obtener fotos de perfil
router.get("/media/profile_pictures/:idUsuario", (req, res)=>{
  pool.query("select arc_nombreArchivo from Archivo where arc_idUsuario = ?", [req.params.idUsuario], (err, rows) =>{
    if (err) return res.send(err)
    var nombreArchivo = JSON.parse(JSON.stringify(rows[0]))["arc_nombreArchivo"]
    res.sendFile(path.join("/home/josuecg/Documentos/Desarrollo red/ProyectoFinal/ExpressIt/Implementación/ApiRest/Server",
    "/profile_pictures/"+nombreArchivo))
  })
})

//Obtener foto de perfil por nombreDeUsuario
router.get("/media/pictures/:nombreUsuario", (req, res)=>{
  pool.query("select a.arc_nombreArchivo from Archivo a where arc_idUsuario = (select u.usr_idUsuario from Usuario u where u.usr_nombreUsuario = ?);", [req.params.nombreUsuario], (err, rows) =>{
    if (err) return res.send(err)
    try{
      var nombreArchivo = JSON.parse(JSON.stringify(rows[0]))["arc_nombreArchivo"]
      res.sendFile(path.join("/home/josuecg/Documentos/Desarrollo red/ProyectoFinal/ExpressIt/Implementación/ApiRest/Server",
      "/profile_pictures/"+nombreArchivo))
    }catch(error){
      res.sendFile(path.join("/home/josuecg/Documentos/Desarrollo red/ProyectoFinal/ExpressIt/Implementación/ApiRest/Server",
      "/profile_pictures/default_foto.jpg"))
    }
  })
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

router.post("/media/entradas/:idEntrada", upload.single('archivo'),(req, res)=>{
  res.send("Listo")
})

//Obtener multimedia de entradas
router.get('/media/:idEntrada', (req, res)=>{
  pool.query("select arc_nombreArchivo from Archivo where arc_idEntrada = ?",[req.params.idEntrada], (err, rows) =>{
    if (err) return res.send(err)
  try{
    var nombreArchivo = JSON.parse(JSON.stringify(rows[0]))["arc_nombreArchivo"]
      res.sendFile(path.join("/home/josuecg/Documentos/Desarrollo red/ProyectoFinal/ExpressIt/Implementación/ApiRest/Server",
        "/media/"+nombreArchivo))
  }catch(error){
    res.send(error)
  }
  })
})

//El usuario tiene foto
router.get('/media/existeFoto/:idEntrada', (req, res)=>{
  pool.query("select count(arc_idArchivo) as numeroFoto from Archivo where arc_idUsuario = ?",[req.params.idEntrada], (err, rows) =>{
    if (err) return res.send(err)
  try{
    var cantidadArchivo = rows[0];
      res.send(cantidadArchivo)
  }catch(error){
    res.send(error)
  }
  })
})


module.exports = router;
