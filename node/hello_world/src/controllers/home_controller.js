const connection = require("../config/database.js");
const { getAllUsers, getUserByID, createUser } = require("../services/CRUDServices.js")

async function getHomepage(req, res) {

    let results = await getAllUsers();
    console.log(results);
    return res.render("home.ejs", { users: results });
};

async function getUser(req, res) {
    console.log(req.query);
    let results = getUserByID(parseInt(req.query.id, 10));
    return res.send(results)
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

    // q = "INSERT INTO Users (email, name, city) VALUES (?, ?, ?)";
    // const [results, fields] = await connection.query(q, [email, user_name, city]);

    await createUser(email, user_name, city);

    return res.send("Created!");

}

module.exports = {
    getHomepage, getUser, getTestViewEngine, postCreateUser, getCreateUser
}