# BookRestAPI
Простое API для хранения книг: их названия, их автора, года их создания. 
GET/books/{title} - найти конкретную книгу по названию.
GET/books/allBooks - получить все книги.
POST/books/create - создать книгу.
PUT/books/update/{title} - обновить книгу по названию
DELETE/books/delete/{title} - удалить книгу по названию.

зависимости: 
spring-boot-starter-data-jpa
spring-boot-starter-web
mysql-connector-j
lombok
Перед запуском необходимо указать базу данных в application.properties файле.
