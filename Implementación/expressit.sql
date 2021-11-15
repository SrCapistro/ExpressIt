-- phpMyAdmin SQL Dump
-- version 5.0.4deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 15-11-2021 a las 00:07:16
-- Versión del servidor: 10.5.12-MariaDB-0+deb11u1
-- Versión de PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `expressit`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Archivo`
--

CREATE TABLE `Archivo` (
  `arc_idArchivo` bigint(20) NOT NULL,
  `arc_nombreArchivo` varchar(200) NOT NULL,
  `arc_ruta` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Entrada`
--

CREATE TABLE `Entrada` (
  `ent_idEntrada` bigint(20) NOT NULL,
  `ent_idUsuario` bigint(20) NOT NULL,
  `ent_fechaEntrada` datetime NOT NULL,
  `ent_textEntrada` varchar(280) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Entrada`
--

INSERT INTO `Entrada` (`ent_idEntrada`, `ent_idUsuario`, `ent_fechaEntrada`, `ent_textEntrada`) VALUES
(1, 1, '2021-11-11 17:17:08', 'Hola a todos'),
(2, 2, '2021-11-11 17:17:40', 'Hace hambre el dia de hoy'),
(3, 3, '2021-11-11 17:17:58', 'Vamos a reprobar desarrollo red :c'),
(4, 1, '2021-11-11 18:38:02', 'Saquen las gomichelas'),
(5, 4, '2021-11-11 18:38:39', 'Saquen las gomichelas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `EntradaHashtag`
--

CREATE TABLE `EntradaHashtag` (
  `eh_idEntrada` bigint(20) NOT NULL,
  `eh_idHashtag` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `EntradaHashtag`
--

INSERT INTO `EntradaHashtag` (`eh_idEntrada`, `eh_idHashtag`) VALUES
(1, 1),
(1, 2),
(1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Hashtag`
--

CREATE TABLE `Hashtag` (
  `htg_nombre` varchar(100) NOT NULL,
  `htg_idHashtag` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Hashtag`
--

INSERT INTO `Hashtag` (`htg_nombre`, `htg_idHashtag`) VALUES
('#FEnElChat', 1),
('#TengoHambre', 2),
('#NoSeProgramar', 3),
('#MejorMeHagoTaquero', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MeGusta`
--

CREATE TABLE `MeGusta` (
  `lk_idEntrada` bigint(20) NOT NULL,
  `lk_idUsuario` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Seguidor`
--

CREATE TABLE `Seguidor` (
  `sg_idSeguidor` bigint(20) NOT NULL,
  `sg_idSeguido` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Seguidor`
--

INSERT INTO `Seguidor` (`sg_idSeguidor`, `sg_idSeguido`) VALUES
(2, 1),
(3, 1),
(4, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE `Usuario` (
  `usr_idUsuario` bigint(20) NOT NULL,
  `usr_nombreUsuario` varchar(100) NOT NULL,
  `usr_descripcion` varchar(100) DEFAULT NULL,
  `usr_estatus` tinyint(1) NOT NULL,
  `usr_nombre` varchar(100) DEFAULT NULL,
  `usr_correo` varchar(100) DEFAULT NULL,
  `usr_tipoUsuario` varchar(100) DEFAULT NULL,
  `usr_contraseña` varchar(100) NOT NULL,
  `usr_fechaNacimiento` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`usr_idUsuario`, `usr_nombreUsuario`, `usr_descripcion`, `usr_estatus`, `usr_nombre`, `usr_correo`, `usr_tipoUsuario`, `usr_contraseña`, `usr_fechaNacimiento`) VALUES
(1, 'capi', 'Hola soy capi', 1, 'Josue Capistran García', 'josuecapistran@gmail.com', '\"Comun\"', '1234', NULL),
(2, 'josuecapistran', NULL, 1, 'Josue Capistran', NULL, '\"Comun\"', '1234', NULL),
(3, 'juanito', 'Me llamo juanito', 1, 'Juanito Bananas Bananitas', 'juanito123@gmail.com', '\"Comun\"', '3333', '23/10/2000'),
(4, 'dianaFer', 'Luz y sol', 1, 'Diana Fernanda Sanchez', 'sanfer@hotmail.com', '\"Comun\"', '4321', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Archivo`
--
ALTER TABLE `Archivo`
  ADD PRIMARY KEY (`arc_idArchivo`);

--
-- Indices de la tabla `Entrada`
--
ALTER TABLE `Entrada`
  ADD PRIMARY KEY (`ent_idEntrada`),
  ADD KEY `Entrada_FK` (`ent_idUsuario`);

--
-- Indices de la tabla `EntradaHashtag`
--
ALTER TABLE `EntradaHashtag`
  ADD KEY `EntradaHashtag_FK` (`eh_idEntrada`),
  ADD KEY `EntradaHashtag_FK_1` (`eh_idHashtag`);

--
-- Indices de la tabla `Hashtag`
--
ALTER TABLE `Hashtag`
  ADD PRIMARY KEY (`htg_idHashtag`);

--
-- Indices de la tabla `MeGusta`
--
ALTER TABLE `MeGusta`
  ADD KEY `Like_FK` (`lk_idUsuario`),
  ADD KEY `Like_FK_1` (`lk_idEntrada`);

--
-- Indices de la tabla `Seguidor`
--
ALTER TABLE `Seguidor`
  ADD KEY `Seguidor_FK` (`sg_idSeguidor`),
  ADD KEY `Seguidor_FK_1` (`sg_idSeguido`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`usr_idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Archivo`
--
ALTER TABLE `Archivo`
  MODIFY `arc_idArchivo` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Entrada`
--
ALTER TABLE `Entrada`
  MODIFY `ent_idEntrada` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `usr_idUsuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Entrada`
--
ALTER TABLE `Entrada`
  ADD CONSTRAINT `Entrada_FK` FOREIGN KEY (`ent_idUsuario`) REFERENCES `Usuario` (`usr_idUsuario`);

--
-- Filtros para la tabla `EntradaHashtag`
--
ALTER TABLE `EntradaHashtag`
  ADD CONSTRAINT `EntradaHashtag_FK` FOREIGN KEY (`eh_idEntrada`) REFERENCES `Entrada` (`ent_idEntrada`),
  ADD CONSTRAINT `EntradaHashtag_FK_1` FOREIGN KEY (`eh_idHashtag`) REFERENCES `Hashtag` (`htg_idHashtag`);

--
-- Filtros para la tabla `MeGusta`
--
ALTER TABLE `MeGusta`
  ADD CONSTRAINT `Like_FK` FOREIGN KEY (`lk_idUsuario`) REFERENCES `Usuario` (`usr_idUsuario`),
  ADD CONSTRAINT `Like_FK_1` FOREIGN KEY (`lk_idEntrada`) REFERENCES `Entrada` (`ent_idEntrada`);

--
-- Filtros para la tabla `Seguidor`
--
ALTER TABLE `Seguidor`
  ADD CONSTRAINT `Seguidor_FK` FOREIGN KEY (`sg_idSeguidor`) REFERENCES `Usuario` (`usr_idUsuario`),
  ADD CONSTRAINT `Seguidor_FK_1` FOREIGN KEY (`sg_idSeguido`) REFERENCES `Usuario` (`usr_idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
