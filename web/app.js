const express = require('express');
const request = require('request');
const bodyParser = require('body-parser');

const app = express();

const port = 3000;
const apiDomain = process.env.API_DNS;

app.use(bodyParser.json());
app.use((req, res, next) => {
  console.log(req.method, req.url);
  next();
})

app.get('/', (req, res) => {
  res.send('hello');
});

app.all('/todo', (req, res) => {
  let options = {
    method: req.method,
    body: req.body,
    json: true,
    uri: `${apiDomain}${req.url}`
  };

  request(options, (err, response) => {
    res.send(response.body);
  })
});

app.listen(port, () => console.log(`app listening on port ${port}`));
