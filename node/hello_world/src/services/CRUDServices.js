const connection = require("../config/database.js");

const getAllUsers = async () => {
    const [results, fields] = await connection.query("SELECT * FROM Users");
    return results;
}

const getUserByID = async (id) => {
    console.log(id)
    const [results, fields] = await connection.query("SELECT * FROM Users WHERE id = ?", [id]);
    return results;
}

const createUser = async (email, user_name, city) => {
    q = "INSERT INTO Users (email, name, city) VALUES (?, ?, ?)";
    await connection.query(q, [email, user_name, city]);
}

module.exports = {getAllUsers, getUserByID, createUser};