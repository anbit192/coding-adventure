const mysql = require("mysql2");
require("dotenv").config();

// connect dirrectly
info = {
    host: process.env.DB_HOST,
    port: process.env.DB_PORT,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME
};
const connection = mysql.createConnection(info);


module.exports = connection;