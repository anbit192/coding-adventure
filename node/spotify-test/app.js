
var client_id = "59109adbef15496880caf68fa035495e";
var client_secret = "73aacf096cad4ade9afcd2038180dbd1";
var redirect_uri = "http://localhost:8888/callback";

var express = require("express");

var app = express();

app.get('/login', function(req, res) {

  var state = generateRandomString(16);
  var scope = 'user-read-private user-read-email';

  res.redirect('https://accounts.spotify.com/authorize?' +
    querystring.stringify({
      response_type: 'code',
      client_id: client_id,
      scope: scope,
      redirect_uri: redirect_uri,
      state: state
    }));
});