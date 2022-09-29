USE tienda;

# 1) 

SELECT producto.nombre AS `Nombre de producto` FROM tienda.producto;

# 2)

SELECT producto.nombre AS `Nombre producto`, producto.precio AS `Precio producto` FROM tienda.producto;

# 3)

SELECT * FROM tienda.producto;

# 4) 

SELECT producto.nombre AS `Nombre producto`, ROUND(producto.precio) AS `Precio producto` FROM tienda.producto;

# 5)

SELECT fabricante.codigo AS `Código de fabricante`, fabricante.nombre AS `Nombre fabricante`
FROM tienda.fabricante
INNER JOIN tienda.producto ON fabricante.codigo = producto.codigo_fabricante;

# 6) (10 en guía) 

SELECT DISTINCT fabricante.codigo AS `Código de fabricante`, fabricante.nombre AS `Nombre fabricante`
FROM tienda.fabricante
INNER JOIN tienda.producto ON fabricante.codigo = producto.codigo_fabricante;

# 7) (11 en guía)

SELECT fabricante.nombre `Nombre de fabricante`
FROM tienda.fabricante
ORDER BY fabricante.nombre ASC;

# 8) (12 en guía)

-- Listado de nombre de productos ordenados por nombre de forma ascendente
SELECT producto.nombre AS `Nombre productos`, producto.precio
FROM tienda.producto
ORDER BY producto.nombre ASC;

-- Listado de nombres de productos ordenados por precio de forma descendente
SELECT producto.nombre AS `Nombre producto`
FROM tienda.producto
ORDER BY producto.precio DESC;

# 9) (13 en guía)

SELECT * FROM tienda.fabricante 
LIMIT 5;

# 10) (14 en guía)

SELECT producto.nombre AS `Nombre producto`, producto.precio AS `Precio producto`
FROM tienda.producto
ORDER BY producto.precio ASC
LIMIT 1;

# 11) (15 en guía)

SELECT producto.nombre AS `Nombre producto`, producto.precio AS `Precio producto`
FROM tienda.producto
ORDER BY producto.precio DESC
LIMIT 1;

# 12) (16 en guía)

SELECT producto.nombre AS `Nombre producto`
FROM tienda.producto
WHERE producto.precio <= 120;

# 13) (17 en guía)

SELECT * FROM tienda.producto
WHERE producto.precio BETWEEN 60 AND 200;

# 14) (18 en guía)

SELECT * FROM tienda.producto
WHERE producto.codigo_fabricante IN (1, 3, 5);

# 15) (19 en guía)

SELECT * FROM tienda.producto
WHERE producto.nombre LIKE '%Portátil%';

-- CONSULTAS MULTITABLAS

# 1)

SELECT producto.codigo AS `Código producto`, producto.nombre AS `Nombre producto`, fabricante.codigo AS `Código fabricante`, fabricante.nombre AS `Nombre fabricante`
FROM tienda.producto
INNER JOIN tienda.fabricante ON producto.codigo_fabricante = fabricante.codigo;

# 2)

SELECT producto.nombre AS `Nombre producto`, producto.precio AS `Precio producto`, fabricante.nombre AS `Nombre fabricante`
FROM tienda.producto
INNER JOIN tienda.fabricante ON producto.codigo_fabricante = fabricante.codigo
ORDER BY fabricante.nombre ASC;

# 3) 

SELECT producto.nombre AS `Nombre producto`, producto.precio AS `Precio producto`, fabricante.nombre AS `Nombre fabricante`
FROM tienda.producto
INNER JOIN tienda.fabricante ON producto.codigo_fabricante = fabricante.codigo
ORDER BY producto.precio ASC
LIMIT 1;

# 4)

SELECT * FROM tienda.producto
INNER JOIN tienda.fabricante ON fabricante.codigo = producto.codigo_fabricante
WHERE fabricante.nombre = 'Lenovo';

# 5)

SELECT * FROM tienda.producto
INNER JOIN tienda.fabricante ON fabricante.codigo = producto.codigo_fabricante
WHERE fabricante.nombre = 'Crucial' AND producto.precio > 200;

# 6) 

SELECT * FROM tienda.producto
INNER JOIN tienda.fabricante ON fabricante.codigo = producto.codigo_fabricante
WHERE fabricante.nombre IN ('Asus', 'Hewlett-Packard');

# 7)

-- Listado de productos con precio mayor o igual a 180 ordenado por precio de forma descendente
SELECT producto.nombre AS `Nombre producto`, producto.precio AS `Precio producto`, fabricante.nombre AS `Nombre fabricante`
FROM tienda.producto
INNER JOIN tienda.fabricante ON fabricante.codigo = producto.codigo_fabricante
WHERE producto.precio >= 180
ORDER BY producto.precio DESC;

-- Listado de productos con precio mayor o igual a 180 ordenado por nombre de producto de forma ascendente
SELECT producto.nombre AS `Nombre producto`, producto.precio AS `Precio producto`, fabricante.nombre AS `Nombre fabricante`
FROM tienda.producto
INNER JOIN tienda.fabricante ON fabricante.codigo = producto.codigo_fabricante
WHERE producto.precio >= 180
ORDER BY producto.nombre ASC;

-- CONSULTAS MULTITABLAS (SOLO CON LEFT JOIN Y RIGHT JOIN)

# 1)

SELECT fabricante.nombre AS `Nombre fabricante`, producto.* 
FROM tienda.fabricante 
LEFT JOIN tienda.producto ON fabricante.codigo = producto.codigo_fabricante;

# 2)

SELECT fabricante.* FROM tienda.producto
RIGHT JOIN tienda.fabricante ON fabricante.codigo = producto.codigo_fabricante
WHERE producto.codigo_fabricante IS NULL;

-- SUBCONSULTAS EN LA CLÁUSULA WHERE (con operadores básicos de comparación)

# 1)

SELECT * FROM tienda.producto
WHERE producto.codigo_fabricante = (
	SELECT fabricante.codigo 
	FROM tienda.fabricante
	WHERE fabricante.nombre = 'Lenovo'
    GROUP BY fabricante.codigo
);

# 2) 

SELECT * FROM tienda.producto
WHERE producto.precio = (
	SELECT MAX(producto.precio) AS `prod_mas_caro` FROM tienda.producto
	WHERE producto.codigo_fabricante = (
		SELECT fabricante.codigo
		FROM tienda.fabricante
		WHERE fabricante.nombre = 'Lenovo'
		LIMIT 1
	)
);

# 3)

SELECT * FROM tienda.producto
WHERE producto.codigo_fabricante = (
	SELECT fabricante.codigo 
	FROM tienda.fabricante
	WHERE fabricante.nombre = 'Lenovo'
    GROUP BY fabricante.codigo
)
ORDER BY producto.precio DESC
LIMIT 1;

# 4)

SELECT * FROM tienda.producto
WHERE producto.precio > (
	SELECT AVG(producto.precio) 
    FROM tienda.producto
	WHERE producto.codigo_fabricante = (
		SELECT fabricante.codigo 
        FROM tienda.fabricante
		WHERE fabricante.nombre = 'Asus'
		LIMIT 1
	)
) AND producto.codigo_fabricante = (
	SELECT fabricante.codigo 
    FROM tienda.fabricante
	WHERE fabricante.nombre = 'Asus'
	LIMIT 1
);

-- SUBCONSULTAS CON IN Y NOT IN

# 1) 

SELECT fabricante.nombre `Nombre fabricante` 
FROM tienda.fabricante
WHERE fabricante.codigo IN (
	SELECT producto.codigo_fabricante 
    FROM tienda.producto
);

# 2)

SELECT fabricante.nombre `Nombre fabricante` 
FROM tienda.fabricante
WHERE fabricante.codigo NOT IN (
	SELECT producto.codigo_fabricante 
    FROM tienda.producto
);

# 3)

SELECT fabricante.nombre FROM tienda.fabricante
WHERE fabricante.codigo IN (
	SELECT producto.codigo_fabricante 
	FROM tienda.producto
	GROUP BY producto.codigo_fabricante HAVING COUNT(*) = (
		SELECT COUNT(*) AS `num_productos`
		FROM tienda.producto
		WHERE producto.codigo_fabricante = (
			SELECT fabricante.codigo 
			FROM tienda.fabricante 
			WHERE fabricante.nombre = 'Lenovo' 
			LIMIT 1
		)
		GROUP BY producto.codigo_fabricante
	)
);

-- Muestra la tabla con los productos y fabricantes respectivos ordenados alfabeticamente por el nombre

/*
SELECT * 
FROM tienda.producto 
INNER JOIN tienda.fabricante ON producto.codigo_fabricante = fabricante.codigo
ORDER BY fabricante.nombre ASC;
*/
