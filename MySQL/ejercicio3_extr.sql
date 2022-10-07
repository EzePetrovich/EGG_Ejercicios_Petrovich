USE pokemondb;

# 1) Nombre de todos los pokemons

SELECT nombre AS `Nombre de pokemones`
FROM pokemondb.pokemon
ORDER BY nombre ASC;

# 2) Pokemons que pesen menos de 10k

SELECT *
FROM pokemondb.pokemon
WHERE peso < 10
ORDER BY nombre ASC;

# 3) Pokemons tipo agua

SELECT pokemon.*, tipo.nombre AS tipo
FROM pokemondb.pokemon
INNER JOIN pokemondb.pokemon_tipo ON pokemon.numero_pokedex = pokemon_tipo.numero_pokedex
INNER JOIN pokemondb.tipo ON pokemon_tipo.id_tipo = tipo.id_tipo
WHERE tipo.nombre = "Agua"
ORDER BY pokemon.nombre;
 
 # 4) Pokemons de tipo agua,fuego y tierra ordenados por tipo
 
SELECT pokemon.*, tipo.nombre AS tipo
FROM pokemondb.pokemon
INNER JOIN pokemondb.pokemon_tipo ON pokemon.numero_pokedex = pokemon_tipo.numero_pokedex
INNER JOIN pokemondb.tipo ON pokemon_tipo.id_tipo = tipo.id_tipo
WHERE tipo.nombre IN ("Agua", "Fuego", "Tierra")
ORDER BY tipo.id_tipo;

# 5) Pokemons tipo fuego y volador

SELECT pokemon.*, tipo.nombre AS tipo
FROM pokemondb.pokemon
INNER JOIN pokemondb.pokemon_tipo ON pokemon.numero_pokedex = pokemon_tipo.numero_pokedex
INNER JOIN pokemondb.tipo ON pokemon_tipo.id_tipo = tipo.id_tipo
WHERE tipo.nombre IN ("Fuego", "Volador")
ORDER BY tipo.id_tipo;

# 6) Pokemons con estadística base de ps mayor que 200

SELECT pokemon.*, estadisticas_base.ps
FROM pokemondb.pokemon
INNER JOIN pokemondb.estadisticas_base ON pokemon.numero_pokedex = estadisticas_base.numero_pokedex
WHERE estadisticas_base.ps > 200;

# 7) Mostrar peso, nombre y altura de la prevolución de Arbok

SELECT pokemon.nombre, pokemon.peso, pokemon.altura
FROM pokemondb.pokemon
WHERE pokemon.numero_pokedex = (
	SELECT evoluciona_de.pokemon_origen
    FROM pokemondb.pokemon
    INNER JOIN pokemondb.evoluciona_de ON pokemon.numero_pokedex = evoluciona_de.pokemon_evolucionado
    WHERE pokemon.nombre = "Arbok" AND evoluciona_de.pokemon_evolucionado = pokemon.numero_pokedex
);

# 8) Pokemons que evolucionan por intercambio

SELECT pokemon.*
FROM pokemondb.pokemon
INNER JOIN pokemondb.pokemon_forma_evolucion ON pokemon.numero_pokedex = pokemon_forma_evolucion.numero_pokedex
INNER JOIN pokemondb.forma_evolucion ON pokemon_forma_evolucion.id_forma_evolucion = forma_evolucion.id_forma_evolucion
INNER JOIN pokemondb.tipo_evolucion ON forma_evolucion.tipo_evolucion = tipo_evolucion.id_tipo_evolucion
WHERE tipo_evolucion.tipo_evolucion = "Intercambio";

# 9) Movimiento con más prioridad

SELECT nombre AS `Nombre movimiento con más prioridad`
FROM pokemondb.movimiento
WHERE movimiento.prioridad = (
	SELECT MAX(prioridad)
    FROM pokemondb.movimiento
);

# 10) Pokemon más pesado

SELECT *
FROM pokemondb.pokemon
ORDER BY peso DESC
LIMIT 1;

# 11) Nombre y tipo de ataque con más potencia

SELECT movimiento.nombre AS `Nombre ataque`, tipo_ataque.tipo AS `Tipo de ataque`
FROM pokemondb.movimiento
INNER JOIN pokemondb.tipo ON movimiento.id_tipo = tipo.id_tipo
INNER JOIN pokemondb.tipo_ataque ON tipo.id_tipo_ataque = tipo_ataque.id_tipo_ataque
WHERE movimiento.potencia = (
	SELECT MAX(potencia)
    FROM pokemondb.movimiento
);

# 12) Número de movimientos de cada tipo

SELECT tipo.nombre AS `Tipo de pokemon`, COUNT(*) AS `Número de movimientos`
FROM pokemondb.tipo
INNER JOIN pokemondb.movimiento ON tipo.id_tipo = movimiento.id_tipo
GROUP BY movimiento.id_tipo;

# 13) Movimientos que puedan envenenar

SELECT movimiento.*
FROM pokemondb.movimiento
INNER JOIN pokemondb.tipo ON movimiento.id_tipo = tipo.id_tipo
WHERE tipo.nombre = "Veneno";

# 14) Movimientos que causan daño ordenados alfabéticamente por nombre

SELECT *
FROM pokemondb.movimiento
WHERE potencia > 0
ORDER BY nombre ASC;

# 15) Movimientos que aprende Pikachu

SELECT DISTINCT pokemon.numero_pokedex, pokemon.nombre AS nombre_pokemon, movimiento.*
FROM pokemondb.movimiento
INNER JOIN pokemondb.pokemon_movimiento_forma ON movimiento.id_movimiento = pokemon_movimiento_forma.id_movimiento
INNER JOIN pokemondb.pokemon ON pokemon_movimiento_forma.numero_pokedex = pokemon.numero_pokedex
WHERE pokemon.nombre = "Pikachu";

# 16) Mostrar todos los movimientos que aprende Pikachu por MT (tipo de aprendizaje)

SELECT DISTINCT pokemon.numero_pokedex, pokemon.nombre AS nombre_pokemon, movimiento.*
FROM pokemondb.movimiento
INNER JOIN pokemondb.pokemon_movimiento_forma ON movimiento.id_movimiento = pokemon_movimiento_forma.id_movimiento
INNER JOIN pokemondb.pokemon ON pokemon_movimiento_forma.numero_pokedex = pokemon.numero_pokedex
INNER JOIN pokemondb.mt ON pokemon_movimiento_forma.id_forma_aprendizaje = mt.id_forma_aprendizaje
WHERE pokemon.nombre = "Pikachu";

# 17) Mostrar todos los movimientos de tipo normal que aprende Pikachu por nivel

SELECT DISTINCT pokemon.numero_pokedex, pokemon.nombre AS nombre_pokemon, nivel_aprendizaje.nivel AS nivel_movimiento, movimiento.*
FROM pokemondb.movimiento
INNER JOIN pokemondb.pokemon_movimiento_forma ON movimiento.id_movimiento = pokemon_movimiento_forma.id_movimiento
INNER JOIN pokemondb.pokemon ON pokemon_movimiento_forma.numero_pokedex = pokemon.numero_pokedex
INNER JOIN pokemondb.nivel_aprendizaje ON pokemon_movimiento_forma.id_forma_aprendizaje = nivel_aprendizaje.id_forma_aprendizaje
WHERE pokemon.nombre = "Pikachu"
ORDER BY nivel_aprendizaje.nivel ASC;

# 18) Mostrar todos los movimientos de efecto secundario cuya probabilidad sea mayor al 30%

SELECT movimiento.*, efecto_secundario.efecto_secundario
FROM pokemondb.movimiento
INNER JOIN pokemondb.movimiento_efecto_secundario ON movimiento.id_movimiento = movimiento_efecto_secundario.id_movimiento
INNER JOIN pokemondb.efecto_secundario ON movimiento_efecto_secundario.id_efecto_secundario = efecto_secundario.id_efecto_secundario
WHERE movimiento_efecto_secundario.probabilidad > 30;

# 19) Mostrar todos los pokemons que evolucionan por piedra

SELECT DISTINCT pokemon.*, tipo_evolucion.tipo_evolucion, tipo_piedra.nombre_piedra
FROM pokemondb.pokemon
INNER JOIN pokemondb.pokemon_forma_evolucion ON pokemon.numero_pokedex = pokemon_forma_evolucion.numero_pokedex
INNER JOIN pokemondb.forma_evolucion ON pokemon_forma_evolucion.id_forma_evolucion = forma_evolucion.id_forma_evolucion
INNER JOIN pokemondb.tipo_evolucion ON forma_evolucion.tipo_evolucion = tipo_evolucion.id_tipo_evolucion
INNER JOIN pokemondb.piedra ON piedra.id_forma_evolucion = forma_evolucion.id_forma_evolucion
INNER JOIN pokemondb.tipo_piedra ON piedra.id_tipo_piedra = tipo_piedra.id_tipo_piedra
WHERE tipo_evolucion.tipo_evolucion = "Piedra"
ORDER BY pokemon.nombre ASC;

# 20) Pokemons que no pueden evolucionar

SELECT pokemon.*
FROM pokemondb.pokemon
WHERE pokemon.numero_pokedex NOT IN (
	SELECT DISTINCT numero_pokedex
    FROM pokemondb.pokemon_forma_evolucion
);

# 21) Cantidad de pokemons de cada tipo

SELECT tipo.nombre AS pokemon_tipo, COUNT(*) AS cantidad_de_pokemons
FROM pokemondb.pokemon
INNER JOIN pokemondb.pokemon_tipo ON pokemon.numero_pokedex = pokemon_tipo.numero_pokedex
INNER JOIN pokemondb.tipo ON pokemon_tipo.id_tipo = tipo.id_tipo
GROUP BY tipo.id_tipo
ORDER BY tipo.id_tipo ASC;