-- SCRIPT CREACIÓN DE TABLAS

-- TABLA COLORES
CREATE TABLE `color` (
  `increment` double NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `color` varchar(255) NOT NULL,
  `increment_type` enum('M','P') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TABLA DESCUENTOS
CREATE TABLE `discounts` (
  `discount` double NOT NULL,
  `final_hour` int DEFAULT NULL,
  `initial_hour` int DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `day_type` enum('ALL','FRIDAY','MONDAY','SATURDAY','SUNDAY','THURSDAY','TUESDAY','WEDNESDAY') NOT NULL,
  `increment_type` enum('M','P') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TABLA PRODUCTO
CREATE TABLE `product` (
  `initial_price` decimal(38,2) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TABLA TIENDA
CREATE TABLE `shop` (
  `current_cash` decimal(38,2) NOT NULL,
  `increment` double NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TABLA STOCK
CREATE TABLE `stock` (
  `amount` int NOT NULL,
  `color_id` bigint NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `producto_id` bigint NOT NULL,
  `tienda_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `stock_color_FK` (`color_id`),
  KEY `stock_product_FK` (`producto_id`),
  KEY `stock_shop_FK` (`tienda_id`),
  CONSTRAINT `stock_color_FK` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`),
  CONSTRAINT `stock_product_FK` FOREIGN KEY (`producto_id`) REFERENCES `product` (`id`),
  CONSTRAINT `stock_shop_FK` FOREIGN KEY (`tienda_id`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TABLA VENTAS
CREATE TABLE `ventas` (
  `discount_applied` double NOT NULL,
  `increment_applied` double NOT NULL,
  `initial_price` decimal(38,2) NOT NULL,
  `returned` bit(1) NOT NULL,
  `total_price` decimal(38,2) NOT NULL,
  `total_products` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_color` bigint NOT NULL,
  `id_product` bigint NOT NULL,
  `id_shop` bigint NOT NULL,
  `time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Ventas_shop_FK` (`id_shop`),
  KEY `ventas_color_FK` (`id_color`),
  CONSTRAINT `ventas_color_FK` FOREIGN KEY (`id_color`) REFERENCES `color` (`id`),
  CONSTRAINT `Ventas_product_FK` FOREIGN KEY (`id_color`) REFERENCES `color` (`id`),
  CONSTRAINT `Ventas_shop_FK` FOREIGN KEY (`id_shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TABLA DEVOLUCIONES
CREATE TABLE `returns` (
  `products_left` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sale_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKtr0miuob7ou1qy7sfhytujv6i` (`products_left`),
  KEY `returns_Ventas_FK` (`sale_id`),
  CONSTRAINT `returns_Ventas_FK` FOREIGN KEY (`sale_id`) REFERENCES `ventas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

