require("dotenv").config();
const express = require('express');
const configViewEngine = require("./config/view_engine.js");
// const webRoutes = require("./routes/web.js")
const app = express(); // app express
// const connection = require("./config/database.js");
const port = process.env.PORT || 1902; // port
const hostname = process.env.HOST_NAME || "localhost";
const initWebRoutes = require("./routes/web.js");
const initAPIRoutes = require("./routes/api.js");

// console.log("Check env: ", process.env);

// config request body
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// config template engine and static files
configViewEngine(app);

// get routes
// app.use("/", webRoutes);
initWebRoutes(app);
initAPIRoutes(app);


app.listen(port, hostname, () => {
  console.log(`app listening on port ${port}`);
}); 