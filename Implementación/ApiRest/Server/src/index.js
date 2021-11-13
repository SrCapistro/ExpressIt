const express = require('express');
const morgan = require('morgan');

//iniciamos los elementos necesarios
const app = express();

//Configuraciones
app.set('port', process.env.PORT || 4000);

//Middlewares
app.use(morgan('dev'));
app.use(express.json());

// Variables globales


//Rutas

app.use('/auth', require('./routes/auth'));
app.use('/users', require('./routes/users'));
app.use('/feed', require('./routes/feed'));

//Public


//Iniciamos el servidor
app.listen(app.get('port'), () =>{
  console.log('Servidor escuchando en el puerto', app.get('port'))
});
