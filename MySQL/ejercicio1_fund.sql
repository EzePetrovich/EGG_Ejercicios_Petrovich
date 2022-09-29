-- Selecciona la BDD o schema personal
USE personal;

# a) 1.
SELECT * 
FROM personal.empleado
ORDER BY id_depto, cod_jefe ASC;

# a) 2.
SELECT * 
FROM personal.departamento;

# a) 3.
SELECT nombre_depto 
FROM personal.departamento;

# a) 4.
SELECT nombre, salario 
FROM personal.empleado;

# a) 5.
SELECT comision 
FROM personal.empleado;

# a) 6.
SELECT * 
FROM personal.empleado 
WHERE cargo = 'Secretaria';

# a) 7.
SELECT * 
FROM personal.empleado 
WHERE cargo = 'Vendedor' 
ORDER BY nombre ASC;

# a) 8.
SELECT nombre, cargo 
FROM personal.empleado 
ORDER BY salario ASC;

# a) 9.
SELECT nombre AS Nombre, cargo AS Cargo 
FROM personal.empleado;

# a) 10.
SELECT id_empleado, nombre, salario, comision 
FROM personal.empleado 
WHERE id_depto = 2000 
ORDER BY comision ASC;

# a) 11.
SELECT id_empleado AS `ID Empleado`, nombre AS Nombre, (salario + comision + 500) AS `Total a Pagar` 
FROM personal.empleado 
WHERE id_depto = 3000 
ORDER BY nombre ASC;

# a) 12.
SELECT * 
FROM personal.empleado 
WHERE nombre LIKE "J%";

# a) 13.
SELECT salario AS Salario, comision AS `Comisión`, (salario + comision) AS `Salario Total`, nombre AS Nombre 
FROM personal.empleado 
WHERE comision > 1000;

# a) 14.
SELECT salario AS Salario, comision AS `Comisión`, (salario + comision) AS `Salario Total`, nombre AS Nombre 
FROM personal.empleado 
WHERE comision = 0 OR comision = null;

# a) 15.
SELECT * 
FROM personal.empleado 
WHERE comision > salario;

# a) 16.
SELECT * 
FROM personal.empleado 
WHERE comision <= (salario * 0.3);

# a) 17.
SELECT * 
FROM personal.empleado 
WHERE NOT nombre LIKE '%MA%';

# a) 18.
SELECT nombre_depto 
FROM personal.departamento 
WHERE (nombre_depto = 'Ventas' OR nombre_depto = 'Investigación' OR nombre_depto = 'Mantenimiento');

# a) 19.
SELECT nombre_depto 
FROM personal.departamento 
WHERE NOT (nombre_depto = 'Ventas' OR nombre_depto = 'Investigación' OR nombre_depto = 'Mantenimiento');

# a) 20.
SELECT MAX(salario) AS `Salario más alto` 
FROM personal.empleado;

# a) 21.
SELECT MAX(nombre) AS `Último Empleado` 
FROM personal.empleado;

# a) 22. 
SELECT MAX(salario) AS `Salario más alto`, MIN(salario) AS `Salario más bajo`, (MAX(salario) - MIN(salario)) AS `Diferencia de salarios` 
FROM personal.empleado;

# a) 23.
SELECT id_depto AS `ID Dpto`, cargo AS Cargo, ROUND(AVG(salario)) AS `Salario Promedio` 
FROM personal.empleado 
GROUP BY empleado.id_depto;

# CONSULTAS CON HAVING

# a) 24.
SELECT departamento.id_depto AS `ID Departamento`, departamento.nombre_depto AS Departamento, COUNT(empleado.id_empleado) AS `Número de empleados` 
FROM personal.empleado 
INNER JOIN personal.departamento ON empleado.id_depto = departamento.id_depto 
GROUP BY departamento.id_depto 
HAVING COUNT(empleado.id_empleado) > 3;

# a) 25.

/* 
MUESTRA LOS DIRECTORES - OK

SELECT departamento.codigo_director AS `cod_director`, empleado.nombre AS `nombre_director`, empleado.id_depto
FROM personal.empleado
INNER JOIN personal.departamento ON departamento.id_depto = empleado.id_depto
WHERE empleado.cod_jefe != departamento.codigo_director OR empleado.cod_jefe IS NULL
ORDER BY empleado.id_depto ASC;
*/

/*
CONTABILIZA LOS EMPLEADOS - OK

SELECT departamento.id_depto, departamento.codigo_director, COUNT(*) AS numero_empleados
FROM personal.empleado
INNER JOIN personal.departamento ON departamento.codigo_director = empleado.cod_jefe
GROUP BY departamento.codigo_director, departamento.id_depto;
*/

-- SOLUCIÓN: combinación de los dos querys anteriores.

SELECT director.cod_director AS `Código director`, director.nombre_director `Nombre director`, director.cargo AS Cargo, COUNT(*) AS `Número de empleados`, director.nombre_depto AS `Departamento`, director.director_depto AS `ID Depto`
FROM personal.empleado
INNER JOIN (
	SELECT departamento.codigo_director AS cod_director, empleado.nombre AS nombre_director, departamento.id_depto AS director_depto, empleado.id_empleado, departamento.nombre_depto, empleado.cargo
	FROM personal.empleado
	INNER JOIN personal.departamento ON departamento.id_depto = empleado.id_depto
	WHERE empleado.cod_jefe != departamento.codigo_director OR empleado.cod_jefe IS NULL
	ORDER BY empleado.id_depto ASC
) AS director ON director.cod_director = empleado.cod_jefe
GROUP BY director.id_empleado HAVING COUNT(*) >= 2
ORDER BY director.director_depto ASC;

# a) 26.
/*
DEPARTAMENTOS CON EMPLEADOS

SELECT departamento.id_depto, departamento.nombre_depto, COALESCE(COUNT(*), 0) AS `cant_empleados`
FROM personal.empleado
INNER JOIN personal.departamento ON departamento.id_depto = empleado.id_depto
WHERE empleado.cod_jefe = departamento.codigo_director
GROUP BY departamento.id_depto;
*/

SELECT departamento.id_depto AS `ID dpto`, departamento.nombre_depto AS `Nombres dpto`
FROM personal.departamento
WHERE departamento.id_depto NOT IN 
(
	-- UTILIZO LA QUERY CON DPTOS CON EMPLEADOS PARA BUSCAR LOS DPTOS SIN EMPLEADOS
	SELECT departamento.id_depto
	FROM personal.empleado
	INNER JOIN personal.departamento ON departamento.id_depto = empleado.id_depto
	WHERE empleado.cod_jefe = departamento.codigo_director
	GROUP BY departamento.id_depto
)
GROUP BY departamento.id_depto
ORDER BY departamento.id_depto ASC;

# a) 27.

/*
SALARIO PROMEDIO DE LA EMPRESA

SELECT ROUND(AVG(empleado.salario)) AS salario_promedio
FROM personal.empleado;
*/

SELECT * FROM personal.empleado
WHERE empleado.salario >= (SELECT ROUND(AVG(empleado.salario)) AS salario_promedio FROM personal.empleado)
ORDER BY empleado.id_depto ASC;
