const connection = require("../config/database.js");

const getAllUsers = async () => {
    const [results, fields] = await connection.query("SELECT * FROM Users");
    return results;
}

const getUserByID = async (id) => {
    const [results, fields] = await connection.query("SELECT * FROM Users WHERE id = ?", [id]);
    if (results.length <= 0) {
        return {}
    }
    return results[0];
}

const createUser = async (email, user_name, city) => {
    q = "INSERT INTO Users (email, name, city) VALUES (?, ?, ?)";
    await connection.query(q, [email, user_name, city]);
}

const updateUser = async (id, email, name, city) => {
    q = `
    UPDATE Users 
    SET email = ?, city = ?, name = ?
    WHERE id = ?
    `
    // console.log(id, email, city, name);
    await connection.query(q, [email, city, name, id]);
}   

const deleteUser = async (id) => {
    q = "DELETE FROM Users WHERE id = ?"
    await connection.query(q, [id]);
}

module.exports = { getAllUsers, getUserByID, createUser, updateUser, deleteUser };