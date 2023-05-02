
/*----------------------------------------PAIS------------------------------------------
  PAIS: id, nombre.
 */
INSERT INTO pais VALUES (1, "Colombia");
INSERT INTO pais VALUES (2, "Mexico");
INSERT INTO pais VALUES (3, "Peru");



/*----------------------------------------DEPARTAMENTO-----------------------------------
  DEPARTAMENTO: id, nombre, pais_id.
 */

INSERT INTO departamento VALUES (1, "Quindio", 1);
INSERT INTO departamento VALUES (2, "Risaralda", 1);
INSERT INTO departamento VALUES (3, "Aguascalientes", 2);




 /*----------------------------------------CIUDAD----------------------------------------
   CIUDAD: id, nombre , departamento_id.
  */

INSERT INTO ciudad VALUES (1, "Armenia", 1);
INSERT INTO ciudad VALUES (2, "Pereira", 2);
INSERT INTO ciudad VALUES (3, "Dosquebradas", 2);


/*---------------------------------------------DIRECCION----------------------------------
  DIRECCION: id, direccion, Tipo, ciudad_id.
 */

INSERT INTO direccion VALUES (1, "Los naranjos" , "Casa" , 1);
INSERT INTO direccion VALUES (2, "La isabela" , "Casa" , 1);
INSERT INTO direccion VALUES (3, "Barrio pereira" , "Apartamento" , 2);
INSERT INTO direccion VALUES (4, "Las Americas" , "Casa" , 1);
INSERT INTO direccion VALUES (5, "El bosque" , "Apartamento" , 3);
INSERT INTO direccion VALUES (6, "Arrayanes" , "Apartamento" , 1);
INSERT INTO direccion VALUES (7, "Guaduales" , "Apartamento" , 1);
INSERT INTO direccion VALUES (8, "Quindos" , "Casa" , 3);
INSERT INTO direccion VALUES (9, "Castellana" , "Casa" , 2);
INSERT INTO direccion VALUES (10, "Proviteq" , "Casa" , 3);
INSERT INTO direccion VALUES (11, "Yulima" , "Apartamento" , 2);



/*-----------------------------------CLIENTE----------------------------------------------
  CLIENTE: id, apellido, correo, nombre, telefono, direccion_id.
 */

INSERT INTO cliente VALUES (1, "Zapata", "za@gmail.com", "Liliana", "3120001123",1);
INSERT INTO cliente VALUES (2, "Velez", "ve@gmail.com", "Jose", "3116731543",3);
INSERT INTO cliente VALUES (3, "Arango", "ar@gmail.com", "Felipe", "3110138923",2);


/*------------------------------------AFILIACION---------------------------------------------
  AFILIACION: id, descuento_compra, nivel, porcentaje.
 */

INSERT INTO afiliacion VALUES (1, 0.30, 1, 0.30);
INSERT INTO afiliacion VALUES (2, 0.25, 2, 0.25);
INSERT INTO afiliacion VALUES (3, 0.20, 3, 0.20);
INSERT INTO afiliacion VALUES (4, 0.15, 4, 0.15);
INSERT INTO afiliacion VALUES (5, 0.10, 5, 0.10);



/*--------------------------------------VENDEDOR-----------------------------------------------
  VENDEDOR: id, apellido, contrasena, correo, estado_afiliacion, nombre, salario, telefono, afiliacion_id
            direccion_id, vendedorJefe_id.
 */

INSERT INTO vendedor VALUES (1, "Jaramillo", "0000", "ja@gmail.com", true, "Juan", 6000000, 3127772598, 1, 4, null);
INSERT INTO vendedor VALUES (2, "Vargas", "1111", "va@gmail.com", false, "Paty", 4500000, 3115672548, 2, 5, 1);
INSERT INTO vendedor VALUES (3, "Perdomo", "9999", "pe@gmail.com", true, "Ryan", 4500000, 3107073295, 2, 6, 1);
INSERT INTO vendedor VALUES (4, "Yate", "8888", "ya@gmail.com", false, "Alejandro", 2500000, 3142342538, 3, 7, 2);
INSERT INTO vendedor VALUES (5, "Martinez", "4567", "ma@gmail.com", true, "Tom", 4500000, 3192552437, 2, 8, 1);
INSERT INTO vendedor VALUES (6, "Bonilla", "5432", "bo@gmail.com", true, "David", 2500000, 3202472497, 3, 9, 2);



/*-------------------------------------CATEGORIA-----------------------------------------------
  CATEGORIA: id, nombre.
 */

INSERT INTO categoria VALUES (1, "Salud");
INSERT INTO categoria VALUES (2, "Nutricion");
INSERT INTO categoria VALUES (3, "Belleza");


/*-------------------------------------------SUBCATEGORIA--------------------------------------
  SUBCATEGORIA: id, nombre, categoria_id
 */

INSERT INTO subcategoria VALUES (1, "Dispositivos Medicos" , 1);
INSERT INTO subcategoria VALUES (2, "Medicamentos" , 1);
INSERT INTO subcategoria VALUES (3, "Proteinas" , 2);
INSERT INTO subcategoria VALUES (4, "Vitaminas y Minerales" , 2);
INSERT INTO subcategoria VALUES (5, "Cuidado Personal" , 3);
INSERT INTO subcategoria VALUES (6, "Maquillaje" , 3);


/*-------------------------------------------PRODUCTO------------------------------------------
  PRODUCTO: codigo, descripcion, nombre, precio, stock, subcategoria_id.
 */

INSERT INTO producto VALUES (1, "Productos para control de salud" , "Medidor Cardiovascular", 120000, 10, 1);
INSERT INTO producto VALUES (2, "Productos para control de salud" , "Medidor Glucemia", 85000, 12, 1);
INSERT INTO producto VALUES (3, "Productos para control de salud" , "Tensiometro", 92000, 15, 1);
INSERT INTO producto VALUES (4, "Productos para mejorar la salud" , "Sevedol", 10000, 20, 2);
INSERT INTO producto VALUES (5, "Productos de proteinas" , "Pro-fitness", 45000, 8, 3);
INSERT INTO producto VALUES (6, "Productos de proteinas" , "Pro-fitness Premium", 70000, 5, 3);
INSERT INTO producto VALUES (7, "Productos para vitaminas y minerales" , "Vitamina C", 15000, 18, 4);
INSERT INTO producto VALUES (8, "Productos para cuidado personal" , "Shampoo", 23000, 7, 5);
INSERT INTO producto VALUES (9, "Productos para cuidado personal" , "Crema Hidratante", 18000, 13, 5);
INSERT INTO producto VALUES (10, "Productos para la belleza" , "Polvos y sombra", 33000, 14, 6);
INSERT INTO producto VALUES (11, "Productos para la belleza" , "Secadora", 110000, 8, 6);



/*---------------------------------------------INVENTARIO_ENTRADA---------------------------------
  INVENTARIO_ENTRADA: id, cantidad, descripcion, fecha_entrada, producto_id, vendedor_id.
 */

INSERT INTO inventario_entrada VALUES (1, 5, "Productos para control de salud", "2023-01-01", 1, 1);
INSERT INTO inventario_entrada VALUES (2, 8, "Productos para mejorar la salud", "2022-01-03", 4, 2);
INSERT INTO inventario_entrada VALUES (3, 10, "Productos de proteinas", "2022-01-07", 6, 1);
INSERT INTO inventario_entrada VALUES (4, 5, "Productos para la belleza", "2022-01-07", 10, 3);


/*---------------------------------------------INVENTARIO_SALIDA-----------------------------------
  INVENTARIO_SALIDA: id, cantidad, descripcion, fecha_salida, producto_id, vendedor_id.
 */

INSERT INTO inventario_salida VALUES (1, 2, "Productos para control de salud", "2023-02-06", 1, 1);
INSERT INTO inventario_salida VALUES (2, 3, "Productos para mejorar la salud", "2022-02-07", 4, 2);
INSERT INTO inventario_salida VALUES (3, 4, "Productos de proteinas", "2022-02-09", 6, 2);
INSERT INTO inventario_salida VALUES (4, 9, "Productos para la belleza", "2022-02-11", 10, 3);



/*-----------------------------------TRANSPORTADOR----------------------------------------
  TRANSPORTADOR : id, apellido, nombre, placa, salario, vehiculo.
 */

INSERT INTO transportador VALUES (1, "Ramirez","Daniel", "ABC123", 2000000, "Nissan");
INSERT INTO transportador VALUES (2, "Ramos", "Laura" , "MCA112", 2100000, "Mazda");
INSERT INTO transportador VALUES (3, "Hernandez", "Luis" , "MFY198",2050000, "KIA");


/*--------------------------------------------ENVIO----------------------------------------------
  ENVIO: id, direccion_id, transportador_id.
 */

INSERT INTO envio VALUES (1, 10, 1);
INSERT INTO envio VALUES (2, 11, 2);

/*-------------------------------------------VENTA--------------------------------------------------
  VENTA: id, descripcion, fecha, cliente_id, envio_id, vendedor_id.
 */

INSERT INTO venta VALUES (1, "Venta completada", "2023-03-01", 1, 1, 1);
INSERT INTO venta VALUES (2, "Venta Pendiente", "2023-04-02", 2, 2, 1);


/*----------------------------------------------DETALLE_VENTA----------------------------------------
  DETALLE_VENTA: id, cantidad, precio, producto_id, venta_id.
*/

INSERT INTO detalle_venta VALUES (1, 3, 30000, 4, 2);
INSERT INTO detalle_venta VALUES (2, 4, 92000, 8, 2);