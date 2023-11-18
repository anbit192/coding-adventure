const express = require("express");
const router = express.Router();
const { getHomepage, getUser, getTestViewEngine, postCreateUser, getCreateUser } = require("../controllers/home_controller.js")


// declare a route
router.get('/', getHomepage);
router.get('/anbish', getUser);
router.get("/test_template_engine", getTestViewEngine);
router.get("/create_user", getCreateUser)
router.post("/create_user", postCreateUser);

module.exports = router;

