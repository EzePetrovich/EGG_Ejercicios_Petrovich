USE jardineria;

# 1)

SELECT codigo_oficina, ciudad
FROM jardineria.oficina;

# 2)

SELECT ciudad, telefono
FROM jardineria.oficina
WHERE pais = "España";

# 3)

SELECT nombre AS Nombre, CONCAT(apellido1, " ", apellido2) AS Apellidos, email AS Email
FROM jardineria.empleado
WHERE codigo_jefe = 7;

# 4)

SELECT puesto AS Puesto, nombre AS Nombre, CONCAT(apellido1, " ", apellido2) AS Apellidos, email AS Email
FROM jardineria.empleado
WHERE codigo_jefe IS NULL;

# 5)

SELECT nombre AS Nombre, CONCAT(apellido1, " ", apellido2) AS Apellidos, puesto AS Puesto
FROM jardineria.empleado
WHERE puesto != "Representante Ventas";

# 6)

SELECT nombre_cliente AS `Client Name`, pais AS Country
FROM jardineria.cliente
WHERE pais = "Spain";

# 7)

SELECT estado AS `Estado de pedido`
FROM jardineria.pedido
GROUP BY estado;

# 8) 

-- YEAR()

SELECT codigo_cliente, fecha_pago
FROM jardineria.pago
WHERE YEAR(fecha_pago) = 2008
GROUP BY codigo_cliente;

-- DATE_FORMAT()

SELECT codigo_cliente, fecha_pago
FROM jardineria.pago
WHERE DATE_FORMAT(fecha_pago, "%Y") = 2008
GROUP BY codigo_cliente;

-- SIN YEAR() y DATE_FORMAT()

SELECT codigo_cliente, fecha_pago
FROM jardineria.pago
WHERE EXTRACT(YEAR FROM fecha_pago) = 2008
GROUP BY codigo_cliente;

# 9)

SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM jardineria.pedido
WHERE TO_DAYS(fecha_entrega) > TO_DAYS(fecha_esperada);

# 10)

-- ADDDATE()

SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM jardineria.pedido
WHERE ADDDATE(fecha_entrega, INTERVAL 2 DAY) <= fecha_esperada;

-- DATEDIFF()

SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM jardineria.pedido
WHERE DATEDIFF(fecha_esperada, fecha_entrega) >= 2;

# 11)

SELECT * 
FROM jardineria.pedido
WHERE YEAR(fecha_pedido) = 2009 AND estado = "Rechazado";

# 12)

SELECT * 
FROM jardineria.pedido
WHERE MONTH(fecha_pedido) = 1 AND estado = "Entregado";

# 13) 

SELECT *
FROM jardineria.pago
WHERE YEAR(fecha_pago) = 2008 AND forma_pago = "PayPal"
ORDER BY total DESC;

# 14)

SELECT forma_pago AS `Formas de pago`
FROM jardineria.pago
GROUP BY forma_pago;

# 15)

SELECT *
FROM jardineria.producto
WHERE gama = "Ornamentales" AND cantidad_en_stock > 100
ORDER BY precio_venta DESC;

# 16)

SELECT *
FROM jardineria.cliente
WHERE ciudad = "Madrid" AND codigo_empleado_rep_ventas IN (11, 30);

# CONSULTAS MULTITABLA (COMPOSICIÓN INTERNA - INNER JOIN)

# 1) 

SELECT cliente.nombre_cliente AS `Nombre cliente`, CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) AS `Representante de ventas`
FROM jardineria.cliente
INNER JOIN jardineria.empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado;

# 2)

SELECT cliente.nombre_cliente AS `Nombre cliente`, CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) AS `Representante de ventas`
FROM jardineria.cliente
INNER JOIN jardineria.empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
INNER JOIN jardineria.pago ON pago.codigo_cliente = cliente.codigo_cliente;

# 3)

SELECT cliente.nombre_cliente AS `Nombre cliente`, CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) AS `Representante de ventas`
FROM jardineria.cliente
INNER JOIN jardineria.empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
WHERE cliente.codigo_cliente NOT IN (SELECT codigo_cliente FROM jardineria.pago);

# 4)

SELECT cliente.nombre_cliente AS `Nombre cliente`, CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) AS `Representante de ventas`, oficina.ciudad AS `Ciudad oficina`
FROM jardineria.cliente
INNER JOIN jardineria.empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
INNER JOIN jardineria.pago ON pago.codigo_cliente = cliente.codigo_cliente
INNER JOIN jardineria.oficina ON oficina.codigo_oficina = empleado.codigo_oficina;

# 5)

SELECT cliente.nombre_cliente AS `Nombre cliente`, CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) AS `Representante de ventas`, oficina.ciudad AS `Ciudad oficina`
FROM jardineria.cliente
INNER JOIN jardineria.empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
INNER JOIN jardineria.oficina ON oficina.codigo_oficina = empleado.codigo_oficina
WHERE cliente.codigo_cliente NOT IN (SELECT codigo_cliente FROM jardineria.pago);

# 6)

SELECT CONCAT(oficina.linea_direccion1, " | ", oficina.linea_direccion2) AS `Dirección oficina`
FROM jardineria.oficina
INNER JOIN jardineria.empleado ON oficina.codigo_oficina = empleado.codigo_oficina
INNER JOIN jardineria.cliente ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
WHERE cliente.ciudad = "Fuenlabrada";

# 7)

SELECT cliente.nombre_cliente AS `Nombre cliente`, CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) AS `Representante de ventas`, oficina.ciudad AS `Ciudad oficina`
FROM jardineria.cliente
INNER JOIN jardineria.empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
INNER JOIN jardineria.oficina ON oficina.codigo_oficina = empleado.codigo_oficina;

# 8)

SELECT CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) AS `Nombre empleado`, CONCAT(jefe.nombre, " ", jefe.apellido1, " ", jefe.apellido2) AS `Nombre jefe`
FROM jardineria.empleado
INNER JOIN jardineria.empleado AS jefe ON empleado.codigo_jefe = jefe.codigo_empleado;

# 9)

SELECT cliente.nombre_cliente AS `Nombre cliente`, pedido.*
FROM jardineria.cliente
INNER JOIN jardineria.pedido
WHERE DATEDIFF(pedido.fecha_esperada, pedido.fecha_entrega) < 0;

# 10)

SELECT DISTINCT producto.gama
FROM jardineria.producto
INNER JOIN jardineria.detalle_pedido ON producto.codigo_producto = detalle_pedido.codigo_producto
INNER JOIN jardineria.pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
ORDER BY producto.gama ASC;

# CONSULTAS MULTITABLA (COMPOSICIÓN EXTERNA - LEFT JOIN, RIGHT JOIN, JOIN)

# 1) Clientes que no realizaron un pago

-- RIGHT JOIN

SELECT cliente.*
FROM jardineria.pago
RIGHT JOIN jardineria.cliente ON pago.codigo_cliente = cliente.codigo_cliente
WHERE pago.codigo_cliente IS NULL;


-- LEFT JOIN

SELECT cliente.*
FROM jardineria.cliente
LEFT JOIN jardineria.pago ON pago.codigo_cliente = cliente.codigo_cliente
WHERE pago.codigo_cliente IS NULL;


# 2) Clientes que no realizaron un pedido

-- RIGHT JOIN

SELECT cliente.*
FROM jardineria.pedido
RIGHT JOIN jardineria.cliente ON pedido.codigo_cliente = cliente.codigo_cliente
WHERE pedido.codigo_cliente IS NULL;

-- LEFT JOIN

SELECT cliente.*
FROM jardineria.cliente
LEFT JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
WHERE pedido.codigo_cliente IS NULL;

# 3) Clientes que no realizaron ningún pago ni pedido

SELECT cliente.*
FROM jardineria.cliente
LEFT JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
LEFT JOIN jardineria.pago ON pago.codigo_cliente = cliente.codigo_cliente
WHERE pedido.codigo_cliente IS NULL AND pago.codigo_cliente IS NULL;

# 4) Empleados sin oficina (No hay, todos tienen una oficina)

SELECT empleado.*
FROM jardineria.empleado
RIGHT JOIN jardineria.oficina ON empleado.codigo_oficina = oficina.codigo_oficina
WHERE oficina.codigo_oficina IS NULL;

# 5) Empleados sin clientes

SELECT empleado.*
FROM jardineria.empleado
LEFT JOIN jardineria.cliente ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
WHERE cliente.codigo_empleado_rep_ventas IS NULL;

# 6) Empleados sin clientes ni oficina (No hay, como todos tienen oficina ya no se cumple la condición para mostrarlos)

SELECT empleado.*
FROM jardineria.empleado
RIGHT JOIN jardineria.oficina ON empleado.codigo_oficina = oficina.codigo_oficina
LEFT JOIN jardineria.cliente ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
WHERE oficina.codigo_oficina IS NULL AND cliente.codigo_empleado_rep_ventas IS NULL;

# 7) Productos que nunca han aparecido en un pedido

SELECT producto.*
FROM jardineria.producto
LEFT JOIN jardineria.detalle_pedido ON producto.codigo_producto = detalle_pedido.codigo_producto
WHERE detalle_pedido.codigo_producto IS NULL;

# 8) Oficinas dónde no trabajan representante de ventas que hayan vendido productos de gama Frutales

-- Clientes que compraron productos de gama "Frutales"

SELECT cliente.*
FROM jardineria.cliente
LEFT JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
LEFT JOIN jardineria.detalle_pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
LEFT JOIN jardineria.producto ON detalle_pedido.codigo_producto = producto.codigo_producto
WHERE producto.gama = "Frutales";

-- Representante de ventas de esos clientes

SELECT cliente.codigo_empleado_rep_ventas
FROM jardineria.cliente
LEFT JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
LEFT JOIN jardineria.detalle_pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
LEFT JOIN jardineria.producto ON detalle_pedido.codigo_producto = producto.codigo_producto
WHERE producto.gama = "Frutales"
GROUP BY cliente.codigo_empleado_rep_ventas;

-- Oficinas de esos representante de ventas (empleados)

SELECT empleado.codigo_oficina
FROM jardineria.cliente
LEFT JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
LEFT JOIN jardineria.detalle_pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
LEFT JOIN jardineria.producto ON detalle_pedido.codigo_producto = producto.codigo_producto
LEFT JOIN jardineria.empleado ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
WHERE producto.gama = "Frutales"
GROUP BY cliente.codigo_empleado_rep_ventas;

-- Solución final

SELECT oficina.*
FROM jardineria.oficina
LEFT JOIN (
	SELECT empleado.codigo_oficina
	FROM jardineria.cliente
	LEFT JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
	LEFT JOIN jardineria.detalle_pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
	LEFT JOIN jardineria.producto ON detalle_pedido.codigo_producto = producto.codigo_producto
	LEFT JOIN jardineria.empleado ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
	WHERE producto.gama = "Frutales"
	GROUP BY cliente.codigo_empleado_rep_ventas
) AS oficina_frutales ON oficina.codigo_oficina = oficina_frutales.codigo_oficina
WHERE oficina_frutales.codigo_oficina IS NULL;

# 9) 

SELECT cliente.*
FROM jardineria.cliente
LEFT JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
LEFT JOIN jardineria.pago ON cliente.codigo_cliente = pago.codigo_cliente
WHERE pedido.codigo_cliente IS NOT NULL AND pago.codigo_cliente IS NULL
GROUP BY cliente.codigo_cliente;

# 10)

SELECT empleado_sin_clientes.*,
CASE
	WHEN empleado_sin_clientes.codigo_jefe IS NULL THEN NULL
    ELSE CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) 
END AS nombre_jefe
FROM jardineria.empleado
LEFT JOIN (
	SELECT empleado.*
	FROM jardineria.empleado
	LEFT JOIN jardineria.cliente ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
	WHERE cliente.codigo_empleado_rep_ventas IS NULL
) AS empleado_sin_clientes ON empleado.codigo_empleado = empleado_sin_clientes.codigo_jefe OR empleado_sin_clientes.codigo_jefe IS NULL
WHERE empleado_sin_clientes.codigo_empleado IS NOT NULL
GROUP BY empleado_sin_clientes.codigo_empleado
ORDER BY empleado_sin_clientes.codigo_empleado ASC;

-- CONSULTAS RESUMEN

# 1) Total de empleados en la compañía

SELECT COUNT(*) AS `Total de empleados`
FROM jardineria.empleado;

# 2) Cantidad de clientes por país

SELECT pais AS País, COUNT(*) AS `Número de clientes`
FROM jardineria.cliente
GROUP BY pais
ORDER BY pais ASC;

# 3) Pago medio recaudado en el año 2009

SELECT CONCAT("$", AVG(total)) AS `Pago medio`, YEAR(fecha_pago) AS `Año`
FROM jardineria.pago
WHERE YEAR(fecha_pago) = 2009;

# 4) Cantidad de pedidos por estado, ordenado por número de pedidos de forma descendente

SELECT estado AS Estado, COUNT(*) AS `Número de pedidos`
FROM jardineria.pedido
GROUP BY estado
ORDER BY `Número de pedidos` DESC;

# 5) Precio de venta del producto más caro y más barato en una sola consulta

SELECT MAX(precio_venta) AS `Producto más caro`, MIN(precio_venta) AS `Producto más barato`
FROM jardineria.producto;

# 6) Número de clientes de la empresa

SELECT COUNT(*) AS `Número de clientes`
FROM jardineria.cliente;

# 7) Cantidad de clientes de la ciudad de Madrid

SELECT ciudad AS Ciudad, COUNT(*) AS `Número de clientes`
FROM jardineria.cliente
WHERE ciudad = "Madrid";

# 8) Cantidad de clientes de todas las ciudades que empiezan con M

SELECT ciudad AS Ciudad, COUNT(*) AS `Número de clientes`
FROM jardineria.cliente
WHERE ciudad LIKE "M%"
GROUP BY ciudad;

# 9) Representante de ventas y número de clientes que atiende

SELECT CONCAT(empleado.nombre, " ", empleado.apellido1, " ", empleado.apellido2) AS `Representante de ventas`, COUNT(cliente.codigo_cliente) AS `Número de clientes`
FROM jardineria.empleado
INNER JOIN jardineria.cliente ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
GROUP BY empleado.codigo_empleado;

# 10) Número de clientes sin representante de ventas. (Todos tienen representante de ventas, así que va a ser 0)

SELECT IFNULL(COUNT(cliente.codigo_cliente), 0) AS `Clientes sin representante de ventas`
FROM jardineria.cliente
WHERE cliente.codigo_empleado_rep_ventas NOT IN (SELECT empleado.codigo_empleado FROM jardineria.empleado) OR cliente.codigo_empleado_rep_ventas IS NULL;

# 11) Fecha del primer y último pago de cada cliente, mostrando nombre y apellido de cada uno

SELECT CONCAT(cliente.nombre_contacto, " ", cliente.apellido_contacto) AS `Nombre y apellido de cliente`, MIN(pago.fecha_pago) AS `Fecha primer pago`, MAX(pago.fecha_pago) AS `Fecha último pago`
FROM jardineria.cliente
INNER JOIN jardineria.pago ON cliente.codigo_cliente = pago.codigo_cliente
GROUP BY cliente.codigo_cliente;

# 12) Número de productos diferentes que hay por pedido de cada cliente
 
SELECT cliente.codigo_cliente AS `Código cliente`, pedido.codigo_pedido AS `Código pedido`, COUNT(detalle_pedido.codigo_producto) AS `Número de productos diferentes`
FROM jardineria.cliente
INNER JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
INNER JOIN jardineria.detalle_pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
GROUP BY pedido.codigo_pedido
ORDER BY cliente.codigo_cliente ASC;
 
 # 13) Suma total por cada pedido

SELECT cliente.codigo_cliente AS `Código cliente`, pedido.codigo_pedido AS `Código pedido`, SUM(detalle_pedido.precio_unidad * detalle_pedido.cantidad) AS `Suma total por pedido`
FROM jardineria.cliente
INNER JOIN jardineria.pedido ON cliente.codigo_cliente = pedido.codigo_cliente
INNER JOIN jardineria.detalle_pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
GROUP BY pedido.codigo_pedido
ORDER BY cliente.codigo_cliente ASC;

# 14) Listado de los 20 productos más vendidos con el número total de unidades vendidas ordenado por número total de productos vendidos

SELECT detalle_pedido.codigo_producto AS `Código producto`, producto.nombre AS `Nombre producto`, producto.gama AS Gama, COUNT(detalle_pedido.cantidad) AS `Cantidad vendida`
FROM jardineria.detalle_pedido
INNER JOIN jardineria.pedido ON detalle_pedido.codigo_pedido = pedido.codigo_pedido
INNER JOIN jardineria.producto ON detalle_pedido.codigo_producto = producto.codigo_producto
GROUP BY detalle_pedido.codigo_producto
ORDER BY `Cantidad vendida` DESC
LIMIT 20;

# 15) Calcular base imponible total, IVA total y total facturado por la empresa en su historial

SELECT CONCAT(SUM(detalle_pedido.cantidad * detalle_pedido.precio_unidad), "€") AS `Base imponible total`, CONCAT((SUM(detalle_pedido.cantidad * detalle_pedido.precio_unidad) * 0.21), "€") AS IVA, CONCAT((SUM(detalle_pedido.cantidad * detalle_pedido.precio_unidad) + (SUM(detalle_pedido.cantidad * detalle_pedido.precio_unidad) * 0.21)), "€") AS `Total facturado`
FROM jardineria.detalle_pedido;

# 16) IDEM anterior pero agrupado por código de producto

SELECT codigo_producto AS `Código producto`, CONCAT(SUM(cantidad * precio_unidad), "€") AS `Base imponible total`, CONCAT((SUM(cantidad * precio_unidad) * 0.21), "€") AS IVA, CONCAT((SUM(cantidad * precio_unidad) + (SUM(cantidad * precio_unidad) * 0.21)), "€") AS `Total facturado`
FROM jardineria.detalle_pedido
GROUP BY detalle_pedido.codigo_producto;

# 17) IDEM anterior pero agrupado por código de productos que empiecen por "OR"

SELECT codigo_producto AS `Código producto`, CONCAT(SUM(cantidad * precio_unidad), "€") AS `Base imponible total`, CONCAT((SUM(cantidad * precio_unidad) * 0.21), "€") AS IVA, CONCAT((SUM(cantidad * precio_unidad) + (SUM(cantidad * precio_unidad) * 0.21)), "€") AS `Total facturado`
FROM jardineria.detalle_pedido
WHERE codigo_producto LIKE "OR%"
GROUP BY detalle_pedido.codigo_producto;

# 18) 

SELECT producto.nombre AS `Nombre producto`, COUNT(detalle_pedido.cantidad) AS `Unidades vendidas`, CONCAT(SUM(detalle_pedido.cantidad * detalle_pedido.precio_unidad), "€") AS `Total facturado`, CONCAT((SUM(detalle_pedido.cantidad * detalle_pedido.precio_unidad) * 1.21), "€") AS `Total facturado + IVA`
FROM jardineria.detalle_pedido
INNER JOIN jardineria.pedido ON detalle_pedido.codigo_pedido = pedido.codigo_pedido
INNER JOIN jardineria.producto ON detalle_pedido.codigo_producto = producto.codigo_producto
GROUP BY detalle_pedido.codigo_producto HAVING `Total facturado` > 3000
ORDER BY detalle_pedido.codigo_producto;

-- SUBCONSULTAS CON OPERADORES BÁSICOS DE COMPARACIÓN

# 1) Cliente con mayor límite de crédito

SELECT nombre_cliente AS `Nombre cliente`
FROM jardineria.cliente
WHERE limite_credito = (SELECT MAX(limite_credito) FROM jardineria.cliente);

# 2) Nombre del producto con el precio de venta más caro

SELECT nombre
FROM jardineria.producto
WHERE precio_venta = (SELECT MAX(precio_venta) FROM jardineria.producto);

# 3) Nombre del producto que ha vendido más unidades

SELECT producto.nombre AS `Nombre producto más vendido`
FROM jardineria.producto
WHERE producto.codigo_producto = (SELECT codigo_producto
FROM jardineria.detalle_pedido
GROUP BY codigo_producto
ORDER BY SUM(cantidad) DESC
LIMIT 1);

# 4) Clientes cuyo límite de credito sea mayor a los pagos que haya realizado. (Sin utilizar INNER JOIN)

SELECT *
FROM jardineria.cliente
WHERE limite_credito > (
SELECT total
FROM jardineria.pago
WHERE codigo_cliente = cliente.codigo_cliente
GROUP BY codigo_cliente
);

# 5) Producto con más unidades en stock

SELECT *
FROM jardineria.producto
WHERE cantidad_en_stock = (
	SELECT MAX(cantidad_en_stock)
	FROM jardineria.producto
) LIMIT 1;

# 6) Producto con menos unidades en stock

SELECT *
FROM jardineria.producto
WHERE cantidad_en_stock = (
	SELECT MIN(cantidad_en_stock)
	FROM jardineria.producto
) LIMIT 1;

# 7) Nombre y apellidos + email de los empleados que están a cargo de Alberto Soria

SELECT CONCAT(nombre, ", ", apellido1, " ", apellido2) AS `Nombre y apellidos`, email AS Email
FROM jardineria.empleado
WHERE codigo_jefe = (
	SELECT codigo_empleado
	FROM jardineria.empleado
	WHERE nombre = "Alberto" AND (apellido1 = "Soria" OR apellido2 = "Soria")
);

-- SUBCONSULTAS CON ALL Y ANY

/*
ALL: todos los valores de la columna dentro del ALL deben coincidir con la tupla enunciada.
ANY: el valor de la tupla debe estar contenida en la columna de la subconsulta del ANY
*/

# 1) Nombre del cliente con mayor límite de crédito

SELECT nombre_cliente AS `Nombre cliente con mayor límite de crédito`
FROM jardineria.cliente
WHERE limite_credito = ANY
(SELECT MAX(limite_credito)
FROM jardineria.cliente);

# 2) Nombre del producto con el precio de venta más caro

SELECT nombre AS `Nombre del producto más caro`
FROM jardineria.producto
WHERE precio_venta = ALL
(SELECT MAX(precio_venta)
FROM jardineria.producto);

# 3) Producto con menos unidades en stock

SELECT *
FROM jardineria.producto
WHERE cantidad_en_stock = ALL
(SELECT MIN(cantidad_en_stock)
FROM jardineria.producto);

-- SUBCONSULTAS CON IN Y NOT IN

# 1) Nombre y apellido1 de los representantes que no tienen clientes

SELECT CONCAT(nombre, " ", apellido1) AS `Nombre y apellido 1`
FROM jardineria.empleado
WHERE codigo_empleado NOT IN (
	SELECT codigo_empleado_rep_ventas
    FROM jardineria.cliente
    GROUP BY codigo_empleado_rep_ventas
);

# 2) Clientes que no han realizado ningún pago

SELECT *
FROM jardineria.cliente
WHERE codigo_cliente NOT IN (
	SELECT codigo_cliente
    FROM jardineria.pago
    GROUP BY codigo_cliente
);

# 3) Clientes que realizaron al menos un pago

SELECT *
FROM jardineria.cliente
WHERE codigo_cliente IN (
	SELECT codigo_cliente
    FROM jardineria.pago
    GROUP BY codigo_cliente
);

# 4) Productos que nunca han aparecido en un pedido

SELECT *
FROM jardineria.producto
WHERE codigo_producto NOT IN (
	SELECT codigo_producto
    FROM jardineria.detalle_pedido
    GROUP BY codigo_producto
);

# 5) Nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados sin clientes

SELECT CONCAT(empleado.nombre, ", ", empleado.apellido1, " ", empleado.apellido2) AS `Nombre y apellidos`, empleado.puesto AS Puesto, oficina.telefono AS `Teléfono oficina`
FROM jardineria.empleado
INNER JOIN jardineria.oficina ON empleado.codigo_oficina = oficina.codigo_oficina
WHERE empleado.codigo_empleado NOT IN (
	SELECT codigo_empleado_rep_ventas
    FROM jardineria.cliente
    GROUP BY codigo_empleado_rep_ventas
);

-- SUBCONSULTAS CON EXISTS Y NOT EXISTS

# 1) Clientes que no realizaron ningún pago

SELECT *
FROM jardineria.cliente
WHERE NOT EXISTS (
	SELECT *
    FROM jardineria.pago
    WHERE pago.codigo_cliente = cliente.codigo_cliente
);

# 2) Clientes que realizaron al menos un pago

SELECT *
FROM jardineria.cliente
WHERE EXISTS (
	SELECT *
    FROM jardineria.pago
    WHERE pago.codigo_cliente = cliente.codigo_cliente
);

# 3) Productos que nunca han aparecido en un pedido

SELECT *
FROM jardineria.producto
WHERE NOT EXISTS (
	SELECT *
    FROM jardineria.detalle_pedido
    WHERE detalle_pedido.codigo_producto = producto.codigo_producto
);

# 4) Productos que han aparecido al menos una vez en un pedido

SELECT *
FROM jardineria.producto
WHERE EXISTS (
	SELECT *
    FROM jardineria.detalle_pedido
    WHERE detalle_pedido.codigo_producto = producto.codigo_producto
);