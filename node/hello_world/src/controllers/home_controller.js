// const connection = require("../config/database.js");
const { getAllUsers, getUserByID, createUser, updateUser, deleteUser } = require("../services/CRUDServices.js")

async function getHomepage(req, res) {

    let results = await getAllUsers();
    // console.log(results);
    return res.render("home.ejs", { users: results });
};

async function getUser(req, res) {
    // console.log(req.query);
    const userID = req.params.id;
    let results = await getUserByID(userID);
    console.log(results)
    return res.render("home.ejs", {users: [results]});
}

function getTestViewEngine(req, res) {
    res.render("sample.ejs")
}

const getCreateUser = (req, res) => {
    res.render("createUser.ejs");
}

const postCreateUser = async (req, res) => {
    console.log(req.body)
    let email = req.body.email;
    let user_name = req.body.user_name;
    let city = req.body.city;

    // let {email, user_name, city} = req.body;
    await createUser(email, user_name, city);

    return res.send("Created!");
}

const getUpdateUser = async (req, res) => {
    const userID = req.params.id;
    editUser = await getUserByID(userID);
    res.render("editUser.ejs", {user: editUser});
}

const postUpdateUser = async (req, res) => {
    // let {userID, email, user_name, city} = req.body;
    let userID = req.body.id;
    let email = req.body.email;
    let user_name = req.body.user_name;
    let city = req.body.city;
    await updateUser(userID, email, user_name, city);

    return res.send("Updated!");

}


const getDeleteUser = async (req, res) => {
    let userID = req.params.id
    let user = await getUserByID(userID);
    return res.render("deleteUser.ejs", {user:user})
}

const postDeleteUser = async (req, res) => {
    let userID = req.body.id;
    // console.log(req.body)
    await deleteUser(userID);
    return res.redirect("/")
}

module.exports = {
    getHomepage, getUser, getTestViewEngine, postCreateUser, getCreateUser, getUpdateUser, postUpdateUser, getDeleteUser, postDeleteUser
}