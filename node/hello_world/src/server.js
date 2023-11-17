const express = require('express'); // commonjs
// import express from "express"; //es module
const path = require("path");
require("dotenv").config();

const app = express(); // app express
const port = process.env.PORT || 1902; // port
const hostname = process.env.HOST_NAME || "localhost";

// console.log("Check env: ", process.env);

// config template engine
app.set("views", path.join(__dirname, "templates"));
app.set("view engine", "ejs");


// declare a route
app.get('/', (req, res) => {
  res.send('Hello World!');
});

app.get('/anbish', (req, res) => {
  res.send('<h3><b>Hello World from anbish!</b></h3>');
});

app.get("/test_template_engine", (req, res) => {
  res.render("sample.ejs")
});


app.listen(port, hostname, () => {
  console.log(`Example app listening on port ${port}`);
});