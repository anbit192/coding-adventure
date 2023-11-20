const express = require("express");
const { getAllUsersController, createUserController, updateUserController, deleteUserController } = require("../controllers/api_controller")
const router = express.Router();

const initAPIRoutes = (app) => {

    router.get("/users", getAllUsersController); // method GET
    router.post("/create-user", createUserController) // method POST
    router.put("/update-user", updateUserController) // method PUT
    router.delete("/delete-user/:id", deleteUserController) // method DELETE

    return app.use("/api/v1", router);
}

module.exports = initAPIRoutes;

