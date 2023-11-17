function getHomepage(req, res) {
    res.send('Hello World!');
}

function getAnbish(req, res) {
    res.send('<h3><b>Hello World from anbish!</b></h3>');
}

function getTestViewEngine(req, res) {
    res.render("sample.ejs")
}

module.exports = {
    getHomepage, getAnbish, getTestViewEngine
}