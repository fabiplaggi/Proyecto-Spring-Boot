-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2022 a las 21:21:31
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bocachovet`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `indumentaria`
--

CREATE TABLE `indumentaria` (
  `id` bigint(20) NOT NULL,
  `Producto` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `Talle` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `Precio` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `Stock` varchar(10) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `indumentaria`
--

INSERT INTO `indumentaria` (`id`, `Producto`, `Talle`, `Precio`, `Stock`) VALUES
(1, 'Campera Presentación Boca Jrs', 'M - XL', '$17.999', '2'),
(2, 'Camiseta Alternativa Boca Jrs 22/23', 'S - M', '$9.500', '3'),
(3, 'Camiseta Titular Boca Jrs 22/23', 'XL - L - M', '$11.000', '5'),
(4, 'Short Alternativo Boca Jrs 21/22', 'XS - L', '$6.000', '2'),
(5, 'Tercera Camiseta Boca Jrs 22/23', 'L - M - XL', '$9.500', '4'),
(6, 'Medias Alternativas Boca Jrs 22/23', 'M', '$1.750', '4'),
(7, 'Short Alternativo Boca Jrs 22/23', 'S - XS', '$6.000', '2'),
(8, 'Camiseta Arquero Boca Jrs 22/23', 'S', '$10.000', '1'),
(9, 'Short Arquero Boca Jrs 22/23', 'L', '$6.000', '2'),
(10, 'Cuarta Camiseta Boca Jrs 20/21', 'M', '$7.500', '1'),
(11, 'Buzo Entrenamiento Boca Jrs', 'L - XL - M', '$12.000', '3'),
(12, 'Camiseta Entrenamiento Boca Jrs', 'L - M', '$6.000', '2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `indumentaria`
--
ALTER TABLE `indumentaria`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `indumentaria`
--
ALTER TABLE `indumentaria`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
