const express = require("express");
const router = express.Router();
const { getHomepage, getUser, getTestViewEngine, postCreateUser, getCreateUser, getUpdateUser, postUpdateUser } = require("../controllers/home_controller.js")


// declare a route
router.get('/', getHomepage);
router.get('/anbish/:id', getUser);
router.get("/test_template_engine", getTestViewEngine);

router.get("/create_user", getCreateUser)
router.post("/create_user", postCreateUser);

router.get("/update/:id", getUpdateUser);
router.post("/update/:id", postUpdateUser);

module.exports = router;

