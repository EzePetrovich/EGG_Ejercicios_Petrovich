USE nba;

# 1) 

SELECT jugador.nombre
FROM nba.jugador
ORDER BY jugador.nombre ASC;

# 2)

SELECT jugador.nombre
FROM nba.jugador
WHERE jugador.posicion = 'C' AND jugador.peso > 200
ORDER BY jugador.nombre ASC;

# 3)

SELECT equipo.nombre
FROM nba.equipo
ORDER BY equipo.nombre ASC;

# 4) 

SELECT equipo.nombre
FROM nba.equipo
WHERE equipo.conferencia = 'East'
ORDER BY equipo.nombre ASC;

# 5)

SELECT *
FROM nba.equipo
WHERE equipo.ciudad LIKE 'C%'
ORDER BY equipo.nombre ASC;

# 6)

SELECT jugador.*, equipo.ciudad, equipo.conferencia, equipo.division
FROM nba.jugador 
INNER JOIN nba.equipo ON equipo.nombre = jugador.nombre_equipo
ORDER BY equipo.nombre ASC;

# 7)

SELECT *
FROM nba.jugador
WHERE jugador.nombre_equipo = 'Raptors'
ORDER BY jugador.nombre ASC;

# 8) 

SELECT jugador.nombre AS `Nombre jugador`, estadistica.Puntos_por_partido AS `Puntos por partido` 
FROM nba.estadistica
INNER JOIN nba.jugador ON estadistica.jugador = jugador.codigo
WHERE jugador.nombre = 'Pau Gasol';

# 9)

SELECT jugador.nombre AS `Nombre jugador`, estadistica.Puntos_por_partido AS `Puntos por partido` 
FROM nba.estadistica
INNER JOIN nba.jugador ON estadistica.jugador = jugador.codigo
WHERE jugador.nombre = 'Pau Gasol' AND estadistica.temporada = '04/05';

# 10)

SELECT jugador.*, SUM(estadistica.Puntos_por_partido) AS `Puntos totales en carrera`
FROM nba.jugador
INNER JOIN nba.estadistica ON  estadistica.jugador = jugador.codigo
GROUP BY estadistica.jugador
ORDER BY jugador.nombre_equipo ASC, `Puntos totales en carrera` ASC;

# 11)

SELECT equipo.*, COUNT(jugador.codigo) AS `Número de jugadores`
FROM nba.equipo
INNER JOIN nba.jugador ON equipo.nombre = jugador.nombre_equipo
GROUP BY equipo.nombre
ORDER BY equipo.nombre ASC;

# 12)

SELECT jugador.*, SUM(estadistica.Puntos_por_partido) AS `Puntos totales en carrera`
FROM nba.jugador
INNER JOIN nba.estadistica ON  estadistica.jugador = jugador.codigo
GROUP BY estadistica.jugador
ORDER BY `Puntos totales en carrera` DESC
LIMIT 1;

# 13)

SELECT equipo.nombre AS `Nombre equipo`, equipo.conferencia AS `Conferencia`, equipo.division AS `División`
FROM nba.equipo 
INNER JOIN nba.jugador ON equipo.nombre = jugador.nombre_equipo
WHERE jugador.altura = (
	SELECT jugador.altura
    FROM nba.jugador
    ORDER BY jugador.altura DESC
    LIMIT 1
);

# 14) 

SELECT equipo.nombre AS `Nombre del equipo`, AVG(partido.puntos_local) AS `Media de puntos de local`, AVG(partido.puntos_visitante) AS `Media de puntos de visitante`
FROM nba.equipo
INNER JOIN nba.partido ON equipo.nombre = partido.equipo_local OR equipo.nombre = partido.equipo_visitante
WHERE equipo.division = 'Pacific'
GROUP BY equipo.nombre
ORDER BY equipo_local ASC;

# 15)

SELECT codigo, equipo_local AS `Equipo local`, equipo_visitante AS `Equipo visitante`, ABS(puntos_local - puntos_visitante) AS `Diferencia`
FROM nba.partido
ORDER BY Diferencia DESC;

# 16) IDEM 14)

# 17)

SELECT equipo.nombre AS `Nombre del equipo`, SUM(partido.puntos_local) AS `Puntos de local total`, SUM(partido.puntos_visitante) AS `Puntos de visitante total`
FROM nba.equipo
INNER JOIN nba.partido ON equipo.nombre = partido.equipo_local OR equipo.nombre = partido.equipo_visitante
GROUP BY equipo.nombre
ORDER BY equipo_local ASC;

# 18)

