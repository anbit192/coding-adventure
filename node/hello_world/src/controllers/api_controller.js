const { getAllUsers, createUser, updateUser, deleteUser } = require("../services/CRUDServices");

const getAllUsersController = async (req, res) => {
    results = await getAllUsers();
    return res.status(200).json(results);
}

const createUserController = async (req, res) => {
    let email = req.body.email;
    let user_name = req.body.user_name;
    let city = req.body.city;

    if (!email || !user_name || !city) {
        return res.json({
            "message": "missing params"
        });
    }

    await createUser(email, user_name, city);

    return res.status(200).json({
        "message": "created!"
    })
}


const updateUserController = async (req, res) => {
    let id = req.body.user_id;
    let email = req.body.user_email;
    let name = req.body.user_name;
    let city = req.body.user_city;

    if (!email || !name || !city || !id) {
        return res.json({
            "message": "missing params"
        });
    }

    await updateUser(id, email, name, city);


    return res.status(200).json({
        "message": "updated!"
    });
}

const deleteUserController = async (req, res) => {
    let id = req.params.id;
    if (!id) {
        return res.json({
            "message": "missing params"
        })
    }

    await deleteUser(id);

    return res.status(200).json({
        "message": "deleted!"
    })
}

module.exports = { getAllUsersController, createUserController, updateUserController, deleteUserController }