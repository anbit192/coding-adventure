const express = require("express");
const router = express.Router();
const {getHomepage, getAnbish, getTestViewEngine} = require("../controllers/home_controller.js")


// declare a route
router.get('/', getHomepage);
router.get('/anbish', getAnbish);
router.get("/test_template_engine", getTestViewEngine);

module.exports = router;

