require("dotenv").config();
const express = require('express');
const configViewEngine = require("./config/view_engine.js");
const webRoutes = require("./routes/web.js")
const app = express(); // app express

const port = process.env.PORT || 1902; // port
const hostname = process.env.HOST_NAME || "localhost";

// console.log("Check env: ", process.env);

// config template engine and static files
configViewEngine(app);

// get routes
app.use("/", webRoutes);

app.listen(port, hostname, () => {
  console.log(`app listening on port ${port}`);
});