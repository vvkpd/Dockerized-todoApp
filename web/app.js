const express = require('express');
const request = require('request');

const app = express();
const port = 3000;
const apiDomain = process.env.API_DNS;

app.use((req, res, next) => {
  console.log(req.method, req.url);
  next();
})

app.get('/', (req, res) => {
  res.send('hello ');
});

app.get('/todo', (req, res) => {
  let options = {
    method: req.method,
    uri: `${apiDomain}${req.url}`
  };

  request(options, (err, response) => {
    res.send(response.body);
  })
});

app.listen(port, () => console.log(`app listening on port ${port}`));
