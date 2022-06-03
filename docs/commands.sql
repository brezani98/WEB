SELECT * FROM categories
INNER JOIN products
ON categories.id = products.category_id;

SELECT products.id, products.name, products.price, categories.name FROM categories
INNER JOIN products
ON categories.id = products.category_id;

